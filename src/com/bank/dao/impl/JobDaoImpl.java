package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bank.dao.JobDao;
import com.bank.entity.Job;
import com.bank.util.DBUtil;

public class JobDaoImpl implements JobDao {

	private static final Logger LOGGER = LogManager.getLogger(JobDaoImpl.class.getName());
	@Override
	public ResultSet queryJobs(Connection conn, int page, int count) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT Job_ID, Name, Description FROM job LIMIT ?, ?");
		ps.setInt(1, page);
		ps.setInt(2, count);
		LOGGER.info("查询岗位：" + ps.toString());
		return ps.executeQuery();
	}

	@Override
	public int insertJob(Connection conn, Job job) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("INSERT INTO job VALUES (?, ?, ?, ?)");
		ps.setInt(1, job.getId());
		ps.setInt(2, job.getGroupId());
		ps.setString(3, job.getName());
		ps.setString(4, job.getDescription());
		LOGGER.info("增加岗位：" + ps.toString());
		return DBUtil.closeStatement(ps);
	}

	@Override
	public int updateJob(Connection conn, Job job) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("UPDATE job SET Name=?, Description=? WHERE Job_ID=?");
		ps.setString(1, job.getName());
		ps.setString(2, job.getDescription());
		ps.setInt(3, job.getId());
		LOGGER.info("更新岗位 " + job.getId() + " ：" + ps.toString());
		return DBUtil.closeStatement(ps);
	}

}
