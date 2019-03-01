package com.andrewtse.kfgit.ui.adapter;

import android.graphics.Color;
import android.view.View;

import com.andrewtse.kfgit.R;
import com.andrewtse.kfgit.model.TrendingModel;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;

/**
 * @author xk
 * @date 2019/2/28
 */
public class TrendingFragmentAdapter extends BaseQuickAdapter<TrendingModel, TrendingFragmentAdapter.TrendingViewHolder> {

    public TrendingFragmentAdapter(int layoutResId) {
        this(layoutResId, null);
    }

    public TrendingFragmentAdapter(@Nullable List<TrendingModel> data) {
        this(-1, data);
    }

    public TrendingFragmentAdapter(int layoutResId, @Nullable List<TrendingModel> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(TrendingViewHolder holder, TrendingModel item) {
        holder.setText(R.id.tv_full_name, item.getFullName());
        holder.setText(R.id.tv_description, item.getDescription());
        holder.setText(R.id.tv_trend, item.getTrend());
        holder.setBackgroundColor(R.id.iv_language_type_color, Color.parseColor(item.getColor()));
        holder.setText(R.id.tv_language, item.getLanguage());
        holder.setSelected(R.id.iv_star_state, item.isStarred());
        holder.setText(R.id.tv_starred_count, item.getStarredCount());
        holder.setSelected(R.id.iv_fork_state, item.isFork());
        holder.setText(R.id.tv_forks_count, item.getForksCount());
    }

    public static class TrendingViewHolder extends BaseViewHolder {

        public TrendingViewHolder(View view) {
            super(view);
        }

        public BaseViewHolder setSelected(@IdRes int viewId, boolean enable) {
            View view = getView(viewId);
            view.setSelected(enable);
            return this;
        }
    }
}
