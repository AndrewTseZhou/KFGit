package com.andrewtse.kfgit.ui.holder;

import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;

import androidx.annotation.IdRes;

/**
 * @author xk
 * @date 2019/3/24
 */
public class CustomViewHolder extends BaseViewHolder {

    public CustomViewHolder(View view) {
        super(view);
    }

    public CustomViewHolder setSelected(@IdRes int viewId, boolean selected) {
        View view = getView(viewId);
        view.setSelected(selected);
        return this;
    }
}
