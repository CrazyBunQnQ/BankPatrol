package com.bank.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.FunctionDao;
import com.bank.entity.Function;
import com.bank.util.DBUtil;

public class FunctionDaoImpl extends BaseDaoImpl implements FunctionDao {

	@Override
	public List<Function> queryFunctions() {
		List<Function> list = new ArrayList<Function>();
		String sql = "SELECT * FROM functions";
		try {
			setConnAndPS(sql);
			LOGGER.info("查询所有功能：" + ps.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Function(rs.getInt(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, rs, ps);
		}
		return list;
	}
}
