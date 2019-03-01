package com.andrewtse.kfgit.model;

import com.andrewtse.kfgit.contract.ITrendingContract;

/**
 * @author xk
 * @date 2019/2/26
 */
public class TrendingModel implements ITrendingContract.ITrendingModel {

    private String mFullName;
    private String mDescription;
    private String mTrend;
    private String mColor;
    private String mLanguage;
    private String mStarredCount;
    private String mForksCount;
    private boolean mIsStarred;
    private boolean mIsFork;

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getTrend() {
        return mTrend;
    }

    public void setTrend(String trend) {
        mTrend = trend;
    }

    public String getColor() {
        return mColor;
    }

    public void setColor(String color) {
        mColor = color;
    }

    public String getLanguage() {
        return mLanguage;
    }

    public void setLanguage(String language) {
        mLanguage = language;
    }

    public String getStarredCount() {
        return mStarredCount;
    }

    public void setStarredCount(String starredCount) {
        mStarredCount = starredCount;
    }

    public String getForksCount() {
        return mForksCount;
    }

    public void setForksCount(String forksCount) {
        mForksCount = forksCount;
    }

    public boolean isStarred() {
        return mIsStarred;
    }

    public void setStarred(boolean starred) {
        mIsStarred = starred;
    }

    public boolean isFork() {
        return mIsFork;
    }

    public void setFork(boolean fork) {
        mIsFork = fork;
    }
}
