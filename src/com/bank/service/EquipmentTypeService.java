package com.bank.service;

import com.bank.entity.EquipmentType;
import com.bank.entity.PageInfo;

public interface EquipmentTypeService {

	/**
	 * 获取指定页的设备种类信息并获取分页信息
	 * @param page
	 * @return
	 */
	PageInfo<EquipmentType> getEtypes(int page);

	/**
	 * 模糊查询指定页的设备种类信息和分页信息
	 * @param page
	 * @param eTypeName
	 * @return
	 */
	PageInfo<EquipmentType> getEtypes(int page, String eTypeName);

}
