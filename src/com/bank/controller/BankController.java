package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.entity.Bank;
import com.bank.entity.BankEquipment;
import com.bank.entity.EquipmentType;
import com.bank.entity.PageInfo;
import com.bank.service.impl.BankServiceImpl;

@WebServlet("/BankServlet")
public class BankController {
       
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
	
	/**
	 * 增加银行
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void insertBank(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("bankId");
		String name = request.getParameter("bankName");
		double longitude = request.getParameter("bankLongitude") == null ? 0: Double.parseDouble(request.getParameter("bankLongitude"));
		double latitude = request.getParameter("bankLatitude") == null ? 0: Double.parseDouble(request.getParameter("bankLatitude"));
		String ip = request.getParameter("bankIp");
		Bank bank = new Bank(id, name, longitude, latitude, ip);
		if (bankService.insertBank(bank)) {
			response.sendRedirect("bankList.do");
		} else {
			request.setAttribute("msg", "添加银行失败");
			request.setAttribute("bank", bank);
			request.getRequestDispatcher("/jsp/system/bank/banknew.jsp").forward(request, response);
		}
	}
	
	/**
	 * 跳转到更新银行界面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void toUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("bankId");
		Bank bank = bankService.getBank(id);
		request.setAttribute("bank", bank);
		request.getRequestDispatcher("/jsp/system/bank/bankupdate.jsp").forward(request, response);
	}
	
	/**
	 * 更新银行
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateBank(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("bankId");
		String name = request.getParameter("bankName");
		double longitude = request.getParameter("bankLongitude") == null ? 0: Double.parseDouble(request.getParameter("bankLongitude"));
		double latitude = request.getParameter("bankLatitude") == null ? 0: Double.parseDouble(request.getParameter("bankLatitude"));
		String ip = request.getParameter("bankIp");
		Bank bank = new Bank(id, name, longitude, latitude, ip);
		if (bankService.updateBank(bank)) {
			response.sendRedirect("bankList.do");
		} else {
			request.setAttribute("msg", "添加银行失败");
			request.setAttribute("bank", bank);
			request.getRequestDispatcher("/jsp/system/bank/bankupdate.jsp").forward(request, response);
		}
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
		int page = Integer.parseInt(request.getParameter("curpage") == null ? "0" : request.getParameter("curpage"));
		PageInfo<Bank> data = bankService.getBanks(page);
		request.setAttribute("data", data);
		request.getRequestDispatcher("/jsp/system/bank/bankList.jsp").forward(request, response);
	}

	/**
	 * 根据 id 查询银行是否存在
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void checkBankId(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		int i = bankService.checkBankId(id);
		PrintWriter out = response.getWriter();
		out.write(i + "");
	}

	/**
	 * 查询指定银行的设备
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void queryEquipments(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bankId = request.getParameter("bankId");
		int page = Integer.parseInt(request.getParameter("curpage") == null ? "0" : request.getParameter("curpage"));
		PageInfo<BankEquipment> data = bankService.getEquipments(bankId, page);
		request.setAttribute("data", data);
		request.getRequestDispatcher("/jsp/system/bank/bankEquipment.jsp").forward(request, response);
	}

	/**
	 * 给指定银行添加设备
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void toAddEquipment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bankId = request.getParameter("bankId");
		Bank bank = bankService.getBank(bankId);
		List<EquipmentType> typeList = bankService.getEquipmentTypes();
		request.setAttribute("bank", bank);
		request.getRequestDispatcher("/jsp/system/bank/bankequnew.jsp").forward(request, response);
	}
}
