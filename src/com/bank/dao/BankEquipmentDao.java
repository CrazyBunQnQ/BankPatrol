package com.bank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bank.entity.BankEquipment;

public interface BankEquipmentDao {

	/**
	 * 查询某个银行中的所有设备
	 * @param conn
	 * @param bankID 银行 ID
	 * @return ResultSet 数据集
	 * @throws SQLException
	 */
	ResultSet queryBankEquipments(Connection conn, String bankID) throws SQLException;
	
	/**
	 * 添加银行设备信息
	 * @param conn
	 * @param bankEquipment
	 * @return int 影响行数
	 * @throws SQLException
	 */
	int insertBankEquipment(Connection conn, BankEquipment bankEquipment) throws SQLException;
	
	/**
	 * 更新银行设备信息
	 * @param conn
	 * @param bankEquipment 银行设备（不包含 id）
	 * @return int 影响行数
	 * @throws SQLException
	 */
	int updateBankEquipment(Connection conn, BankEquipment bankEquipment) throws SQLException;
	
	/**
	 * 按照设备流水 ID 删除设备信息
	 * @param conn
	 * @param eachID 流水 ID
	 * @return int 影响行数
	 * @throws SQLException
	 */
	int deleteBankEquipment(Connection conn, String eachID) throws SQLException;
}
