package org.shiro.converter;

import static org.junit.Assert.assertNotNull;

import java.util.Set;

import org.junit.Test;
import org.shiro.crawler.OpenPhish;
import org.shiro.main.Kraken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FeedConverter_Test {

	private static final Logger log = LoggerFactory.getLogger(FeedConverter_Test.class);

	@Test
	public void test_feed_to_json() {
		Kraken kraken = new Kraken();
		kraken.addFeedCrawlerService(new OpenPhish());
		kraken.collectFeeds();
		Set<String> feeds = kraken.getCurrentFeeds();

		String json = FeedConverter.transform(feeds);
		assertNotNull(json);
		log.info("feed json: " + json);
	}

}
