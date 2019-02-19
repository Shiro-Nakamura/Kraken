package org.shiro.reader;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;

public class Text_Reader_Test extends TestCase {

	private static final Logger log = LoggerFactory.getLogger(Text_Reader_Test.class);

	@Test
	public void test_text_reader() {
		String address = "http://techslides.com/demos/samples/sample.txt";
		TextReader reader = new TextReader(address);

		String response = reader.readFeeds();
		log.info("read response with :" + reader.getClass().getSimpleName());
		log.info("response: " + response);

		assertNotNull(response);
		assertFalse(response.isEmpty());
	}

	@Test
	public void test_text_reader_openfish() {
		String address = "https://openphish.com/feed.txt";
		TextReader reader = new TextReader(address);
		log.info("read response with :" + reader.getClass().getSimpleName());

		String response = reader.readFeeds();
		log.info("response: "+response);
		assertNotNull(response);
		assertFalse(response.isEmpty());
	}
}
