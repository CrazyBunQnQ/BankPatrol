package com.bank.service.impl;

import java.util.List;

import com.bank.dao.LogDao;
import com.bank.dao.impl.LogDaoImpl;
import com.bank.entity.Log;
import com.bank.entity.PageInfo;
import com.bank.service.LogService;

public class LogServiceImpl implements LogService {
	LogDao ldi = new  LogDaoImpl();
	////获取日志分页对象
	@Override
	public PageInfo<Log> queryLogs(int page) {
		//创建对象
		PageInfo<Log> pageInfo = new PageInfo<Log>();
		//设置当前页
		pageInfo.setCurPage(page);
		//定义日志集合
		List<Log> log = ldi.queryLogs(pageInfo.getPageSize(), page);
		//定义部门总条数
		int count = ldi.countLogs();
		//获取部门信息总页数
		int totalPage = (int)Math.ceil((double)count/pageInfo.getPageSize());
		//设置总页数
		pageInfo.setTotalPage(totalPage);
		//设置总条数
		pageInfo.setTotalRecord(count);
		//设置部门信息
		pageInfo.setPagedata(log);
		return pageInfo;
	}

	//清空日志
	@Override
	public boolean clearLogs() {
		return ldi.clearLogs();
	}

	//添加登录时间
	@Override
	public boolean addLoginTime(String loginTime, String loginId) {
		return ldi.addLoginTime(loginTime, loginId);
	}

	//添加退出时间
	@Override
	public boolean addLogoutTime(String loginTime, String loginId, String logoutTime) {
		return ldi.addLogoutTime(loginTime, loginId, logoutTime);
	}
}
