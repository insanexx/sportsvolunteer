package cn.xx.sportsvolunteer.dao;

import java.util.List;

import cn.xx.sportsvolunteer.beans.Volunteer;

public interface VolunteerDao {
	public void add(Volunteer v);
	public void delete(Volunteer v);
	public void update(Volunteer v);
	public Volunteer get(String id);
	public List<Volunteer> get(int pageIndex,int pageSize);
}
