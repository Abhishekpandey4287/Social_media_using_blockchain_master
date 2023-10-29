package com.example.social_media_using_blockchain.models;
public class VideoModel {

    String description;
    String userName;
    String media_url;
    String songName;

    public VideoModel(String description, String userName, String media_url, String songName) {
        this.description = description;
        this.userName = userName;
        this.media_url = media_url;
        this.songName = songName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMedia_url() {
        return media_url;
    }

    public void setMedia_url(String media_url) {
        this.media_url = media_url;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }
}