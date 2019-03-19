package ca.saskshare.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class ServiceUtils {
	
	public static String md5(String password) {
		return DigestUtils.md5Hex(password);
	}
}
