package org.shiro.model;

import java.util.ArrayList;
import java.util.List;

public class Feeds {

	private List<String> urls = new ArrayList<String>();
	private List<String> hashes = new ArrayList<String>();
	private List<String> ips = new ArrayList<String>();

	public void addUrl(String url) {
		urls.add(url);
	}

	public void addHash(String hash) {
		hashes.add(hash);
	}

	public void addIp(String ip) {
		ips.add(ip);
	}

}
