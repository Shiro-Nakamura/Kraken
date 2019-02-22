package org.shiro.model;

import java.util.ArrayList;
import java.util.List;

public class Feeds {

	private List<FeedUrl> url = new ArrayList<FeedUrl>();
	private List<FeedIp> ip = new ArrayList<FeedIp>();
	private List<FeedHash> hash = new ArrayList<FeedHash>();

	public List<FeedUrl> getUrl() {
		return url;
	}

	public void setUrl(List<FeedUrl> url) {
		this.url = url;
	}

	public List<FeedIp> getIp() {
		return ip;
	}

	public void setIp(List<FeedIp> ip) {
		this.ip = ip;
	}

	public List<FeedHash> getHash() {
		return hash;
	}

	public void setHash(List<FeedHash> hash) {
		this.hash = hash;
	}
	
	public void addHash(String hash) {
		FeedHash feed = new FeedHash();
		feed.setHash(hash);
		this.hash.add(feed);
	}
	
	public void addIp(String ip) {
		FeedIp feed = new FeedIp();
		feed.setIp(ip);
		this.ip.add(feed);
	}
	
	public void addUrl(String url) {
		FeedUrl feed = new FeedUrl();
		feed.setUrl(url);
		this.url.add(feed);
	}

}
