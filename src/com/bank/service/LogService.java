package com.bank.service;

import java.util.Date;

import com.bank.entity.Log;
import com.bank.entity.PageInfo;

public interface LogService {
	//日志分页显示
	public PageInfo<Log> queryLogs(int page);
		
	//清空日志
	public boolean clearLogs();
	
	//添加登录时间
	public boolean addLoginTime(String loginTime, String loginId);
	
	//添加退出时间
	public boolean addLogoutTime(String loginTime, String loginId, String logoutTime);
	
}
