package com.bank.dao.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.BankEquipmentDao;
import com.bank.entity.Bank;
import com.bank.entity.BankEquipment;
import com.bank.entity.EquipmentType;
import com.bank.util.DBUtil;

public class BankEquipmentDaoImpl extends BaseDaoImpl implements BankEquipmentDao {
	
	@Override
	public int queryBankEquipmentsCount(String bankID) {
		int n = 0;
		String sql = "SELECT COUNT(*) FROM bankequipment";
		try {
			setConnAndPS(sql);
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, null, ps);
		}
		return n;
	}

	@Override
	public List<BankEquipment> queryBankEquipments(String bankID, int page, int count) {
		List<BankEquipment> list = new ArrayList<BankEquipment>();
		String sql = "SELECT * FROM bankequipment WHERE Bank_id=? LIMIT ?, ?";
		try {
			setConnAndPS(sql);
			ps.setString(1, bankID);
			ps.setInt(2, page);
			ps.setInt(3, count);
			LOGGER.info("查询银行 " + bankID + " 的设备：" + ps.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new BankEquipment(
						rs.getString(1), 
						new EquipmentType(rs.getString(2), ""), 
						new Bank(rs.getString(3), "", 0, 0, ""), 
						rs.getDouble(4), 
						rs.getDate(5), 
						rs.getInt(6), 
						rs.getDouble(7))
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, rs, ps);
		}
		return list;
	}

	@Override
	public int insertBankEquipment(BankEquipment bankEquipment) {
		int n = 0;
		String sql = "INSERT INTO bankequipment VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			setConnAndPS(sql);
			ps.setString(1, bankEquipment.getEachID());
			ps.setString(2, bankEquipment.getType().getId());
			ps.setString(3, bankEquipment.getBank().getId());
			ps.setDouble(4, bankEquipment.getValue());
			ps.setDate(5, new Date(bankEquipment.getBuyDate().getTime()));
			ps.setInt(6, bankEquipment.getStatus());
			ps.setDouble(7, bankEquipment.getDepreciationValue());
			LOGGER.info("添加银行设备：" + ps.toString());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, null, ps);
		}
		return n;
	}

	@Override
	public int updateBankEquipment(BankEquipment BankEquipment) {
		int n = 0;
		String sql = "UPDATE bankequipment SET"
				+ " Equipment_id=?,"
				+ " Bank_id=?,"
				+ " Equipment_Value=?,"
				+ " Equipment_BuyDate=?,"
				+ " Status=?,"
				+ "	Depreciation_Value=?"
				+ " WHERE EquipmentEach_ID=?";
		try {
			setConnAndPS(sql);
			ps.setString(1, BankEquipment.getType().getId());
			ps.setString(2, BankEquipment.getBank().getId());
			ps.setDouble(3, BankEquipment.getValue());
			ps.setDate(4, new Date(BankEquipment.getBuyDate().getTime()));
			ps.setInt(5, BankEquipment.getStatus());
			ps.setDouble(6, BankEquipment.getDepreciationValue());
			ps.setString(7, BankEquipment.getEachID());
			LOGGER.info("更新银行设备 " + BankEquipment.getEachID() + "：" + ps.toString());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, null, ps);
		}
		return n;
	}

	@Override
	public int deleteBankEquipment(String eachID) {
		int n = 0;
		String sql = "DELETE FROM bankequipment WHERE EquipmentEach_ID=?";
		try {
			setConnAndPS(sql);
			ps.setString(1, eachID);
			LOGGER.info("删除银行设备 " + eachID + "：" + ps.toString());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, null, ps);
		}
		return n;
	}
}
