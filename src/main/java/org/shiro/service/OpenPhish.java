package org.shiro.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.shiro.reader.TextReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpenPhish implements FeedCrawlerService {

	private static final Logger log = LoggerFactory.getLogger(OpenPhish.class);
	private static final String ADDRESS = "https://openphish.com/feed.txt";

	public Set<String> getMalwareFeeds() {
		TextReader reader = new TextReader(ADDRESS);
		log.info("start reading from service: " + OpenPhish.class.getSimpleName());
		String response = reader.readFeeds();
		return convertResponseToFeeds(response);

	}

	private Set<String> convertResponseToFeeds(String response) {
		String[] urls = response.split("\n");
		log.info("finish read from service: " + OpenPhish.class.getSimpleName() + ", number of feeds: " + urls.length);
		return new HashSet<String>(Arrays.asList(urls));
	}

}
