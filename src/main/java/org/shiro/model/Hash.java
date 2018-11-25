package org.shiro.model;

import org.apache.commons.codec.digest.DigestUtils;

public class Hash {

	private String md5;
	private String sha1;

	public Hash(String hash) {
		md5 = DigestUtils.md5Hex(hash).toLowerCase();
		sha1 = DigestUtils.sha1Hex(hash).toLowerCase();
	}

	public String getMd5() {
		return md5;
	}

	public String getSha1() {
		return sha1;
	}
}
