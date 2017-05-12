package com.bank.dao;

import java.util.List;

import com.bank.entity.EquipmentType;

public interface EquipmentTypeDao {

	/**
	 * 查询所有的设备种类
	 * @return
	 */
	List<EquipmentType> queryTyps();

}
