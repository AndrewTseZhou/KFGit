package com.andrewtse.kfgit.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.andrewtse.kfgit.contract.IStarredContract;

/**
 * @author xk
 * @date 2019/2/19
 */
public class StarredModel extends BaseRepoModel implements IStarredContract.IStarredModel {

    private PermissionsBean permissions;

    public PermissionsBean getPermissions() {
        return permissions;
    }

    public void setPermissions(PermissionsBean permissions) {
        this.permissions = permissions;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.permissions, flags);
    }

    public StarredModel() {
    }

    protected StarredModel(Parcel in) {
        this.permissions = in.readParcelable(PermissionsBean.class.getClassLoader());
    }

    public static final Creator<StarredModel> CREATOR = new Creator<StarredModel>() {
        @Override
        public StarredModel createFromParcel(Parcel source) {
            return new StarredModel(source);
        }

        @Override
        public StarredModel[] newArray(int size) {
            return new StarredModel[size];
        }
    };

    public static class PermissionsBean implements Parcelable {
        private boolean admin;
        private boolean push;
        private boolean pull;

        public boolean isAdmin() {
            return admin;
        }

        public void setAdmin(boolean admin) {
            this.admin = admin;
        }

        public boolean isPush() {
            return push;
        }

        public void setPush(boolean push) {
            this.push = push;
        }

        public boolean isPull() {
            return pull;
        }

        public void setPull(boolean pull) {
            this.pull = pull;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeByte(this.admin ? (byte) 1 : (byte) 0);
            dest.writeByte(this.push ? (byte) 1 : (byte) 0);
            dest.writeByte(this.pull ? (byte) 1 : (byte) 0);
        }

        public PermissionsBean() {
        }

        protected PermissionsBean(Parcel in) {
            this.admin = in.readByte() != 0;
            this.push = in.readByte() != 0;
            this.pull = in.readByte() != 0;
        }

        public static final Creator<PermissionsBean> CREATOR = new Creator<PermissionsBean>() {
            @Override
            public PermissionsBean createFromParcel(Parcel source) {
                return new PermissionsBean(source);
            }

            @Override
            public PermissionsBean[] newArray(int size) {
                return new PermissionsBean[size];
            }
        };

        @Override
        public String toString() {
            return "PermissionsBean{" +
                   "admin=" + admin +
                   ", push=" + push +
                   ", pull=" + pull +
                   '}';
        }
    }

    @Override
    public String toString() {
        return "StarredModel{" +
               "permissions=" + permissions +
               "} " + super.toString();
    }
}
