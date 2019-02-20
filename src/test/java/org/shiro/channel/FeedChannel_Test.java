package org.shiro.channel;

import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

public class FeedChannel_Test {

	private static final String URL_GOOGLE = "www.google.com";
	private static final String MD5_EICAR = "44d88612fea8a8f36de82e1278abb02f";

	@Test
	public void test_feed_channel() {
		List<String> urlFeed = Arrays.asList(URL_GOOGLE);
		List<String> hashFeed = Arrays.asList(MD5_EICAR);

		ChannelManager manager = new ChannelManager();
		FeedChannel channel = new FeedChannel();

		manager.addObserver(channel);
		manager.addFeeds(urlFeed);

		Set<List<String>> currentFeeds = channel.getFeeds();
		assertThat(currentFeeds.size(), CoreMatchers.is(1));

		String firstFeed = currentFeeds.iterator().next().get(0);
		assertThat(firstFeed, CoreMatchers.is(URL_GOOGLE));

		manager.addFeeds(hashFeed);
		currentFeeds = channel.getFeeds();
		assertThat(currentFeeds.size(), CoreMatchers.is(2));

		String secondFeed = currentFeeds.iterator().next().get(0);
		assertThat(secondFeed, CoreMatchers.is(MD5_EICAR));

	}

}
