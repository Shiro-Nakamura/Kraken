package org.shiro.services;

import java.util.Set;

import org.shiro.model.MalwareFeed;

public class OpenPhish implements FeedCrawlerService{
	
	private static final String ADDRESS = "https://openphish.com/feed.txt";

	public Set<MalwareFeed> getMalwareFeeds() {
		// TODO Auto-generated method stub
		return null;
	}

}
