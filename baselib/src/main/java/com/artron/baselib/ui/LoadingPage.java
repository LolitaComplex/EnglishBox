package com.artron.baselib.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.artron.baselib.R;
import com.artron.baselib.entity.Response;
import com.artron.baselib.utils.UIUtils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Doing on 2016/9/6.
 *
 */
public abstract class LoadingPage<T> extends FrameLayout {

    private static final int STATE_UNKOWN = 0;
    private static final int STATE_LOADING = 1;
    private static final int STATE_ERROR = 2;
    private static final int STATE_EMPTY = 3;
    private static final int STATE＿SUCCESS = 4;

    private int mCurrentState = STATE_UNKOWN;

    private View mLoadingView;
    private View mErrorView;
    private View mEmptyView;
    private View mSuccessView;


    public LoadingPage(Context context) {
        super(context);
        init();
    }

    public LoadingPage(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LoadingPage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public LoadingPage(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutParams params = new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mLoadingView = createLoadView();
        if (mLoadingView != null) {
            this.addView(mLoadingView, params);
        }

        mErrorView = createErrorView();
        if (mErrorView != null) {
            this.addView(mErrorView, params);
        }

        mEmptyView = createEmptyView();
        if (mEmptyView != null) {
            this.addView(mEmptyView, params);
        }


        showPage();
    }

    private View createLoadView() {
        return UIUtils.inflate(R.layout.general_loading,this);
    }

    private View createErrorView() {
        View errorView = UIUtils.inflate(R.layout.general_error, this);
        Button errorButton = (Button) errorView.findViewById(R.id.General_error_btn);
        errorButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });
        return errorView;
    }


    private View createEmptyView() {
        return UIUtils.inflate(R.layout.general_empty, this);
    }

    private void showPage() {
        if (mLoadingView != null) {
            mLoadingView.setVisibility(mCurrentState == STATE_UNKOWN || mCurrentState == STATE_LOADING ? VISIBLE : GONE);
        }

        if (mErrorView != null) {
            mErrorView.setVisibility(mCurrentState == STATE_ERROR ? VISIBLE : GONE);
        }

        if (mEmptyView != null) {
            mEmptyView.setVisibility(mCurrentState == STATE_EMPTY ? VISIBLE : GONE);
        }

        if (mCurrentState == STATE＿SUCCESS) {
            if (mSuccessView == null) {
                mSuccessView = createSuccessView(this);
                this.addView(mSuccessView);
            }
            mSuccessView.setVisibility(VISIBLE);
        }else {
            if (mSuccessView != null) {
                mSuccessView.setVisibility(View.INVISIBLE);
            }
        }
    }

    public enum LoadResult {
        unknown(0),error(2),empyt(3), success(4);

        private int value;

        LoadResult(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public void show() {
        if (mCurrentState == STATE_ERROR || mCurrentState == STATE_EMPTY || mCurrentState == STATE_UNKOWN) {
            mCurrentState = STATE_LOADING;
        }

        //TODO
        Observable<Response<T>> responseObservable = retrofitData();
        if (responseObservable == null) {
            return;
        }


       responseObservable
                .map(new Func1<Response<T>, T>() {
                    @Override
                    public T call(Response<T> responseResult) {
                        T content = responseResult.getContent();
                        if (content == null) {
                            content = responseResult.getResult();
                        }
                        return content;
                    }
                })
                .compose(bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<T>() {
                    @Override
                    public void call(T t) {
//                        Log.e("LoadingPage", "请求成功了 Success");
                        if (t == null) {
                            mCurrentState = STATE_ERROR;
                        } else {
                            mCurrentState = load(t).getValue();
                        }

                        showPage();
                        if (mCurrentState == STATE＿SUCCESS)
                            initViewWithData(t);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
//                        Log.e("LoadingPage", "请求失败了了 Failure");
                        mCurrentState = STATE_ERROR;
                        showPage();
                        Log.e("LoadPage", "数据解析错误", throwable);
                    }
                }, new Action0() {
                    @Override
                    public void call() {
//                        Log.e("LoadingPage", "请求完成了了 Complete");
                        if (mCurrentState == STATE_LOADING) {
                            mCurrentState = STATE_ERROR;
                        }
                    }
                });


        showPage();
    }

    public int getCurrentState() {
        return mCurrentState;
    }

    /*================= 模板方法 =======================*/

    protected abstract View createSuccessView(ViewGroup parent);

    protected abstract LoadResult load(T t);

    protected abstract Observable<Response<T>> retrofitData();

    protected abstract void initViewWithData(T t);

    protected abstract Observable.Transformer<T, T> bindToLifecycle();
}
