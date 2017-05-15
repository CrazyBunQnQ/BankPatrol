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
import com.bank.controller.DepartmentController;
import com.bank.controller.EquipmentTypeController;
import com.bank.controller.JobController;
import com.bank.controller.LogController;
import com.bank.controller.LoginController;
import com.bank.controller.PiGroupController;
import com.bank.controller.PiWorkerController;
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
			DepartmentController deptc = new DepartmentController();
			if (ary[1].equals("deptList")) {
				deptc.deptList(request, response);
			}else if (ary[1].equals("toAdd")) {
				deptc.toDeptAdd(request, response);
			}else if (ary[1].equals("checkDeptname")) {
				deptc.checkDeptName(request, response);
			}else if (ary[1].equals("deptAdd")) {
				deptc.deptAdd(request, response);
			}else if (ary[1].equals("deptDelete")) {
				deptc.deptDelete(request, response);
			}else if (ary[1].equals("dept2Update")) {
				deptc.dept2Update(request, response);
			}else if (ary[1].equals("deptUpdate")) {
				deptc.deptUpdate(request, response);
			}
		} else if (ary[0].equals("job")) {// 岗位模块
			 JobController jobController = new JobController();
			if ("jobList".equals(ary[1])) {
				jobController.queryGws(request, response);
			} else if ("toAdd".equals(ary[1])) {
				jobController.toAddJob(request, response);
			} else if ("checkName".equals(ary[1])) {
				jobController.checkName(request, response);
			} else if ("addJob".equals(ary[1])) {
				jobController.addJob(request, response);
			} else if ("toUpdate".equals(ary[1])) {
				jobController.toUpdateJob(request, response);
			} else if ("updateJob".equals(ary[1])) {
				jobController.updateJob(request, response);
			} else if ("xtymList".equals(ary[1])) {
				jobController.queryXtyms(request, response);
			} else if ("funcList".equals(ary[1])) {
				jobController.queryfuns(request, response);
			} else if ("showXtyms".equals(ary[1])) {
				jobController.showXtyms(request, response);
			} else if ("updateXtym".equals(ary[1])) {
				jobController.updateXtyms(request, response);
			}
		} else if (ary[0].equals("bank")) {// 银行模块
			BankController bankController = new BankController();
			if ("bankList".equals(ary[1])) {
				bankController.queryBanks(request, response);
			} else if ("toAdd".equals(ary[1])) {
				bankController.toAddBank(request, response);
			} else if ("checkBankId".equals(ary[1])) {
				bankController.checkBankId(request, response);
			} else if ("bankAdd".equals(ary[1])) {
				bankController.insertBank(request, response);
			} else if ("toUpdate".equals(ary[1])) {
				bankController.toUpdate(request, response);
			} else if ("bankUpdate".equals(ary[1])) {
				bankController.updateBank(request, response);
			} else if ("EquipmentsList".equals(ary[1])) {
				bankController.queryEquipments(request, response);
			} else if ("toAddEquipment".equals(ary[1])) {
				bankController.toAddEquipment(request, response);
			} else if ("checkBankEquId".equals(ary[1])) {
				bankController.checkEquipmentId(request, response);
			} else if ("AddEquipment".equals(ary[1])) {
				bankController.insertEquipment(request, response);
			} else if ("toUpdateEquipment".equals(ary[1])) {
				bankController.toUpdateEquipment(request, response);
			} else if ("UpdateEquipment".equals(ary[1])) {
				bankController.updateEquipment(request, response);
			} else if ("deleteEquipment".equals(ary[1])) {
				bankController.deleteEquipment(request, response);
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
				etc.toUpdateType(request, response);
			} else if ("updateEType".equals(ary[1])) {
				etc.updateType(request, response);
			} else if ("deleteType".equals(ary[1])) {
				etc.deleteType(request, response);
			}
		} else if (ary[0].equals("piwoker")) {// 巡检工模块
			PiWorkerController pc = new PiWorkerController();
			if(ary[1].equals("piwokerList")) {
				pc.queryPiWorkers(request, response);
			}else if(ary[1].equals("toAdd")) {
				pc.toAdd(request, response);
			}else if(ary[1].equals("addPiworker")) {
				pc.addPiworker(request, response);
			}else if(ary[1].equals("checkPiWorkerId")) {
				pc.checkPiWorkerId(request, response);
			}
				
			// LogController logController=new LogController();
		} else if (ary[0].equals("pigroup")) {// 巡检组模块
			PiGroupController pc = new PiGroupController();
			if(ary[1].equals("pigrouplist")) {
				pc.queryPiGroups(request, response);
			}else if(ary[1].equals("toAdd")){
				pc.toAdd(request, response);
			}
		}else if (ary[0].equals("log")) {// 日志模块
			 LogController logController = new LogController();
			if ("logList".equals(ary[1])) {
				logController.queryLogs(request, response);
			} else if ("clearLogs".equals(ary[1])) {
				logController.clearLogs(request, response);
			}else if ("exportLogs".equals(ary[1])) {
				logController.exportLogs(request, response);
			}
			
			
			
		}else {// 以上多条else if 都不满足时，跳转到404.jsp错误页面
			request.getRequestDispatcher("/404.jsp").forward(request, response);
			return;
		}
	}
}
