package com.doing.englishbox.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.doing.englishbox.ui.fragment.PageFragment;

/**
 * Class description here
 *
 * @author doing
 * @version 1.0.0
 * @since 2017-08-07.
 */

public class BoxPageAdapter extends FragmentStatePagerAdapter {

    public BoxPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }
}
