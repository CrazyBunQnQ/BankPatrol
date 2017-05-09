package com.bank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.entity.Department;
import com.bank.entity.Job;
import com.bank.entity.PageInfo;
import com.bank.entity.User;
import com.bank.service.UserService;
import com.bank.service.impl.UserServiceImpl;

public class UserController {
    UserService us = new UserServiceImpl();
	public void userList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接当前的页码信息
		String curpage = request.getParameter("curpage"); 
		//调
		PageInfo<User> data = us.userList(curpage);
		//存  把查出的数据放入request
		request.setAttribute("data", data);
		//转
		request.getRequestDispatcher("/jsp/system/user/userlist.jsp").forward(request, response);
		
	}
	public void userDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 接收Id
		String userId = request.getParameter("userId");
		//调Service层
		us.deleteUser(userId);
		//转到显示页面
		response.sendRedirect("userList.do");
		
	}
	public void toUserAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接 不接
		//查询部门下拉列表
		List<Department> list1 = us.findAllDeprtments();
		//查询岗位下拉列表
		List<Job> list2 = us.findAllJobs();
		//把查出来的部门放入request
		request.setAttribute("d", list1);
		//把查出来的岗位放入request
		request.setAttribute("j", list2);
	
	    //转 到时新增页面
	    request.getRequestDispatcher("/jsp/system/user/usernew.jsp").forward(request, response);	
		
	}
	public void userAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//接 
		String loginId = request.getParameter("loginId");
		String pwd = request.getParameter("loginPassword");
		String userName = request.getParameter("userName");
		String dept = request.getParameter("dept");
		String job = request.getParameter("job");
		String userStatus = request.getParameter("userStatus");
		//封装 
		User user = new User();
		user.setLoginId(loginId);
		user.setJobId(Integer.parseInt(job));
		user.setDepartmentId(Integer.parseInt(dept));
		user.setLoginPwd(pwd);
		user.setName(userName);
		user.setStatus("1".equals(userStatus));
		//调用service       
		us.addUser(user);
		//转
		response.sendRedirect("userList.do");
	}
	
	/**
	 * 去修改页面
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void toUserUpte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId = request.getParameter("loginId");
		
		//调用Service 
		User user = us.toUpdateUser(loginId);
		//放入 request
		request.setAttribute("user", user);
		
		List<Department> d = us.findAllDeprtments();
		List<Job> j = us.findAllJobs();
		
		request.setAttribute("d", d);
		request.setAttribute("j", j);
		//转页
		request.getRequestDispatcher("/jsp/system/user/userupdate.jsp").forward(request, response);	
	}
	public void userUpdate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 接
		String loginId = request.getParameter("loginId");
		String pwd = request.getParameter("loginPassword");
		String userName = request.getParameter("userName");
		String dept = request.getParameter("dept");
		String job = request.getParameter("job");
		String userStatus = request.getParameter("userStatus");
		// 封装
		User user = new User();
		user.setLoginId(loginId);
		user.setJobId(Integer.parseInt(job));
		user.setDepartmentId(Integer.parseInt(dept));
		user.setLoginPwd(pwd);
		user.setName(userName);
		user.setStatus("1".equals(userStatus));
		// service
		us.updateUser(user);
		// zhuan
		response.sendRedirect("userList.do");
	}
}
