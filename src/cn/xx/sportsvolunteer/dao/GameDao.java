package cn.xx.sportsvolunteer.dao;

import java.util.List;

import cn.xx.sportsvolunteer.beans.Game;

public interface GameDao {//dao==data access object
	public void add(Game game);
	public void delete(String id);
	public void update(Game game);
	public Game getById(String id);
	/**
	 * 管理员获取所有
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<Game> getList(int pageIndex,int pageSize);
	/**
	 * 企业获取自己创建的
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public List<Game> getListByEnterprise(int pageIndex,int pageSize,int enterpriseid);
}
