package org.shiro.services;

import java.util.Set;

import org.shiro.model.MalwareFeed;

public class PhishTank implements FeedCrawlerService{
	
	private static final String ADDRESS = "http://data.phishtank.com/data/online-valid.json";

	public Set<MalwareFeed> getMalwareFeeds() {
		// TODO Auto-generated method stub
		return null;
	}

}
