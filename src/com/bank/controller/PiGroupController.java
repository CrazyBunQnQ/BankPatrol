package com.bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.entity.PageInfo;
import com.bank.entity.PiGroup;
import com.bank.service.PiGroupSeviceDao;
import com.bank.service.impl.PiGroupServiceDaoImpl;

public class PiGroupController {

	PiGroupSeviceDao pgd = new PiGroupServiceDaoImpl();
	
	public void queryPiGroups(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int page = Integer.parseInt(request.getParameter("curpage") == null ? "1" : request.getParameter("curpage"));
		PageInfo<PiGroup> data = pgd.queryPiGroup(page);
		request.setAttribute("data", data);
		request.getRequestDispatcher("/jsp/system/pg/piWorkerGroup.jsp").forward(request, response);
		
	}

	public void toAdd(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException  {

		request.getRequestDispatcher("/jsp/system/pg/piGroupNew.jsp").forward(request, response);
	}

	
}
