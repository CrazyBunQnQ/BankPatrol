package com.bank.service;

import java.sql.SQLException;

import com.bank.entity.Bank;
import com.bank.entity.PageInfo;

public interface BankService {

	/**
	 * 获取银行列表信息的 JSON 字符串
	 * 
	 * @param page
	 *            当前页
	 * @return
	 * @throws SQLException
	 */
	PageInfo<Bank> getBanks(int page) throws SQLException;

	/**
	 * 添加银行
	 * @param bank
	 * @return 是否成功
	 */
	boolean insertBank(Bank bank);

	/**
	 * 检查指定银行 id 是否已存在
	 * @param id
	 * @return 1：已存在；0：不存在
	 */
	int checkBankId(String id);
}
