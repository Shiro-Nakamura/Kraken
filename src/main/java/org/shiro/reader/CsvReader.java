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

public class CsvReader implements FeedReader {

	private static final Logger log = LoggerFactory.getLogger(CsvReader.class);

	private String address;
	private String delimiter;
	private String skipPrefix;

	public CsvReader(String address, String delimiter) {
		this.address = address;
		this.delimiter = delimiter;
		this.skipPrefix = "";
	}

	public CsvReader(String address, String delimiter, String skipPrefix) {
		this.address = address;
		this.delimiter = delimiter;
		this.skipPrefix = skipPrefix;
	}

	public String readFeeds() {
		StringBuilder response = new StringBuilder();
		try {
			InputStream is = new URL(address).openStream();
			Reader reader = new BufferedReader(new InputStreamReader(is));

			try (BufferedReader br = new BufferedReader(reader)) {
				String line;
				while ((line = br.readLine()) != null) {
					if (skipPrefix.isEmpty() || line.startsWith(skipPrefix) == false) {
						String[] values = line.split(delimiter);
						response.append(Arrays.asList(values));
						response.append("\n");
					}
				}
			}

		} catch (MalformedURLException e) {
			log.error("failed to open address: " + address, e);
		} catch (IOException e) {
			log.error("failed to read csv from address: " + address, e);
		}
		return response.toString();
	}
}
