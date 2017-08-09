package com.artron.baselib.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.artron.baselib.entity.Response;
import com.artron.baselib.ui.LoadingPage;
import com.artron.baselib.ui.LoadingPage.LoadResult;
import com.artron.baselib.utils.BaseUtil;
import com.artron.baselib.utils.UIUtils;

import butterknife.ButterKnife;
import rx.Observable;

/**
 * Created by Doing on 2016/9/6.
 *
 */
public abstract class BaseLoadingFragment<T> extends BaseFragment {

    private LoadingPage<T> mLoadingPage;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        BaseLoadingFragment.this.initVariable();

        if (mLoadingPage == null) {
            mLoadingPage = new LoadingPage<T>(mContext) {
                @Override
                protected View createSuccessView(ViewGroup container) {
                    View inflate = inflater.inflate(getLayoutId(), container, false);
                    ButterKnife.bind(BaseLoadingFragment.this, inflate);
                    BaseLoadingFragment.this.initView();
                    return inflate;
                }

                @Override
                protected LoadResult load(T t) {
                    return BaseLoadingFragment.this.checkData(t);
                }

                @Override
                protected Observable<Response<T>> retrofitData() {
                    return BaseLoadingFragment.this.retrofitData();
                }

                @Override
                protected void initViewWithData(T t) {
                    BaseLoadingFragment.this.initViewWithData(t);
                }

                @Override
                protected Observable.Transformer<T, T> bindToLifecycle() {
                    return BaseLoadingFragment.this.bindToLifecycle();
                }
            };
        } else {
            BaseUtil.removeParent(mLoadingPage);
        }

        return mLoadingPage;
    }

    public void show() {
        int unKnownValue = LoadResult.unknown.getValue();
        if (mLoadingPage != null && mLoadingPage.getCurrentState() == unKnownValue) {
            mLoadingPage.show();
            //设置该页面已经首次加载成功数据
        }
    }

    public void showImmediate(){
        if (mLoadingPage != null) {
            mLoadingPage.show();
        }
    }


    //============== 模板方法 ==================

    protected void initVariable(){}

    @LayoutRes
    protected abstract int getLayoutId();

    protected void initView(){}

    public abstract void initViewWithData(T data);

    protected LoadResult checkData(T datas) {
        return LoadResult.success;
    }

    protected abstract Observable<Response<T>> retrofitData();

}
