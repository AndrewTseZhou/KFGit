package com.andrewtse.kfgit.model;

import android.os.Parcel;

import com.andrewtse.kfgit.contract.ISearchContract;

/**
 * @author xk
 * @date 2019/2/22
 */
public class SearchModel extends RepoModel implements ISearchContract.ISearchModel {

    private double score;

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(this.score);
    }

    public SearchModel() {
    }

    protected SearchModel(Parcel in) {
        this.score = in.readDouble();
    }

    public static final Creator<SearchModel> CREATOR = new Creator<SearchModel>() {
        @Override
        public SearchModel createFromParcel(Parcel source) {
            return new SearchModel(source);
        }

        @Override
        public SearchModel[] newArray(int size) {
            return new SearchModel[size];
        }
    };
}
