package com.pierre.pierreboudonexercice4gson.Classes;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by Pierre on 10/05/2016.
 */
public class User {
    @SerializedName("login")
    private String login;
    @SerializedName("id")
    private int id;
    @SerializedName("avatar_url")
    private String avatar_url;
    @SerializedName("url")
    private String url;
    @SerializedName("html_url")
    private String html_url;
    @SerializedName("gists_url")
    private String gists_url;
    @SerializedName("type")
    private String type;
    @SerializedName("public_repos")
    private int public_repos;
    @SerializedName("created_at")
    private Date created_at;

    public User(String login, int id, String avatar_url, String url, String html_url, String gists_url, String type, int public_repos, Date created_at) {
        this.login = login;
        this.id = id;
        this.avatar_url = avatar_url;
        this.url = url;
        this.html_url = html_url;
        this.gists_url = gists_url;
        this.type = type;
        this.public_repos = public_repos;
        this.created_at = created_at;
    }

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

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getGists_url() {
        return gists_url;
    }

    public void setGists_url(String gists_url) {
        this.gists_url = gists_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPublic_repos() {
        return public_repos;
    }

    public void setPublic_repos(int public_repos) {
        this.public_repos = public_repos;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
