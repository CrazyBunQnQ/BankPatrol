package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bank.dao.FunctionDao;

public class FunctionDaoImpl implements FunctionDao {

	private static final Logger LOGGER = LogManager.getLogger(FunctionDaoImpl.class.getName());
	
	@Override
	public ResultSet queryFunctions(Connection conn) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM functions");
		LOGGER.info("查询所有功能：" + ps.toString());
		return ps.executeQuery();
	}
}
