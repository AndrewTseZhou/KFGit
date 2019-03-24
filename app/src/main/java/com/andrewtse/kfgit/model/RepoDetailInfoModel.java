package com.andrewtse.kfgit.model;

import android.os.Parcel;

import com.andrewtse.kfgit.contract.IRepoDetailInfoContract;

/**
 * @author xk
 * @date 2019/3/17
 */
public class RepoDetailInfoModel extends BaseRepoModel implements IRepoDetailInfoContract.IRepoDetailInfoModel {

    private OwnerBean organization;

    private int network_count;

    private int subscribers_count;

    public OwnerBean getOrganization() {
        return organization;
    }

    public void setOrganization(OwnerBean organization) {
        this.organization = organization;
    }

    public int getNetworkCount() {
        return network_count;
    }

    public void setNetworkCount(int networkCount) {
        this.network_count = networkCount;
    }

    public int getSubscribersCount() {
        return subscribers_count;
    }

    public void setSubscribersCount(int subscribersCount) {
        this.subscribers_count = subscribersCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeParcelable(this.organization, flags);
        dest.writeInt(this.network_count);
        dest.writeInt(this.subscribers_count);
    }

    public RepoDetailInfoModel() {
    }

    protected RepoDetailInfoModel(Parcel in) {
        super(in);
        this.organization = in.readParcelable(OwnerBean.class.getClassLoader());
        this.network_count = in.readInt();
        this.subscribers_count = in.readInt();
    }

    public static final Creator<RepoDetailInfoModel> CREATOR = new Creator<RepoDetailInfoModel>() {
        @Override
        public RepoDetailInfoModel createFromParcel(Parcel source) {
            return new RepoDetailInfoModel(source);
        }

        @Override
        public RepoDetailInfoModel[] newArray(int size) {
            return new RepoDetailInfoModel[size];
        }
    };

    @Override
    public String toString() {
        return "RepoDetailInfoModel{" +
               "organization=" + organization +
               ", network_count=" + network_count +
               ", subscribers_count=" + subscribers_count +
               "} " + super.toString();
    }
}
