package com.andrewtse.kfgit.ui.adapter;

import android.graphics.Color;

import com.andrewtse.kfgit.R;
import com.andrewtse.kfgit.model.TrendingModel;
import com.andrewtse.kfgit.ui.holder.CustomViewHolder;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * @author xk
 * @date 2019/2/28
 */
public class TrendingFragmentAdapter extends BaseQuickAdapter<TrendingModel, CustomViewHolder> {

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
    protected void convert(CustomViewHolder holder, TrendingModel item) {
        holder.setSelected(R.id.iv_star_state, item.isStarred())
              .setSelected(R.id.iv_fork_state, item.isFork())
              .setText(R.id.tv_full_name, item.getFullName())
              .setText(R.id.tv_description, item.getDescription())
              .setText(R.id.tv_trend, item.getTrend())
              .setBackgroundColor(R.id.iv_language_type_color, Color.parseColor(item.getColor()))
              .setText(R.id.tv_language, item.getLanguage())
              .setText(R.id.tv_starred_count, item.getStarredCount())
              .setText(R.id.tv_forks_count, item.getForksCount());
    }
}
