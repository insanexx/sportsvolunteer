package cn.xx.sportsvolunteer.test;

import java.util.List;

import org.junit.Test;

import cn.xx.sportsvolunteer.beans.Manager;
import cn.xx.sportsvolunteer.dao.ManagerDao;
import cn.xx.sportsvolunteer.dao.impl.ManagerDaoImpl;
import cn.xx.sportsvolunteer.utils.IdGenerator;
import cn.xx.sportsvolunteer.utils.MD5Util;

public class ManagerDaoImplTest {

	private ManagerDao mdao = new ManagerDaoImpl();
	
//	@Test
	public void testAdd() {
		for(int i=0;i<5;i++) {
			Manager m = new Manager();
			m.setId(IdGenerator.createId());
			m.setUsername("xiuxiu"+i);
			m.setPassword(MD5Util.getMD5("sham"+i));
			mdao.add(m);
		}
	}

//	@Test
	public void testDelete() {
		mdao.delete("f0f367dc-6127-495e-89f3-1969239b7b63");
	}

//	@Test
	public void testUpdate() {
		Manager m = mdao.getAll().get(0);
		m.setUsername(m.getUsername()+"_update");
		mdao.update(m );
	}

//	@Test
	public void testGetById() {
		Manager m = mdao.getById("5034abd5-8b36-4cd2-a9c6-7e19a2505014");
		System.out.println(m);
	}

//	@Test
	public void testGetAll() {
		List<Manager> list = mdao.getAll();
		System.out.println(list);
	}

}
