package cn.xx.sportsvolunteer.test;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.xx.sportsvolunteer.beans.Volunteer;
import cn.xx.sportsvolunteer.dao.VolunteerDao;
import cn.xx.sportsvolunteer.dao.impl.VolunteerDaoImpl;
import cn.xx.sportsvolunteer.utils.IdGenerator;
import cn.xx.sportsvolunteer.utils.MD5Util;

public class VolunteerDaoImplTest {

	private VolunteerDao vdao = new VolunteerDaoImpl();

	// @Test
	public void testAdd() {
		for (int i = 1; i <= 20; i++) {
			Volunteer v = new Volunteer();
			v.setId(IdGenerator.createId());
			v.setAddress("上海");
			v.setAge(20 + i);
			v.setGender("男");
			v.setIdcardnumber("441111111111111155");
			v.setPassword(MD5Util.getMD5("sham"));
			v.setPhonenumber("12312312345");
			v.setRegistertime(new Date());
			v.setSpecialskill("no");
			v.setUsername("xiuxiu" + i);
			vdao.add(v);
		}
	}

//	@Test
	public void testDelete() {
		vdao.delete("fa3f34eb-ef33-4c2c-bb81-54f542cff47e");
	}

//	@Test
	public void testUpdate() {
		Volunteer v = vdao.getById("0d91901d-f12d-4f4c-991c-7d115f32f2d6");
		v.setSpecialskill("yes");
		vdao.update(v);
		
	}

//	@Test
	public void testGetById() {
		System.out.println(vdao.getById("0d91901d-f12d-4f4c-991c-7d115f32f2d6"));
	}

//	@Test
	public void testGetList() {
		List<Volunteer> list = vdao.getList(2, 3);
		for (Volunteer v : list) {
			System.out.println(v.getUsername());
		}
	}

}
