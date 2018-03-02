package cn.xx.sportsvolunteer.dao;

import java.util.List;

import cn.xx.sportsvolunteer.beans.Game;

public interface GameDao {//dao==data access object
	public void add(Game game);
	public void delete(String id);
	public void update(Game game);
	public Game getById(String id);
	public List<Game> getList(int pageIndex,int pageSize);
}
