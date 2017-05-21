package com.bank.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.bank.entity.EquipmentType;
import com.bank.entity.PageInfo;
import com.bank.service.EquipmentTypeService;
import com.bank.service.impl.EquipmentTypeServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class EquipmentTypeAction extends ActionSupport {
	private static final long serialVersionUID = 1545011556429507177L;

	private EquipmentTypeService eTypeService = new EquipmentTypeServiceImpl();
	
	private Integer page;
	private String hiddenFind;
	private EquipmentType eType;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getHiddenFind() {
		return hiddenFind;
	}

	public void setHiddenFind(String hiddenFind) {
		this.hiddenFind = hiddenFind;
	}

	public EquipmentType geteType() {
		return eType;
	}

	public void seteType(EquipmentType eType) {
		this.eType = eType;
	}

	public String list() {
		
		PageInfo<EquipmentType> data = eTypeService.getEtypes(page, eType.getName(), eType.getId());
		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.setAttribute("hiddenFind", hiddenFind);
		request.setAttribute("data", data);
		request.setAttribute("eType", eType);
		
		return "SUCCESS";
	}
}
