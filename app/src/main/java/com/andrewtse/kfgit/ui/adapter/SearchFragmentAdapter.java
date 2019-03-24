package com.andrewtse.kfgit.ui.adapter;

import android.text.TextUtils;
import android.widget.ImageView;

import com.andrewtse.kfgit.R;
import com.andrewtse.kfgit.common.utils.GlideUtils;
import com.andrewtse.kfgit.model.SearchModel;
import com.andrewtse.kfgit.ui.holder.CustomViewHolder;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * @author xk
 * @date 2019/2/22
 */
public class SearchFragmentAdapter extends BaseQuickAdapter<SearchModel, CustomViewHolder> {

    public SearchFragmentAdapter(int layoutResId) {
        this(layoutResId, null);
    }

    public SearchFragmentAdapter(@Nullable List<SearchModel> data) {
        this(-1, data);
    }

    public SearchFragmentAdapter(int layoutResId, @Nullable List<SearchModel> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(CustomViewHolder holder, SearchModel item) {
        GlideUtils.loadImg(mContext, item.getOwner().getAvatarUrl(), (ImageView) holder.getView(R.id.iv_avatar));
        holder.setSelected(R.id.iv_star_state, true)
              .setSelected(R.id.iv_fork_state, item.isFork())
              .setText(R.id.tv_full_name, item.getFullName())
              .setText(R.id.tv_description, item.getDescription())
              .setText(R.id.tv_license_name, item.getLicense() != null ? item.getLicense().getName() : "None")
              .setText(R.id.tv_language, !TextUtils.isEmpty(item.getLanguage()) ? item.getLanguage() : "Unknown")
              .setText(R.id.tv_starred_count, String.valueOf(item.getStargazersCount()))
              .setText(R.id.tv_forks_count, String.valueOf(item.getForksCount()));
    }
}
