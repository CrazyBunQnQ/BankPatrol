package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bank.util.DBUtil;

public class BaseDaoImpl {
	
	protected static final Logger LOGGER = LogManager.getLogger(BaseDaoImpl.class.getName());
	protected Connection conn = null; 
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;
	
	protected void setConnAndPS(String sql) throws SQLException {
		conn = DBUtil.getConnection();
		ps = conn.prepareStatement(sql);
	}
}
