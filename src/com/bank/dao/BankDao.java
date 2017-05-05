package com.bank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bank.entity.Bank;

public interface BankDao {

	/**
	 * 查询所有银行
	 * @param conn
	 * @param page 第几页
	 * @param count 每页显示数量
	 * @return ResultSet 数据集
	 * @throws SQLException
	 */
	ResultSet queryBanks(Connection conn, int page, int count) throws SQLException;
	
	/**
	 * 添加银行网点
	 * @param conn
	 * @param bank
	 * @return int 影响行数
	 * @throws SQLException
	 */
	int insertBank(Connection conn, Bank bank) throws SQLException;
	
	/**
	 * 更新银行信息
	 * @param conn
	 * @param bank 新的银行信息（不包含 id）
	 * @return int 影响行数
	 * @throws SQLException
	 */
	int updateBank(Connection conn, Bank bank) throws SQLException;
	
	
}
