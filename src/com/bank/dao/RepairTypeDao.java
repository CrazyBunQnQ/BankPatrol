package com.bank.dao;

import java.util.List;

import com.bank.entity.RepairType;

/**
 * 设备问题报修接口
 * 
 * @author lenovo
 *
 */
public interface RepairTypeDao {

	/**
	 * 添加设备报修问题
	 * @param RepairType
	 * @return
	 */
	public boolean addRepairType(RepairType RepairType);
	
	/**
	 * 根据id删除设备报修问题
	 * @param id
	 * @return
	 */
	public boolean deleteRepairType(int id);
	
	/**
	 * 分页查询设备报修问题
	 * @param pageSize
	 * @param pageNum
	 * @param PITYPE_Value
	 * @return
	 */
	public List<RepairType> queryRepairType(int pageSize, int pageNum, String PITYPE_Value);
	
	/**
	 * 根据问题类型进行模糊搜索
	 * @param PITYPE_Value
	 * @return
	 */
	public RepairType queryRepairTypeByPITYPE_Value(String PITYPE_Value);
	
	/**
	 * 修改设备报修问题
	 * @param RepairType
	 * @return
	 */
	public boolean updateRepairType(RepairType RepairType);
	
}
