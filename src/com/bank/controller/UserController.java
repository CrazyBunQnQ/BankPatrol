package com.bank.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.entity.Department;
import com.bank.entity.Job;
import com.bank.entity.PageInfo;
import com.bank.entity.User;
import com.bank.service.UserService;
import com.bank.service.impl.UserServiceImpl;
import com.bank.util.DateUtils;

public class UserController {
	UserService us = new UserServiceImpl();

	/**
	 * 显示列表页(支持查询)
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void userList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1、接当前的页码信息
		String curpage = request.getParameter("curpage");
		String hiddenFind = request.getParameter("hiddenFind") == null ? "hidden" : request.getParameter("hiddenFind");
		// 接收文本框的值
		String loginId = request.getParameter("loginId") == null ? "" : request.getParameter("loginId");
		String userName = request.getParameter("userName") == null ? "" : request.getParameter("userName");
		// 2.根据接收的值 进行查询
		User u = new User();
		u.setLoginId(loginId);
		u.setName(userName);
		PageInfo<User> data = us.userList(curpage, u);
		// 存 把查出的数据放入request
		request.setAttribute("hiddenFind", hiddenFind);
		request.setAttribute("loginId", loginId);
		request.setAttribute("userName", userName);
		request.setAttribute("data", data);
		// 调
		// 转
		request.getRequestDispatcher("/jsp/system/user/userlist.jsp").forward(request, response);
	}

	/**
	 * 删除用户
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void userDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 接收Id
		String userId = request.getParameter("userId");
		// 调Service层
		us.deleteUser(userId);
		// 转到显示页面
		response.sendRedirect("userList.do");
	}

	/**
	 * 跳转到更新用户界面
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void toUserAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 接 不接
		// 查询部门下拉列表
		List<Department> list1 = us.findAllDeprtments();
		// 查询岗位下拉列表
		List<Job> list2 = us.findAllJobs();
		// 把查出来的部门放入request
		request.setAttribute("d", list1);
		// 把查出来的岗位放入request
		request.setAttribute("j", list2);
		// 转 到时新增页面
		request.getRequestDispatcher("/jsp/system/user/usernew.jsp").forward(request, response);

	}

	/**
	 * 添加用户
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void userAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 接
		String loginId = request.getParameter("loginId");
		String pwd = request.getParameter("checkpwd");
		String userName = request.getParameter("userName");
		String dept = request.getParameter("dept");
		String job = request.getParameter("job");
		String userStatus = request.getParameter("userStatus");
		//生成worker_id/
		Date date =  new Date();
		String strDate = DateUtils.dateToTotalStr(date);
		Random rd = new Random();
		int random = rd.nextInt(1000);
		String strWorkId = strDate + random;
		long workerId = Long.parseLong(strWorkId);
		
		// 封装
		User user = new User();
		user.setLoginId(loginId);
		user.setJobId(Integer.parseInt(job));
		user.setDepartmentId(Integer.parseInt(dept));
		user.setLoginPwd(pwd);
		user.setName(userName);
		user.setStatus("1".equals(userStatus));
		user.setWorkerId(workerId);
		// 调用service
		if (us.addUser(user)) {
			// 转
			response.sendRedirect("userList.do");
		} else {
			// TODO 用户名重复
		}
	}

	/**
	 * 去修改页面
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void toUserUpte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginId = request.getParameter("loginId");
		// 调用Service
		User user = us.toUpdateUser(loginId);
		// 放入 request
		request.setAttribute("user", user);
		List<Department> d = us.findAllDeprtments();
		List<Job> j = us.findAllJobs();
		request.setAttribute("d", d);
		request.setAttribute("j", j);
		// 转页
		request.getRequestDispatcher("/jsp/system/user/userupdate.jsp").forward(request, response);
	}

	/**
	 * 更新用户
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
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

	/**
	 * 检查用户名是否存在
	 * 
	 * @param request
	 * @param response
	 */
	public void checkUName(HttpServletRequest request, HttpServletResponse response) {
		String uname = request.getParameter("users.loginId");
		try {
			if (us.hasUser(uname)) {
				response.getWriter().write("1");
			} else {
				response.getWriter().write("0");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
