package com.andrewtse.kfgit.ui.adapter;

import com.andrewtse.kfgit.R;
import com.andrewtse.kfgit.ui.entity.ProfileItem;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * @author xk
 * @date 2019/2/21
 */
public class ProfileFragmentAdapter extends BaseQuickAdapter<ProfileItem, BaseViewHolder> {


    public ProfileFragmentAdapter(int layoutResId) {
        this(layoutResId, null);
    }

    public ProfileFragmentAdapter(@Nullable List<ProfileItem> data) {
        this(-1, data);
    }

    public ProfileFragmentAdapter(int layoutResId, @Nullable List<ProfileItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, ProfileItem item) {
        holder.setImageResource(R.id.iv_profile_item_icon, item.getIconId())
              .setText(R.id.tv_profile_item_name, item.getName());
    }
}
