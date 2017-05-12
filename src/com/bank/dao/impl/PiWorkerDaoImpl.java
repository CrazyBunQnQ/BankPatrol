package com.bank.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.PiWorkerDao;
import com.bank.entity.Department;
import com.bank.entity.PiGroup;
import com.bank.entity.PiWorker;
import com.bank.util.DBUtil;

public class PiWorkerDaoImpl extends BaseDaoImpl implements PiWorkerDao {

	//添加巡检工信息
	@Override
	public boolean addPiWorker(PiWorker pw) {
		boolean flag = false;
		String sql = "INSERT INTO PiWorker (Worker_ID,Group_id,Worker_Tel1,Worker_Tel2) VALUES (?,?,?,?)";
		try {
			setConnAndPS(sql);
			ps.setLong(1, pw.getId());
			ps.setLong(2, pw.getPiGroup().getId());
			ps.setString(3, pw.getTel1());
			ps.setString(4, pw.getTel2());
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

	//删除巡检工信息
	@Override
	public boolean deletePiWorker(int id) {
		boolean flag = false;
		String sql = "delete from PiWorker where Worker_ID = ?";
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

	//分页查询巡检工信息
	@Override
	public List<PiWorker> queryPiWorker(int pageSize, int pageNum, PiGroup piGroup, String tel1, String tel2) {
		List<PiWorker> listPiWorker = new ArrayList<PiWorker>();
		String sql = "select Worker_ID,Group_id,Worker_Tel1,Worker_Tel2 from PiWorker limit ?,?";
		try {
			setConnAndPS(sql);
			ps.setInt(1, (pageNum-1)*pageSize);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			while(rs.next()){
				PiWorker pw = new PiWorker();
				pw.setId(rs.getLong("Worker_ID"));
				//pw.setPiGroup(rs.get);
				listPiWorker.add(pw);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return listPiWorker;
	}

	//修改巡检工信息
	@Override
	public boolean updatePiWorker(PiWorker pw) {
		boolean flag = false;
		String sql = "update PiWorker set Worker_ID=?,Group_id=?,Worker_Tel1=?,Worker_Tel2=? where Worker_ID=?";
		try {
			setConnAndPS(sql);
			ps.setLong(1, pw.getId());
			ps.setLong(2, pw.getPiGroup().getId());
			ps.setString(3, pw.getTel1());
			ps.setString(4, pw.getTel2());
			ps.setLong(5, pw.getId());
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
