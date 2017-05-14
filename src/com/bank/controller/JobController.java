package com.bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.entity.Job;
import com.bank.entity.PageInfo;
import com.bank.service.impl.JobServiceImpl;

public class JobController {
	private JobServiceImpl jobService = new JobServiceImpl();

	/**
	 * 查询并跳转到岗位列表
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void queryGws(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("curpage") == null ? "0" : request.getParameter("curpage"));
		PageInfo<Job> data = jobService.getJobs(page);
		request.setAttribute("data", data);
		request.getRequestDispatcher("/jsp/system/job/joblist.jsp").forward(request, response);
	}
}
