package cn.xx.sportsvolunteer.dao;

import java.util.List;

import cn.xx.sportsvolunteer.beans.Enterprise;
//Database access object，数据库访问对象
public interface EnterpriseDao {
	public void add(Enterprise m);
	public void delete(int id);
	public void update(Enterprise m);
	public Enterprise getById(int id);
	public List<Enterprise> getAll();
	public Enterprise getByUsernameAndPassword(String username, String password);
}
