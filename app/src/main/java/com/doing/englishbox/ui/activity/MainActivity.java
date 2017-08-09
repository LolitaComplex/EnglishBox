package com.doing.englishbox.ui.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

import com.artron.baselib.utils.DensityUitls;
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
        getStatusBarHeight();
        getHeight();
    }

    private int getStatusBarHeight() {
        Resources resources = this.getResources();
        int resourceId = resources.getIdentifier("status_bar_height", "dimen","android");
        int height = resources.getDimensionPixelSize(resourceId);
        Log.v("dbw", "Status height:" + DensityUitls.px2dip(height));
        Log.v("dbw", "pixil:" + height);
        return height;
    }

    public void getHeight() {
        mToolbar.post(new Runnable() {
            @Override
            public void run() {
                Log.v("dbw", "Status height:" + DensityUitls.px2dip(mToolbar.getMeasuredHeight()));
                Log.v("dbw", "pix:" + mToolbar.getMeasuredHeight());
            }
        });

    }

}
