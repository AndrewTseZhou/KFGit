package com.andrewtse.kfgit.ui.adapter;

import android.view.View;
import android.widget.ImageView;

import com.andrewtse.kfgit.R;
import com.andrewtse.kfgit.common.utils.ConvertUtils;
import com.andrewtse.kfgit.common.utils.GlideUtils;
import com.andrewtse.kfgit.model.StarredModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;

/**
 * @author xk
 * @date 2019/2/19
 */
public class StarredFragmentAdapter extends BaseQuickAdapter<StarredModel, StarredFragmentAdapter.StarredViewHolder> {

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
    protected void convert(StarredViewHolder holder, StarredModel item) {
        GlideUtils.loadImg(mContext, item.getOwner().getAvatarUrl(), (ImageView) holder.getView(R.id.iv_avatar));
        holder.setText(R.id.tv_full_name, item.getFullName());
        holder.setText(R.id.tv_description, item.getDescription());
        holder.setText(R.id.tv_updated_at, ConvertUtils.convertTime(item.getUpdatedAt()));
        holder.setText(R.id.tv_language, item.getLanguage());
        holder.setSelected(R.id.iv_star_state, true);
        holder.setText(R.id.tv_starred_count, String.valueOf(item.getStargazersCount()));
        holder.setSelected(R.id.iv_fork_state, item.isFork());
        holder.setText(R.id.tv_forks_count, String.valueOf(item.getForksCount()));
    }

    public static class StarredViewHolder extends BaseViewHolder {
        public StarredViewHolder(View view) {
            super(view);
        }

        public BaseViewHolder setSelected(@IdRes int viewId, boolean enable) {
            View view = getView(viewId);
            view.setSelected(enable);
            return this;
        }
    }
}
