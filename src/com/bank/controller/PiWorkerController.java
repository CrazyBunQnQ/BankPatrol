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
	//创建对象
	PIWorkerServiceDao pwd = new PiWorkerServiceDaoImpl();
	PiGroupDao pgd = new PiGroupDaoImpl();
	
	public void queryPiWorkers(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//拿到当前页
		int page = Integer.parseInt(request.getParameter("curpage") == null ? "1" : request.getParameter("curpage"));
		//拿到模糊查询的搜索条件
		String name = request.getParameter("searchPiWokerName");
		//判断是否显示搜索区内容
		String hiddenFind = request.getParameter("hiddenFind") == null ? "hidden" : request.getParameter("hiddenFind");
		//把是否显示搜索内容放到request域中，并取名为hiddenFind
		request.setAttribute("hiddenFind", hiddenFind);
		//把模糊搜索的条件放到request域中并取名为name
		request.setAttribute("searchPiWorkerName", name);
		//创建巡检工分页对象，并给对象赋值
		PageInfo<PiWorker> data = pwd.queryPiWoker(page, (String)request.getAttribute("searchPiWorkerName"));
		//将查出的值放入request域中并取名为data
		request.setAttribute("data", data);
		//转发页面到/jsp/system/pi/piWorker.jsp（因为要带数据到该页面所以用转发不用重定向）
		request.getRequestDispatcher("/jsp/system/pi/piWorker.jsp").forward(request, response);
	}
	public void toAdd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//创建巡检组对象并拿到所有巡检组
		List<PiGroup> pigroups = pgd.getAllGroup();
		//将查出的值放入request域中并取名为pigroups
		request.setAttribute("groups", pigroups);
		//转发页面到/jsp/system/pi/piWorkerNew.jsp
		request.getRequestDispatcher("/jsp/system/pi/piWorkerNew.jsp").forward(request, response);
	}
	
	public void addPiworker(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//从提交的form表单中获取workerId
		long workId = Long.parseLong(request.getParameter("workerId"));
		//从提交的form表单中获取第一个电话
		String tel1 = request.getParameter("workerTel1");
		//从提交的form表单中获取第二个电话
		String tel2 = request.getParameter("workerTel2");
		//从提交的form表单中获取groupId
		long groupId = Long.parseLong(request.getParameter("groupId"));
		//判断是否存在用户
		if(pwd.hasUser(workId)){
			//创建对象
			PiWorker piWorker = new PiWorker();
			//设置巡检工id
			piWorker.setId(workId);
			//设置巡检工第一个电话
			piWorker.setTel1(tel1);
			//设置巡检工第二个电话
			piWorker.setTel2(tel2);
			//创建对象
			PiGroup piGroup = new PiGroup();
			//设置巡检组id
			piGroup.setId(groupId);
			//设置巡检工的巡检组
			piWorker.setPiGroup(piGroup);
			//调用方法，添加巡检工
			pwd.addPiWorker(piWorker);
			//重定向到/Bank/piwoker/piwokerList.do
			response.sendRedirect("/Bank/piwoker/piwokerList.do");
		}
	}
	
	public void checkPiWorkerId(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		//从ajax异步请求中获取workId
		long workId = Long.parseLong(request.getParameter("id"));
		//判断用户是否在用户表中存在且巡检工表中不存在
		if(pwd.hasUser(workId)&& !pwd.hasUserInPiWorker(workId)){
			//给前台响应一个为1的值
			response.getWriter().write("1");
		}else{
			//给前台响应一个为0的值
			response.getWriter().write("0");
		}
	}
	
	public void deletePiworker(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException  {
		//从前台请求中获取id
		long id = Long.parseLong(request.getParameter("id"));
		//若成功删除则跳转到/Bank/piwoker/piwokerList.do
		if(pwd.deletePiWorker(id)){
			response.sendRedirect("/Bank/piwoker/piwokerList.do");
		}
	}
	public void update2Piworker(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException  {
		//从前台请求中获取id
		long id = Long.parseLong(request.getParameter("id"));
		//创建巡检工对象并根据id获取对象
		PiWorker piWorker = pwd.getPiWorkerById(id);
		//将查出的值放入request域中并取名为piWorker
		request.setAttribute("piWorker", piWorker);
		//将页面转发到/jsp/system/pi/piWorkerUpdate.jsp
		request.getRequestDispatcher("/jsp/system/pi/piWorkerUpdate.jsp").forward(request, response);
	}
	public void updatePiwoker(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//从前台请求中获取id
		long id = Long.parseLong(request.getParameter("wokerId"));
		//从前台请求中获取workerName
		String name = request.getParameter("workerName");
		//从前台请求中获取第一个电话
		String workerTel1 = request.getParameter("workerTel1");
		//从前台请求中获取第二个电话
		String workerTel2 = request.getParameter("workerTel2");
		//创建对象
		PiWorker p = new PiWorker();
		//给对象设置id
		p.setId(id);
		//给对象设置name
		p.setWorkerName(name);
		//给对象设置第一个电话
		p.setTel1(workerTel1);
		//给对象设置第二个电话
		p.setTel2(workerTel2);
		//若更新成功则跳转到/Bank/piwoker/piwokerList.do
		if(pwd.updatePiWorker(p)){
			response.sendRedirect("/Bank/piwoker/piwokerList.do");
		}
	}
}
