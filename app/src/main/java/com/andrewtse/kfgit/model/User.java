package com.andrewtse.kfgit.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.andrewtse.kfgit.contract.ILoginContract;

/**
 * @author xk
 * @date 2019/2/17
 */
public class User implements ILoginContract.IUser, Parcelable {

    private String login;
    private int id;
    private String avatar_url;
    private String gravatar_id;
    private String url;
    private String html_url;
    private String followers_url;
    private String following_url;
    private String gists_url;
    private String starred_url;
    private String subscriptions_url;
    private String organizations_url;
    private String repos_url;
    private String events_url;
    private String received_events_url;
    private String type;
    private boolean site_admin;
    private String name;
    private String company;
    private String blog;
    private String location;
    private String email;
    private String hireable;
    private String bio;
    private int public_repos;
    private int public_gists;
    private int followers;
    private int following;
    private String created_at;
    private String updated_at;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatarUrl() {
        return avatar_url;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatar_url = avatarUrl;
    }

    public String getGravatarId() {
        return gravatar_id;
    }

    public void setGravatarId(String gravatarId) {
        this.gravatar_id = gravatarId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtmlUrl() {
        return html_url;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.html_url = htmlUrl;
    }

    public String getFollowersUrl() {
        return followers_url;
    }

    public void setFollowersUrl(String followersUrl) {
        this.followers_url = followersUrl;
    }

    public String getFollowingUrl() {
        return following_url;
    }

    public void setFollowingUrl(String followingUrl) {
        this.following_url = followingUrl;
    }

    public String getGistsUrl() {
        return gists_url;
    }

    public void setGistsUrl(String gistsUrl) {
        this.gists_url = gistsUrl;
    }

    public String getStarredUrl() {
        return starred_url;
    }

    public void setStarredUrl(String starredUrl) {
        this.starred_url = starredUrl;
    }

    public String getSubscriptionsUrl() {
        return subscriptions_url;
    }

    public void setSubscriptionsUrl(String subscriptionsUrl) {
        this.subscriptions_url = subscriptionsUrl;
    }

    public String getOrganizationsUrl() {
        return organizations_url;
    }

    public void setOrganizationsUrl(String organizationsUrl) {
        this.organizations_url = organizationsUrl;
    }

    public String getReposUrl() {
        return repos_url;
    }

    public void setReposUrl(String reposUrl) {
        this.repos_url = reposUrl;
    }

    public String getEventsUrl() {
        return events_url;
    }

    public void setEventsUrl(String eventsUrl) {
        this.events_url = eventsUrl;
    }

    public String getReceivedEventsUrl() {
        return received_events_url;
    }

    public void setReceivedEventsUrl(String receivedEventsUrl) {
        this.received_events_url = receivedEventsUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isSiteAdmin() {
        return site_admin;
    }

    public void setSiteAdmin(boolean siteAdmin) {
        this.site_admin = siteAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHireable() {
        return hireable;
    }

    public void setHireable(String hireable) {
        this.hireable = hireable;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getPublicRepos() {
        return public_repos;
    }

    public void setPublicRepos(int publicRepos) {
        this.public_repos = publicRepos;
    }

    public int getPublicGists() {
        return public_gists;
    }

    public void setPublicGists(int publicGists) {
        this.public_gists = publicGists;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.login);
        dest.writeInt(this.id);
        dest.writeString(this.avatar_url);
        dest.writeString(this.gravatar_id);
        dest.writeString(this.url);
        dest.writeString(this.html_url);
        dest.writeString(this.followers_url);
        dest.writeString(this.following_url);
        dest.writeString(this.gists_url);
        dest.writeString(this.starred_url);
        dest.writeString(this.subscriptions_url);
        dest.writeString(this.organizations_url);
        dest.writeString(this.repos_url);
        dest.writeString(this.events_url);
        dest.writeString(this.received_events_url);
        dest.writeString(this.type);
        dest.writeByte(this.site_admin ? (byte) 1 : (byte) 0);
        dest.writeString(this.name);
        dest.writeString(this.company);
        dest.writeString(this.blog);
        dest.writeString(this.location);
        dest.writeString(this.email);
        dest.writeString(this.hireable);
        dest.writeString(this.bio);
        dest.writeInt(this.public_repos);
        dest.writeInt(this.public_gists);
        dest.writeInt(this.followers);
        dest.writeInt(this.following);
        dest.writeString(this.created_at);
        dest.writeString(this.updated_at);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.login = in.readString();
        this.id = in.readInt();
        this.avatar_url = in.readString();
        this.gravatar_id = in.readString();
        this.url = in.readString();
        this.html_url = in.readString();
        this.followers_url = in.readString();
        this.following_url = in.readString();
        this.gists_url = in.readString();
        this.starred_url = in.readString();
        this.subscriptions_url = in.readString();
        this.organizations_url = in.readString();
        this.repos_url = in.readString();
        this.events_url = in.readString();
        this.received_events_url = in.readString();
        this.type = in.readString();
        this.site_admin = in.readByte() != 0;
        this.name = in.readString();
        this.company = in.readString();
        this.blog = in.readString();
        this.location = in.readString();
        this.email = in.readString();
        this.hireable = in.readString();
        this.bio = in.readString();
        this.public_repos = in.readInt();
        this.public_gists = in.readInt();
        this.followers = in.readInt();
        this.following = in.readInt();
        this.created_at = in.readString();
        this.updated_at = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public String toString() {
        return "User{" +
               "login='" + login + '\'' +
               ", id=" + id +
               ", avatar_url='" + avatar_url + '\'' +
               ", gravatar_id='" + gravatar_id + '\'' +
               ", url='" + url + '\'' +
               ", html_url='" + html_url + '\'' +
               ", followers_url='" + followers_url + '\'' +
               ", following_url='" + following_url + '\'' +
               ", gists_url='" + gists_url + '\'' +
               ", starred_url='" + starred_url + '\'' +
               ", subscriptions_url='" + subscriptions_url + '\'' +
               ", organizations_url='" + organizations_url + '\'' +
               ", repos_url='" + repos_url + '\'' +
               ", events_url='" + events_url + '\'' +
               ", received_events_url='" + received_events_url + '\'' +
               ", type='" + type + '\'' +
               ", site_admin=" + site_admin +
               ", name='" + name + '\'' +
               ", company='" + company + '\'' +
               ", blog='" + blog + '\'' +
               ", location='" + location + '\'' +
               ", email='" + email + '\'' +
               ", hireable='" + hireable + '\'' +
               ", bio='" + bio + '\'' +
               ", public_repos=" + public_repos +
               ", public_gists=" + public_gists +
               ", followers=" + followers +
               ", following=" + following +
               ", created_at='" + created_at + '\'' +
               ", updated_at='" + updated_at + '\'' +
               '}';
    }
}
