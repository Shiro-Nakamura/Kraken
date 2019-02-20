package org.shiro.channel;

import java.util.ArrayList;
import java.util.List;

public class ChannelManager {

	private List<Channel> channels = new ArrayList<>();

	public void addObserver(Channel channel) {
		this.channels.add(channel);
	}

	public void removeObserver(Channel channel) {
		this.channels.remove(channel);
	}

	public void addFeeds(List<String> feed) {
		for (Channel channel : this.channels) {
			channel.update(feed);
		}
	}
}
