package com.shiro.reader;

public class JsonReader implements MalwareFeedReader {
    private String address;

    public JsonReader(String address) {
        this.address = address;
    }

    @Override
    public String readFeeds() {
        return null;
    }
}
