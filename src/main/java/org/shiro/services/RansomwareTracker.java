package org.shiro.services;

import java.util.Set;

import org.shiro.model.MalwareFeed;

public class RansomwareTracker implements FeedCrawlerService{
	
	private static final String ADDRESS = "https://ransomwaretracker.abuse.ch/feeds/csv/";

	public Set<MalwareFeed> getMalwareFeeds() {
		// TODO Auto-generated method stub
		return null;
	}
}
