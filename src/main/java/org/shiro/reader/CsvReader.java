package org.shiro.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opencsv.CSVReader;

public class CsvReader implements FeedReader {

	private static final Logger log = LoggerFactory.getLogger(CsvReader.class);

	private String address;

	public CsvReader(String address) {
		this.address = address;
	}

	public String readFeeds() {
		StringBuilder response = new StringBuilder();
		try {
			InputStream is = new URL(address).openStream();
			Reader reader = new BufferedReader(new InputStreamReader(is));
			CSVReader csvReader = new CSVReader(reader);

			String[] values = null;
			while ((values = csvReader.readNext()) != null) {
				response.append(Arrays.asList(values));
			}
			csvReader.close();
		} catch (MalformedURLException e) {
			log.error("failed to open address: " + address, e);
		} catch (IOException e) {
			log.error("failed to read csv from address: " + address, e);
		}
		return response.toString();
	}
}
