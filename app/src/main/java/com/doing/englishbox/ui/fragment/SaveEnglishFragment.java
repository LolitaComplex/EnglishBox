package com.doing.englishbox.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.artron.baselib.base.BaseStaticFragment;
import com.doing.englishbox.R;
import com.doing.englishbox.data.database.BoxItemManager;
import com.doing.englishbox.data.entity.AboutItem;
import com.doing.englishbox.data.entity.BoxItem;
import com.doing.englishbox.data.entity.Chinese;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Class description here
 *
 * @author doing
 * @version 1.0.0
 * @since 2017-08-07.
 */

public class SaveEnglishFragment extends BaseStaticFragment implements View.OnClickListener {

    @BindView(R.id.SaveEnglishFragment_btn_save)
    protected Button mBtnSave;
    private BoxItemManager mManager;

    public static SaveEnglishFragment newInstance() {
        Bundle args = new Bundle();
        SaveEnglishFragment fragment = new SaveEnglishFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initVariable() {
        mManager = BoxItemManager.getInstance();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_save;
    }

    @Override
    protected void initView() {
        mBtnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.SaveEnglishFragment_btn_save:
                break;
        }
    }

    private BoxItem buildBoxItem() {
        BoxItem item = new BoxItem();
        item.setContent("Excuse me");
        mManager.add(item);

        AboutItem aboutItem = new AboutItem();
        aboutItem.setContent("excuse");

        Chinese chineseExcuse = new Chinese();
        chineseExcuse.setContent("原谅我（很少会单独使用，c发音/g/）");

        return null;
    }
}
