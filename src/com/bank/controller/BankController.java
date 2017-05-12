package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
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
import com.bank.util.DateUtils;

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
		request.setAttribute("bankId", bankId);
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
		goAddOrUpdate(bankId, request, response);
		request.getRequestDispatcher("/jsp/system/bank/bankequnew.jsp").forward(request, response);
	}

	/**
	 * 检查设备 id 是否存在，存在输出 1，不存在输出 0
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void checkEquipmentId(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id");
		int i = bankService.checkEquipmentId(id);
		PrintWriter out = response.getWriter();
		out.write(i + "");
	}

	public void insertEquipment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String equipmentId = request.getParameter("equipmentEachId");
		String typeId = request.getParameter("equipmentId");
		String bankId = request.getParameter("bankId");
		String bankName = request.getParameter("bankName");
		Double value = Double.parseDouble(request.getParameter("equipmentValue"));
		Date buyDate = DateUtils.strToDate("yyyy-MM-dd", request.getParameter("equipmentBuyDate"));
		Integer status = Integer.parseInt(request.getParameter("status"));
		Double depreciationValue = Double.parseDouble(request.getParameter("depreciationValue"));
		BankEquipment be = new BankEquipment();
		be.setEachID(equipmentId);
		be.setTypeId(typeId);
		be.setBankId(bankId);
		be.setBankName(bankName);
		be.setValue(value);
		be.setBuyDate(buyDate);
		be.setStatus(status);
		be.setDepreciationValue(depreciationValue);
		if (bankService.insertEquipment(be)) {
			response.sendRedirect("EquipmentsList.do?bankId=" + bankId);
		} else {
			request.setAttribute("msg", "添加银行设备失败");
			request.setAttribute("equipment", be);
			goAddOrUpdate(bankId, request, response);
			request.getRequestDispatcher("/jsp/system/bank/bankequnew.jsp").forward(request, response);
		}
	}
	

	public void toUpdateEquipment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eqId = request.getParameter("eqId");
		BankEquipment be = bankService.getEquipment(eqId);
		List<EquipmentType> typeList = bankService.getEquipmentTypes();
		request.setAttribute("typs", typeList);
		request.setAttribute("equi", be);
		request.getRequestDispatcher("/jsp/system/bank/bankequpdate.jsp").forward(request, response);
	}

	public void updateEquipment(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String equipmentId = request.getParameter("equipmentEachId");
		String typeId = request.getParameter("equipmentId");
		String bankId = request.getParameter("bankId");
		Double value = Double.parseDouble(request.getParameter("equipmentValue"));
		Date buyDate = DateUtils.strToDate("yyyy-MM-dd", request.getParameter("equipmentBuyDate"));
		Integer status = Integer.parseInt(request.getParameter("status"));
		Double depreciationValue = Double.parseDouble(request.getParameter("depreciationValue"));
		BankEquipment be = new BankEquipment();
		be.setEachID(equipmentId);
		be.setTypeId(typeId);
		be.setBankId(bankId);
		be.setValue(value);
		be.setBuyDate(buyDate);
		be.setStatus(status);
		be.setDepreciationValue(depreciationValue);
		if (bankService.updateEquipment(be)) {
			response.sendRedirect("EquipmentsList.do?bankId=" + bankId);
		} else {
			request.setAttribute("msg", "修改银行设备信息失败");
			request.setAttribute("equipment", be);
			goAddOrUpdate(bankId, request, response);
			request.getRequestDispatcher("/jsp/system/bank/bankequpdate.jsp").forward(request, response);
		}
	}

	/**
	 * 删除指定流水 id 的银行设备，并跳转到指定银行 id 下的所有银行设备
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void deleteEquipment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String eqId = request.getParameter("eqId");
		String bankId = request.getParameter("bankId");
		if (bankService.deleteEquipment(eqId)) {
			response.sendRedirect("EquipmentsList.do?bankId=" + bankId);
		} else {
			//TODO 删除失败提示
		}
	}
	
	/**
	 * 跳转到增加或修改设备页面
	 * @param bankId 银行 id
	 * @param request
	 * @param response
	 */
	private void goAddOrUpdate(String bankId, HttpServletRequest request, HttpServletResponse response){
		Bank bank = bankService.getBank(bankId);
		List<EquipmentType> typeList = bankService.getEquipmentTypes();
		request.setAttribute("typs", typeList);
		request.setAttribute("bank", bank);
	}
}
