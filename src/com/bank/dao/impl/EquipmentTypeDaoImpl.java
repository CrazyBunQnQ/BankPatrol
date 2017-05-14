package com.bank.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.BankEquipmentDao;
import com.bank.dao.EquipmentTypeDao;
import com.bank.entity.EquipmentType;
import com.bank.util.DBUtil;

public class EquipmentTypeDaoImpl extends BaseDaoImpl implements EquipmentTypeDao {

	@Override
	public boolean addEquipmentType(EquipmentType EquipmentType) {
		return false;
	}

	@Override
	public boolean deleteEquipmentType(int id) {
		return false;
	}

	@Override
	public List<EquipmentType> queryEquipmentTypes(int page, int count, String eName) {
		List<EquipmentType> list = new ArrayList<EquipmentType>();
		StringBuffer sql = new StringBuffer("SELECT * FROM equipmenttype");
		BankEquipmentDao bedi = new BankEquipmentDaoImpl();
		if (!"".equals(eName)) {
			sql.append(" WHERE Equipment_Name LIKE '%" + eName + "%'");
		}
		sql.append(" LIMIT ?, ?");
		try {
			setConnAndPS(sql.toString());
			ps.setInt(1, page);
			ps.setInt(2, count);
			LOGGER.info("查询设备种类列表：" + ps.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
				String typeId = rs.getString(1);
				list.add(new EquipmentType(typeId, rs.getString(2), bedi.hasEquipmentsByType(typeId)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, rs, ps);
		}
		return list;
	}

	@Override
	public boolean updateEquipmentType(EquipmentType EquipmentType) {
		return false;
	}

	@Override
	public List<EquipmentType> queryTyps() {
		List<EquipmentType> list = new ArrayList<EquipmentType>();
		String sql = "SELECT * FROM equipmenttype";
		try {
			setConnAndPS(sql);
			LOGGER.info("查询所有设备种类：" + ps.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new EquipmentType(rs.getString(1), rs.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, rs, ps);
		}
		return list;
	}

	@Override
	public int queryEquipmentsCount() {
		int count = 0;
		String sql = "SELECT COUNT(*) FROM equipmenttype";
		try {
			setConnAndPS(sql);
			LOGGER.info("查询所有设备种类的数量：" + ps.toString());
			rs = ps.executeQuery();
			count = rs.next() ? rs.getInt(1) : 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, rs, ps);
		}
		return count;
	}
}
