package com.bank.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.EquipmentTypeDao;
import com.bank.entity.Department;
import com.bank.entity.EquipmentType;
import com.bank.util.DBUtil;

public class EquipmentTypeDaoImpl extends BaseDaoImpl implements EquipmentTypeDao {

	@Override
	public boolean addEquipmentType(EquipmentType EquipmentType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEquipmentType(int id) {
		return false;
	}

	@Override
	public List<Department> queryEquipmentType(int pageSize, int pageNum, String Equipment_Name) {
		return null;
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

}
