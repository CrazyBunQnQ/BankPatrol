package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.UserDao;
import com.bank.util.DBUtil;
import com.zrkc.syyh.model.UserModel;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	@Override
	public List<UserModel> findListByPage(int from, int pageSize) {
		String sql = "select Login_ID,User_Name,Department_Name,Name ,User_Status from users u join department d "
        +" on u.Department_ID = d.Department_id " +
    	 " join job j on u.Job_ID = j.Job_ID limit ?,? ";
		Connection conn = null;
		PreparedStatement ps = null ;
		ResultSet rs = null;
		List<UserModel>  list = new ArrayList<UserModel>();
		try {
			setConnAndPS(sql);
			ps.setInt(1, from);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserModel u = new UserModel();
				u.setLoginId(rs.getString("Login_ID"));
				u.setUserName(rs.getString("User_Name"));
				u.setDepartmentName(rs.getString("Department_Name"));
				u.setJobName(rs.getString("Name"));
				u.setUserStatus(rs.getString("User_Status"));
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
	public int findCount() {
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
			DBUtil.closeConnection(conn, rs, ps);
		}
		return n;
	}
}