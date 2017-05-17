package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.entity.Function;
import com.bank.entity.Log;
import com.bank.entity.User;
import com.bank.entity.Xtymb;
import com.bank.service.LogService;
import com.bank.service.LoginService;
import com.bank.service.impl.LogServiceImpl;
import com.bank.service.impl.LoginServiceImpl;
import com.bank.util.DateUtils;
import com.bank.util.MD5Util;


/**
 * 登录与退出模块
 */
public class LoginController {
	
	private LoginService userService = new LoginServiceImpl();
	private LogService logService = new LogServiceImpl();

	// private LogService logService=new LogServiceImpl();
	/**
	 * 用户登录
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String loginId = request.getParameter("loginId");
		String loginPassword = MD5Util.getMD5(request.getParameter("loginPassword"));
		User user = userService.findUser(loginId, loginPassword);

		if (user != null) {
			if (user.isStatus()) {
				request.getSession().setAttribute("flag", "login_success");
				request.getSession().setAttribute("user", user);
				// 登录同时记录日志记录（日志模块需要完成的功能）
				Log log = new Log();
				log.setCheckIn(DateUtils.dateToStr(DateUtils.YYMMDD_HHmmss_24, new Date()));
				log.setUseername(user.getLoginId());
				HttpSession session = request.getSession();
				session.setAttribute("log",log);
				logService.addLoginTime(((Log)session.getAttribute("log")).getCheckIn(), user.getLoginId());//添加日志
				response.sendRedirect("../login/initdata.do");// 调用初始化数据
			} else {
				request.getSession().setAttribute("flag", "login_error");
				request.setAttribute("err", "账号被禁用，请联系管理员");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} else {
			PrintWriter out = response.getWriter();
			out.println("<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('用户名或密码有误，请重新输入！');");
			out.println("history.back();");
			out.println("</script>");
			out.flush();
			out.close();
		}
	}

	/**
	 * 登出,退出
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Log log = (Log) session.getAttribute("log");

		if (log != null) {
			// 退出同时更新登出时间（日志模块相关）
			logService.addLogoutTime(log.getCheckIn(), log.getUseername(), DateUtils.dateToStr(DateUtils.YYMMDD_HHmmss_24, new Date()));
		}
		session.invalidate();
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}

	/**
	 * 获得用户能操作的模块(大模块)
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void initdata(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.从session中获得用户
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {// 登录状态
			// 2.根据用户的岗位id获得用户能操作的模块
			List<Function> funList = userService.findFunctionsByJobId(user.getJobId());
			// 3.根据用户，根据模块id(funcId)获得左侧列表:子模块列表
			List<Xtymb> xtymbList = userService.leftList(user, funList.get(0).getId());
			String funName = funList.get(0).getName();
			request.getSession().setAttribute("functions", funList);
			request.getSession().setAttribute("funName", funName);
			request.getSession().setAttribute("leftList", xtymbList);
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		} else {// 未登录
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
	
	/**
	 * 获得左侧列表(根据用户，根据模块id:funcId 获得左侧列表)
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void leftList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获得模块id
		int funcId = Integer.parseInt(request.getParameter("funcId"));
		// 2.从session中获得用户
		User user = (User) request.getSession().getAttribute("user");
		String funName = userService.findFunctionsByJobId(user.getJobId()).get(funcId-1).getName();
		// 3.根据用户，根据模块id(funcId)获得左侧列表:子模块列表
		List<Xtymb> list = userService.leftList(user, funcId);
		request.getSession().setAttribute("funName", funName);
		request.getSession().setAttribute("leftList", list);
		request.getRequestDispatcher("/left.jsp").forward(request, response);
	}
}
