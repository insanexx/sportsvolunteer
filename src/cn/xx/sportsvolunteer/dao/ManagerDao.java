package cn.xx.sportsvolunteer.dao;

import java.util.List;

import cn.xx.sportsvolunteer.beans.Manager;

public interface ManagerDao {
	public void add(Manager m);
	public void delete(Manager m);
	public void update(Manager m);
	public Manager get(String username);
	public List<Manager> get();
}
