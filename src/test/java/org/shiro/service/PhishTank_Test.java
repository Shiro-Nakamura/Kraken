package org.shiro.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Set;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PhishTank_Test {

	private static final Logger log = LoggerFactory.getLogger(PhishTank_Test.class);

	@Test
	public void test_openphish_service() {
		PhishTank service = new PhishTank();
		Set<String> feeds = service.getMalwareFeeds();
		assertNotNull(feeds);
		assertFalse(feeds.isEmpty());
		log.info("number of received feeds: " + feeds.size());

		String firstFeed = feeds.iterator().next();
		log.info("first received feed: " + firstFeed);
		assertFalse(firstFeed.equals("{}"));

	}
}
