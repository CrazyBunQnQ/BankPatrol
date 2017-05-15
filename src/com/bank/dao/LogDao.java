package com.bank.dao;

import java.util.Date;
import java.util.List;

import com.bank.entity.Log;

public interface LogDao {

	//添加登录时间
	public boolean addLoginTime(Date loginTime, String loginId);
	
	//添加退出时间
	public boolean addLogoutTime(Date loginTime, String loginId, Date logoutTime); 
	
	//清除日志
	public boolean clearLogs();
	
	//获取所有日志信息
	public List<Log> getAllLogs();
	
	//分页显示所有日志信息
	public List<Log> queryLogs(int pageSize, int pageNum);
	
	//获取日志信息条数
	public int countLogs();

}
