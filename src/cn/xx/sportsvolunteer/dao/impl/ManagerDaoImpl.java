package cn.xx.sportsvolunteer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import cn.xx.sportsvolunteer.beans.Manager;
import cn.xx.sportsvolunteer.dao.ManagerDao;
import cn.xx.sportsvolunteer.utils.DBUtil;

public class ManagerDaoImpl implements ManagerDao {

	@Override
	public void add(Manager m) {
		String sql = "insert into manager(username,password) value(?,?)";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, m.getUsername());
			pst.setString(2, m.getPassword());
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(Manager m) {

	}

	@Override
	public void update(Manager m) {

	}

	@Override
	public Manager get(String username) {
		return null;
	}

	@Override
	public List<Manager> get() {
		return null;
	}

}
