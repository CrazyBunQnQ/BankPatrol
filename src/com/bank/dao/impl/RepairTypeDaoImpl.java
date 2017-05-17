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
	public boolean addRepairType(RepairType repairType) {
		boolean flag = false;
		String sql = "INSERT INTO faultrepairtype (Pitype_ID,PITYPE_Value) VALUES (?,?)";
		try {
			setConnAndPS(sql);
			ps.setInt(1, repairType.getId());
			ps.setString(2, repairType.getValue());
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
	public List<RepairType> queryRepairType(int pageSize, int pageNum) {
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
	public List<RepairType> queryRepairTypeByPiType_Value(int pageSize, int pageNum, String name) {
		List<RepairType> listRepairType = new ArrayList<RepairType>();
		String sql = "Select Pitype_ID,PITYPE_Value from faultrepairtype where PITYPE_Value like ? limit ?,?";
		try {
			setConnAndPS(sql);
			ps.setString(1, name);
			ps.setInt(2, (pageNum-1)*pageSize);
			ps.setInt(3, pageSize);
			rs = ps.executeQuery();
			while(rs.next()){
				RepairType rt = new RepairType();
				rt.setId(rs.getInt("Pitype_ID"));
				rt.setValue(rs.getString("PITYPE_Value"));
				listRepairType.add(rt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);			
		}
		return listRepairType;
	}

	//修改设备报修问题
	@Override
	public boolean updateRepairType(RepairType repairType) {
		boolean flag = false;
		String sql = "update faultrepairtype set Pitype_ID=?, PITYPE_Value=? where Pitype_ID=?";
		try {
			setConnAndPS(sql);
			ps.setInt(1, repairType.getId());
			ps.setString(2, repairType.getValue());
			ps.setInt(3, repairType.getId());
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

	@Override
	public int countRepairType(String PITYPE_Value) {
		int count = 0;
		String sql = "select count(PITYPE_Value) from faultrepairtype";
		try {
			setConnAndPS(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				count = rs.getInt("count(PITYPE_Value)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return count;
	}

	@Override
	public boolean hasType(String PITYPE_Value) {
		boolean flag = false;
		String sql = "select PITYPE_Value from faultrepairtype where PITYPE_Value = ?";
		try {
			setConnAndPS(sql);
			ps.setString(1, PITYPE_Value);
			rs = ps.executeQuery();
			if(rs.next()){
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return flag;
	}

	@Override
	public RepairType queryRepairTypeById(int id) {
		RepairType rp = new RepairType();
		String sql = "Select Pitype_ID,PITYPE_Value from faultrepairtype where Pitype_ID=?";
		try {
			setConnAndPS(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);			
		}
		return rp;
	}

}
