package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.entity.Function;
import com.bank.entity.Gwym;
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
			response.sendRedirect("jobList");
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
			response.sendRedirect("jobList");
		} else {
			request.setAttribute("msg", "更新岗位失败");
			request.setAttribute("job", job);
			request.getRequestDispatcher("/jsp/system/job/jobupdate.jsp").forward(request, response);
		}
	}

	/**
	 * 显示指定岗位的所有权限
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void queryXtyms(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("curpage") == null ? "0" : request.getParameter("curpage"));
		int jobId = Integer.parseInt(request.getParameter("jobId") == null ? "0" : request.getParameter("jobId"));
		PageInfo<Gwym> data = jobService.getGws(jobId, page);
		request.setAttribute("data", data);
		request.setAttribute("jobId", jobId);
		request.getRequestDispatcher("/jsp/system/job/xtymlist.jsp").forward(request, response);
	}

	/**
	 * 显示模块列表
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void queryfuns(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int jobId = Integer.parseInt(request.getParameter("jobId") == null ? "0" : request.getParameter("jobId"));
		List<Function> data = jobService.getFuns();
		request.setAttribute("data", data);
		request.setAttribute("jobId", jobId);
		request.getRequestDispatcher("/jsp/system/job/funclist.jsp").forward(request, response);
	}

	/**
	 * 显示指定模块的所有权限，该岗位拥有的权限默认选中
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void showXtyms(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int jobId = Integer.parseInt(request.getParameter("jobId") == null ? "0" : request.getParameter("jobId"));
		int funcId = Integer.parseInt(request.getParameter("funcId") == null ? "0" : request.getParameter("funcId"));
		List<Gwym> gws = jobService.getQXList(jobId, funcId);
		request.setAttribute("gws", gws);
		request.setAttribute("jobId", jobId);
		request.setAttribute("funcId", funcId);
		request.getRequestDispatcher("/jsp/system/job/xtym.jsp").forward(request, response);
	}

	public void updateXtyms(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int jobId = Integer.parseInt(request.getParameter("jobId") == null ? "0" : request.getParameter("jobId"));
		int funcId = Integer.parseInt(request.getParameter("funcId") == null ? "0" : request.getParameter("funcId"));
		String[] ymbhs = request.getParameterValues("ymbhs");
		if (jobService.updateXtyms(jobId, funcId, ymbhs)) {
			response.sendRedirect("xtymList?jobId=" + jobId);
		} else {
			response.sendRedirect("showXtyms?jobId=" + jobId + "&funcId=" + funcId);
		}
	}
}
