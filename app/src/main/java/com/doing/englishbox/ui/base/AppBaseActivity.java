package com.doing.englishbox.ui.base;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.artron.baselib.base.BaseActivity;
import com.doing.englishbox.R;

import butterknife.BindView;

/**
 * Class description here
 *
 * @author doing
 * @version 1.0.0
 * @since 2017-08-07.
 */

public abstract class AppBaseActivity extends BaseActivity {

    @BindView(R.id.General_toolbar)
    protected Toolbar mToolbar;
    @BindView(R.id.General_content)
    protected FrameLayout mFlContent;

    @Override
    protected void initActionBar() {
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }
    }
}
