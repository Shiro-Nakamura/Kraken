package com.shiro.service;

import com.shiro.reader.JsonReader;
import com.shiro.reader.MalwareFeedReader;
import com.shiro.reader.TextReader;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class OpenPhishService {

    private static final String ADDRESS = "https://openphish.com/feed.txt";
    private static MalwareFeedReader reader = new TextReader(ADDRESS);

    private PropertyChangeSupport changes = new PropertyChangeSupport(this);;
    private static Timer updateTimer = new Timer();
    private static long period = TimeUnit.SECONDS.toMillis(5);


    public void update() {
        updateTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                String response = reader.readFeeds();
                MalwareFeedResponse feed = convertToMalwareFeed(response);
                changes.firePropertyChange("malwareFeed", malwareFeed,feed);
                System.out.println(malwareFeed.toString());
            }
        }, 0, period);
    }


    private MalwareFeedResponse convertToMalwareFeed(String response) {
        List<String> urls = new ArrayList<>();
        urls.add("test");
        malwareFeed.getUrl().setUrls(urls);
        return malwareFeed;
    }

    public static void main(String[] args){
        OpenPhishService service = new OpenPhishService();
        service.update();


    }



}
