package cn.xx.sportsvolunteer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.xx.sportsvolunteer.beans.Enterprise;
import cn.xx.sportsvolunteer.dao.EnterpriseDao;
import cn.xx.sportsvolunteer.utils.DBUtil;

public class EnterpriseDaoImpl implements EnterpriseDao {

	@Override
	public void add(Enterprise enterprise) {
		String sql = "insert into enterprise(id,username,password,enterpriseName,address,phonenumber,business) value(?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, enterprise.getId());
			pst.setString(2, enterprise.getUsername());
			pst.setString(3, enterprise.getPassword());
			pst.setString(4, enterprise.getEnterpriseName());
			pst.setString(5, enterprise.getAddress());
			pst.setString(6, enterprise.getPhonenumber());
			pst.setString(7, enterprise.getBusiness());
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
		String sql = "delete from enterprise where id=?";
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
	public void update(Enterprise enterprise) {
		String sql = "update enterprise set username=?,password=?,enterpriseName=?,address=?,phonenumber=?,business=? where id=?";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, enterprise.getUsername());
			pst.setString(2, enterprise.getPassword());
			pst.setString(3, enterprise.getEnterpriseName());
			pst.setString(4, enterprise.getAddress());
			pst.setString(5, enterprise.getPhonenumber());
			pst.setString(6, enterprise.getBusiness());
			pst.setInt(7, enterprise.getId());
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
	public Enterprise getById(int id) {
		Enterprise enterprise = null;
		String sql = "select * from enterprise where id=?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				enterprise = new Enterprise();
				enterprise.setId(id);
				enterprise.setUsername(rs.getString("username"));
				enterprise.setPassword(rs.getString("password"));
				enterprise.setPhonenumber(rs.getString("phonenumber"));
				enterprise.setEnterpriseName(rs.getString("enterpriseName"));
				enterprise.setAddress(rs.getString("address"));
				enterprise.setBusiness(rs.getString("business"));
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
		return enterprise;
	}

	@Override
	public List<Enterprise> getAll() {
		List<Enterprise> list = new ArrayList<Enterprise>();
		String sql = "select * from enterprise";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				Enterprise enterprise = new Enterprise();
				enterprise.setId(rs.getInt("id"));
				enterprise.setUsername(rs.getString("username"));
				enterprise.setPassword(rs.getString("password"));
				enterprise.setPhonenumber(rs.getString("phonenumber"));
				enterprise.setEnterpriseName(rs.getString("enterpriseName"));
				enterprise.setAddress(rs.getString("address"));
				enterprise.setBusiness(rs.getString("business"));
				list.add(enterprise);
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
	public Enterprise getByUsernameAndPassword(String username, String password) {
		Enterprise enterprise = null;
		String sql = "select * from enterprise where username=? and password=?";
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
				enterprise = new Enterprise();
				enterprise.setId(rs.getInt("id"));
				enterprise.setUsername(rs.getString("username"));
				enterprise.setPassword(rs.getString("password"));
				enterprise.setPhonenumber(rs.getString("phonenumber"));
				enterprise.setEnterpriseName(rs.getString("enterpriseName"));
				enterprise.setAddress(rs.getString("address"));
				enterprise.setBusiness(rs.getString("business"));
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
		return enterprise;
	}
}
