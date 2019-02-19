package org.shiro.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Set;

import org.junit.Test;
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
	}

}
