package cn.xx.sportsvolunteer.test;

import org.junit.Test;

import cn.xx.sportsvolunteer.beans.Enterprise;
import cn.xx.sportsvolunteer.dao.EnterpriseDao;
import cn.xx.sportsvolunteer.dao.impl.EnterpriseDaoImpl;
import cn.xx.sportsvolunteer.utils.MyDatabaseUtil;
import cn.xx.sportsvolunteer.utils.IdGenerator;
import cn.xx.sportsvolunteer.utils.PasswordJM;

public class MyTest {
	@Test
	public void testIdGenerator() {
		System.out.println(IdGenerator.createId());	
	}
	
	@Test
	public void testmd5() {
		System.out.println(PasswordJM.getJMPWD("admin"));	
	}
	
	@Test
	public void testjdbc() {
		System.out.println(MyDatabaseUtil.getConnection());	
	}
	
	@Test
	public void testmanager() {
		EnterpriseDao mdao = new EnterpriseDaoImpl();
		Enterprise m = new Enterprise();
		m.setUsername("xiuxiu2");
		m.setPassword("mmmmmm");
		m.setPassword(PasswordJM.getJMPWD(m.getPassword()));
		mdao.add(m);
	}
}
