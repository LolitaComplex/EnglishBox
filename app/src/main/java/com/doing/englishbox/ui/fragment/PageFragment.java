package com.doing.englishbox.ui.fragment;

import android.os.Bundle;

import com.artron.baselib.base.BaseLoadingFragment;
import com.artron.baselib.entity.Response;
import com.doing.englishbox.data.entity.BoxItem;

import java.util.List;

import rx.Observable;

/**
 * Class description here
 *
 * @author doing
 * @version 1.0.0
 * @since 2017-08-07.
 */

public class PageFragment extends BaseLoadingFragment<List<BoxItem>> {

    public static final String PAGE_FRAGMENT_POSITION = "PageFragmentPosition";
    private int mPosition;

    public static PageFragment newInstance(int position) {
        Bundle args = new Bundle();
        args.putInt(PAGE_FRAGMENT_POSITION, position);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initVariable() {
        mPosition = getArguments().getInt(PAGE_FRAGMENT_POSITION);
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    public void initViewWithData(List<BoxItem> data) {

    }

    @Override
    protected Observable<Response<List<BoxItem>>> retrofitData() {
        return null;
    }

}

