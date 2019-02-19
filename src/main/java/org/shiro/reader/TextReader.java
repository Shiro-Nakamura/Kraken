package org.shiro.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextReader implements FeedReader {

	private static final Logger log = LoggerFactory.getLogger(TextReader.class);

	private String address;

	public TextReader(String address) {
		this.address = address;
	}

	public String readFeeds() {
		StringBuilder response = new StringBuilder();
		try {
			InputStream is = new URL(address).openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String inputLine;
			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
				response.append("\n");
			}
			reader.close();
		} catch (MalformedURLException e) {
			log.error("failed to open address: " + address, e);
		} catch (IOException e) {
			log.error("failed read feeds from address: " + address, e);
		}

		return response.toString();
	}

}
