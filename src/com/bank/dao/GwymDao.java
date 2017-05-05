package com.bank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface GwymDao {

	/**
	 * 查询指定岗位的权限
	 * @param conn
	 * @param jobId 岗位 id
	 * @param page 当前页
	 * @param count 每页显示数量
	 * @return 数据集
	 * @throws SQLException
	 */
	ResultSet queryGwyms(Connection conn, int jobId, int page, int count) throws SQLException;
	
	
}
