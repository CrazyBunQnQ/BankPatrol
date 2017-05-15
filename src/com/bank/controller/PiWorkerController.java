package com.bank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.dao.PiGroupDao;
import com.bank.dao.impl.PiGroupDaoImpl;
import com.bank.entity.PageInfo;
import com.bank.entity.PiGroup;
import com.bank.entity.PiWorker;
import com.bank.service.PIWorkerServiceDao;
import com.bank.service.impl.PiWorkerServiceDaoImpl;

public class PiWorkerController {

	PIWorkerServiceDao pwd = new PiWorkerServiceDaoImpl();
	PiGroupDao pgd = new PiGroupDaoImpl();
	
	public void queryPiWorkers(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int page = Integer.parseInt(request.getParameter("curpage") == null ? "1" : request.getParameter("curpage"));
		String name = request.getParameter("searchPiWokerName");
		request.setAttribute("searchPiWorkerName", name);
		PageInfo<PiWorker> data = pwd.queryPiWoker(page, (String)request.getAttribute("searchPiWorkerName"));
		request.setAttribute("data", data);
		request.getRequestDispatcher("/jsp/system/pi/piWorker.jsp").forward(request, response);
		
	}
	public void toAdd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<PiGroup> pigroups = pgd.getAllGroup();
		request.setAttribute("groups", pigroups);
		request.getRequestDispatcher("/jsp/system/pi/piWorkerNew.jsp").forward(request, response);
	}
	public void addPiworker(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		long workId = Long.parseLong(request.getParameter("workerId"));
		String tel1 = request.getParameter("workerTel1");
		String tel2 = request.getParameter("workerTel2");
		long groupId = Long.parseLong(request.getParameter("groupId"));
		if(pwd.hasUser(workId)){
			PiWorker piWorker = new PiWorker();
			piWorker.setId(workId);
			piWorker.setTel1(tel1);
			piWorker.setTel2(tel2);
			PiGroup piGroup = new PiGroup();
			piGroup.setId(groupId);
			piWorker.setPiGroup(piGroup);
			pwd.addPiWorker(piWorker);
		}
	}
	public void checkPiWorkerId(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		long workId = Long.parseLong(request.getParameter("id"));
		if(pwd.hasUser(workId)){
			response.getWriter().write("1");
		}else{
			response.getWriter().write("0");
		}
	}

}
