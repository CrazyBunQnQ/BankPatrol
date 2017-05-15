package com.bank.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.RepairTypeDao;
import com.bank.entity.RepairType;
import com.bank.util.DBUtil;

public class RepairTypeDaoImpl extends BaseDaoImpl implements RepairTypeDao {

	//添加设备报修问题
	@Override
	public boolean addRepairType(RepairType RepairType) {
		boolean flag = false;
		String sql = "INSERT INTO faultrepairtype (Pitype_ID,PITYPE_Value) VALUES (?,?)";
		try {
			setConnAndPS(sql);
			ps.setInt(1, RepairType.getId());
			ps.setString(2, RepairType.getValue());
			int a =ps.executeUpdate();
			if(a>0){
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return flag;
	}

	//根据id删除设备报修问题
	@Override
	public boolean deleteRepairType(int id) {
		boolean flag = false;
		String sql = "delete from faultrepairtype where Pitype_ID = ?";
		try {
			setConnAndPS(sql);
			ps.setInt(1, id);
			int a =ps.executeUpdate();
			if(a>0){
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return flag;
	}

	//分页查询设备报修问题
	@Override
	public List<RepairType> queryRepairType(int pageSize, int pageNum, String PITYPE_Value) {
		List<RepairType> listRepairType = new ArrayList<RepairType>();
		String sql = "select Pitype_ID, PITYPE_Value from faultrepairtype limit ?,?";
		try {
			setConnAndPS(sql);
			ps.setInt(1, (pageNum-1)*pageSize);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			while(rs.next()){
				RepairType rp = new RepairType();
				rp.setId(rs.getInt("Pitype_ID"));
				rp.setValue(rs.getString("PITYPE_Value"));
				listRepairType.add(rp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return listRepairType;
	}

	//根据问题类型进行模糊搜索
	@Override
	public RepairType queryRepairTypeByPITYPE_Value(String PITYPE_Value) {
		RepairType RepairType = new RepairType();
		String sql = "Select Pitype_ID,PITYPE_Value from faultrepairtype where PITYPE_Value=?";
		try {
			setConnAndPS(sql);
			ps.setString(1, RepairType.getValue());
			rs = ps.executeQuery();
			if(rs.next()){
				RepairType.setId(rs.getInt("Pitype_ID"));
				RepairType.setValue(rs.getString("PITYPE_Value"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);			
		}
		return RepairType;
	}

	//修改设备报修问题
	@Override
	public boolean updateRepairType(RepairType RepairType) {
		boolean flag = false;
		String sql = "update faultrepairtype set Pitype_ID=?, PITYPE_Value=? where PITYPE_Value=?";
		try {
			setConnAndPS(sql);
			ps.setInt(1, RepairType.getId());
			ps.setString(2, RepairType.getValue());
			ps.setInt(3, RepairType.getId());
			int a =ps.executeUpdate();
			if(a>0){
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return flag;
	}

}
