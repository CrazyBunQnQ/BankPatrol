package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bank.dao.BankDao;
import com.bank.entity.Bank;
import com.bank.util.DBUtil;

public class BankDaoImpl implements BankDao {
	private static final Logger LOGGER = LogManager.getLogger(BankDaoImpl.class.getName());

	@Override
	public ResultSet queryBanks(Connection conn, int page, int count) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM bank LIMIT ?, ?");
		ps.setInt(1, page);
		ps.setInt(2, count);
		LOGGER.info("查询银行：" + ps.toString());
		return ps.executeQuery();
	}

	@Override
	public int insertBank(Connection conn, Bank bank) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("INSERT INTO bank VALUES(?, ?, ?, ?, ?)");
		ps.setString(1, bank.getId());
		ps.setString(2, bank.getName());
		ps.setDouble(3, bank.getLongitude());
		ps.setDouble(4, bank.getLatitude());
		ps.setString(5, bank.getIp());
		LOGGER.info("添加银行信息：" + ps.toString());
		return DBUtil.closeStatement(ps);
	}

	@Override
	public int updateBank(Connection conn, Bank bank) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("UPDATE bank SET Bank_Name=?, Bank_Longitude=?, Bank_Latitude=?, Bank_IP=? WHERE Bank_id=?");
		ps.setString(1, bank.getName());
		ps.setDouble(2, bank.getLongitude());
		ps.setDouble(3, bank.getLatitude());
		ps.setString(4, bank.getIp());
		ps.setString(5, bank.getId());
		LOGGER.info("添加银行信息：" + ps.toString());
		return DBUtil.closeStatement(ps);
	}
}
