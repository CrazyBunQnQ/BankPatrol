package com.bank.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.bank.entity.Department;
import com.bank.entity.Function;
import com.bank.entity.Job;
import com.bank.entity.User;
import com.bank.entity.Xtymb;
import com.bank.service.UserService;
import com.bank.service.impl.UserServiceImpl;

public class UserAction extends BaseAction {

	private static final long serialVersionUID = -3442882080520300398L;
	private UserService us = new UserServiceImpl();

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String login() {
		user = us.findUser(user.getLoginId(), user.getLoginPwd());

		if (user != null) {
			if (user.isStatus()) {
				session.put("flag", "login_success");
				session.put("user", user);
				return SUCCESS;
			} else {
				session.put("flag", "login_error");
				request.put("err", "账号被禁用，请联系管理员");
				return ERROR;
			}
		} else {
			session.put("flag", "pwd_error");
			request.put("err", "用户名或密码错误");
			return ERROR;
		}
	}

	public String logout() {
		session.clear();
		return SUCCESS;
	}

	public String initdata() {
		User user = (User) session.get("user");
		if (user != null) {
			List<Function> funList = us.findFunctionsByJobId(user.getJobId());
			List<Xtymb> xtymbList = us.leftList(user, funList.get(0).getId());
			String funName = funList.get(0).getName();
			session.put("functions", funList);
			session.put("funName", funName);
			session.put("leftList", xtymbList);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String leftList() {
		int funcId = Integer.parseInt((String)request.get("funcId"));
		User user = (User) session.get("user");
		String funName = us.findFunctionsByJobId(user.getJobId()).get(funcId - 1).getName();
		List<Xtymb> list = us.leftList(user, funcId);
		session.put("funName", funName);
		session.put("leftList", list);
		return SUCCESS;
	}

	public String delete() {
		String userId = (String)request.get("userId");
		us.deleteUser(userId);
		return NONE;
	}

	public String list() {
		List<User> list = us.userList();
		request.put("list", list);
		return SUCCESS;
	}

	public String insert() {
		if (us.addUser(user)) {
			return NONE;
		} else {
			return ERROR;
		}
	}

	public String add() {
		List<Department> list1 = us.findAllDeprtments();
		List<Job> list2 = us.findAllJobs();
		request.put("d", list1);
		request.put("j", list2);
		return SUCCESS;
	}

	public String toUpdate() {
		user = us.toUpdateUser(user.getLoginId());
		request.put("user", user);
		List<Department> d = us.findAllDeprtments();
		List<Job> j = us.findAllJobs();
		request.put("d", d);
		request.put("j", j);
		return SUCCESS;
	}

	public String update() {
		us.updateUser(user);
		return NONE;
	}

	public void checkId() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		if (us.hasUser(user.getLoginId())) {
			response.getWriter().write("1");
		} else {
			response.getWriter().write("0");
		}
	}
}
