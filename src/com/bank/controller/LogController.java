package com.bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.dao.LogDao;
import com.bank.dao.impl.LogDaoImpl;
import com.bank.entity.Log;
import com.bank.entity.PageInfo;
import com.bank.service.LogService;
import com.bank.service.impl.LogServiceImpl;
import com.bank.util.ExportLogUtil;

public class LogController {

	LogService logService = new LogServiceImpl();

	public void queryLogs(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("curpage") == null ? "1" : request.getParameter("curpage"));
		PageInfo<Log> data = logService.queryLogs(page);
		request.setAttribute("data", data);
		request.getRequestDispatcher("/jsp/system/log/logList.jsp").forward(request, response);
	}

	public void clearLogs(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LogDao ld = new LogDaoImpl();
		if (ld.clearLogs()) {
			response.getWriter().write("1");
		} else {
			response.getWriter().write("0");
		}
	}

	public void exportLogs(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		if(ExportLogUtil.exportLogs()){
			response.getWriter().write("1");
		} else {
			response.getWriter().write("0");
		}
			
	}
}
