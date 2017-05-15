package com.bank.dao.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.BankEquipmentDao;
import com.bank.entity.BankEquipment;
import com.bank.entity.EquipmentType;
import com.bank.util.DBUtil;

public class BankEquipmentDaoImpl extends BaseDaoImpl implements BankEquipmentDao {

	@Override
	public int queryEquipmentsCount(String bankID) {
		int n = 0;
		String sql = "SELECT COUNT(EquipmentEach_ID) FROM bankequipment WHERE Bank_id=?";
		try {
			setConnAndPS(sql);
			ps.setString(1, bankID);
			LOGGER.info("查询银行 " + bankID + " 的设备数量：" + ps.toString());
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
	public List<BankEquipment> queryBankEquipments(String bankID, int page, int count) {
		List<BankEquipment> list = new ArrayList<BankEquipment>();
		String sql = "SELECT EquipmentEach_ID, Equipment_id, Equipment_Value, Equipment_BuyDate, Status, Depreciation_Value FROM bankequipment WHERE Bank_id=? LIMIT ?, ?";
		try {
			setConnAndPS(sql);
			ps.setString(1, bankID);
			ps.setInt(2, page);
			ps.setInt(3, count);
			LOGGER.info("查询银行 " + bankID + " 的设备：" + ps.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
				BankEquipment be = new BankEquipment();
				be.setEachID(rs.getString(1));
				be.setTypeId(rs.getString(2));
				be.setBankId(bankID);
				be.setValue(rs.getDouble(3));
				be.setBuyDate(rs.getDate(4));
				be.setStatus(rs.getInt(5));
				be.setDepreciationValue(rs.getDouble(6));
				list.add(be);
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
		String sql = "UPDATE bankequipment SET" + " Equipment_id=?," + " Equipment_Value=?," + " Equipment_BuyDate=?," + " Status=?," + "	Depreciation_Value=?" + " WHERE EquipmentEach_ID=? AND Bank_id=?";
		try {
			setConnAndPS(sql);
			ps.setString(1, BankEquipment.getType().getId());
			ps.setDouble(2, BankEquipment.getValue());
			ps.setDate(3, new Date(BankEquipment.getBuyDate().getTime()));
			ps.setInt(4, BankEquipment.getStatus());
			ps.setDouble(5, BankEquipment.getDepreciationValue());
			ps.setString(6, BankEquipment.getEachID());
			ps.setString(7, BankEquipment.getBank().getId());
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

	@Override
	public boolean hasEquipmentId(String id) {
		boolean result = true;
		String sql = "SELECT EquipmentEach_ID FROM bankequipment WHERE EquipmentEach_ID=?";
		try {
			setConnAndPS(sql);
			ps.setString(1, id);
			LOGGER.info("查询银行设备 " + id + "是否存在：" + ps.toString());
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
	public int insertBank(BankEquipment be) {
		int n = 0;
		String sql = "INSERT INTO bankequipment VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			setConnAndPS(sql);
			ps.setString(1, be.getEachID());
			ps.setString(2, be.getTypeId());
			ps.setString(3, be.getBankId());
			ps.setDouble(4, be.getValue());
			ps.setDate(5, new Date(be.getBuyDate().getTime()));
			ps.setInt(6, be.getStatus());
			ps.setDouble(7, be.getDepreciationValue());
			LOGGER.info("在 " + be.getBankName() + " 下添加设备：" + ps.toString());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, null, ps);
		}
		return n;
	}

	@Override
	public BankEquipment queryBankEquipment(String eqId) {
		BankEquipment be = new BankEquipment();
		String sql = "SELECT bankequipment.EquipmentEach_ID, bankequipment.Equipment_id, equipmenttype.Equipment_Name, bankequipment.Bank_id, bank.Bank_Name, bankequipment.Equipment_Value, bankequipment.Equipment_BuyDate, bankequipment.Status, bankequipment.Depreciation_Value FROM bankequipment, equipmenttype, bank WHERE equipmenttype.Equipment_id=bankequipment.Equipment_id AND bank.Bank_id=bankequipment.Bank_id AND bankequipment.EquipmentEach_ID=?";
		try {
			setConnAndPS(sql);
			ps.setString(1, eqId);
			LOGGER.info("获取流水 id 为 " + eqId + " 的设备：" + ps.toString());
			rs = ps.executeQuery();
			if (rs.next()) {
				be.setEachID(rs.getString(1));
				be.setTypeId(rs.getString(2));
				be.setType(new EquipmentType(rs.getString(2), rs.getString(3)));
				be.setBankId(rs.getString(4));
				be.setBankName(rs.getString(5));
				be.setValue(rs.getDouble(6));
				be.setBuyDate(rs.getDate(7));
				be.setStatus(rs.getInt(8));
				be.setDepreciationValue(rs.getDouble(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, rs, ps);
		}
		return be;
	}
	
	@Override
	public boolean hasEquipmentsByType(String typeId) {
		boolean result = false;
		String sql = "SELECT Equipment_id FROM bankequipment WHERE Equipment_id=?";
		try {
			setConnAndPS(sql);
			ps.setString(1, typeId);
			LOGGER.info("是否存在种类 id 为 " + typeId + " 的设备：" + ps.toString());
			rs = ps.executeQuery();
			result = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} DBUtil.closeConnection(conn, rs, ps);
		return result;
	}
}
