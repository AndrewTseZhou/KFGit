package com.andrewtse.kfgit.common.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * @author xk
 * @date 2019/3/17
 */
public class GlideUtils {

    public static void loadImg(Context context, String url, ImageView imageView) {
        Glide.with(context)
             .asBitmap()
             .load(url)
             .diskCacheStrategy(DiskCacheStrategy.ALL)
             .into(imageView);
    }
}
