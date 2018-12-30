package org.shiro.main;

import java.util.ArrayList;
import java.util.List;

import org.shiro.service.FeedCrawlerService;

public class Kraken {

	private List<FeedCrawlerService> services = new ArrayList<FeedCrawlerService>();

	public void addFeedCrawlerService(FeedCrawlerService service) {
		services.add(service);
	}

}
