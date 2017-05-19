package com.bank.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.JobDao;
import com.bank.entity.Job;
import com.bank.util.DBUtil;

public class JobDaoImpl extends BaseDaoImpl implements JobDao {

	@Override
	public int queryJobsCount() {
		int n = 0;
		String sql = "SELECT COUNT(Job_ID) FROM job";
		try {
			setConnAndPS(sql);
			LOGGER.info("查询岗位的数量");
			rs = ps.executeQuery();
			n = rs.next() ? rs.getInt(1) : 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, rs, ps);
		}
		return n;
	}
	
	@Override
	public List<Job> queryJobs(int page, int count) {
		List<Job> list = new ArrayList<Job>();
		String sql = "SELECT Job_ID, Name, Description FROM job LIMIT ?, ?";
		try {
			setConnAndPS(sql);
			ps.setInt(1, page);
			ps.setInt(2, count);
			LOGGER.info("查询岗位：" + ps.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Job(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, rs, ps);
		}
		return list;
	}

	@Override
	public int insertJob(Job job) {
		int n = 0;
		String sql = "INSERT INTO job VALUES (Job_ID, ?, ?)";
		try {
			setConnAndPS(sql);
			ps.setString(1, job.getName());
			ps.setString(2, job.getDescription());
			LOGGER.info("增加岗位：" + ps.toString());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, null, ps);
		}
		return n;
	}

	@Override
	public int updateJob(Job job) {
		int n = 0;
		String sql = "UPDATE job SET Name=?, Description=? WHERE Job_ID=?";
		try {
			setConnAndPS(sql);
			ps.setString(1, job.getName());
			ps.setString(2, job.getDescription());
			ps.setInt(3, job.getId());
			LOGGER.info("更新岗位 " + job.getId() + " ：" + ps.toString());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, null, ps);
		}
		return n;
	}

	@Override
	public int deleteJob(int jobId) {
		int n = 0;
		String sql = "DELETE FROM job WHERE Job_ID=?";
		try {
			setConnAndPS(sql);
			ps.setInt(1, jobId);
			LOGGER.info("删除岗位 " + jobId + " ：" + ps.toString());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, null, ps);
		}
		return n;
	}

	@Override
	public boolean hasJob(String name) {
		boolean result = true;
		String sql = "SELECT Name FROM job WHERE Name=?";
		try {
			setConnAndPS(sql);
			ps.setString(1, name);
			LOGGER.info("是否存在岗位 " + name + "：" + ps.toString());
			rs = ps.executeQuery();
			result = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, rs, ps);
		}
		return result;
	}

}
