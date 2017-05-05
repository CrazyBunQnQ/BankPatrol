package com.bank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bank.entity.Job;

public interface JobDao {

	/**
	 * 查询岗位
	 * @param conn
	 * @param page 当前页（第一页为0）
	 * @param count 每页显示数量
	 * @return 数据集
	 * @throws SQLException
	 */
	ResultSet queryJobs(Connection conn, int page, int count) throws SQLException;
	
	/**
	 * 增加岗位
	 * @param conn
	 * @param job
	 * @return int 影响行数
	 * @throws SQLException
	 */
	int insertJob(Connection conn, Job job) throws SQLException;
	
	/**
	 * 更新岗位（不更新 id 和 group）
	 * @param conn
	 * @param job
	 * @return int 影响行数
	 * @throws SQLException
	 */
	int updateJob(Connection conn, Job job) throws SQLException;
}
