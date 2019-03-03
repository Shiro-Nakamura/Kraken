package org.shiro.converter;

import java.util.Collection;

import org.shiro.model.Feeds;

import com.google.gson.Gson;

public class FeedConverter {

	public static String transform(Collection<String> collectedFeeds) {
		Feeds feeds = new Feeds();
		for (String feed : collectedFeeds) {
			feeds.addtFeed(feed);
		}
		Gson gson = new Gson();
		return gson.toJson(feeds);
	}
}
