package com.artron.baselib.adapter.recyclerview;

/**
 * Created by Diong on 2016/9/18.
 *
 */
public interface ItemViewDelegate<T> {

    int getItemViewLayoutId();

    boolean isForViewType(T item, int position);

    void convert(BaseViewHolder holder, T t, int position);

    boolean isEnable();
}
