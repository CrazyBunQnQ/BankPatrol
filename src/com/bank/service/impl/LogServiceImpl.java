package com.bank.service.impl;

import java.util.List;

import com.bank.dao.LogDao;
import com.bank.dao.impl.LogDaoImpl;
import com.bank.entity.Log;
import com.bank.entity.PageInfo;
import com.bank.service.LogService;

public class LogServiceImpl implements LogService {

	LogDao ldi = new  LogDaoImpl();
	@Override
	public PageInfo<Log> queryLogs(int page) {
		PageInfo<Log> pageInfo = new PageInfo<Log>();
		pageInfo.setCurPage(page);
		List<Log> log = ldi.queryLogs(pageInfo.getPageSize(), page);
		int count = ldi.countLogs();
		int totalPage = (int)Math.ceil((double)count/pageInfo.getPageSize());
		pageInfo.setTotalPage(totalPage);
		pageInfo.setTotalRecord(count);
		pageInfo.setPagedata(log);
		return pageInfo;
	}

	@Override
	public boolean clearLogs() {
		return ldi.clearLogs();
	}

	@Override
	public boolean addLoginTime(String loginTime, String loginId) {
		
		return ldi.addLoginTime(loginTime, loginId);
	}

	@Override
	public boolean addLogoutTime(String loginTime, String loginId, String logoutTime) {
		return ldi.addLogoutTime(loginTime, loginId, logoutTime);
	}

}
