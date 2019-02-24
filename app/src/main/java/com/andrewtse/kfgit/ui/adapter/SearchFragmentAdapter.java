package com.andrewtse.kfgit.ui.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.andrewtse.kfgit.R;
import com.andrewtse.kfgit.model.SearchModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;

/**
 * @author xk
 * @date 2019/2/22
 */
public class SearchFragmentAdapter extends BaseQuickAdapter<SearchModel, SearchFragmentAdapter.SearchViewHolder> {

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
    protected void convert(SearchViewHolder holder, SearchModel item) {
        Glide.with(mContext)
             .asBitmap()
             .load(item.getOwner().getAvatarUrl())
             .diskCacheStrategy(DiskCacheStrategy.ALL)
             .into((ImageView) holder.getView(R.id.iv_avatar));
        holder.setText(R.id.tv_full_name, item.getFullName());
        holder.setText(R.id.tv_description, item.getDescription());
        holder.setText(R.id.tv_license_name, item.getLicense() != null ? item.getLicense().getName() : "None");
        holder.setText(R.id.tv_language, !TextUtils.isEmpty(item.getLanguage()) ? item.getLanguage() : "Unknown");
        holder.setSelected(R.id.iv_star_state, true);
        holder.setText(R.id.tv_starred_count, String.valueOf(item.getStargazersCount()));
        holder.setSelected(R.id.iv_fork_state, item.isFork());
        holder.setText(R.id.tv_forks_count, String.valueOf(item.getForksCount()));
    }

    public static class SearchViewHolder extends BaseViewHolder {

        public SearchViewHolder(View view) {
            super(view);
        }

        public BaseViewHolder setSelected(@IdRes int viewId, boolean enable) {
            View view = getView(viewId);
            view.setSelected(enable);
            return this;
        }
    }
}
