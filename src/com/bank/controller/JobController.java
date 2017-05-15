package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

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

	/**
	 * 跳转到添加岗位界面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void toAddJob(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("jobName")==null?"":request.getParameter("jobName");
		String description = request.getParameter("description")==null?"":request.getParameter("description");
		Job job = new Job(name, description);
		request.setAttribute("job", job);
		request.getRequestDispatcher("/jsp/system/job/jobnew.jsp").forward(request, response);
	}

	/**
	 * 检查岗位名称是否存在
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	public void checkName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("jobName");
		int i = jobService.hasJob(name);
		PrintWriter out = response.getWriter();
		out.write(i + "");
	}

	/**
	 * 添加岗位
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void addJob(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("jobName")==null?"":request.getParameter("jobName");
		String description = request.getParameter("description")==null?"":request.getParameter("description");
		Job job = new Job(name, description);
		if (jobService.addJob(job)) {
			response.sendRedirect("jobList.do");
		} else {
			request.setAttribute("msg", "添加岗位失败");
			request.setAttribute("job", job);
			request.getRequestDispatcher("/jsp/system/job/jobnew.jsp").forward(request, response);
		}
	}

	/**
	 * 跳转到更新岗位界面
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void toUpdateJob(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("jobId") == null ? "0" : request.getParameter("jobId"));
		String name = request.getParameter("jobName") == null ? "" : request.getParameter("jobName");
		String description = request.getParameter("description") == null ? "" : request.getParameter("description");
		Job job = new Job(id, name, description);
		request.setAttribute("job", job);
		request.getRequestDispatcher("/jsp/system/job/jobupdate.jsp").forward(request, response);
	}

	/**
	 * 更新岗位
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void updateJob(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("jobId") == null ? "0" : request.getParameter("jobId"));
		String name = request.getParameter("jobName") == null ? "" : request.getParameter("jobName");
		String description = request.getParameter("description") == null ? "" : request.getParameter("description");
		Job job = new Job(id, name, description);
		if (jobService.updateJob(job)) {
			response.sendRedirect("jobList.do");
		} else {
			request.setAttribute("msg", "更新岗位失败");
			request.setAttribute("job", job);
			request.getRequestDispatcher("/jsp/system/job/jobupdate.jsp").forward(request, response);
		}
	}
}
