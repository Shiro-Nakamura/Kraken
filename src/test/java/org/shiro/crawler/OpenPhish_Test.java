package org.shiro.crawler;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Set;

import org.junit.Test;
import org.shiro.crawler.OpenPhish;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenPhish_Test {

	private static final Logger log = LoggerFactory.getLogger(OpenPhish_Test.class);

	@Test
	public void test_openphish_service() {
		OpenPhish service = new OpenPhish();
		Set<String> feeds = service.getMalwareFeeds();
		assertNotNull(feeds);
		assertFalse(feeds.isEmpty());
		log.info("number of received feeds: " + feeds.size());
		log.info("first received feed: " + feeds.iterator().next());

	}

}
