package com.bank.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.service.UserService;
import com.bank.service.impl.UserServiceImpl;

public class UserController {
	UserService us = new UserServiceImpl();

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
