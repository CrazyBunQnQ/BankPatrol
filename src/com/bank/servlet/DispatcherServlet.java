package com.bank.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bank.controller.BankController;
import com.bank.controller.EquipmentTypeController;
import com.bank.controller.LoginController;
import com.bank.controller.UserController;

public class DispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = -4531284206455190654L;
	private static final Logger LOGGER = LogManager.getLogger(DispatcherServlet.class.getName());

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = uri.substring(uri.indexOf("/", 1) + 1, uri.lastIndexOf("."));

		String[] ary = path.split("/");
		LOGGER.info("\r\nuri: " + uri + "\r\npath: " + Arrays.toString(ary));
		if (ary.length != 2) {
			request.getRequestDispatcher("/404.jsp").forward(request, response);
			return;
		}

		if (ary[0].equals("login")) {// 登录,登出,用户模块
			LoginController loginController = new LoginController();
			if (ary[1].equals("login")) {
				loginController.login(request, response);
			} else if (ary[1].equals("logout")) {
				loginController.logout(request, response);
			} else if (ary[1].equals("initdata")) {
				loginController.initdata(request, response);
			} else if (ary[1].equals("leftList")) {
				loginController.leftList(request, response);
			}
		} else if (ary[0].equals("user")) {// 用户模块
			UserController uc = new UserController();
			if (ary[1].equals("userList")) {
				uc.userList(request, response);
			} else if (ary[1].equals("userDelete")) {
				uc.userDelete(request, response);
			} else if (ary[1].equals("toAdd")) {
				uc.toUserAdd(request, response);
			} else if (ary[1].equals("checkUserName")) {
				uc.checkUName(request, response);
			} else if (ary[1].equals("userAdd")) {
				uc.userAdd(request, response);
			} else if (ary[1].equals("userUpdate")) {
				uc.userUpdate(request, response);
			} else if (ary[1].equals("toUserUpte")) {
				uc.toUserUpte(request, response);
			}
		} else if (ary[0].equals("dept")) {// 部门模块

		} else if (ary[0].equals("bank")) {// 银行模块
			BankController bc = new BankController();
			if ("bankList".equals(ary[1])) {
				bc.queryBanks(request, response);
			} else if ("toAdd".equals(ary[1])) {
				bc.toAddBank(request, response);
			} else if ("checkBankId".equals(ary[1])) {
				bc.checkBankId(request, response);
			} else if ("bankAdd".equals(ary[1])) {
				bc.insertBank(request, response);
			} else if ("toUpdate".equals(ary[1])) {
				bc.toUpdate(request, response);
			} else if ("bankUpdate".equals(ary[1])) {
				bc.updateBank(request, response);
			} else if ("EquipmentsList".equals(ary[1])) {
				bc.queryEquipments(request, response);
			} else if ("toAddEquipment".equals(ary[1])) {
				bc.toAddEquipment(request, response);
			} else if ("checkBankEquId".equals(ary[1])) {
				bc.checkEquipmentId(request, response);
			} else if ("AddEquipment".equals(ary[1])) {
				bc.insertEquipment(request, response);
			} else if ("toUpdateEquipment".equals(ary[1])) {
				bc.toUpdateEquipment(request, response);
			} else if ("UpdateEquipment".equals(ary[1])) {
				bc.updateEquipment(request, response);
			} else if ("deleteEquipment".equals(ary[1])) {
				bc.deleteEquipment(request, response);
			}
		} else if (ary[0].equals("etype")) {// 设备种类模块
			EquipmentTypeController etc = new EquipmentTypeController();
			if ("equipmentTypeList".equals(ary[1])) {
				etc.queryETypes(request, response);
			} else if ("toAdd".equals(ary[1])) {
				etc.toAddType(request, response);
			} else if ("checkETypeId".equals(ary[1])) {
				etc.checkETypeId(request, response);
			} else if ("checkETypeName".equals(ary[1])) {
				etc.checkETypeName(request, response);
			} else if ("addEType".equals(ary[1])) {
				etc.addEType(request, response);
			} else if ("toUpdate".equals(ary[1])) {
				
			}
		} else if (ary[0].equals("log")) {// 日志模块
			// LogController logController=new LogController();
			if (ary[1].equals("")) {

			}
		} else {// 以上多条else if 都不满足时，跳转到404.jsp错误页面
			request.getRequestDispatcher("/404.jsp").forward(request, response);
			return;
		}
	}
}
