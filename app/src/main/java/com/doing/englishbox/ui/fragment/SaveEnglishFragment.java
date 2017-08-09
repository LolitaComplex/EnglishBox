package com.doing.englishbox.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.artron.baselib.base.BaseStaticFragment;
import com.doing.englishbox.R;
import com.doing.englishbox.data.database.BoxItemManager;
import com.doing.englishbox.data.entity.AboutItem;
import com.doing.englishbox.data.entity.BoxItem;
import com.doing.englishbox.data.entity.Chinese;

import java.util.List;

import butterknife.BindView;

/**
 * Class description here
 *
 * @author doing
 * @version 1.0.0
 * @since 2017-08-07.
 */

public class SaveEnglishFragment extends BaseStaticFragment implements View.OnClickListener {

    private static final String TAG = "SaveEnglishFragment";

    @BindView(R.id.SaveEnglishFragment_btn_save)
    protected Button mBtnSave;
    @BindView(R.id.SaveEnglishFragment_btn_select)
    protected Button mBtnSelect;
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
        mBtnSelect.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.SaveEnglishFragment_btn_save:
                addBoxItem();
                break;

            case R.id.SaveEnglishFragment_btn_select:
                List<BoxItem> boxItem = mManager.getBoxItemList();
                boxItem.get(0).getChinese();
                boxItem.get(0).getAbout();
                Log.d(TAG, "SaveEnglish: " + boxItem);
                Log.d(TAG, "SaveEnglish: " + mManager.getAboutList());
                Log.d(TAG, "SaveEnglish: " + mManager.getChineseList());
                Log.d(TAG, "SaveEnglish: " + mManager.getSentenceList());
                break;
        }
    }

    private void addBoxItem() {
        BoxItem item = new BoxItem();
        item.setContent("Excuse me");
        mManager.add(item);

        //初始化相关项
        Chinese chineseExcuse = new Chinese();
        chineseExcuse.setContent("原谅我（很少会单独使用，c发音/g/）");
        mManager.add(chineseExcuse);

        AboutItem aboutItem = new AboutItem();
        aboutItem.setContent("excuse");
        aboutItem.setBoxItemId(item.getId());
        aboutItem.setChineseId(chineseExcuse.getId());
        mManager.add(aboutItem);

        //初始化四个中文解释
        Chinese chineseOne = new Chinese();
        chineseOne.setContent("对不起，打扰了");
        chineseOne.setBoxItemId(item.getId());
        mManager.add(chineseOne);

        Chinese chineseTwo = new Chinese();
        chineseTwo.setContent("借过（借过一下，让一让）");
        chineseTwo.setBoxItemId(item.getId());
        mManager.add(chineseTwo);

        Chinese chineseThree = new Chinese();
        chineseThree.setContent("失陪了");
        chineseThree.setBoxItemId(item.getId());
        mManager.add(chineseThree);

        Chinese chineseFour = new Chinese();
        chineseFour.setContent("麻烦再说一遍");
        chineseFour.setBoxItemId(item.getId());
        mManager.add(chineseFour);
    }

    private void addTwo() {
        BoxItem item = new BoxItem();
        item.setContent("yse");
        mManager.add(item);

        Chinese chineseOne = new Chinese();
        chineseOne.setContent("是的");
        chineseOne.setBoxItemId(item.getId());
        mManager.add(item);

        Chinese chineseTwo = new Chinese();
        chineseTwo.setContent("什么事？（要用升调去读）");
        chineseTwo.setBoxItemId(item.getId());
        mManager.add(item);
    }
}
