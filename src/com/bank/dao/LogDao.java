package com.bank.dao;

import java.util.Date;
import java.util.List;

import com.bank.entity.Log;

public interface LogDao {

	//添加登录时间
	public boolean addLoginTime(Date loginTime, String loginId);
	
	//添加退出时间
	public boolean addLogoutTime(Date loginTime, String loginId, Date logoutTime); 
	
	//清楚日志
	public boolean clearLog();
	
	//获取所有日志信息
	public List<Log> getAllLogs();
}
