package com.bank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface FunctionDao {

	/**
	 * 查询功能列表
	 * @param conn
	 * @return 数据集
	 * @throws SQLException
	 */
	ResultSet queryFunctions(Connection conn) throws SQLException;
}
