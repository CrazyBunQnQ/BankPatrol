package com.bank.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bank.dao.LogDao;
import com.bank.entity.Log;
import com.bank.util.DBUtil;

public class LogDaoImpl extends BaseDaoImpl implements LogDao {

	@Override
	public boolean addLoginTime(Date loginTime, String loginId) {

		boolean flag = false;
		String sql = "insert into logs (checkin_time, users_Id) values (?,?)";
		try {
			setConnAndPS(sql);
			ps.setDate(1, new java.sql.Date(loginTime.getTime()));
			ps.setString(2,loginId);
			int a = ps.executeUpdate();
			if(a>0){
				flag = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return flag;
	}

	@Override
	public boolean addLogoutTime(Date loginTime, String loginId, Date logoutTime) {
		boolean flag = false;
		String sql = "update logs set checkout_time = ? where users_id = ? and checkin_time = ?";
		try {
			setConnAndPS(sql);
			ps.setDate(1, new java.sql.Date(logoutTime.getTime()));
			ps.setString(2,loginId);
			ps.setDate(3, new java.sql.Date(loginTime.getTime()));
			int a = ps.executeUpdate();
			if(a>0){
				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return flag;
	}

	@Override
	public boolean clearLog() {
		boolean flag = false;
		String sql = "delete from logs";
		try {
			setConnAndPS(sql);
			int a = ps.executeUpdate();
			if(a>0){
				flag = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return flag;
	}

	@Override
	public List<Log> getAllLogs() {

		List<Log> logs = new ArrayList<Log>();
		String sql = "select log_id, checkin_time, checkout_time, users_id from logs";
		try {
			setConnAndPS(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Log log = new Log();
				log.setId(rs.getLong("log_id"));
				log.setCheckIn(rs.getDate("checkin_time"));
				log.setCheckOut(rs.getDate("checkout_time"));
				log.setUseername(rs.getString("users_id"));
				logs.add(log);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return logs;
	}



}
