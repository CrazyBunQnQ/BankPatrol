package com.bank.dao;

import java.util.List;

import com.bank.entity.EquipmentType;

/**
 * 银行设备种类接口
 * 
 * @author lenovo
 *
 */
public interface EquipmentTypeDao {

	/**
	 * 添加银行设备种类
	 * @param et
	 * @return
	 */
	public boolean addEquipmentType(EquipmentType EquipmentType);
	
	/**
	 * 根据id删除银行设备种类
	 * @param id
	 * @return
	 */
	public boolean deleteEquipmentType(int id);
	
	/**
	 * 分页查询银行设备种类
	 * @param page 当前页
	 * @param count 每页显示的数量
	 * @param eName
	 * @return
	 */
	public List<EquipmentType> queryEquipmentTypes(int page, int count, String eName);
	
	/**
	 * 修改银行设备种类
	 * @param et
	 * @return
	 */
	public boolean updateEquipmentType(EquipmentType EquipmentType);
	

	/**
	 * 查询所有的设备种类
	 * @return
	 */
	List<EquipmentType> queryTyps();

	/**
	 * 查询所有设备种类的数量
	 * @return
	 */
	int queryEquipmentsCount();
}
