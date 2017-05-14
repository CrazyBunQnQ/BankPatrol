package com.bank.service.impl;

import java.util.List;

import com.bank.dao.impl.EquipmentTypeDaoImpl;
import com.bank.entity.EquipmentType;
import com.bank.entity.PageInfo;
import com.bank.service.EquipmentTypeService;

public class EquipmentTypeServiceImpl implements EquipmentTypeService {
	EquipmentTypeDaoImpl etdi = new EquipmentTypeDaoImpl();

	@Override
	public PageInfo<EquipmentType> getEtypes(int page) {
		return getEtypes(page, "", "");
	}
	
	@Override
	public PageInfo<EquipmentType> getEtypes(int page, String eTypeName, String eTypeId) {
		PageInfo<EquipmentType> data = new PageInfo<EquipmentType>();
		data.setCurPage(page);
		List<EquipmentType> list = etdi.queryTypes(data.getFrom(), data.getPageSize(), eTypeId, eTypeName);
		int count = etdi.queryEquipmentsCount(eTypeId, eTypeName);
		data.setPagedata(list);
		data.setTotalRecord(count);
		return data;
	}

	@Override
	public int checkEquipmentId(String typeId) {
		return etdi.hasType(typeId) ? 1 : 0;
	}

	@Override
	public int checkEquipmentName(String typeName) {
		return etdi.hasTypeName(typeName) ? 1 : 0;
	}

	public boolean insertEType(EquipmentType eType) {
		return etdi.insertEquipmentType(eType) > 0;
	}
}
