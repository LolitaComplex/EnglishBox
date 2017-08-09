package com.doing.englishbox.ui.activity;

import android.os.Bundle;

import com.doing.englishbox.R;
import com.doing.englishbox.ui.base.AppBaseActivity;
import com.doing.englishbox.ui.fragment.MainFragment;


public class MainActivity extends AppBaseActivity {


    @Override
    protected int getLayoutId() {
        return R.layout.general_page;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        addFragment(R.id.General_content, MainFragment.newInstance(), false);
    }

    @Override
    protected void initActionBar() {

    }


}
