package com.bank.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.BankDao;
import com.bank.entity.Bank;
import com.bank.util.DBUtil;

public class BankDaoImpl extends BaseDaoImpl implements BankDao {

	@Override
	public int queryBankesCount() {
		int n = 0;
		String sql = "SELECT COUNT(Bank_id) FROM bank";
		try {
			setConnAndPS(sql);
			LOGGER.info("查询银行数量：" + ps.toString());
			rs = ps.executeQuery();
			if (rs.next()) {
				n = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, rs, ps);
		}
		return n;
	}
	
	@Override
	public List<Bank> queryBanks(int page, int count) {
		List<Bank> list = new ArrayList<Bank>();
		String sql = "SELECT * FROM bank LIMIT ?, ?";
		try {
			setConnAndPS(sql);
			ps.setInt(1, page);
			ps.setInt(2, count);
			LOGGER.info("查询银行：" + ps.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Bank(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, rs, ps);
		}
		return list;
	}

	@Override
	public int insertBank(Bank bank) {
		int n = 0;
		String sql = "INSERT INTO bank VALUES(?, ?, ?, ?, ?)";
		try {
			setConnAndPS(sql);
			ps.setString(1, bank.getId());
			ps.setString(2, bank.getName());
			ps.setDouble(3, bank.getLongitude());
			ps.setDouble(4, bank.getLatitude());
			ps.setString(5, bank.getIp());
			LOGGER.info("添加银行信息：" + ps.toString());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, null, ps);
		}
		return n;
	}

	@Override
	public int updateBank(Bank bank) {
		int n = 0;
		String sql = "UPDATE bank SET Bank_Name=?, Bank_Longitude=?, Bank_Latitude=?, Bank_IP=? WHERE Bank_id=?";
		try {
			setConnAndPS(sql);
			ps.setString(1, bank.getName());
			ps.setDouble(2, bank.getLongitude());
			ps.setDouble(3, bank.getLatitude());
			ps.setString(4, bank.getIp());
			ps.setString(5, bank.getId());
			LOGGER.info("更新银行信息：" + ps.toString());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, null, ps);
		}
		return n;
	}

	@Override
	public boolean hasBank(String id) {
		boolean result = true;
		String sql = "SELECT Bank_id FROM bank WHERE Bank_id=?";
		try {
			setConnAndPS(sql);
			ps.setString(1, id);
			LOGGER.info("查询银行是否存在：" + ps.toString());
			rs = ps.executeQuery();
			result = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, rs, ps);
		}
		return result;
	}

	@Override
	public Bank queryBank(String id) {
		Bank bank = null;
		String sql = "SELECT Bank_Name, Bank_Longitude, Bank_Latitude, Bank_IP FROM bank WHERE Bank_id=?";
		try {
			setConnAndPS(sql);
			ps.setString(1, id);
			LOGGER.info("查询指定银行信息：" + ps.toString());
			rs = ps.executeQuery();
			bank = rs.next() ? new Bank(id, rs.getString(1), rs.getDouble(2), rs.getDouble(3), rs.getString(4)) : null;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, rs, ps);
		}
		return bank;
	}
}
