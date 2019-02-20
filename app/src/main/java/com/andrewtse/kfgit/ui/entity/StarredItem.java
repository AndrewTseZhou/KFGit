package com.andrewtse.kfgit.ui.entity;

/**
 * @author xk
 * @date 2019/2/20
 */
public class StarredItem {

    private String avatar_url;
    private String full_name;
    private String description;
    private String updated_at;
    private String language;
    private int stargazers_count;
    private boolean fork;

    private int forks_count;

    public String getAvatarUrl() {
        return avatar_url;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatar_url = avatarUrl;
    }

    public String getFullName() {
        return full_name;
    }

    public void setFullName(String fullName) {
        this.full_name = fullName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUpdatedAt() {
        return updated_at;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updated_at = updatedAt;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getStargazersCount() {
        return stargazers_count;
    }

    public void setStargazersCount(int stargazersCount) {
        this.stargazers_count = stargazersCount;
    }

    public boolean isFork() {
        return fork;
    }

    public void setFork(boolean fork) {
        this.fork = fork;
    }

    public int getForksCount() {
        return forks_count;
    }

    public void setForksCount(int forksCount) {
        this.forks_count = forksCount;
    }
}
