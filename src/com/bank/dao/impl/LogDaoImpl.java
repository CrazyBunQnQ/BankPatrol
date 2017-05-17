package com.bank.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.LogDao;
import com.bank.entity.Log;
import com.bank.util.DBUtil;

public class LogDaoImpl extends BaseDaoImpl implements LogDao {

	//添加登录时间
	@Override
	public boolean addLoginTime(String loginTime, String loginId) {
		boolean flag = false;
		String sql = "insert into logs (checkin_time, users_Id) values (?,?)";
		try {
			//获取数据库连接对象Connection及PreparedStatement对象
			setConnAndPS(sql);
			//给占位符赋值
			ps.setString(1, loginTime);
			ps.setString(2,loginId);
			//执行sql语句，返回影响行数
			int a = ps.executeUpdate();
			//若受影响行数大于0，则添加成功
			if(a>0){
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return flag;
	}

	//添加退出时间
	@Override
	public boolean addLogoutTime(String loginTime, String loginId, String logoutTime) {
		boolean flag = false;
		String sql = "update logs set checkout_time = ? where users_id = ? and checkin_time = ?";
		try {
			//获取数据库连接对象Connection及PreparedStatement对象
			setConnAndPS(sql);
			//给占位符赋值
			ps.setString(1,logoutTime);
			ps.setString(2,loginId);
			ps.setString(3, loginTime);
			//执行sql语句，返回影响行数
			int a = ps.executeUpdate();
			//若受影响行数大于0，则添加成功
			if(a>0){
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return flag;
	}

	//清空日志
	@Override
	public boolean clearLogs() {
		boolean flag = false;
		String sql = "delete from logs";
		try {
			////获取数据库连接对象Connection及PreparedStatement对象
			setConnAndPS(sql);
			//执行sql语句，返回影响行数
			int a = ps.executeUpdate();
			//若受影响行数大于0，则清空成功
			if(a>0){
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return flag;
	}

	//获取所有日志信息
	@Override
	public List<Log> getAllLogs() {
		//创建对象
		List<Log> logs = new ArrayList<Log>();
		String sql = "select log_id, checkin_time, checkout_time, users_id from logs ";
		try {
			//获取数据库连接对象Connection及PreparedStatement对象
			setConnAndPS(sql);
			//执行sql语句，返回影响行数
			rs = ps.executeQuery();
			//循环输出查询结果
			while(rs.next()){
				//创建对象
				Log log = new Log();
				//设置id
				log.setId(rs.getLong("log_id"));
				//设置登录时间
				log.setCheckIn(rs.getString("checkin_time"));
				//设置退出时间
				log.setCheckOut(rs.getString("checkout_time"));
				//设置用户名称
				log.setUseername(rs.getString("users_id"));
				//添加到集合
				logs.add(log);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return logs;
	}
	
	//分页显示所有日志信息
	@Override
	public List<Log> queryLogs(int pageSize, int pageNum) {
		//创建对象
		List<Log> logs = new ArrayList<Log>();
		String sql = "select log_id, checkin_time, checkout_time, users_id from logs limit ?,?";
		try {
			//获取数据库连接对象Connection及PreparedStatement对象
			setConnAndPS(sql);
			//给占位符赋值
			ps.setInt(1, (pageNum-1)*pageSize);
			ps.setInt(2, pageSize);
			//执行sql语句，返回影响行数
			rs = ps.executeQuery();
			//循环输出查询结果
			while(rs.next()){
				//创建对象
				Log log = new Log();
				//设置id
				log.setId(rs.getLong("log_id"));
				//设置登录时间
				log.setCheckIn(rs.getString("checkin_time"));
				//设置退出时间
				log.setCheckOut(rs.getString("checkout_time"));
				//设置用户名称
				log.setUseername(rs.getString("users_id"));
				//添加到集合
				logs.add(log);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return logs;
	}

	//获取日志信息条数
	@Override
	public int countLogs() {
		//定义日志信息条数，初值为0
		int count = 0;
		String sql = "select count(log_ID) from logs";
		try {
			//获取数据库连接对象Connection及PreparedStatement对象
			setConnAndPS(sql);
			//执行sql语句，返回影响行数
			rs = ps.executeQuery();
			//若查询结果不为空，则给日志信息条数赋值
			if(rs.next()){
				count = rs.getInt("count(log_ID)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return count;
	}
}
