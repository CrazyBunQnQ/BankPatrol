package com.bank.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.bank.dao.LoginDao;
import com.bank.entity.Function;
import com.bank.entity.User;
import com.bank.entity.Xtymb;
import com.bank.util.DBUtil;

public class LoginDaoImpl extends BaseDaoImpl implements LoginDao{
	
	/**
	 * 根据用户登录名和密码查找用户
	 */
	@Override
	public User findUser(String loginId, String loginPassword) {
		String sql="select Job_ID,Department_id,User_Name,User_Status" +
				" from users" +
				" where Login_ID=?" +
				" and Login_Password=?";
		User user = null;
		try {
			setConnAndPS(sql);
			ps.setString(1, loginId);
			ps.setString(2, loginPassword);
			rs=ps.executeQuery();
			if(rs.next()){
				user=new User();
				user.setLoginId(loginId);
				user.setLoginPassword(loginPassword);
				user.setJobId(rs.getLong("Job_ID"));
				user.setDepartmentId(rs.getLong("Department_id"));
				user.setUserName(rs.getString("User_Name"));
				user.setUserStatus(rs.getString("User_Status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return user;
	}
	
	/**
	 * 根据岗位id获得此岗们的功能，权限（这里指的是大模块）
	 */
	@Override
	public List<Function> findFunctionsByJobId(Long jobId) {
		String sql="select distinct f.Func_ID,f.Func_Name " +
				"from functions f join xtymb x on f.Func_ID=x.Func_ID " +
				"join gwym g on x.ymbh=g.ymbh " +
				"where g.Job_ID=?";
		List<Function> list=new ArrayList<Function>();
		try {
			setConnAndPS(sql);
			ps.setLong(1, jobId);
			rs=ps.executeQuery();
			while(rs.next()){
				Function function = new Function();
				function.setFuncId(rs.getLong("Func_ID"));
				function.setFuncName(rs.getString("Func_Name"));
				list.add(function);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return list;
	}
	
	/**
	 * 根据岗位id，根据模块id获得左侧列表:子模块列表
	 */
	@Override
	public List<Xtymb> findXtymbList(long jobId, long funcId) {
		String sql="select x.ymbh,x.Func_ID,x.ymmc,x.URL,x.IMG " +
				"from xtymb x join gwym g on x.ymbh=g.ymbh " +
				"where g.Job_ID=? " +
				"and x.Func_ID=?";
		List<Xtymb> list=new ArrayList<Xtymb>();
		try {
			setConnAndPS(sql);
			ps.setLong(1, jobId);
			ps.setLong(2, funcId);
			rs=ps.executeQuery();
			while(rs.next()){
				Xtymb x = new Xtymb();
				x.setYmbh(rs.getLong("ymbh"));
				x.setFuncId(funcId);
				x.setYmmc(rs.getString("ymmc"));
				x.setUrl(rs.getString("URL"));
				x.setImg(rs.getString("IMG"));
				list.add(x);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return list;
	}
}