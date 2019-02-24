package com.andrewtse.kfgit.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.andrewtse.kfgit.contract.ISearchContract;

/**
 * @author xk
 * @date 2019/2/22
 */
public class SearchModel implements ISearchContract.ISearchModel, Parcelable {

    private int id;
    private String node_id;
    private String name;
    private String full_name;
    private boolean privateX;
    private OwnerBean owner;
    private String html_url;
    private String description;
    private boolean fork;
    private String url;
    private String forks_url;
    private String keys_url;
    private String collaborators_url;
    private String teams_url;
    private String hooks_url;
    private String issue_events_url;
    private String events_url;
    private String assignees_url;
    private String branches_url;
    private String tags_url;
    private String blobs_url;
    private String git_tags_url;
    private String git_refs_url;
    private String trees_url;
    private String statuses_url;
    private String languages_url;
    private String stargazers_url;
    private String contributors_url;
    private String subscribers_url;
    private String subscription_url;
    private String commits_url;
    private String git_commits_url;
    private String comments_url;
    private String issue_comment_url;
    private String contents_url;
    private String compare_url;
    private String merges_url;
    private String archive_url;
    private String downloads_url;
    private String issues_url;
    private String pulls_url;
    private String milestones_url;
    private String notifications_url;
    private String labels_url;
    private String releases_url;
    private String deployments_url;
    private String created_at;
    private String updated_at;
    private String pushed_at;
    private String git_url;
    private String ssh_url;
    private String clone_url;
    private String svn_url;
    private String homepage;
    private int size;
    private int stargazers_count;
    private int watchers_count;
    private String language;
    private boolean has_issues;
    private boolean has_projects;
    private boolean has_downloads;
    private boolean has_wiki;
    private boolean has_pages;
    private int forks_count;
    private String mirror_url;
    private boolean archived;
    private int open_issues_count;
    private LicenseBean license;
    private int forks;
    private int open_issues;
    private int watchers;
    private String default_branch;
    private double score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNodeId() {
        return node_id;
    }

    public void setNodeId(String nodeId) {
        this.node_id = nodeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return full_name;
    }

    public void setFullName(String fullName) {
        this.full_name = fullName;
    }

    public boolean isPrivateX() {
        return privateX;
    }

    public void setPrivateX(boolean privateX) {
        this.privateX = privateX;
    }

    public OwnerBean getOwner() {
        return owner;
    }

    public void setOwner(OwnerBean owner) {
        this.owner = owner;
    }

    public String getHtmlUrl() {
        return html_url;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.html_url = htmlUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFork() {
        return fork;
    }

    public void setFork(boolean fork) {
        this.fork = fork;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getForksUrl() {
        return forks_url;
    }

    public void setForksUrl(String forksUrl) {
        this.forks_url = forksUrl;
    }

    public String getKeysUrl() {
        return keys_url;
    }

    public void setKeysUrl(String keysUrl) {
        this.keys_url = keysUrl;
    }

    public String getCollaboratorsUrl() {
        return collaborators_url;
    }

    public void setCollaboratorsUrl(String collaboratorsUrl) {
        this.collaborators_url = collaboratorsUrl;
    }

    public String getTeamsUrl() {
        return teams_url;
    }

    public void setTeamsUrl(String teamsUrl) {
        this.teams_url = teamsUrl;
    }

    public String getHooksUrl() {
        return hooks_url;
    }

    public void setHooksUrl(String hooksUrl) {
        this.hooks_url = hooksUrl;
    }

    public String getIssueEventsUrl() {
        return issue_events_url;
    }

    public void setIssueEventsUrl(String issueEventsUrl) {
        this.issue_events_url = issueEventsUrl;
    }

    public String getEventsUrl() {
        return events_url;
    }

    public void setEventsUrl(String eventsUrl) {
        this.events_url = eventsUrl;
    }

    public String getAssigneesUrl() {
        return assignees_url;
    }

    public void setAssigneesUrl(String assigneesUrl) {
        this.assignees_url = assigneesUrl;
    }

    public String getBranchesUrl() {
        return branches_url;
    }

    public void setBranchesUrl(String branchesUrl) {
        this.branches_url = branchesUrl;
    }

    public String getTagsUrl() {
        return tags_url;
    }

    public void setTagsUrl(String tagsUrl) {
        this.tags_url = tagsUrl;
    }

    public String getBlobsUrl() {
        return blobs_url;
    }

    public void setBlobsUrl(String blobsUrl) {
        this.blobs_url = blobsUrl;
    }

    public String getGitTagsUrl() {
        return git_tags_url;
    }

    public void setGitTagsUrl(String gitTagsUrl) {
        this.git_tags_url = gitTagsUrl;
    }

    public String getGitRefsUrl() {
        return git_refs_url;
    }

    public void setGitRefsUrl(String gitRefsUrl) {
        this.git_refs_url = gitRefsUrl;
    }

    public String getTreesUrl() {
        return trees_url;
    }

    public void setTreesUrl(String treesUrl) {
        this.trees_url = treesUrl;
    }

    public String getStatusesUrl() {
        return statuses_url;
    }

    public void setStatusesUrl(String statusesUrl) {
        this.statuses_url = statusesUrl;
    }

    public String getLanguagesUrl() {
        return languages_url;
    }

    public void setLanguagesUrl(String languagesUrl) {
        this.languages_url = languagesUrl;
    }

    public String getStargazersUrl() {
        return stargazers_url;
    }

    public void setStargazersUrl(String stargazersUrl) {
        this.stargazers_url = stargazersUrl;
    }

    public String getContributorsUrl() {
        return contributors_url;
    }

    public void setContributorsUrl(String contributorsUrl) {
        this.contributors_url = contributorsUrl;
    }

    public String getSubscribersUrl() {
        return subscribers_url;
    }

    public void setSubscribersUrl(String subscribersUrl) {
        this.subscribers_url = subscribersUrl;
    }

    public String getSubscriptionUrl() {
        return subscription_url;
    }

    public void setSubscriptionUrl(String subscriptionUrl) {
        this.subscription_url = subscriptionUrl;
    }

    public String getCommitsUrl() {
        return commits_url;
    }

    public void setCommitsUrl(String commitsUrl) {
        this.commits_url = commitsUrl;
    }

    public String getGitCommitsUrl() {
        return git_commits_url;
    }

    public void setGitCommitsUrl(String gitCommitsUrl) {
        this.git_commits_url = gitCommitsUrl;
    }

    public String getCommentsUrl() {
        return comments_url;
    }

    public void setCommentsUrl(String commentsUrl) {
        this.comments_url = commentsUrl;
    }

    public String getIssueCommentUrl() {
        return issue_comment_url;
    }

    public void setIssueCommentUrl(String issueCommentUrl) {
        this.issue_comment_url = issueCommentUrl;
    }

    public String getContentsUrl() {
        return contents_url;
    }

    public void setContentsUrl(String contentsUrl) {
        this.contents_url = contentsUrl;
    }

    public String getCompareUrl() {
        return compare_url;
    }

    public void setCompareUrl(String compareUrl) {
        this.compare_url = compareUrl;
    }

    public String getMergesUrl() {
        return merges_url;
    }

    public void setMergesUrl(String mergesUrl) {
        this.merges_url = mergesUrl;
    }

    public String getArchiveUrl() {
        return archive_url;
    }

    public void setArchiveUrl(String archiveUrl) {
        this.archive_url = archiveUrl;
    }

    public String getDownloadsUrl() {
        return downloads_url;
    }

    public void setDownloadsUrl(String downloadsUrl) {
        this.downloads_url = downloadsUrl;
    }

    public String getIssuesUrl() {
        return issues_url;
    }

    public void setIssuesUrl(String issuesUrl) {
        this.issues_url = issuesUrl;
    }

    public String getPullsUrl() {
        return pulls_url;
    }

    public void setPullsUrl(String pullsUrl) {
        this.pulls_url = pullsUrl;
    }

    public String getMilestonesUrl() {
        return milestones_url;
    }

    public void setMilestonesUrl(String milestonesUrl) {
        this.milestones_url = milestonesUrl;
    }

    public String getNotificationsUrl() {
        return notifications_url;
    }

    public void setNotificationsUrl(String notificationsUrl) {
        this.notifications_url = notificationsUrl;
    }

    public String getLabelsUrl() {
        return labels_url;
    }

    public void setLabelsUrl(String labelsUrl) {
        this.labels_url = labelsUrl;
    }

    public String getReleasesUrl() {
        return releases_url;
    }

    public void setReleasesUrl(String releasesUrl) {
        this.releases_url = releasesUrl;
    }

    public String getDeploymentsUrl() {
        return deployments_url;
    }

    public void setDeploymentsUrl(String deploymentsUrl) {
        this.deployments_url = deploymentsUrl;
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

    public String getPushedAt() {
        return pushed_at;
    }

    public void setPushedAt(String pushedAt) {
        this.pushed_at = pushedAt;
    }

    public String getGitUrl() {
        return git_url;
    }

    public void setGitUrl(String gitUrl) {
        this.git_url = gitUrl;
    }

    public String getSshUrl() {
        return ssh_url;
    }

    public void setSshUrl(String sshUrl) {
        this.ssh_url = sshUrl;
    }

    public String getCloneUrl() {
        return clone_url;
    }

    public void setCloneUrl(String cloneUrl) {
        this.clone_url = cloneUrl;
    }

    public String getSvnUrl() {
        return svn_url;
    }

    public void setSvnUrl(String svnUrl) {
        this.svn_url = svnUrl;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStargazersCount() {
        return stargazers_count;
    }

    public void setStargazersCount(int stargazersCount) {
        this.stargazers_count = stargazersCount;
    }

    public int getWatchersCount() {
        return watchers_count;
    }

    public void setWatchersCount(int watchersCount) {
        this.watchers_count = watchersCount;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isHasIssues() {
        return has_issues;
    }

    public void setHasIssues(boolean hasIssues) {
        this.has_issues = hasIssues;
    }

    public boolean isHasProjects() {
        return has_projects;
    }

    public void setHasProjects(boolean hasProjects) {
        this.has_projects = hasProjects;
    }

    public boolean isHasDownloads() {
        return has_downloads;
    }

    public void setHasDownloads(boolean hasDownloads) {
        this.has_downloads = hasDownloads;
    }

    public boolean isHasWiki() {
        return has_wiki;
    }

    public void setHasWiki(boolean hasWiki) {
        this.has_wiki = hasWiki;
    }

    public boolean isHasPages() {
        return has_pages;
    }

    public void setHasPages(boolean hasPages) {
        this.has_pages = hasPages;
    }

    public int getForksCount() {
        return forks_count;
    }

    public void setForksCount(int forksCount) {
        this.forks_count = forksCount;
    }

    public String getMirrorUrl() {
        return mirror_url;
    }

    public void setMirrorUrl(String mirrorUrl) {
        this.mirror_url = mirrorUrl;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public int getOpenIssuesCount() {
        return open_issues_count;
    }

    public void setOpenIssuesCount(int openIssuesCount) {
        this.open_issues_count = openIssuesCount;
    }

    public LicenseBean getLicense() {
        return license;
    }

    public void setLicense(LicenseBean license) {
        this.license = license;
    }

    public int getForks() {
        return forks;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

    public int getOpenIssues() {
        return open_issues;
    }

    public void setOpenIssues(int openIssues) {
        this.open_issues = openIssues;
    }

    public int getWatchers() {
        return watchers;
    }

    public void setWatchers(int watchers) {
        this.watchers = watchers;
    }

    public String getDefaultBranch() {
        return default_branch;
    }

    public void setDefaultBranch(String defaultBranch) {
        this.default_branch = defaultBranch;
    }

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
        dest.writeInt(this.id);
        dest.writeString(this.node_id);
        dest.writeString(this.name);
        dest.writeString(this.full_name);
        dest.writeByte(this.privateX ? (byte) 1 : (byte) 0);
        dest.writeParcelable(this.owner, flags);
        dest.writeString(this.html_url);
        dest.writeString(this.description);
        dest.writeByte(this.fork ? (byte) 1 : (byte) 0);
        dest.writeString(this.url);
        dest.writeString(this.forks_url);
        dest.writeString(this.keys_url);
        dest.writeString(this.collaborators_url);
        dest.writeString(this.teams_url);
        dest.writeString(this.hooks_url);
        dest.writeString(this.issue_events_url);
        dest.writeString(this.events_url);
        dest.writeString(this.assignees_url);
        dest.writeString(this.branches_url);
        dest.writeString(this.tags_url);
        dest.writeString(this.blobs_url);
        dest.writeString(this.git_tags_url);
        dest.writeString(this.git_refs_url);
        dest.writeString(this.trees_url);
        dest.writeString(this.statuses_url);
        dest.writeString(this.languages_url);
        dest.writeString(this.stargazers_url);
        dest.writeString(this.contributors_url);
        dest.writeString(this.subscribers_url);
        dest.writeString(this.subscription_url);
        dest.writeString(this.commits_url);
        dest.writeString(this.git_commits_url);
        dest.writeString(this.comments_url);
        dest.writeString(this.issue_comment_url);
        dest.writeString(this.contents_url);
        dest.writeString(this.compare_url);
        dest.writeString(this.merges_url);
        dest.writeString(this.archive_url);
        dest.writeString(this.downloads_url);
        dest.writeString(this.issues_url);
        dest.writeString(this.pulls_url);
        dest.writeString(this.milestones_url);
        dest.writeString(this.notifications_url);
        dest.writeString(this.labels_url);
        dest.writeString(this.releases_url);
        dest.writeString(this.deployments_url);
        dest.writeString(this.created_at);
        dest.writeString(this.updated_at);
        dest.writeString(this.pushed_at);
        dest.writeString(this.git_url);
        dest.writeString(this.ssh_url);
        dest.writeString(this.clone_url);
        dest.writeString(this.svn_url);
        dest.writeString(this.homepage);
        dest.writeInt(this.size);
        dest.writeInt(this.stargazers_count);
        dest.writeInt(this.watchers_count);
        dest.writeString(this.language);
        dest.writeByte(this.has_issues ? (byte) 1 : (byte) 0);
        dest.writeByte(this.has_projects ? (byte) 1 : (byte) 0);
        dest.writeByte(this.has_downloads ? (byte) 1 : (byte) 0);
        dest.writeByte(this.has_wiki ? (byte) 1 : (byte) 0);
        dest.writeByte(this.has_pages ? (byte) 1 : (byte) 0);
        dest.writeInt(this.forks_count);
        dest.writeString(this.mirror_url);
        dest.writeByte(this.archived ? (byte) 1 : (byte) 0);
        dest.writeInt(this.open_issues_count);
        dest.writeParcelable(this.license, flags);
        dest.writeInt(this.forks);
        dest.writeInt(this.open_issues);
        dest.writeInt(this.watchers);
        dest.writeString(this.default_branch);
        dest.writeDouble(this.score);
    }

    public SearchModel() {
    }

    protected SearchModel(Parcel in) {
        this.id = in.readInt();
        this.node_id = in.readString();
        this.name = in.readString();
        this.full_name = in.readString();
        this.privateX = in.readByte() != 0;
        this.owner = in.readParcelable(OwnerBean.class.getClassLoader());
        this.html_url = in.readString();
        this.description = in.readString();
        this.fork = in.readByte() != 0;
        this.url = in.readString();
        this.forks_url = in.readString();
        this.keys_url = in.readString();
        this.collaborators_url = in.readString();
        this.teams_url = in.readString();
        this.hooks_url = in.readString();
        this.issue_events_url = in.readString();
        this.events_url = in.readString();
        this.assignees_url = in.readString();
        this.branches_url = in.readString();
        this.tags_url = in.readString();
        this.blobs_url = in.readString();
        this.git_tags_url = in.readString();
        this.git_refs_url = in.readString();
        this.trees_url = in.readString();
        this.statuses_url = in.readString();
        this.languages_url = in.readString();
        this.stargazers_url = in.readString();
        this.contributors_url = in.readString();
        this.subscribers_url = in.readString();
        this.subscription_url = in.readString();
        this.commits_url = in.readString();
        this.git_commits_url = in.readString();
        this.comments_url = in.readString();
        this.issue_comment_url = in.readString();
        this.contents_url = in.readString();
        this.compare_url = in.readString();
        this.merges_url = in.readString();
        this.archive_url = in.readString();
        this.downloads_url = in.readString();
        this.issues_url = in.readString();
        this.pulls_url = in.readString();
        this.milestones_url = in.readString();
        this.notifications_url = in.readString();
        this.labels_url = in.readString();
        this.releases_url = in.readString();
        this.deployments_url = in.readString();
        this.created_at = in.readString();
        this.updated_at = in.readString();
        this.pushed_at = in.readString();
        this.git_url = in.readString();
        this.ssh_url = in.readString();
        this.clone_url = in.readString();
        this.svn_url = in.readString();
        this.homepage = in.readString();
        this.size = in.readInt();
        this.stargazers_count = in.readInt();
        this.watchers_count = in.readInt();
        this.language = in.readString();
        this.has_issues = in.readByte() != 0;
        this.has_projects = in.readByte() != 0;
        this.has_downloads = in.readByte() != 0;
        this.has_wiki = in.readByte() != 0;
        this.has_pages = in.readByte() != 0;
        this.forks_count = in.readInt();
        this.mirror_url = in.readString();
        this.archived = in.readByte() != 0;
        this.open_issues_count = in.readInt();
        this.license = in.readParcelable(LicenseBean.class.getClassLoader());
        this.forks = in.readInt();
        this.open_issues = in.readInt();
        this.watchers = in.readInt();
        this.default_branch = in.readString();
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

    public static class OwnerBean implements Parcelable {
        private String login;
        private int id;
        private String node_id;
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

        public String getNodeId() {
            return node_id;
        }

        public void setNodeId(String nodeId) {
            this.node_id = nodeId;
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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.login);
            dest.writeInt(this.id);
            dest.writeString(this.node_id);
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
        }

        public OwnerBean() {
        }

        protected OwnerBean(Parcel in) {
            this.login = in.readString();
            this.id = in.readInt();
            this.node_id = in.readString();
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
        }

        public static final Creator<OwnerBean> CREATOR = new Creator<OwnerBean>() {
            @Override
            public OwnerBean createFromParcel(Parcel source) {
                return new OwnerBean(source);
            }

            @Override
            public OwnerBean[] newArray(int size) {
                return new OwnerBean[size];
            }
        };
    }

    public static class LicenseBean implements Parcelable {
        private String key;
        private String name;
        private String spdx_id;
        private String url;
        private String node_id;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSpdxId() {
            return spdx_id;
        }

        public void setSpdxId(String spdxId) {
            this.spdx_id = spdxId;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getNodeId() {
            return node_id;
        }

        public void setNodeId(String nodeId) {
            this.node_id = nodeId;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.key);
            dest.writeString(this.name);
            dest.writeString(this.spdx_id);
            dest.writeString(this.url);
            dest.writeString(this.node_id);
        }

        public LicenseBean() {
        }

        protected LicenseBean(Parcel in) {
            this.key = in.readString();
            this.name = in.readString();
            this.spdx_id = in.readString();
            this.url = in.readString();
            this.node_id = in.readString();
        }

        public static final Creator<LicenseBean> CREATOR = new Creator<LicenseBean>() {
            @Override
            public LicenseBean createFromParcel(Parcel source) {
                return new LicenseBean(source);
            }

            @Override
            public LicenseBean[] newArray(int size) {
                return new LicenseBean[size];
            }
        };
    }
}
