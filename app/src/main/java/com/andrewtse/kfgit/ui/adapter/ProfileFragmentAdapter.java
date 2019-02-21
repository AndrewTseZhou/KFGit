package com.andrewtse.kfgit.ui.adapter;

import android.view.View;

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
public class ProfileFragmentAdapter extends BaseQuickAdapter<ProfileItem, ProfileFragmentAdapter.ProfileViewHolder> {


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
    protected void convert(ProfileViewHolder holder, ProfileItem item) {
        holder.setImageResource(R.id.iv_profile_item_icon, item.getIconId());
        holder.setText(R.id.tv_profile_item_name, item.getName());
    }

    public static class ProfileViewHolder extends BaseViewHolder {

        public ProfileViewHolder(View view) {
            super(view);
        }
    }
}
