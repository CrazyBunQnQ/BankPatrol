package com.bank.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.GwymDao;
import com.bank.entity.Gwym;
import com.bank.util.DBUtil;

public class GwymDaoImpl extends BaseDaoImpl implements GwymDao {

	@Override
	public List<Gwym> queryGwyms(int jobId, int page, int count) {
		List<Gwym> list = new ArrayList<Gwym>();
		String sql = "SELECT xtymb.ymbh, xtymb.ymmc, functions.Func_Name FROM gwym, job, xtymb, functions WHERE job.Job_ID=? AND job.Job_ID=gwym.Job_ID AND xtymb.ymbh=gwym.ymbh AND functions.Func_ID=xtymb.Func_ID LIMIT ?, ?";
		try {
			setConnAndPS(sql);
			ps.setInt(1, jobId);
			ps.setInt(2, page);
			ps.setInt(3, count);
			LOGGER.info("查询指定岗位的权限：" + ps.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
				Gwym gwym = new Gwym();
				gwym.setJobId(jobId);
				gwym.setXtymbId(rs.getLong(1));
				gwym.setFunName(rs.getString(3));
				gwym.setXtymbName(rs.getString(2));
				list.add(gwym);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, rs, ps);
		}
		return list;
	}

	@Override
	public List<Gwym> queryGwyms(int jobId, int funId, int page, int count) {
		List<Gwym> list = new ArrayList<Gwym>();
		String sql = "SELECT xtymb.ymbh, xtymb.ymmc FROM gwym, job, xtymb, functions WHERE job.Job_ID=? AND functions.Func_ID=? AND job.Job_ID=gwym.Job_ID AND xtymb.ymbh=gwym.ymbh AND functions.Func_ID=xtymb.Func_ID ORDER BY xtymb.ymbh LIMIT ?, ?";
		try {
			setConnAndPS(sql);
			ps.setInt(1, jobId);
			ps.setInt(2, funId);
			ps.setInt(3, page);
			ps.setInt(4, count);
			LOGGER.info("查询指定岗位、指定模块的权限：" + ps.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
				Gwym gwym = new Gwym();
				gwym.setJobId(jobId);
				gwym.setFunId(funId);
				gwym.setXtymbId(rs.getLong(1));
				gwym.setXtymbName(rs.getString(2));
				list.add(gwym);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, rs, ps);
		}
		return list;
	}

	public List<Gwym> queryAllGwyms(int funId, int page, int count) {
		List<Gwym> list = new ArrayList<Gwym>();
		String sql = "SELECT ymbh, ymmc FROM xtymb WHERE Func_ID=? ORDER BY ymbh LIMIT ?, ?";
		try {
			setConnAndPS(sql);
			ps.setInt(1, funId);
			ps.setInt(2, page);
			ps.setInt(3, count);
			LOGGER.info("查询指定模块的权限：" + ps.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
				Gwym gwym = new Gwym();
				gwym.setFunId(funId);
				gwym.setXtymbId(rs.getLong(1));
				gwym.setXtymbName(rs.getString(2));
				list.add(gwym);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, rs, ps);
		}
		return list;
	}

	@Override
	public int insertGwyms(int jobId, int[] ymbh) {
		int result = 0;
		StringBuffer sql = new StringBuffer();
		int n = ymbh.length;
		for (int i = 0; i < n; i++) {
			sql.append("INSERT INTO gwym VALUES (?, ?);");
		}
		try {
			setConnAndPS(sql.toString());
			for (int i = 0; i < n; i++) {
				ps.setInt(2 * i + 1, jobId);
				ps.setInt(2 * (i + 1), ymbh[i]);
			}
			LOGGER.info("给岗位 " + jobId + " 添加 " + n + " 个功能：" + ps.toString());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, null, ps);
		}
		return result;
	}

	@Override
	public int deleteGwyms(int jobId, int[] ymbh) {
		int result = 0;
		StringBuffer sql = new StringBuffer();
		int n = ymbh.length;
		for (int i = 0; i < n; i++) {
			sql.append("DELETE FROM gwym WHERE Job_ID=? AND ymbh=?;");
		}
		try {
			setConnAndPS(sql.toString());
			for (int i = 0; i < n; i++) {
				ps.setInt(2 * i + 1, jobId);
				ps.setInt(2 * (i + 1), ymbh[i]);
			}
			LOGGER.info("给岗位 " + jobId + " 删除 " + n + " 个功能：" + ps.toString());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, null, ps);
		}
		return result;
	}
}