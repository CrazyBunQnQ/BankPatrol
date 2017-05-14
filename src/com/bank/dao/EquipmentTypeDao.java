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
	 * @return 影响行数
	 */
	public int insertEquipmentType(EquipmentType EquipmentType);
	
	/**
	 * 根据id删除银行设备种类
	 * @param id 设备种类 id
	 * @return 影响行数
	 */
	public int deleteEquipmentType(String id);
	
	/**
	 * 查询所有设备种类的数量（支持模糊查询）
	 * @return
	 */
	int queryEquipmentsCount(String eTypeId, String eTypeName);
	
	/**
	 * 分页查询银行设备种类（可模糊查询）
	 * @param page 当前页
	 * @param count 每页显示的数量
	 * @param eTypeId 种类 id 模糊查询
	 * @param eTypeName 种类名称模糊查询
	 * @return
	 */
	public List<EquipmentType> queryTypes(int page, int count, String eTypeId, String eTypeName);
	
	/**
	 * 修改银行设备种类
	 * @param et
	 * @return 影响行数
	 */
	public int updateEquipmentType(EquipmentType EquipmentType);
	

	/**
	 * 查询所有的设备种类
	 * @return
	 */
	List<EquipmentType> queryTyps();

	/**
	 * 查询是否存在指定设备种类 id 的种类
	 * @param typeId 设备种类 id
	 * @return
	 */
	boolean hasType(String typeId);

	/**
	 * 查询是否存在某种类型的设备
	 * @param typeName 种类名称
	 * @return
	 */
	boolean hasTypeName(String typeName);
}
