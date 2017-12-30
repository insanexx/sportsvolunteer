package cn.xx.sportsvolunteer.utils;

import java.security.MessageDigest;
import java.util.Base64;

public class MD5Util {
	public static String getMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] bytes = md.digest(input.getBytes("UTF-8"));
			return Base64.getEncoder().encodeToString(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
