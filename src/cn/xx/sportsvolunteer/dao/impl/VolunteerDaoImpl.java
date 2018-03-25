package cn.xx.sportsvolunteer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import cn.xx.sportsvolunteer.beans.Game;
import cn.xx.sportsvolunteer.beans.Volunteer;
import cn.xx.sportsvolunteer.dao.VolunteerDao;
import cn.xx.sportsvolunteer.utils.DBUtil;

public class VolunteerDaoImpl implements VolunteerDao {

	@Override
	public void add(Volunteer v) {
		String sql = "insert into volunteer(id,username,password,age,gender,address,idcardnumber,phonenumber,specialskill,registertime) value(?,?,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, v.getId());
			pst.setString(2, v.getUsername());
			pst.setString(3, v.getPassword());
			pst.setInt(4, v.getAge());
			pst.setString(5, v.getGender());
			pst.setString(6, v.getAddress());
			pst.setString(7, v.getIdcardnumber());
			pst.setString(8, v.getPhonenumber());
			pst.setString(9, v.getSpecialskill());
			pst.setTimestamp(10, new Timestamp(v.getRegistertime().getTime()));
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
	public void delete(String id) {
		String sql = "delete from volunteer where id=?";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
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
	public void update(Volunteer v) {
		String sql = "update volunteer set username=?,password=?,age=?,gender=?,"
				+ "address=?,idcardnumber=?,phonenumber=?,specialskill=? where id=?";//registertime不需要修改
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, v.getUsername());
			pst.setString(2, v.getPassword());
			pst.setInt(3, v.getAge());
			pst.setString(4, v.getGender());
			pst.setString(5, v.getAddress());
			pst.setString(6, v.getIdcardnumber());
			pst.setString(7, v.getPhonenumber());
			pst.setString(8, v.getSpecialskill());
			pst.setString(9, v.getId());
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
	public Volunteer getById(String id) {
		Volunteer v = null;
		String sql = "select * from volunteer where id=?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				v = new Volunteer();
				v.setId(id);
				v.setUsername(rs.getString("username"));
				v.setPassword(rs.getString("password"));
				v.setAddress(rs.getString("address"));
				v.setAge(rs.getInt("age"));
				v.setGender(rs.getString("gender"));
				v.setIdcardnumber(rs.getString("idcardnumber"));
				v.setPhonenumber(rs.getString("phonenumber"));
				v.setRegistertime(rs.getTimestamp("registertime"));
				v.setSpecialskill(rs.getString("specialskill"));
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
		return v;
	}

	@Override
	public List<Volunteer> getList(int pageIndex, int pageSize) {
		if(pageIndex<=0) {
			pageIndex = 1;
		}
		List<Volunteer> list = new ArrayList<Volunteer>();
		String sql = "select * from volunteer limit ?,?";//limit a,b==>a从0开始，取b个。
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, (pageIndex-1)*pageSize);
			pst.setInt(2, pageSize);
			rs = pst.executeQuery();
			while(rs.next()) {
				Volunteer v = new Volunteer();
				v.setId(rs.getString("id"));
				v.setUsername(rs.getString("username"));
				v.setPassword(rs.getString("password"));
				v.setAddress(rs.getString("address"));
				v.setAge(rs.getInt("age"));
				v.setGender(rs.getString("gender"));
				v.setIdcardnumber(rs.getString("idcardnumber"));
				v.setPhonenumber(rs.getString("phonenumber"));
				v.setRegistertime(rs.getTimestamp("registertime"));
				v.setSpecialskill(rs.getString("specialskill"));
				list.add(v);
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
	public Volunteer getByUsernameAndPassword(String username, String password) {
		Volunteer volunteer = null;
		String sql = "select * from volunteer where username=? and password=?";
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
				volunteer = new Volunteer();
				volunteer.setId(rs.getString("id"));
				volunteer.setUsername(rs.getString("username"));
				volunteer.setPassword(rs.getString("password"));
				volunteer.setAddress(rs.getString("address"));
				volunteer.setAge(rs.getInt("age"));
				volunteer.setGender(rs.getString("gender"));
				volunteer.setIdcardnumber(rs.getString("idcardnumber"));
				volunteer.setPhonenumber(rs.getString("phonenumber"));
				volunteer.setRegistertime(rs.getTimestamp("registertime"));
				volunteer.setSpecialskill(rs.getString("specialskill"));
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
		return volunteer;
	}

	public void entergame(Game game,Volunteer v) {
		String sql = "insert into game_volunteer(gameid,volunteerid) value(?,?)";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, game.getId());
			pst.setString(2, v.getId());
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
	public boolean isEnterGame(Game game, Volunteer v) {
		String sql = "select * from game_volunteer where gameid=? and volunteerid=?";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = DBUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, game.getId());
			pst.setString(2, v.getId());
			rs = pst.executeQuery();
			if(rs.next()) {
				return true;
			}else {
				return false;
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
	}
	
}
