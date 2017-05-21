package com.bank.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bank.entity.Department;
import com.bank.entity.Function;
import com.bank.entity.Job;
import com.bank.entity.PageInfo;
import com.bank.entity.User;
import com.bank.entity.Xtymb;
import com.bank.service.LoginService;
import com.bank.service.UserService;
import com.bank.service.impl.LoginServiceImpl;
import com.bank.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	private static final long serialVersionUID = -3442882080520300398L;
	private UserService us = new UserServiceImpl();
	private LoginService userService = new LoginServiceImpl();
	private HttpServletRequest request = null;

	private User user;
	private String curpage;
	private String hiddenFind;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCurpage() {
		return curpage;
	}

	public void setCurpage(String curpage) {
		this.curpage = curpage;
	}

	public String getHiddenFind() {
		return hiddenFind;
	}

	public void setHiddenFind(String hiddenFind) {
		this.hiddenFind = hiddenFind;
	}

	public String login() {
		request = ServletActionContext.getRequest();
		user = userService.findUser(user.getLoginId(), user.getLoginPwd());

		if (user != null) {
			if (user.isStatus()) {
				request.getSession().setAttribute("flag", "login_success");
				request.getSession().setAttribute("user", user);
				return "SUCCESS";
			} else {
				request.getSession().setAttribute("flag", "login_error");
				request.setAttribute("err", "账号被禁用，请联系管理员");
				return "FAIL";
			}
		} else {
			request.getSession().setAttribute("flag", "pwd_error");
			request.setAttribute("err", "用户名或密码错误");
			return "FAIL";
		}
	}

	public String logout() {
		request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.invalidate();
		return "SUCCESS";
	}

	public String initdata() {
		request = ServletActionContext.getRequest();
		User user = (User) request.getSession().getAttribute("user");
		if (user != null) {
			List<Function> funList = userService.findFunctionsByJobId(user.getJobId());
			List<Xtymb> xtymbList = userService.leftList(user, funList.get(0).getId());
			String funName = funList.get(0).getName();
			request.getSession().setAttribute("functions", funList);
			request.getSession().setAttribute("funName", funName);
			request.getSession().setAttribute("leftList", xtymbList);
			return "SUCCESS";
		} else {
			return "FAIL";
		}
	}

	public String leftList() {
		request = ServletActionContext.getRequest();
		int funcId = Integer.parseInt(request.getParameter("funcId"));
		User user = (User) request.getSession().getAttribute("user");
		String funName = userService.findFunctionsByJobId(user.getJobId()).get(funcId - 1).getName();
		List<Xtymb> list = userService.leftList(user, funcId);
		request.getSession().setAttribute("funName", funName);
		request.getSession().setAttribute("leftList", list);
		return "SUCCESS";
	}

	public String delete() {
		request = ServletActionContext.getRequest();
		String userId = request.getParameter("userId");
		us.deleteUser(userId);
		return "REFRESH";
	}

	public String list() {
		request = ServletActionContext.getRequest();
		PageInfo<User> data = us.userList(curpage, user);
		request.setAttribute("hiddenFind", hiddenFind);
		request.setAttribute("loginId", user == null ? "" : user.getLoginId());
		request.setAttribute("userName", user == null ? "" : user.getName());
		request.setAttribute("data", data);
		return "SUCCESS";
	}

	public String toAdd() {
		request = ServletActionContext.getRequest();
		List<Department> list1 = us.findAllDeprtments();
		List<Job> list2 = us.findAllJobs();
		request.setAttribute("d", list1);
		request.setAttribute("j", list2);
		return "SUCCESS";
	}

	public String add() {
		if (us.addUser(user)) {
			return "REFRESH";
		} else {
			return "FAIL";
		}
	}

	public String toUpdate() {
		request = ServletActionContext.getRequest();
		user = us.toUpdateUser(user.getLoginId());
		request.setAttribute("user", user);
		List<Department> d = us.findAllDeprtments();
		List<Job> j = us.findAllJobs();
		request.setAttribute("d", d);
		request.setAttribute("j", j);
		return "SUCCESS";
	}

	public String update() {
		us.updateUser(user);
		return "REFRESH";
	}

	public void checkId() throws IOException {
		request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		if (us.hasUser(user.getLoginId())) {
			response.getWriter().write("1");
		} else {
			response.getWriter().write("0");
		}
	}
}
