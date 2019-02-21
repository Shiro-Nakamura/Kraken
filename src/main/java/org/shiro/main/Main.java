package org.shiro.main;

import org.shiro.crawler.OpenPhish;

public class Main {
	
	public Main() {
		Kraken kraken = new Kraken();
		kraken.addFeedCrawlerService(new OpenPhish());
	}

}
