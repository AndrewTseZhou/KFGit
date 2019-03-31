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
    private int mStarredCount;
    private int mForksCount;
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

    public int getStarredCount() {
        return mStarredCount;
    }

    public void setStarredCount(String starredCount) {
        if (starredCount.contains(",")) {
            String strCount = starredCount.replace(",", "");
            mStarredCount = Integer.valueOf(strCount);
        } else {
            mStarredCount = Integer.valueOf(starredCount);
        }
    }

    public int getForksCount() {
        return mForksCount;
    }

    public void setForksCount(String forksCount) {
        if (forksCount.contains(",")) {
            String strCount = forksCount.replace(",", "");
            mForksCount = Integer.valueOf(strCount);
        } else {
            mForksCount = Integer.valueOf(forksCount);
        }
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

    @Override
    public String toString() {
        return "TrendingModel{" +
               "mFullName='" + mFullName + '\'' +
               ", mDescription='" + mDescription + '\'' +
               ", mTrend='" + mTrend + '\'' +
               ", mColor='" + mColor + '\'' +
               ", mLanguage='" + mLanguage + '\'' +
               ", mStarredCount='" + mStarredCount + '\'' +
               ", mForksCount='" + mForksCount + '\'' +
               ", mIsStarred=" + mIsStarred +
               ", mIsFork=" + mIsFork +
               '}';
    }
}
