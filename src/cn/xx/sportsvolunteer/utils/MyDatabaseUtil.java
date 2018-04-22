package cn.xx.sportsvolunteer.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDatabaseUtil {
	private final static String JDBCURL = "jdbc:mysql://localhost:3306/sportsvolunteer";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "root";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	public static Connection getConnection() {
		try {
			//连接数据库
			return DriverManager.getConnection(JDBCURL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
