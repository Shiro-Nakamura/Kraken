package org.shiro.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.shiro.crawler.OpenPhish;
import org.shiro.crawler.RansomwareTracker;
import org.shiro.service.Kraken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Kraken_Service_Test {

	private static final Logger log = LoggerFactory.getLogger(Kraken_Service_Test.class);

	@Test
	public void test_kraken_collect_feeds() {
		Kraken kraken = new Kraken();
		kraken.addFeedCrawlerService(new OpenPhish());
		kraken.collectFeeds();

		Set<String> feeds = kraken.getCurrentFeeds();
		assertNotNull(feeds);
		assertTrue(feeds.size() > 0);

		log.info("feed size: " + feeds.size());
		log.info("first feed: " + feeds.iterator().next());
	}

	
	@Test
	public void test_kraken_thread() {
		Kraken kraken = new Kraken();
		kraken.addFeedCrawlerService(new OpenPhish());
		kraken.addFeedCrawlerService(new RansomwareTracker());
		kraken.setTimeUnit(TimeUnit.SECONDS);
		kraken.setInterval(10);
		
		Thread thread = new Thread(kraken);
		thread.start();
		
		try {
			TimeUnit.SECONDS.sleep(15);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		kraken.setRunning(false);
		Set<String> feeds = kraken.getCurrentFeeds();
		assertNotNull(feeds);
		assertTrue(feeds.size() > 0);

		log.info("feed size: " + feeds.size());
		log.info("first feed: " + feeds.iterator().next());
		
	}
}
