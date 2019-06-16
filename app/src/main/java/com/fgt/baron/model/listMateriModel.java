package com.fgt.baron.model;

public class listMateriModel {

    private int imgProfile, imgContent;
    private String textUser, textTitle;

    public listMateriModel(int imgProfile, int imgContent, String textUser, String textTitle) {
        this.imgProfile = imgProfile;
        this.imgContent = imgContent;
        this.textUser = textUser;
        this.textTitle = textTitle;
    }

    public int getImgProfile() {
        return imgProfile;
    }

    public void setImgProfile(int imgProfile) {
        this.imgProfile = imgProfile;
    }

    public int getImgContent() {
        return imgContent;
    }

    public void setImgContent(int imgContent) {
        this.imgContent = imgContent;
    }

    public String getTextUser() {
        return textUser;
    }

    public void setTextUser(String textUser) {
        this.textUser = textUser;
    }

    public String getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
    }
}
