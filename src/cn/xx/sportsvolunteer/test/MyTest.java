package cn.xx.sportsvolunteer.test;

import org.junit.Test;

import cn.xx.sportsvolunteer.beans.Manager;
import cn.xx.sportsvolunteer.dao.ManagerDao;
import cn.xx.sportsvolunteer.dao.impl.ManagerDaoImpl;
import cn.xx.sportsvolunteer.utils.DBUtil;
import cn.xx.sportsvolunteer.utils.IdGenerator;
import cn.xx.sportsvolunteer.utils.MD5Util;

public class MyTest {
	@Test
	public void testIdGenerator() {
		System.out.println(IdGenerator.createId());	
	}
	
	@Test
	public void testmd5() {
		System.out.println(MD5Util.getMD5("admin"));	
	}
	
	@Test
	public void testjdbc() {
		System.out.println(DBUtil.getConnection());	
	}
	
	@Test
	public void testmanager() {
		ManagerDao mdao = new ManagerDaoImpl();
		Manager m = new Manager();
		m.setUsername("xiuxiu2");
		m.setPassword("mmmmmm");
		m.setPassword(MD5Util.getMD5(m.getPassword()));
		mdao.add(m);
	}
}
