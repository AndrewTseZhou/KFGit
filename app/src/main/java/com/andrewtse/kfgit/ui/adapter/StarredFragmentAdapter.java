package com.andrewtse.kfgit.ui.adapter;

import android.view.View;
import android.widget.ImageView;

import com.andrewtse.kfgit.R;
import com.andrewtse.kfgit.ui.entity.StarredItem;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;

/**
 * @author xk
 * @date 2019/2/19
 */
public class StarredFragmentAdapter extends BaseQuickAdapter<StarredItem, StarredFragmentAdapter.StarredViewHolder> {

    public StarredFragmentAdapter(int layoutResId) {
        this(layoutResId, null);
    }

    public StarredFragmentAdapter(@Nullable List<StarredItem> data) {
        this(-1, data);
    }

    public StarredFragmentAdapter(int layoutResId, @Nullable List<StarredItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(StarredViewHolder holder, StarredItem item) {
        Glide.with(mContext)
             .asBitmap()
             .load(item.getAvatarUrl())
             .diskCacheStrategy(DiskCacheStrategy.ALL)
             .into((ImageView) holder.getView(R.id.iv_avatar));
        holder.setText(R.id.tv_full_name, item.getFullName());
        holder.setText(R.id.tv_description, item.getDescription());
        holder.setText(R.id.tv_updated_at, convertTime(item.getUpdatedAt()));
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

    private String convertTime(String originalDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date passDate;
        Date nowDate;
        long diff;
        String result = "";

        try {
            passDate = sdf.parse(originalDate);
            String nowStr = sdf.format(new Date());
            nowDate = sdf.parse(nowStr);
            diff = nowDate.getTime() - passDate.getTime();

            if (diff / 60 / 60 / 24 / 7 / 31 / 12 / 1000 > 0) {
                result = "updated at " + (diff / 60 / 60 / 24 / 7 / 31 / 12 / 1000) + " year ago";
            } else if (diff / 60 / 60 / 24 / 7 / 31 / 1000 > 0) {
                result = "updated at " + (diff / 60 / 60 / 24 / 7 / 31 / 1000) + " months ago";
            } else if (diff / 60 / 60 / 24 / 7 / 1000 > 0) {
                result = "updated at " + (diff / 60 / 60 / 24 / 7 / 1000) + " week ago";
            } else if (diff / 60 / 60 / 24 / 1000 > 0) {
                result = "updated at " + (diff / 60 / 60 / 24 / 1000) + " days ago";
            } else if (diff / 60 / 60 / 1000 > 0) {
                result = "updated at " + (diff / 60 / 60 / 1000) + " hours ago";
            } else if (diff / 60 / 1000 > 0) {
                result = "updated at " + (diff / 60 / 1000) + " minutes ago";
            } else {
                result = "updated at " + "just now";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}
