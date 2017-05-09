package com.bank.dao;

import java.util.List;

import com.bank.entity.BankEquipment;

public interface BankEquipmentDao {
	
	/**
	 * 查询某个银行中的所有设备数量
	 * @param bankID 银行 ID
	 * @return
	 */
	int queryBankEquipmentsCount(String bankID);

	/**
	 * 查询某个银行中的所有设备
	 * @param bankID 银行 ID
	 * @param page 当前页数（第一页为0）
	 * @param count 每页显示数量
	 * @return List
	 */
	List<BankEquipment> queryBankEquipments(String bankID, int page, int count);
	
	/**
	 * 添加银行设备信息
	 * @param bankEquipment
	 * @return int 影响行数
	 */
	int insertBankEquipment(BankEquipment bankEquipment);
	
	/**
	 * 更新银行设备信息
	 * @param bankEquipment 银行设备（不包含 id）
	 * @return int 影响行数
	 */
	int updateBankEquipment(BankEquipment bankEquipment);
	
	/**
	 * 按照设备流水 ID 删除设备信息
	 * @param eachID 流水 ID
	 * @return int 影响行数
	 */
	int deleteBankEquipment(String eachID);
}
