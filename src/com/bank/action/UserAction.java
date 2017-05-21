package com.bank.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bank.entity.Function;
import com.bank.entity.User;
import com.bank.entity.Xtymb;
import com.bank.service.LoginService;
import com.bank.service.impl.LoginServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {

	private static final long serialVersionUID = -3442882080520300398L;
	private LoginService userService = new LoginServiceImpl();
	private HttpServletRequest request = ServletActionContext.getRequest();

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String login() {
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

	public String initdata() {
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
}
