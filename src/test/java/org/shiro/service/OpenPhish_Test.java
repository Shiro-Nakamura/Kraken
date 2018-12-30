package org.shiro.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Set;

import org.junit.Test;

public class OpenPhish_Test {

	@Test
	public void test_openphish_service() {
		OpenPhish service = new OpenPhish();
		Set<String> feeds = service.getMalwareFeeds();
		assertNotNull(feeds);
		assertFalse(feeds.isEmpty());
	}

}
