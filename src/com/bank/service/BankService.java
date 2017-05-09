package com.bank.service;

import java.sql.SQLException;

public interface BankService {

	/**
	 * 获取银行列表信息的 JSON 字符串
	 * 
	 * @param page
	 *            当前页
	 * @param count
	 *            每页显示的数量
	 * @return JSON 字符串
	 * @throws SQLException
	 */
	String getBanks(int page, int count) throws SQLException;
}
