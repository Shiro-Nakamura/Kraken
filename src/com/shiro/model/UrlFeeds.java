package com.shiro.model;

import java.util.ArrayList;
import java.util.List;

public class UrlFeeds {

    private List<String> urls = new ArrayList<>();
    private int size;

    public int getSize() {
        return urls.size();
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
