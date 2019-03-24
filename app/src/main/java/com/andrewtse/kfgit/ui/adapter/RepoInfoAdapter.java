package com.andrewtse.kfgit.ui.adapter;

import com.andrewtse.kfgit.R;
import com.andrewtse.kfgit.ui.entity.RepoInfoItem;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * @author xk
 * @date 2019/3/18
 */
public class RepoInfoAdapter extends BaseQuickAdapter<RepoInfoItem, BaseViewHolder> {

    public RepoInfoAdapter(int layoutResId) {
        this(layoutResId, null);
    }

    public RepoInfoAdapter(@Nullable List<RepoInfoItem> data) {
        this(-1, data);
    }

    public RepoInfoAdapter(int layoutResId, @Nullable List<RepoInfoItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, RepoInfoItem item) {
        holder.setImageResource(R.id.iv_item_icon, item.getIconId())
              .setText(R.id.tv_item_key, item.getKey())
              .setText(R.id.tv_item_value, item.getValue());
    }
}
