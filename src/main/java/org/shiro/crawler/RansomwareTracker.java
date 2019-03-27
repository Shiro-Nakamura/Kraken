package org.shiro.crawler;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.shiro.reader.CsvReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RansomwareTracker implements FeedCrawler {

	private static final Logger log = LoggerFactory.getLogger(RansomwareTracker.class);
	private static final String ADDRESS = "https://ransomwaretracker.abuse.ch/feeds/csv/";

	public Set<String> getMalwareFeeds() {
		CsvReader reader = new CsvReader(ADDRESS, ",", "#");
		log.info("start reading from service: " + RansomwareTracker.class.getSimpleName());
		String response = reader.readFeeds();
		return convertResponseToFeeds(response);
	}

	private Set<String> convertResponseToFeeds(String response) {
		String[] urls = response.split("\n");
		log.info("finish read from service: " + RansomwareTracker.class.getSimpleName() + ", number of feeds: " + urls.length);
		return new HashSet<String>(Arrays.asList(urls));
	}
}
