package com.andrewtse.kfgit.common.utils;

import android.os.Bundle;
import android.view.View;

import com.andrewtse.kfgit.model.BaseRepoModel;
import com.andrewtse.kfgit.model.TrendingModel;
import com.andrewtse.kfgit.ui.module.repo.RepoDetailInfoActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;

/**
 * @author xk
 * @date 2019/3/18
 * 处理repo item的点击事件工具类
 */
public class ClickUtils {

    public static void handleTrendingRepoClick(BaseQuickAdapter adapter, View view, int position) {
        Bundle bundle = new Bundle();
        TrendingModel modelInfo = (TrendingModel) adapter.getItem(position);
        if (modelInfo != null && modelInfo.getFullName() != null) {
            String[] fullName = modelInfo.getFullName().split("/");
            bundle.putString(RepoDetailInfoActivity.OWNER_NAME, fullName[0].trim());
            bundle.putString(RepoDetailInfoActivity.REPO_NAME, fullName[1].trim());
            ActivityUtils.startActivity(bundle, ActivityUtils.getTopActivity(), RepoDetailInfoActivity.class);
        }
    }

    public static void handleBaseRepoClick(BaseQuickAdapter adapter, View view, int position) {
        Bundle bundle = new Bundle();
        BaseRepoModel modelInfo = (BaseRepoModel) adapter.getItem(position);
        if (modelInfo != null) {
            bundle.putString(RepoDetailInfoActivity.OWNER_NAME, modelInfo.getOwner().getLogin());
            bundle.putString(RepoDetailInfoActivity.REPO_NAME, modelInfo.getName());
            ActivityUtils.startActivity(bundle, ActivityUtils.getTopActivity(), RepoDetailInfoActivity.class);
        }
    }
}
