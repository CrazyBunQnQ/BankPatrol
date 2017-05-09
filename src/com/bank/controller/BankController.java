package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bank.dao.impl.GwymDaoImpl;
import com.bank.service.impl.BankServiceImpl;

@WebServlet("/BankServlet")
public class BankController {
       
	private static final Logger LOGGER = LogManager.getLogger(GwymDaoImpl.class.getName());
	private BankServiceImpl bankService = new BankServiceImpl();

	public BankController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		switch (type) {
		case "insert":
//			insertBank(request, response);
			break;
		case "update":
			updateBank(request, response);
			break;
		case "query":
			queryBanks(request, response);
			break;
		default:
			break;
		}
	}
	
	private void updateBank(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("bankId");
	}
	
	/**
	 * 分页查询银行网点
	 * @param request
	 * @param response
	 */
	private void queryBanks(HttpServletRequest request, HttpServletResponse response) {
		int page = Integer.parseInt(request.getParameter("page"));
		int count = Integer.parseInt(request.getParameter("page"));
		String jsonStr = null;
		try {
			jsonStr = bankService.getBanks(page, count);
		} catch (SQLException e) {
			LOGGER.warn("数据库查询误");
			e.printStackTrace();
		}
		try {
			PrintWriter out = response.getWriter();
			// TODO 判断为空
			out.write(jsonStr);
		} catch (IOException e) {
			LOGGER.error("I/O 流错误");
			e.printStackTrace();
		}
	}

	public void bankList(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
