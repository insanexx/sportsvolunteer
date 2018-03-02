package cn.xx.sportsvolunteer.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.xx.sportsvolunteer.beans.Game;
import cn.xx.sportsvolunteer.dao.GameDao;
import cn.xx.sportsvolunteer.dao.impl.GameDaoImpl;
import cn.xx.sportsvolunteer.utils.IdGenerator;

public class GameDaoImplTest {
	private GameDao dao = new GameDaoImpl();
	@Test
	public void testAdd() {
		Game game = new Game();
		game.setAddress("上海公园2");
		game.setBegintime(new Date());
		game.setDescription("***比赛2");
		game.setEndtime(new Date(game.getBegintime().getTime()+2*24*60*60*1000));
		game.setId(IdGenerator.createId());
		game.setJobdescription("打扫卫生2");
		game.setName("上海奥运会2");
		game.setSalary(901);
		dao.add(game );
	}

	@Test
	public void testDelete() {
		dao.delete("0aa078c6-3bdd-42f2-8871-af00fb6096e6");
	}

	@Test
	public void testUpdate() {
		Game game = dao.getById("da6177c4-d8ea-4f3d-8087-a7143e17c999");
		game.setName(game.getName()+"---修改了");
		dao.update(game);
	}

	@Test
	public void testGetById() {
		Game g = dao.getById("da6177c4-d8ea-4f3d-8087-a7143e17c999");
		System.out.println(g);
	}

	@Test
	public void testGetList() {
		List<Game> list = dao.getList(1, 10);
		if(list!=null&&list.size()>0) {
			for(Game g:list) {
				System.out.println(g);
			}
		}
	}

}
