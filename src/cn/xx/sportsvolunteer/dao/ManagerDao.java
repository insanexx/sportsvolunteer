package cn.xx.sportsvolunteer.dao;

import java.util.List;

import cn.xx.sportsvolunteer.beans.Manager;

public interface ManagerDao {
	public void add(Manager m);
	public void delete(String id);
	public void update(Manager m);
	public Manager getById(String id);
	public List<Manager> getAll();
}
