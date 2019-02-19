package org.shiro.reader;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;

public class Json_Reader_Test extends TestCase {
	
	private static final Logger log = LoggerFactory.getLogger(Json_Reader_Test.class);

	@Test
	public void test_json_reader() {
		String address = "https://jsonplaceholder.typicode.com/todos/1";
		JsonReader reader = new JsonReader(address);

		String response = reader.readFeeds();
		log.info("read response with :" + reader.getClass().getSimpleName());
		log.info("response: " + response);

		assertNotNull(response);
		assertFalse(response.isEmpty());
	}


}
