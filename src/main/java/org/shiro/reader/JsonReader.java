package org.shiro.reader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonReader implements FeedReader {

	private static final Logger log = LoggerFactory.getLogger(JsonReader.class);

	private String address;

	public JsonReader(String address) {
		this.address = address;
	}

	@Override
	public String readFeeds() {
		try {
			JSONObject json = new JSONObject();
			URL url = new URL(address);
			String raw = IOUtils.toString(url, Charset.forName("UTF-8"));
			if (raw.isEmpty())
				throw new IllegalArgumentException("no content recevied");
			json = new JSONObject(raw);
			return json.toString();
			
		} catch (MalformedURLException e) {
			log.error("failed to open address: " + address, e);
		} catch (IOException e) {
			log.error("failed to read json from address: " + address, e);
		} catch (IllegalArgumentException e) {
			log.error("failed to get json from address: " + address, e);
		}
		return "";
	}
}
