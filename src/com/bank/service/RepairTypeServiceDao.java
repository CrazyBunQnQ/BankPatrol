package com.bank.service;

import com.bank.entity.PageInfo;
import com.bank.entity.RepairType;

public interface RepairTypeServiceDao {

	/**
	 * 分页查询设备报修问题
	 * @param pageNum
	 * @param condition
	 * @return
	 */
	public PageInfo<RepairType> queryRepairType(int pageNum,String PITYPE_Value);
	
	/**
	 * 根据设备类型模糊查询
	 * @param pageNum
	 * @param condition
	 * @return
	 */
	public PageInfo<RepairType> queryRepairTypeByPiType_Value(int pageNum, String PITYPE_Value);
	
	/**
	 * 添加设备报修问题
	 * @param RepairType
	 * @return
	 */
	public boolean addRepairType(RepairType repairType);
	
	/**
	 * 删除设备报修问题
	 * @param id
	 * @return
	 */
	public boolean deleteRepairType(int id);
	
	/**
	 * 更新设备报修问题
	 * @param piWorker
	 * @return
	 */
	public boolean updateRepairType(RepairType repairType);
	
	/**
	 * 根据id查询报修类型
	 * @param id
	 * @return
	 */
	public RepairType repairType2Update(int id);
	
	/**
	 * 添加时确认是否有该问题
	 * @param id
	 * @return
	 */
	public boolean hasType(String PITYPE_Value);
	
}
