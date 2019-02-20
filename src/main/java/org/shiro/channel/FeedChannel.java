package org.shiro.channel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FeedChannel implements Channel {

	private Set<List<String>> feeds = new HashSet<>();

	@Override
	public void update(List<String> feed) {
		feeds.add(feed);
	}

	public Set<List<String>> getFeeds() {
		return feeds;
	}
}
