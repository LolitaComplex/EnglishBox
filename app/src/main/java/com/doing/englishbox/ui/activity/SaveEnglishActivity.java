package com.doing.englishbox.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.doing.englishbox.R;
import com.doing.englishbox.ui.base.AppBaseActivity;
import com.doing.englishbox.ui.fragment.SaveEnglishFragment;

/**
 * Class description here
 *
 * @author doing
 * @version 1.0.0
 * @since 2017-08-07.
 */

public class SaveEnglishActivity extends AppBaseActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, SaveEnglishActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.general_page;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        addFragment(R.id.General_content, SaveEnglishFragment.newInstance(), false);
    }

    @Override
    protected void initActionBar() {

    }
}
