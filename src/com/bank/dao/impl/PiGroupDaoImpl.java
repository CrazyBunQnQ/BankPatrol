package com.bank.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.PiGroupDao;
import com.bank.entity.PiGroup;
import com.bank.util.DBUtil;

public class PiGroupDaoImpl extends BaseDaoImpl implements PiGroupDao {

	//添加巡检组
	@Override
	public boolean addPiGroup(PiGroup PiGroup) {
		boolean flag = false;
		String sql = "INSERT INTO PiGroup (Group_ID,Group_Name) VALUES (?,?)";
		try {
			setConnAndPS(sql);
			ps.setLong(1, PiGroup.getId());
			ps.setString(2, PiGroup.getName());
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

	//根据id删除巡检组
	@Override
	public boolean deletePiGroup(int id) {
		boolean flag = false;
		String sql = "delete from PiGroup where Group_ID = ?";
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

	//分页查询巡检组
	@Override
	public List<PiGroup> queryPiGroup(int pageSize, int pageNum) {
		List<PiGroup> listPiGroup = new ArrayList<PiGroup>();
		String sql = "select Group_ID, Group_Name from PiGroup limit ?,?";
		try {
			setConnAndPS(sql);
			ps.setInt(1, (pageNum-1)*pageSize);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			while(rs.next()){
				PiGroup piGroup = new PiGroup();
				piGroup.setId(rs.getLong("Group_ID"));
				piGroup.setName(rs.getString("Group_Name"));
				listPiGroup.add(piGroup);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return listPiGroup;
	}

	//修改巡检组
	@Override
	public boolean updatePiGroup(PiGroup PiGroup) {
		boolean flag = false;
		String sql = "update PiGroup set Department_id=?, Department_Name=? where Department_id=?";
		try {
			setConnAndPS(sql);
			ps.setLong(1, PiGroup.getId());
			ps.setString(2, PiGroup.getName());
			ps.setLong(3, PiGroup.getId());
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
	public List<PiGroup> getAllGroup() {
		List<PiGroup> groups = new ArrayList<PiGroup>();
		String sql = "select Group_ID, Group_Name from PiGroup";
		try {
			setConnAndPS(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				PiGroup piGroup = new PiGroup();
				piGroup.setId(rs.getLong("Group_ID"));
				piGroup.setName(rs.getString("Group_Name"));
				groups.add(piGroup);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return groups;
	}

	@Override
	public int countPiGruop() {
		int count = 0;
		String sql = "select count(Group_id) from pigroup";
		try {
			setConnAndPS(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				count = rs.getInt("count(Group_id)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return count;
	}
}
