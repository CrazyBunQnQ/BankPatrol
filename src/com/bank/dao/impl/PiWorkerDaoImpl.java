package com.bank.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.PiWorkerDao;
import com.bank.entity.PiWorker;
import com.bank.util.DBUtil;

public class PiWorkerDaoImpl extends BaseDaoImpl implements PiWorkerDao {

	//添加巡检工信息
	@Override
	public boolean addPiWorker(PiWorker pw) {
		boolean flag = false;
		String sql = "INSERT INTO PiWorker (Worker_id, Group_id,Worker_Tel1,Worker_Tel2) VALUES (?,?,?,?)";
		try {
			//获取数据库连接对象Connection及PreparedStatement对象
			setConnAndPS(sql);
			//给占位符赋值
			ps.setLong(1, pw.getId());
			ps.setLong(2, pw.getPiGroup().getId());
			ps.setString(3, pw.getTel1());
			ps.setString(4, pw.getTel2());
			//执行sql语句，返回影响行数
			int a =ps.executeUpdate();
			//受影响行数大于0则添加成功
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
	public boolean deletePiWorker(long id) {
		boolean flag = false;
		String sql = "delete from PiWorker where Worker_ID = ?";
		try {
			//获取数据库连接对象Connection及PreparedStatement对象
			setConnAndPS(sql);
			//给占位符赋值
			ps.setLong(1, id);
			//执行sql语句，返回影响行数
			int a =ps.executeUpdate();
			//受影响行数大于0则删除成功
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
		//创建对象
		List<PiWorker> listPiWorker = new ArrayList<PiWorker>();
		String sql = "";
		if(name==null){
			sql = "select DISTINCT pi.Worker_ID, pi.Worker_Tel1, pi.Worker_Tel2, u.user_name from PiWorker pi, users u where pi.Worker_ID = u.Worker_ID limit ?,?";
		}else{
			sql = "select DISTINCT pi.Worker_ID, pi.Worker_Tel1, pi.Worker_Tel2, u.user_name from PiWorker pi, users u where pi.Worker_ID = u.Worker_ID and u.user_name like ? limit ?,?";
		}
		try {
			//获取数据库连接对象Connection及PreparedStatement对象
			setConnAndPS(sql);
			//给占位符赋值
			if(name==null){
				ps.setInt(1, (pageNum-1)*pageSize);
				ps.setInt(2, pageSize);
			}else{
				ps.setString(1, "%" + name + "%");
				ps.setInt(2, (pageNum-1)*pageSize);
				ps.setInt(3, pageSize);
			}
			//执行sql语句，返回影响行数
			rs = ps.executeQuery();
			//循环输出查询结果
			while(rs.next()){
				//创建对象
				PiWorker pw = new PiWorker();
				//设置id
				pw.setId(rs.getLong("Worker_ID"));
				//设置巡检工名称
				pw.setWorkerName(rs.getString("user_name"));
				//设置巡检工第一个电话号码
				pw.setTel1(rs.getString("Worker_Tel1"));
				//设置巡检工第二个电话号码
				pw.setTel2(rs.getString("Worker_Tel2"));
				//添加到集合
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
		String sql = "update PiWorker set Worker_Tel1=?,Worker_Tel2=? where Worker_ID=?";
		String sql0 = "update users set user_name = ? where Worker_ID=?";
		try {
			//获取数据库连接对象Connection及PreparedStatement对象
			setConnAndPS(sql);
			//给占位符赋值
			ps.setString(1, pw.getTel1());
			ps.setString(2, pw.getTel2());
			ps.setLong(3, pw.getId());
			//执行sql语句，返回影响行数
			int a =ps.executeUpdate();
			//获取数据库连接对象Connection及PreparedStatement对象
			setConnAndPS(sql0);
			//给占位符赋值
			ps.setString(1, pw.getWorkerName());
			ps.setLong(2, pw.getId());
			//执行sql语句，返回影响行数
			int b =ps.executeUpdate();
			//若a>0并且b>0，则成功
			if(a>0 && b>0){
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return flag;
	}

	//获取巡检工信息条数
	@Override
	public int countPiWorker(String name) {
		//定义巡检工信息条数，初值为0
		int count = 0;
		String sql = "";
		if(name == null){
			sql = "select count(Worker_ID) from PiWorker";
		}else{
			sql = "select count(pi.Worker_ID) from PiWorker pi, users u where pi.Worker_ID = u.Worker_ID and user_name like ?";
		}
		try {
			//获取数据库连接对象Connection及PreparedStatement对象
			setConnAndPS(sql);
			//若name不为空则给占位符赋值
			if(name!=null){
				ps.setString(1, "%" + name + "%");
			}
			//执行sql语句，返回影响行数
			rs = ps.executeQuery();
			//根据查询结果，给巡检工信息条数赋值
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

	//查询是否存在该用户
	@Override
	public boolean hasUser(long id) {
		boolean flag = false;
		String sql = "select worker_id from users where worker_id = ?";
		try {
			//获取数据库连接对象Connection及PreparedStatement对象
			setConnAndPS(sql);
			//给占位符赋值
			ps.setLong(1, id);
			//执行sql语句，返回影响行数
			rs = ps.executeQuery();
			//若查询结果不为空，则可以添加
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

	// 判断巡检工表中是否存在
	@Override
	public boolean hasInPiWorker(long id) {
		boolean flag = false;
		String sql = "select worker_id from piworker where worker_id = ?";
		try {
			//获取数据库连接对象Connection及PreparedStatement对象
			setConnAndPS(sql);
			//给占位符赋值
			ps.setLong(1, id);
			//执行sql语句，返回影响行数
			rs = ps.executeQuery();
			//若查询结果不为空，则可以添加
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
	public PiWorker getPiWorkerById(long id) {
		
		PiWorker p = new PiWorker();
		String sql = "select pi.Worker_Tel1, pi.Worker_Tel2, u.user_name from PiWorker pi, users u where pi.Worker_ID = u.Worker_ID and pi.Worker_ID = ?";
		try {
			//获取数据库连接对象Connection及PreparedStatement对象
			setConnAndPS(sql);
			//给占位符赋值
			ps.setLong(1, id);
			//执行sql语句，返回影响行数
			rs = ps.executeQuery();
			//若查询结果不为空，则给巡检工设置属性
			if(rs.next()){
				//设置id
				p.setId(id);
				//设置巡检工姓名
				p.setWorkerName(rs.getString("user_name"));
				//设置第一个电话
				p.setTel1(rs.getString("Worker_Tel1"));
				//设置第二个电话
				p.setTel2(rs.getString("Worker_Tel2"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
}
