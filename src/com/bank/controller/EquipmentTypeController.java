package com.bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.entity.EquipmentType;
import com.bank.entity.PageInfo;
import com.bank.service.impl.EquipmentTypeServiceImpl;

public class EquipmentTypeController {
	private EquipmentTypeServiceImpl eTypeService = new EquipmentTypeServiceImpl();

	/**
	 * 分页查询所有的设备种类
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void queryETypes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("curpage") == null ? "0" : request.getParameter("curpage"));
		String hiddenFind = request.getParameter("hiddenFind") == null ? "hidden" : request.getParameter("hiddenFind");
		String eTypeName = request.getParameter("eTypeName") == null ? "" : request.getParameter("eTypeName");
		String eTypeId = request.getParameter("eTypeId") == null ? "" : request.getParameter("eTypeId");
		PageInfo<EquipmentType> data = eTypeService.getEtypes(page, eTypeName, eTypeId);
		request.setAttribute("hiddenFind", hiddenFind);
		request.setAttribute("data", data);
		request.setAttribute("eTypeName", eTypeName);
		request.setAttribute("eTypeId", eTypeId);
		request.getRequestDispatcher("/jsp/system/etype/equipmentType.jsp").forward(request, response);
	}

}
