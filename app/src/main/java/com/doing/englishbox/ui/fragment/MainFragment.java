package com.doing.englishbox.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.artron.baselib.base.BaseStaticFragment;
import com.doing.englishbox.R;
import com.doing.englishbox.ui.activity.SaveEnglishActivity;
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

public class MainFragment extends BaseStaticFragment implements View.OnClickListener {


    @BindView(R.id.MainFragment_btn_save)
    protected Button mBtnSave;
    @BindView(R.id.MainFragment_btn_show)
    protected Button mBtnShow;

    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView() {
        mBtnSave.setOnClickListener(this);
        mBtnShow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.MainFragment_btn_save:
                SaveEnglishActivity.start(mContext);
                break;

            case R.id.MainFragment_btn_show:

                break;
        }
    }
}
