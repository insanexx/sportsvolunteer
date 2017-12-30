package cn.xx.sportsvolunteer.utils;

import java.util.UUID;

public class IdGenerator {
	public static String createId() {
		return UUID.randomUUID().toString();
	}
}
