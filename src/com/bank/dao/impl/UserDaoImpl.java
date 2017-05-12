package com.bank.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.UserDao;
import com.bank.entity.Department;
import com.bank.entity.Function;
import com.bank.entity.Job;
import com.bank.entity.User;
import com.bank.entity.Xtymb;
import com.bank.util.DBUtil;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	@Override
	public List<User> queryUsers(int page, int count) {
		List<User> list = new ArrayList<User>();
		String sql = "select Login_ID,User_Name,Department_Name,Name ,User_Status from users u join department d on u.Department_ID = d.Department_id join job j on u.Job_ID = j.Job_ID limit ?,? ";
		try {
			setConnAndPS(sql);
			ps.setInt(1, page);
			ps.setInt(2, count);
			rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setLoginId(rs.getString("Login_ID"));
				u.setName(rs.getString("User_Name"));
				u.setDepartmentName(rs.getString("Department_Name"));
				u.setJobName(rs.getString("Name"));
				u.setStatus("1".equals(rs.getString("User_Status")));
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, rs, ps);
		}
		return list;
	}

	@Override
	public List<User> queryUsers(int from, int pageSize, User u) {
		StringBuilder sql = new StringBuilder("select Login_ID,User_Name,Department_Name,Name ,User_Status from users u join department d on u.Department_ID = d.Department_id join job j on u.Job_ID = j.Job_ID  where 1=1 ");
		if (u.getLoginId() != null) {
			sql.append(" and Login_ID like '%" + u.getLoginId() + "%'");
		}
		if (u.getName() != null) {
			sql.append(" and User_Name like '%" + u.getName() + "%'");
		}
		sql.append(" limit ?,? ");
		List<User> list = new ArrayList<User>();
		try {
			setConnAndPS(sql.toString());
			ps.setInt(1, from);
			ps.setInt(2, pageSize);
			LOGGER.info("用户模糊查询：" + ps.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setLoginId(rs.getString("Login_ID"));
				user.setName(rs.getString("User_Name"));
				user.setDepartmentName(rs.getString("Department_Name"));
				user.setJobName(rs.getString("Name"));
				user.setStatus("1".equals(rs.getString("User_Status")));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, rs, ps);
		}
		return list;
	}

	@Override
	public int queryUsersCount() {
		int n = 0;
		String sql = "select count(*) from users";
		try {
			setConnAndPS(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				n = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, null, ps);
		}
		return n;
	}

	@Override
	public int queryUsersCount(User u) {
		int count = 0;
		StringBuilder sql = new StringBuilder("select count(*) from users where 1=1 ");
		if (u.getLoginId() != null) {
			sql.append(" and Login_ID like '%" + u.getLoginId() + "%'");
		}
		if (u.getName() != null) {
			sql.append(" and User_Name like '%" + u.getName() + "%'");
		}
		try {
			setConnAndPS(sql.toString());
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, rs, ps);
		}
		return count;
	}

	@Override
	public int deleteUser(String userId) {
		int n = 0;
		String sql = "delete from users where Login_ID = ?";
		try {
			setConnAndPS(sql);
			ps.setString(1, userId);
			n = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, null, ps);
		}
		return n;
	}

	@Override
	public List<Department> findAllDepts() {
		List<Department> list = new ArrayList<Department>();
		String sql = "select * from department";
		try {
			setConnAndPS(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Department d = new Department();
				d.setId(rs.getInt(1));
				d.setName(rs.getString(2));
				list.add(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, rs, ps);
		}
		return list;
	}

	@Override
	public List<Job> findAllJobs() {
		List<Job> list = new ArrayList<Job>();
		String sql = "select * from job ";
		try {
			setConnAndPS(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Job j = new Job();
				j.setId(rs.getInt(1));
				j.setName(rs.getString(2));
				list.add(j);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, rs, ps);
		}
		return list;
	}

	@Override
	public int userAdd(User user) {
		int n = 0;
		String sql = "INSERT INTO users(Login_ID,Job_ID,Department_ID,Login_Password,User_Name,User_Status) VALUES(?,?,?,?,?,?)";
		try {
			setConnAndPS(sql);
			ps.setString(1, user.getLoginId());
			ps.setLong(2, user.getJobId());
			ps.setLong(3, user.getDepartmentId());
			ps.setString(4, user.getLoginPwd());
			ps.setString(5, user.getName());
			ps.setString(6, user.isStatus() ? "1" : "0");
			LOGGER.info("添加用户：" + ps.toString());
			n = ps.executeUpdate();
		} catch (Exception e) {
			LOGGER.warn("该用户名已存在");
			n = -1;
		} finally {
			DBUtil.closeConnection(conn, null, ps);
		}
		return n;
	}

	@Override
	public User queryUser(String loginId) {
		User u = new User();
		String sql = " select Login_ID,User_Name,Department_Name,Name ,Login_Password ,User_Status,d.Department_id , u. Job_ID from users u join department d on u.Department_ID = d.Department_id join job j on u.Job_ID = j.Job_ID where u.Login_ID = ? ";
		try {
			setConnAndPS(sql);
			ps.setString(1, loginId);
			rs = ps.executeQuery();
			if (rs.next()) {
				u.setLoginId(rs.getString("Login_ID"));
				u.setName(rs.getString("User_Name"));
				u.setDepartmentId(rs.getInt("Department_ID"));
				u.setJobId(rs.getInt("Job_ID"));
				u.setLoginPwd(rs.getString("Login_Password"));
				u.setStatus("1".equals(rs.getString("User_Status")));
				u.setDepartmentName(rs.getString("Department_Name"));
				u.setJobName(rs.getString("Name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, rs, ps);
		}
		return u;
	}

	@Override
	public int updateUser(User user) {
		int n = 0;
		String sql = "update users set Job_ID= ?, Department_ID = ?,Login_Password= ? , user_name=?, User_Status=?  where login_id=? ";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setLong(1, user.getJobId());
			ps.setLong(2, user.getDepartmentId());
			ps.setString(3, user.getLoginPwd());
			ps.setString(4, user.getName());
			ps.setString(5, user.isStatus() ? "1" : "0");
			ps.setString(6, user.getLoginId());
			n = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, null, ps);
		}
		return n;
	}

	@Override
	public User findUser(String loginId, String loginPwd) {
		User user = null;
		String sql = "select Job_ID,Department_id,User_Name,User_Status from users where Login_ID=? and Login_Password=?";
		try {
			setConnAndPS(sql);
			ps.setString(1, loginId);
			ps.setString(2, loginPwd);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setLoginId(loginId);
				// user.setLoginPwd(loginPwd);
				user.setJobId(rs.getInt("Job_ID"));
				user.setDepartmentId(rs.getInt("Department_id"));
				user.setName(rs.getString("User_Name"));
				user.setStatus("1".equals(rs.getString("User_Status")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, rs, ps);
		}
		return user;
	}

	@Override
	public List<Function> findFunctionsByJobId(int jobId) {
		List<Function> list = new ArrayList<Function>();
		String sql = "select distinct f.Func_ID,f.Func_Name from functions f join xtymb x on f.Func_ID=x.Func_ID join gwym g on x.ymbh=g.ymbh where g.Job_ID=?";
		try {
			setConnAndPS(sql);
			ps.setLong(1, jobId);
			rs = ps.executeQuery();
			while (rs.next()) {
				Function function = new Function();
				function.setId(rs.getInt("Func_ID"));
				function.setName(rs.getString("Func_Name"));
				list.add(function);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, rs, ps);
		}
		return list;
	}

	@Override
	public List<Xtymb> findXtymbList(int jobId, int funcId) {
		List<Xtymb> list = new ArrayList<Xtymb>();
		String sql = "select x.ymbh,x.Func_ID,x.ymmc,x.URL,x.IMG from xtymb x join gwym g on x.ymbh=g.ymbh where g.Job_ID=? and x.Func_ID=?";
		try {
			setConnAndPS(sql);
			ps.setInt(1, jobId);
			ps.setInt(2, funcId);
			rs = ps.executeQuery();
			while (rs.next()) {
				Xtymb x = new Xtymb();
				x.setId(rs.getLong("ymbh"));
				x.setFunId(funcId);
				x.setName(rs.getString("ymmc"));
				x.setUrl(rs.getString("URL"));
				x.setImgPath(rs.getString("IMG"));
				list.add(x);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, rs, ps);
		}
		return list;
	}

	@Override
	public boolean hasUser(String uname) {
		boolean result = true;
		String sql = "SELECT Login_ID FROM users WHERE Login_ID=?";
		try {
			setConnAndPS(sql);
			ps.setString(1, uname);
			LOGGER.info("是否存在用户 " + uname + "：" + ps.toString());
			rs = ps.executeQuery();
			result = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, rs, ps);
		}
		return result;
	}
}