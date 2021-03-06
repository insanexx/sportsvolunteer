package cn.xx.sportsvolunteer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.xx.sportsvolunteer.beans.Game;
import cn.xx.sportsvolunteer.dao.GameDao;
import cn.xx.sportsvolunteer.utils.MyDatabaseUtil;

public class GameDaoImpl implements GameDao {

	@Override
	public void add(Game g) {
		String sql = "insert into game(id,name,description,jobdescription,begintime,endtime,address,salary,enterpriseid,personcount) value(?,?,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = MyDatabaseUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, g.getId());
			pst.setString(2, g.getName());
			pst.setString(3, g.getDescription());
			pst.setString(4, g.getJobdescription());
			pst.setTimestamp(5, new Timestamp(g.getBegintime().getTime()));
			pst.setTimestamp(6, new Timestamp(g.getEndtime().getTime()));
			pst.setString(7, g.getAddress());
			pst.setDouble(8, g.getSalary());
			pst.setInt(9, g.getEnterpriseid());
			pst.setInt(10, g.getPersoncount());
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
		String sql = "delete from game where id=?";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = MyDatabaseUtil.getConnection();
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
	public void update(Game g) {
		String sql = "update game set name=?,description=?,jobdescription=?,begintime=?,"
				+ "endtime=?,address=?,salary=?,enterpriseid=?,personcount=? where id=?";
		Connection conn = null;
		PreparedStatement pst = null;
		conn = MyDatabaseUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, g.getName());
			pst.setString(2, g.getDescription());
			pst.setString(3, g.getJobdescription());
			pst.setTimestamp(4, new Timestamp(g.getBegintime().getTime()));
			pst.setTimestamp(5, new Timestamp(g.getEndtime().getTime()));
			pst.setString(6, g.getAddress());
			pst.setDouble(7, g.getSalary());
			pst.setInt(8, g.getEnterpriseid());
			pst.setInt(9, g.getPersoncount());
			pst.setString(10, g.getId());
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
	public Game getById(String id) {
		String sql = "select g.*,(select count(*) from game_volunteer gv where gv.gameid=g.id ) as enteredcount from game g where id=?";
		Game game = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = MyDatabaseUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				game = new Game();
				game.setId(id);
				game.setAddress(rs.getString("address"));
				game.setBegintime(new Date(rs.getTimestamp("begintime").getTime()));
				game.setDescription(rs.getString("description"));
				game.setEndtime(new Date(rs.getTimestamp("endtime").getTime()));
				game.setJobdescription(rs.getString("jobdescription"));
				game.setName(rs.getString("name"));
				game.setSalary(rs.getDouble("salary"));
				game.setEnterpriseid(rs.getInt("enterpriseid"));
				game.setPersoncount(rs.getInt("personcount"));
				game.setRestcount(game.getPersoncount()-rs.getInt("enteredcount"));
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
		return game;
	}

	@Override
	public List<Game> getList(int pageIndex, int pageSize,String volunteerid) {
		if(pageIndex<=0) {
			pageIndex = 1;
		}
		List<Game> list = new ArrayList<Game>();
		String sql = "select g.*,e.enterpriseName as enterprisename,(select count(*) from game_volunteer gv where gv.gameid=g.id) as enteredcount, (select count(*) from game_volunteer gv where gv.volunteerid=? and gv.gameid=g.id)>0 as entered from game g, enterprise e where g.enterpriseid=e.id order by g.begintime asc limit ?,? ";//limit a,b==>a从0开始，取b个。
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = MyDatabaseUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, volunteerid);
			pst.setInt(2, (pageIndex-1)*pageSize);
			pst.setInt(3, pageSize);
			rs = pst.executeQuery();
			while(rs.next()) {
				Game game = new Game();
				game.setId(rs.getString("id"));
				game.setAddress(rs.getString("address"));
				game.setBegintime(new Date(rs.getTimestamp("begintime").getTime()));
				game.setDescription(rs.getString("description"));
				game.setEndtime(new Date(rs.getTimestamp("endtime").getTime()));
				game.setJobdescription(rs.getString("jobdescription"));
				game.setName(rs.getString("name"));
				game.setSalary(rs.getDouble("salary"));
				game.setEnterpriseid(rs.getInt("enterpriseid"));
				game.setPersoncount(rs.getInt("personcount"));
				game.setEnterprisename(rs.getString("enterprisename"));
				game.setRestcount(game.getPersoncount()-rs.getInt("enteredcount"));
				game.setEntered(rs.getBoolean("entered"));
				list.add(game);
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
	public List<Game> getListByEnterprise(int pageIndex, int pageSize, int enterpriseid) {
		if(pageIndex<=0) {
			pageIndex = 1;
		}
		List<Game> list = new ArrayList<Game>();
		String sql = "select g.*,(select count(*) from game_volunteer gv where gv.gameid=g.id ) as enteredcount from game"
				+ " g where g.enterpriseid=? order by g.begintime asc limit ?,? ";//limit a,b==>a从0开始，取b个。
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = MyDatabaseUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, enterpriseid);
			pst.setInt(2, (pageIndex-1)*pageSize);
			pst.setInt(3, pageSize);
			rs = pst.executeQuery();
			while(rs.next()) {
				Game game = new Game();
				game.setId(rs.getString("id"));
				game.setAddress(rs.getString("address"));
				game.setBegintime(new Date(rs.getTimestamp("begintime").getTime()));
				game.setDescription(rs.getString("description"));
				game.setEndtime(new Date(rs.getTimestamp("endtime").getTime()));
				game.setJobdescription(rs.getString("jobdescription"));
				game.setName(rs.getString("name"));
				game.setSalary(rs.getDouble("salary"));
				game.setEnterpriseid(rs.getInt("enterpriseid"));
				game.setPersoncount(rs.getInt("personcount"));
				game.setRestcount(game.getPersoncount()-rs.getInt("enteredcount"));
				list.add(game);
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
	public List<Game> getList(int pageIndex, int pageSize) {
		if(pageIndex<=0) {
			pageIndex = 1;
		}
		List<Game> list = new ArrayList<Game>();
		String sql = "select g.*,(select count(*) from game_volunteer gv where gv.gameid=g.id ) as enteredcount from game g order by g.begintime asc limit ?,? ";//limit a,b==>a从0开始，取b个。
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		conn = MyDatabaseUtil.getConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, (pageIndex-1)*pageSize);
			pst.setInt(2, pageSize);
			rs = pst.executeQuery();
			while(rs.next()) {
				Game game = new Game();
				game.setId(rs.getString("id"));
				game.setAddress(rs.getString("address"));
				game.setBegintime(new Date(rs.getTimestamp("begintime").getTime()));
				game.setDescription(rs.getString("description"));
				game.setEndtime(new Date(rs.getTimestamp("endtime").getTime()));
				game.setJobdescription(rs.getString("jobdescription"));
				game.setName(rs.getString("name"));
				game.setSalary(rs.getDouble("salary"));
				game.setEnterpriseid(rs.getInt("enterpriseid"));
				game.setPersoncount(rs.getInt("personcount"));
				game.setRestcount(game.getPersoncount()-rs.getInt("enteredcount"));
				list.add(game);
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

}
