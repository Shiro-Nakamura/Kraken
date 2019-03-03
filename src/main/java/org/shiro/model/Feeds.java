package org.shiro.model;

import java.util.ArrayList;
import java.util.List;

public class Feeds {

	private List<Feed> feeds = new ArrayList<Feed>();

	public void addtFeed(Feed feed) {
		feeds.add(feed);
	}

	public List<Feed> getFeeds() {
		return feeds;
	}
}
