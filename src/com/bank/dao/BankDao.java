package com.bank.dao;

import java.util.List;

import com.bank.entity.Bank;

public interface BankDao {
	
	/**
	 * 查询所有银行网点的数量
	 * @return
	 */
	int queryBankesCount();

	/**
	 * 查询所有银行
	 * @param page 第几页
	 * @param count 每页显示数量
	 * @return List
	 */
	List<Bank> queryBanks(int page, int count);
	
	/**
	 * 添加银行网点
	 * @param bank
	 * @return int 影响行数
	 */
	int insertBank(Bank bank);
	
	/**
	 * 更新银行信息
	 * @param bank 新的银行信息（不包含 id）
	 * @return int 影响行数
	 */
	int updateBank(Bank bank);

	/**
	 * 查询指定银行 id 是否已存在
	 * @param id
	 * @return
	 */
	boolean hasBank(String id);
}
