package cn.xx.sportsvolunteer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.xx.sportsvolunteer.beans.Manager;
import cn.xx.sportsvolunteer.dao.ManagerDao;
import cn.xx.sportsvolunteer.utils.DBUtil;

public class ManagerDaoImpl implements ManagerDao {

	@Override
	public void add(Manager m) {
		String sql = "insert into manager(id,username,password) value(?,?,?)";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, m.getId());
			pst.setString(2, m.getUsername());
			pst.setString(3, m.getPassword());
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally{
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void delete(int id) {
		String sql = "delete from manager where id=?";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally{
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void update(Manager m) {
		String sql = "update manager set username=?,password=? where id=?";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, m.getUsername());
			pst.setString(2, m.getPassword());
			pst.setInt(3, m.getId());
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally{
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Manager getById(int id) {
		Manager m = null;
		String sql = "select * from manager where id=?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				m = new Manager();
				m.setId(id);
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return m;
	}

	@Override
	public List<Manager> getAll() {
		List<Manager> list = new ArrayList<Manager>();
		String sql = "select * from manager";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				Manager m = new Manager();
				m.setId(rs.getInt("id"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				list.add(m);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	@Override
	public Manager getByUsernameAndPassword(String username, String password) {
		Manager m = null;
		String sql = "select * from manager where username=? and password=?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs.next()) {
				m = new Manager();
				m.setId(rs.getInt("id"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return m;
	}

}
