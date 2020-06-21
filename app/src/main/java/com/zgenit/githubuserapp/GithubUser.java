package com.zgenit.githubuserapp;

import android.os.Parcel;
import android.os.Parcelable;

public class GithubUser implements Parcelable {

    private String username;
    private String name;
    private int avatar;
    private String company;
    private String location;
    private int repository;
    private int follower;
    private int following;

    public GithubUser(){
    }

    protected GithubUser(Parcel in) {
        username = in.readString();
        name = in.readString();
        avatar = in.readInt();
        company = in.readString();
        location = in.readString();
        repository = in.readInt();
        follower = in.readInt();
        following = in.readInt();
    }

    public static final Creator<GithubUser> CREATOR = new Creator<GithubUser>() {
        @Override
        public GithubUser createFromParcel(Parcel in) {
            return new GithubUser(in);
        }

        @Override
        public GithubUser[] newArray(int size) {
            return new GithubUser[size];
        }
    };

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRepository() {
        return repository;
    }

    public void setRepository(int repository) {
        this.repository = repository;
    }

    public int getFollower() {
        return follower;
    }

    public void setFollower(int follower) {
        this.follower = follower;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(name);
        dest.writeInt(avatar);
        dest.writeString(company);
        dest.writeString(location);
        dest.writeInt(repository);
        dest.writeInt(follower);
        dest.writeInt(following);
    }
}
