package org.shiro.model;

import java.util.ArrayList;
import java.util.List;

public class Feeds {

	private List<String> feeds = new ArrayList<String>();

	public void addtFeed(String feed) {
		feeds.add(feed);
	}

	public List<String> getFeeds() {
		return feeds;
	}
}
