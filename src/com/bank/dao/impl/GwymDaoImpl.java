package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bank.dao.GwymDao;

public class GwymDaoImpl implements GwymDao {

	private static final Logger LOGGER = LogManager.getLogger(GwymDaoImpl.class.getName());
	
	@Override
	public ResultSet queryGwyms(Connection conn,int jobId, int page, int count) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT job.Job_ID, xtymb.ymbh FROM gwym, job, xtymb WHERE job.Job_ID=? AND job.Job_ID=gwym.Job_ID AND xtymb.ymbh=gwym.ymbh LIMIT ?, ?");
		ps.setInt(1, jobId);
		ps.setInt(2, page);
		ps.setInt(3, count);
		LOGGER.info("查询指定岗位的权限：" + ps.toString());
		return ps.executeQuery();
	}

}
