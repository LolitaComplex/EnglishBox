package com.artron.baselib.base;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.MotionEvent;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import rx.Subscription;

/**
 * Createdy 杜营 on 2016/4/14.
 */
public abstract class BaseActivity extends RxAppCompatActivity {

    public String TAG;
    private static final List<BaseActivity> mStackActivities = new LinkedList<>();
    private Unbinder mBind;

    protected BaseFragment mCurrentFragment;

    protected Subscription mSubscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //CrashExceptionUtil.getInstance().init(this);
        setContentView(getLayoutId());
        synchronized (mStackActivities) {
            mStackActivities.add(this);
        }

        if (getClass() != null) {
            String className = getClass().getName();
            TAG = className.substring(className.lastIndexOf(".") + 1);
        }

        //注册黄油刀
        mBind = ButterKnife.bind(this);

        initVariable();
        initView(savedInstanceState);
        initActionBar();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        try {
            return super.dispatchTouchEvent(ev);
        } catch (Exception e) {
            Log.e(TAG, "dispatchTouchEvent: ", e);
            return false;
        }
    }

    public void killAll() {
        List<BaseActivity> clone;

        synchronized (mStackActivities) {
            clone = new ArrayList<>(mStackActivities);
        }
        for (BaseActivity activity : clone) {
            activity.finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mBind != null) {
            mBind.unbind();
        }

        if (mSubscription != null && !mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }

        synchronized (mStackActivities) {
            mStackActivities.remove(this);
        }
    }

    public void addFragment(int contentId, BaseFragment fragment, boolean backStackFlag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        if (mCurrentFragment != null) {
//            transaction.hide(mCurrentFragment);
//        }
        if (!fragment.isAdded()) {
            transaction.add(contentId, fragment, fragment.getFragmentTag());
        }

        if (backStackFlag) {
            transaction.addToBackStack(fragment.getFragmentTag());
        }

        transaction.show(fragment);
        transaction.commit();

        mCurrentFragment = fragment;
    }

    public void replaceFragment(int contentId, BaseFragment fragment, boolean backStackFlag) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        if (mCurrentFragment != null) {
//            transaction.hide(mCurrentFragment);
//        }
        if (!fragment.isAdded()) {
            transaction.replace(contentId,fragment);
        }

        if (backStackFlag) {
            transaction.addToBackStack(fragment.getFragmentTag());
        }

        transaction.show(fragment);
        transaction.commit();

        mCurrentFragment = fragment;
    }


    /*===============================模板方法===================================*/
    protected void initVariable() {
    }

    protected abstract int getLayoutId();

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract void initActionBar();

}
