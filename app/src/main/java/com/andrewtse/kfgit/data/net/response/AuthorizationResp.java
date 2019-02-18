package com.andrewtse.kfgit.data.net.response;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author xk
 * @date 2019/2/17
 */
public class AuthorizationResp implements Parcelable {

    private int id;
    private String url;
    private AppBean app;
    private String token;
    private String hashed_token;
    private String token_last_eight;
    private String note;
    private String note_url;
    private String created_at;
    private String updated_at;
    private String fingerprint;
    private String[] scopes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public AppBean getApp() {
        return app;
    }

    public void setApp(AppBean app) {
        this.app = app;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getHashedToken() {
        return hashed_token;
    }

    public void setHashedToken(String hashedToken) {
        this.hashed_token = hashedToken;
    }

    public String getTokenLastEight() {
        return token_last_eight;
    }

    public void setTokenLastEight(String tokenLastEight) {
        this.token_last_eight = tokenLastEight;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNoteUrl() {
        return note_url;
    }

    public void setNoteUrl(String noteUrl) {
        this.note_url = noteUrl;
    }

    public String getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(String createdAt) {
        this.created_at = createdAt;
    }

    public String getUpdatedAt() {
        return updated_at;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updated_at = updatedAt;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    public String[] getScopes() {
        return scopes;
    }

    public void setScopes(String[] scopes) {
        this.scopes = scopes;
    }

    public AuthorizationResp() {
    }

    protected AuthorizationResp(Parcel in) {
        this.id = in.readInt();
        this.url = in.readString();
        this.app = in.readParcelable(AppBean.class.getClassLoader());
        this.token = in.readString();
        this.hashed_token = in.readString();
        this.token_last_eight = in.readString();
        this.note = in.readString();
        this.note_url = in.readString();
        this.created_at = in.readString();
        this.updated_at = in.readString();
        this.fingerprint = in.readString();
        this.scopes = in.createStringArray();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.url);
        dest.writeParcelable(this.app, flags);
        dest.writeString(this.token);
        dest.writeString(this.hashed_token);
        dest.writeString(this.token_last_eight);
        dest.writeString(this.note);
        dest.writeString(this.note_url);
        dest.writeString(this.created_at);
        dest.writeString(this.updated_at);
        dest.writeString(this.fingerprint);
        dest.writeStringArray(this.scopes);
    }

    public static final Parcelable.Creator<AuthorizationResp> CREATOR = new Parcelable.Creator<AuthorizationResp>() {
        @Override
        public AuthorizationResp createFromParcel(Parcel source) {
            return new AuthorizationResp(source);
        }

        @Override
        public AuthorizationResp[] newArray(int size) {
            return new AuthorizationResp[size];
        }
    };

    public static class AppBean implements Parcelable {
        private String name;
        private String url;
        private String client_id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getClient_id() {
            return client_id;
        }

        public void setClient_id(String client_id) {
            this.client_id = client_id;
        }

        public AppBean() {
        }

        protected AppBean(Parcel in) {
            this.name = in.readString();
            this.url = in.readString();
            this.client_id = in.readString();
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.name);
            dest.writeString(this.url);
            dest.writeString(this.client_id);
        }

        public static final Parcelable.Creator<AppBean> CREATOR = new Parcelable.Creator<AppBean>() {
            @Override
            public AppBean createFromParcel(Parcel source) {
                return new AppBean(source);
            }

            @Override
            public AppBean[] newArray(int size) {
                return new AppBean[size];
            }
        };
    }
}
