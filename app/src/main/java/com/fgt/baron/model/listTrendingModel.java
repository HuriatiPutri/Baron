package com.fgt.baron.model;

public class listTrendingModel {

    private String category, title, user;

    public listTrendingModel(String category, String title, String user) {
        this.category = category;
        this.title = title;
        this.user = user;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
