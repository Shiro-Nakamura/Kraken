package com.shiro.model;

import java.util.ArrayList;
import java.util.List;

public class HashFeeds {

    private List<String> hashes = new ArrayList<>();
    private int size;

    public int getSize() {
        return hashes.size();
    }

    public List<String> getHashes() {
        return hashes;
    }

    public void setHashes(List<String> hashes) {
        this.hashes = hashes;
    }
}
