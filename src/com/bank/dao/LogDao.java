package com.bank.dao;

import java.util.List;

import com.bank.entity.Log;

public interface LogDao {

	/**
	 * 添加登录时间
	 * @param loginTime
	 * @param loginId
	 * @return
	 */
	public boolean addLoginTime(String loginTime, String loginId);
	
	/**
	 * 添加退出时间
	 * @param loginTime
	 * @param loginId
	 * @param logoutTime
	 * @return
	 */
	public boolean addLogoutTime(String loginTime, String loginId, String logoutTime); 
	
	/**
	 * 清除日志
	 * @return
	 */
	public boolean clearLogs();
	
	/**
	 * 获取所有日志信息
	 * @return
	 */
	public List<Log> getAllLogs();
	
	/**
	 * 分页显示所有日志信息
	 * @param pageSize
	 * @param pageNum
	 * @return
	 */
	public List<Log> queryLogs(int pageSize, int pageNum);
	
	/**
	 * 获取日志信息条数
	 * @return
	 */
	public int countLogs();

}
