package org.shiro.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import org.shiro.crawler.FeedCrawler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Kraken implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(Kraken.class);

	private Set<String> currentFeeds = new HashSet<String>();
	private List<FeedCrawler> services = new ArrayList<FeedCrawler>();

	private AtomicBoolean running = new AtomicBoolean(false);
	private TimeUnit timeunit = TimeUnit.DAYS;
	private long interval = 1;

	public void addFeedCrawlerService(FeedCrawler service) {
		services.add(service);
	}

	@Override
	public void run() {
		running.set(true);
		while (running.get()) {
			try {
				collectFeeds();
				timeunit.sleep(interval);
			} catch (InterruptedException e) {
			}
		}
	}

	public void collectFeeds() {
		log.info("start collect feeds...");
		currentFeeds.clear();
		for (FeedCrawler service : services) {
			Set<String> feed = service.getMalwareFeeds();
			currentFeeds.addAll(feed);
		}
		log.info("finished collecting feeds");
	}

	public void setTimeUnit(TimeUnit timeunit) {
		this.timeunit = timeunit;
	}

	public void setInterval(long interval) {
		this.interval = interval;
	}
	
	public void setRunning(boolean running) {
		this.running.set(running);
	}

	public Set<String> getCurrentFeeds() {
		return currentFeeds;
	}

}
