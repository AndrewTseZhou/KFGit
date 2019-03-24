package com.andrewtse.kfgit.ui.adapter;

import android.widget.ImageView;

import com.andrewtse.kfgit.R;
import com.andrewtse.kfgit.common.utils.ConvertUtils;
import com.andrewtse.kfgit.common.utils.GlideUtils;
import com.andrewtse.kfgit.model.StarredModel;
import com.andrewtse.kfgit.ui.holder.CustomViewHolder;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * @author xk
 * @date 2019/2/19
 */
public class StarredFragmentAdapter extends BaseQuickAdapter<StarredModel, CustomViewHolder> {

    public StarredFragmentAdapter(int layoutResId) {
        this(layoutResId, null);
    }

    public StarredFragmentAdapter(@Nullable List<StarredModel> data) {
        this(-1, data);
    }

    public StarredFragmentAdapter(int layoutResId, @Nullable List<StarredModel> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(CustomViewHolder holder, StarredModel item) {
        GlideUtils.loadImg(mContext, item.getOwner().getAvatarUrl(), (ImageView) holder.getView(R.id.iv_avatar));
        holder.setSelected(R.id.iv_star_state, true)
              .setSelected(R.id.iv_fork_state, item.isFork())
              .setText(R.id.tv_full_name, item.getFullName())
              .setText(R.id.tv_description, item.getDescription())
              .setText(R.id.tv_updated_at, ConvertUtils.convertTime(item.getUpdatedAt()))
              .setText(R.id.tv_language, item.getLanguage())
              .setText(R.id.tv_starred_count, String.valueOf(item.getStargazersCount()))
              .setText(R.id.tv_forks_count, String.valueOf(item.getForksCount()));
    }
}
