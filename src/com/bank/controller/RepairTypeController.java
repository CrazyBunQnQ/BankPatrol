package com.bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.entity.PageInfo;
import com.bank.entity.RepairType;
import com.bank.service.RepairTypeServiceDao;
import com.bank.service.impl.RepairTypeServiceDaoImpl;

public class RepairTypeController {

	RepairTypeServiceDao rts = new RepairTypeServiceDaoImpl();
	
	public void faultRepairType(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		int page = Integer.parseInt(request.getParameter("curpage") == null ? "1" : request.getParameter("curpage"));
		String name = request.getParameter("searchPITYPE_Value");
		request.setAttribute("searchPITYPE_Value", name);
		PageInfo<RepairType> data = rts.queryRepairType(page, (String)request.getAttribute("searchPITYPE_Value"));
		request.setAttribute("data", data);
		request.getRequestDispatcher("/jsp/system/frt/faultRepairType.jsp").forward(request, response);
	}
	
	public void queryRepairTypeByPiTypeValue(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	public void toRepairTypeAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/system/dept/faultRepairTypenew.jsp").forward(request, response);
	}

	public void checkRepairTypeName(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		String repairType = request.getParameter("name");
		if(rts.hasType(repairType)){
			response.getWriter().write("0");
		}else{
			response.getWriter().write("1");
		};
	}

	public void repairTypeAdd(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		String name = request.getParameter("PITYPE_Value");
		RepairType rt = new RepairType();
		if(rts.addRepairType(new RepairType(rt.getId(), name))){
			response.sendRedirect("/Bank/frt/faultRepairType");
		}
	}

	public void repairTypeDelete(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		int repairTypeId = Integer.parseInt(request.getParameter("Pitype_ID"));
		if(rts.deleteRepairType(repairTypeId)){
			response.sendRedirect("/Bank/frt/faultRepairType");
		}
	}

	public void repairType2Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("Pitype_ID"));
		RepairType repairType = rts.repairType2Update(id);
		request.setAttribute("repairType", repairType);
		request.getRequestDispatcher("/jsp/system/frt/faultRepairTypeupdate.jsp").forward(request, response);	
	}

	public void repairTypeUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("Pitype_ID"));
		String name = request.getParameter("PITYPE_Value");
		RepairType repairType = new RepairType();
		repairType.setId(id);
		repairType.setValue(name);
		if(rts.updateRepairType(new RepairType())){
			response.sendRedirect("/Bank/frt/faultRepairType");
		}
	}
}
