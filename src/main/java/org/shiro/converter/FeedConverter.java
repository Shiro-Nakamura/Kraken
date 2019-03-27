package org.shiro.converter;

import java.util.Collection;

import org.apache.commons.validator.routines.InetAddressValidator;
import org.apache.commons.validator.routines.UrlValidator;
import org.shiro.model.Feeds;

import com.google.gson.Gson;

public class FeedConverter {

	public static String transform(Collection<String> collectedFeeds) {
		Feeds feeds = new Feeds();
		for (String feed : collectedFeeds) {
			if (isValidIp(feed)) {
				feeds.addIp(feed);
			} else if (isValidUrl(feed)) {
				feeds.addUrl(feed);
			} else if (isValidHash(feed)) {
				feeds.addHash(feed);
			}
		}
		Gson gson = new Gson();
		return gson.toJson(feeds);
	}

	private static boolean isValidUrl(String url) {
		UrlValidator validator = new UrlValidator();
		return validator.isValid(url);
	}

	private static boolean isValidIp(String ip) {
		InetAddressValidator validator = new InetAddressValidator();
		return validator.isValid(ip);
	}

	private static boolean isValidHash(String hash) {
		return (isValidMd5(hash) || isValidSHA1(hash));
	}

	private static boolean isValidMd5(String s) {
		return s.matches("^[a-fA-F0-9]{32}$");
	}

	private static boolean isValidSHA1(String s) {
		return s.matches("^[a-fA-F0-9]{40}$");
	}

}
