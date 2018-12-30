package org.shiro.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.shiro.model.MalwareFeed;
import org.shiro.services.FeedCrawlerService;
import org.shiro.services.OpenPhish;

public class Kraken {

	private List<FeedCrawlerService> services = new ArrayList<FeedCrawlerService>();

	public Kraken() {
		addBasicServices();
	}

	private void addBasicServices() {
		// services.add(new RansomwareTracker());
		services.add(new OpenPhish());
		// services.add(new PhishTank());
	}

	public void addFeedCrawlerService(FeedCrawlerService service) {
		services.add(service);
	}

	public Set<MalwareFeed> crawle() {
		Set<MalwareFeed> feeds = new HashSet<MalwareFeed>();

		for (FeedCrawlerService service : services) {
			feeds.addAll(service.getMalwareFeeds());
		}
		return feeds;
	}

}
