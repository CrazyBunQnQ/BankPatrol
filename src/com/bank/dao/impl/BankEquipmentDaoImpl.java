package com.bank.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bank.dao.BankEquipmentDao;
import com.bank.entity.BankEquipment;
import com.bank.util.DBUtil;

public class BankEquipmentDaoImpl implements BankEquipmentDao {
	private static final Logger LOGGER = LogManager.getLogger(BankEquipmentDaoImpl.class.getName());

	@Override
	public ResultSet queryBankEquipments(Connection conn, String bankID) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM bank_equipment WHERE Bank_id=?");
		ps.setString(1, bankID);
		LOGGER.info("查询银行 " + bankID + " 的设备：" + ps.toString());
		return ps.executeQuery();
	}

	@Override
	public int insertBankEquipment(Connection conn, BankEquipment bankEquipment) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("INSERT INTO bank_equipment VALUES (?, ?, ?, ?, ?, ?, ?)");
		ps.setString(1, bankEquipment.getEachID());
		ps.setString(2, bankEquipment.getType().getId());
		ps.setString(3, bankEquipment.getBank().getId());
		ps.setDouble(4, bankEquipment.getValue());
		ps.setDate(5, new Date(bankEquipment.getBuyDate().getTime()));
		ps.setInt(6, bankEquipment.getStatus());
		ps.setDouble(7, bankEquipment.getDepreciationValue());
		LOGGER.info("添加银行设备：" + ps.toString());
		return DBUtil.closeStatement(ps);
	}

	@Override
	public int updateBankEquipment(Connection conn, BankEquipment BankEquipment) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("UPDATE bank_equipment SET"
				+ " Equipment_id=?,"
				+ " Bank_id=?,"
				+ " Equipment_Value=?,"
				+ " Equipment_BuyDate=?,"
				+ " Status=?,"
				+ "	Depreciation_Value=?"
				+ " WHERE EquipmentEach_ID=?");
		ps.setString(1, BankEquipment.getType().getId());
		ps.setString(2, BankEquipment.getBank().getId());
		ps.setDouble(3, BankEquipment.getValue());
		ps.setDate(4, new Date(BankEquipment.getBuyDate().getTime()));
		ps.setInt(5, BankEquipment.getStatus());
		ps.setDouble(6, BankEquipment.getDepreciationValue());
		ps.setString(7, BankEquipment.getEachID());
		LOGGER.info("更新银行设备 " + BankEquipment.getEachID() + "：" + ps.toString());
		return DBUtil.closeStatement(ps);
	}

	@Override
	public int deleteBankEquipment(Connection conn, String eachID) throws SQLException {
		PreparedStatement ps = conn.prepareStatement("DELETE FROM bank_equipment WHERE EquipmentEach_ID=?");
		ps.setString(1, eachID);
		LOGGER.info("删除银行设备 " + eachID + "：" + ps.toString());
		return DBUtil.closeStatement(ps);
	}
}
