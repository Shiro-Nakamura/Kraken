package org.shiro.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.shiro.reader.JsonReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PhishTank implements FeedCrawlerService {

	private static final Logger log = LoggerFactory.getLogger(PhishTank.class);
	private static final String ADDRESS = "http://data.phishtank.com/data/online-valid.json";

	public Set<String> getMalwareFeeds() {
		JsonReader reader = new JsonReader(ADDRESS);
		log.info("start reading from service: " + PhishTank.class.getSimpleName());
		String response = reader.readFeeds();
		if (response.isEmpty()) {
			log.warn("no content read from service: " + PhishTank.class.getSimpleName());
			return new HashSet<>();
		} else {
			log.info("finish read from service: " + PhishTank.class.getSimpleName());
			return new HashSet<>(Arrays.asList(response));

		}
	}
}
