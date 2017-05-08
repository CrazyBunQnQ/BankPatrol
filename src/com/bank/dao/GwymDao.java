package com.bank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface GwymDao {

	/**
	 * 查询指定岗位的可操作页面编号、可操作页面和可操作模块
	 * @param conn
	 * @param jobId 岗位 id
	 * @param page 当前页
	 * @param count 每页显示数量
	 * @return 数据集
	 * @throws SQLException
	 */
	ResultSet queryGwyms(Connection conn, int jobId, int page, int count) throws SQLException;
	
	/**
	 * 查询指定岗位、指定操作模块的可操作页面编号和名称
	 * @param conn
	 * @param jobId 岗位 id
	 * @param funId 模块 id
	 * @param page 当前页
	 * @param count 每页显示数量
	 * @return
	 * @throws SQLException
	 */
	ResultSet queryGwyms(Connection conn, int jobId, int funId, int page, int count) throws SQLException;
	
	/**
	 * 按照指定操作模块查询该模块所有的操作页面编号和名称
	 * @param conn
	 * @param funId 模块 id
	 * @param page 当前页
	 * @param count 每页显示数量
	 * @return
	 * @throws SQLException
	 */
	ResultSet queryAllGwyms(Connection conn, int funId, int page, int count) throws SQLException;
	
	/**
	 * 给指定岗位添加指定的子功能
	 * @param conn
	 * @param jobId 岗位 id
	 * @param ymbh 子功能 id
	 * @return int 影响行数
	 * @throws SQLException
	 */
	@Deprecated
	int insertGwym(Connection conn, int jobId, int ymbh) throws SQLException;
	
	/**
	 * 给指定岗位添加指定的子功能数组
	 * @param conn
	 * @param jobId 岗位 id
	 * @param ymbh 子功能 id 数组
	 * @return int 影响行数
	 * @throws SQLException
	 */
	int insertGwyms(Connection conn, int jobId, int[] ymbh) throws SQLException;
	
	/**
	 * 删除指定岗位的某些子功能
	 * @param conn
	 * @param jobId 岗位 id
	 * @param ymbh 子功能 id 数组
	 * @return
	 * @throws SQLException
	 */
	int deleteGwyms(Connection conn, int jobId, int[] ymbh) throws SQLException;
}
