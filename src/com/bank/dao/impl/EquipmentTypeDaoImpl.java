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
	public int insertEquipmentType(EquipmentType eType) {
		int n = 0;
		String sql = "INSERT INTO equipmenttype VALUES(?, ?)";
		try {
			setConnAndPS(sql);
			ps.setString(1, eType.getId());
			ps.setString(2, eType.getName());
			LOGGER.info("添加设备种类：" + ps.toString());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, null, ps);
		}
		return n;
	}

	@Override
	public int deleteEquipmentType(String id) {
		int n = 0;
		String sql = "DELETE FROM equipmenttype WHERE Equipment_id=?";
		try {
			setConnAndPS(sql);
			ps.setString(1, id);
			LOGGER.info("删除设备种类：" + ps.toString());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, null, ps);
		}
		return n;
	}
	
	@Override
	public int queryEquipmentsCount(String eTypeId, String eTypeName) {
		int count = 0;
		StringBuffer sql = new StringBuffer("SELECT COUNT(Equipment_id) FROM equipmenttype WHERE 1=1");
		if (!"".equals(eTypeId)) {
			sql.append(" AND Equipment_id LIKE '%" + eTypeId + "%'");
		}
		if (!"".equals(eTypeName)) {
			sql.append(" AND Equipment_Name LIKE '%" + eTypeName + "%'");
		}
		try {
			setConnAndPS(sql.toString());
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

	@Override
	public List<EquipmentType> queryTypes(int page, int count, String eTypeId, String eTypeName) {
		List<EquipmentType> list = new ArrayList<EquipmentType>();
		StringBuffer sql = new StringBuffer("SELECT * FROM equipmenttype WHERE 1=1");
		BankEquipmentDao bedi = new BankEquipmentDaoImpl();
		if (!"".equals(eTypeId)) {
			sql.append(" AND Equipment_id LIKE '%" + eTypeId + "%'");
		}
		if (!"".equals(eTypeName)) {
			sql.append(" AND Equipment_Name LIKE '%" + eTypeName + "%'");
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
	public int updateEquipmentType(EquipmentType eType) {
		int n = 0; 
		String sql = "UPDATE equipmenttype SET Equipment_Name=? WHERE Equipment_id=?";
		try {
			setConnAndPS(sql);
			ps.setString(1, eType.getName());
			ps.setString(2, eType.getId());
			LOGGER.info("更新设备种类：" + ps.toString());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, null, ps);
		}
		return n;
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
	public boolean hasType(String typeId) {
		boolean result = true;
		String sql = "SELECT Equipment_id FROM equipmenttype WHERE Equipment_id=?";
		try {
			setConnAndPS(sql);
			ps.setString(1, typeId);
			LOGGER.info("是否存在种类 id 为 " + typeId + " 的设备：" + ps.toString());
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
	public boolean hasTypeName(String typeName) {
		boolean result = true;
		String sql = "SELECT Equipment_id FROM equipmenttype WHERE Equipment_Name=?";
		try {
			setConnAndPS(sql);
			ps.setString(1, typeName);
			LOGGER.info("是否存在" + typeName + "类型的设备：" + ps.toString());
			rs = ps.executeQuery();
			result = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(conn, rs, ps);
		}
		return result;
	}
}
