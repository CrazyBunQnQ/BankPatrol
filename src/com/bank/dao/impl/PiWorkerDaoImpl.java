package com.bank.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.PiWorkerDao;
import com.bank.entity.PiGroup;
import com.bank.entity.PiWorker;
import com.bank.util.DBUtil;

public class PiWorkerDaoImpl extends BaseDaoImpl implements PiWorkerDao {

	//添加巡检工信息
	@Override
	public boolean addPiWorker(PiWorker pw) {
		boolean flag = false;
		String sql = "INSERT INTO PiWorker (Group_id,Worker_Tel1,Worker_Tel2) VALUES (?,?,?,?)";
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

	//根据id删除巡检工信息
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
	public List<PiWorker> queryPiWorker(int pageSize, int pageNum, String name) {
		List<PiWorker> listPiWorker = new ArrayList<PiWorker>();
		String sql = "";
		if(name==null){
			sql = "select DISTINCT pi.Worker_ID, pi.Worker_Tel1, pi.Worker_Tel2, u.user_name from PiWorker pi, users u where pi.Worker_ID = u.Worker_ID limit ?,?";
		}else{
			sql = "select DISTINCT pi.Worker_ID, pi.Worker_Tel1, pi.Worker_Tel2, u.user_name from PiWorker pi, users u where pi.Worker_ID = u.Worker_ID and u.user_name like ? limit ?,?";
		}
		try {
			setConnAndPS(sql);
			if(name==null){
				ps.setInt(1, (pageNum-1)*pageSize);
				ps.setInt(2, pageSize);
			}else{
				ps.setString(1, name);
				ps.setInt(2, (pageNum-1)*pageSize);
				ps.setInt(3, pageSize);
			}
			rs = ps.executeQuery();
			while(rs.next()){
				PiWorker pw = new PiWorker();
				pw.setId(rs.getLong("Worker_ID"));
				pw.setWorkerName(rs.getString("user_name"));
				pw.setTel1(rs.getString("Worker_Tel1"));
				pw.setTel2(rs.getString("Worker_Tel2"));
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

	@Override
	public int countPiWorker(String name) {
		int count = 0;
		String sql = "";
		if(name == null){
			sql = "select count(Worker_ID) from PiWorker";
		}else{
			sql = "select count(pi.Worker_ID) from PiWorker pi, users u where pi.Worker_ID = u.Worker_ID and user_name like ?";
		}
		try {
			setConnAndPS(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				if(name == null){
					count = rs.getInt("count(Worker_ID)");
				}else{
					count = rs.getInt("count(pi.Worker_ID)");
				}	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return count;
	}

	@Override
	public boolean hasUser(long id) {
		boolean flag = false;
		String sql = "select worker_id from users where worker_id = ?";
		try {
			setConnAndPS(sql);
			ps.setLong(1, id);
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

}
