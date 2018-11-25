package org.shiro.services;

import java.util.Set;

import org.shiro.model.MalwareFeed;

public interface FeedCrawlerService {

	public Set<MalwareFeed> getMalwareFeeds();

}
