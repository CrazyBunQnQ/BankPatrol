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
import com.bank.entity.Bank;
import com.bank.entity.PageInfo;
import com.bank.service.impl.BankServiceImpl;

@WebServlet("/BankServlet")
public class BankController {
       
	private static final Logger LOGGER = LogManager.getLogger(GwymDaoImpl.class.getName());
	private BankServiceImpl bankService = new BankServiceImpl();

	/**
	 * 跳转到添加银行页面
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void toAddBank(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/system/bank/banknew.jsp").forward(request, response);
	}
	
	public void insertBank(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("bankId");
		String name = request.getParameter("bankName");
		double longitude = request.getParameter("bankLongitude") == null?0:Double.parseDouble(request.getParameter("bankLongitude"));
		double latitude = request.getParameter("bankLatitude") == null?0:Double.parseDouble(request.getParameter("bankLatitude"));
		String ip = request.getParameter("bankIp");
		Bank bank = new Bank(id, name, longitude, latitude, ip);
		if (bankService.insertBank(bank)) {
			response.sendRedirect("bankList.do");
		} else {
			//TODO 添加失败
			request.setAttribute("msg", "添加银行失败");
			request.setAttribute("bank", bank);
			request.getRequestDispatcher("/jsp/system/bank/bankList.jsp").forward(request, response);
		}
	}
	
	private void updateBank(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("bankId");
	}
	
	/**
	 * 分页查询银行网点
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 * @throws SQLException 
	 */
	public void queryBanks(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int page = Integer.parseInt(request.getParameter("page") == null?"0":request.getParameter("page"));
		PageInfo<Bank> data = bankService.getBanks(page);
		request.setAttribute("data", data);
		request.getRequestDispatcher("/jsp/system/bank/bankList.jsp").forward(request, response);
	}

	public void bankList(HttpServletRequest request, HttpServletResponse response) {
		
	}

	public void checkBankId(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		int i = bankService.checkBankId(id);
		PrintWriter out = response.getWriter();
		out.write(i+"");
	}

}
