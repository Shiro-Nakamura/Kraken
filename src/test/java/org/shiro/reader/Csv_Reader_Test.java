package org.shiro.reader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import junit.framework.TestCase;

public class Csv_Reader_Test extends TestCase {

	private static final Logger log = LoggerFactory.getLogger(Csv_Reader_Test.class);

	public void test_read_csv() {
		String address = "https://sample-videos.com/csv/Sample-Spreadsheet-1000-rows.csv";

		CsvReader reader = new CsvReader(address, ",");
		log.info("read response with: " + reader.getClass().getSimpleName());
		String response = reader.readFeeds();
		assertNotNull(response);
		log.info("response: " + response);
		assertFalse(response.isEmpty());
	}

}
