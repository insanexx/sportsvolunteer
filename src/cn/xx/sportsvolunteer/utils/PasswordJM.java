package cn.xx.sportsvolunteer.utils;

import java.security.MessageDigest;
import java.util.Base64;

public class PasswordJM {
	public static String getJMPWD(String pwd) {
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] pwdbytes = md.digest(pwd.getBytes("UTF-8"));
			return Base64.getEncoder().encodeToString(pwdbytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
