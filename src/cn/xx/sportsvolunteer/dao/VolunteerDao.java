package cn.xx.sportsvolunteer.dao;

import java.util.List;

import cn.xx.sportsvolunteer.beans.Game;
import cn.xx.sportsvolunteer.beans.Volunteer;

public interface VolunteerDao {
	public void add(Volunteer v);
	public void delete(String id);
	public void update(Volunteer v);
	public Volunteer getById(String id);
	public List<Volunteer> getList(int pageIndex,int pageSize);
	public Volunteer getByUsernameAndPassword(String username, String password);
	public void entergame(Game game,Volunteer v);
	public boolean isEnterGame(Game game, Volunteer v);
}
