package com.doing.englishbox.ui.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.artron.baselib.base.BaseStaticFragment;
import com.doing.englishbox.R;
import com.doing.englishbox.ui.adapter.BoxPageAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Class description here
 *
 * @author doing
 * @version 1.0.0
 * @since 2017-08-07.
 */

public class BoxPagerFragment extends BaseStaticFragment {

    @BindView(R.id.ContentFragment_vp_page)
    protected ViewPager mViewPager;

    public static BoxPagerFragment newInstance() {
        Bundle args = new Bundle();
        BoxPagerFragment fragment = new BoxPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_pager;
    }

    @Override
    protected void initView() {
        BoxPageAdapter adapter = new BoxPageAdapter(getChildFragmentManager());
        mViewPager.setAdapter(adapter);
    }

}
