package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.entity.EquipmentType;
import com.bank.entity.PageInfo;
import com.bank.service.EquipmentTypeService;
import com.bank.service.impl.EquipmentTypeServiceImpl;

public class EquipmentTypeController {
	private EquipmentTypeService eTypeService = new EquipmentTypeServiceImpl();

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

	/**
	 * 跳转到添加设备种类页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void toAddType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EquipmentType eType = new EquipmentType("", "");
		request.setAttribute("eType", eType);
		request.getRequestDispatcher("/jsp/system/etype/equipmentTypenew.jsp").forward(request, response);
	}

	/**
	 * 检查设备种类 id 是否存在，存在输出 1，不存在输出 0
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	public void checkETypeId(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String typeId = request.getParameter("id");
		int i = eTypeService.checkEquipmentId(typeId);
		PrintWriter out = response.getWriter();
		out.write(i + "");
	}

	/**
	 * 检查设备种类名称是否存在，存在输出 1，不存在输出 0
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	public void checkETypeName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String typeName = request.getParameter("name");
		int i = eTypeService.checkEquipmentName(typeName);
		PrintWriter out = response.getWriter();
		out.write(i + "");
	}

	/**
	 * 增加设备种类
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void addEType(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String id = request.getParameter("eTypeId");
		String name = request.getParameter("eTypeName");
		EquipmentType eType = new EquipmentType(id, name);
		if (eTypeService.insertEType(eType)) {
			response.sendRedirect("equipmentTypeList");
		} else {
			request.setAttribute("msg", "添加设备种类失败");
			request.setAttribute("eType", eType);
			request.getRequestDispatcher("/jsp/system/etype/equipmentTypenew.jsp").forward(request, response);
		}
	}
	
	/**
	 * 跳转到更新设备种类界面
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void toUpdateType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("eTypeId");
		String name = request.getParameter("eTypeName");
		EquipmentType eType = new EquipmentType(id, name);
		request.setAttribute("eType", eType);
		request.getRequestDispatcher("/jsp/system/etype/equipmentTypeupdate.jsp").forward(request, response);
	}

	/**
	 * 更新设备种类
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void updateType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("eTypeId");
		String name = request.getParameter("eTypeName");
		EquipmentType eType = new EquipmentType(id, name);
		if (eTypeService.updateEType(eType)) {
			response.sendRedirect("equipmentTypeList");
		} else {
			request.setAttribute("msg", "更新设备种类失败");
			request.setAttribute("eType", eType);
			request.getRequestDispatcher("/jsp/system/etype/equipmentTypeupdate.jsp").forward(request, response);
		}
	}

	/**
	 * 删除设备种类
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void deleteType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("eTypeId");
		if (eTypeService.deleteEType(id)) {
			response.sendRedirect("equipmentTypeList");
		} else {
			request.setAttribute("msg", "更新设备种类失败");
			request.getRequestDispatcher("/jsp/system/etype/equipmentTypeList").forward(request, response);
		}
	}
}
