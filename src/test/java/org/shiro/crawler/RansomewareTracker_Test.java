package org.shiro.crawler;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Set;

import org.junit.Test;
import org.shiro.crawler.RansomwareTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RansomewareTracker_Test {

	private static final Logger log = LoggerFactory.getLogger(RansomewareTracker_Test.class);

	@Test
	public void test_ransomeware_service() {
		RansomwareTracker service = new RansomwareTracker();
		Set<String> feeds = service.getMalwareFeeds();
		assertNotNull(feeds);
		assertFalse(feeds.isEmpty());
		log.info("number of received feeds: " + feeds.size());
		log.info("first received feed: " + feeds.iterator().next());

	}

}
