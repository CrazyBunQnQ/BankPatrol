package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bank.dao.GwymDao;
import com.bank.util.DBUtil;

public class GwymDaoImpl implements GwymDao {

	private static final Logger LOGGER = LogManager.getLogger(GwymDaoImpl.class.getName());
	
	@Override
	public ResultSet queryGwyms(Connection conn,int jobId, int page, int count) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT xtymb.ymbh, xtymb.ymmc, functions.Func_Name FROM gwym, job, xtymb, functions WHERE job.Job_ID=? AND job.Job_ID=gwym.Job_ID AND xtymb.ymbh=gwym.ymbh AND functions.Func_ID=xtymb.Func_ID LIMIT ?, ?");
		ps.setInt(1, jobId);
		ps.setInt(2, page);
		ps.setInt(3, count);
		LOGGER.info("查询指定岗位的权限：" + ps.toString());
		return ps.executeQuery();
	}

	@Override
	public ResultSet queryGwyms(Connection conn, int jobId, int funId, int page, int count) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT xtymb.ymbh, xtymb.ymmc FROM gwym, job, xtymb, functions WHERE job.Job_ID=? AND functions.Func_ID=? AND job.Job_ID=gwym.Job_ID AND xtymb.ymbh=gwym.ymbh AND functions.Func_ID=xtymb.Func_ID ORDER BY xtymb.ymbh LIMIT ?, ?");
		ps.setInt(1, jobId);
		ps.setInt(2, funId);
		ps.setInt(3, page);
		ps.setInt(4, count);
		LOGGER.info("查询指定岗位、指定模块的权限：" + ps.toString());
		return ps.executeQuery();
	}
	
	public ResultSet queryAllGwyms(Connection conn, int funId, int page, int count) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT ymbh, ymmc FROM xtymb WHERE Func_ID=? ORDER BY ymbh LIMIT ?, ?");
		ps.setInt(1, funId);
		ps.setInt(2, page);
		ps.setInt(3, count);
		LOGGER.info("查询指定模块的权限：" + ps.toString());
		return ps.executeQuery();
	}

	@Override
	@Deprecated
	public int insertGwym(Connection conn, int jobId, int ymbh) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("INSERT INTO gwym VALUES (?, ?)");
		ps.setInt(1, jobId);
		ps.setInt(2, ymbh);
		LOGGER.info("给岗位 " + jobId + " 添加 " + ymbh + " 功能：" + ps.toString());
		return DBUtil.closeStatement(ps);
	}

	@Override
	public int insertGwyms(Connection conn, int jobId, int[] ymbh) throws SQLException {
		// TODO 将 sql 变成参数传进来
		StringBuffer sql = new StringBuffer();
		int n = ymbh.length;
		for (int i = 0; i < n; i++) {
			sql.append("INSERT INTO gwym VALUES (?, ?);");
		}
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		for (int i = 0; i < n; i++) {
			ps.setInt(2 * i + 1, jobId);
			ps.setInt(2 * (i + 1), ymbh[i]);
		}
		LOGGER.info("给岗位 " + jobId + " 添加 " + n + " 个功能：" + ps.toString());
		return DBUtil.closeStatement(ps);
	}

	@Override
	public int deleteGwyms(Connection conn, int jobId, int[] ymbh) throws SQLException {
		// TODO 将 sql 变成参数传进来
		StringBuffer sql = new StringBuffer();
		int n = ymbh.length;
		for (int i = 0; i < n; i++) {
			sql.append("DELETE FROM gwym WHERE Job_ID=? AND ymbh=?;");
		}
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		for (int i = 0; i < n; i++) {
			ps.setInt(2 * i + 1, jobId);
			ps.setInt(2 * (i + 1), ymbh[i]);
		}
		LOGGER.info("给岗位 " + jobId + " 删除 " + n + " 个功能：" + ps.toString());
		return DBUtil.closeStatement(ps);
	}
}
