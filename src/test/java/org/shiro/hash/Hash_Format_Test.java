package org.shiro.hash;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.shiro.model.Hash;

public class Hash_Format_Test {

	private static final String EICAR_CONTENT = "X5O!P%@AP[4\\\\PZX54(P^)7CC)7}$EICAR-STANDARD-ANTIVIRUS-TEST-FILE!$H+H*";
	private static final String MD5 = "44d88612fea8a8f36de82e1278abb02f";
	private static final String SHA1 = "3395856ce81f2b7382dee72602f798b642f14140";

	@Test
	public void test_from_md5_hash_generation() {
		Hash hash = new Hash(EICAR_CONTENT);
		assertThat(hash.getMd5(), CoreMatchers.is(MD5));
	}

	@Test
	public void test_from_sha1_hash_generation() {
		Hash hash = new Hash(EICAR_CONTENT);
		assertThat(hash.getSha1(), CoreMatchers.is(SHA1));
	}

	@Test
	public void test_from_invalid_hash_generation() {
		String input = "44d";
		Hash hash = new Hash(input);
		assertThat(hash.getMd5(), CoreMatchers.is(MD5));
		assertThat(hash.getSha1(), CoreMatchers.is(SHA1));
	}

}
