package com.bank.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.DepartmentDao;
import com.bank.entity.Department;
import com.bank.util.DBUtil;

public class DepartmentDaoImpl extends BaseDaoImpl implements DepartmentDao {

	//添加部门信息
	@Override
	public boolean addDepartment(String deptName) {
		boolean flag = false;
		String sql = "INSERT INTO Department (Department_Name) VALUES (?)";
		try {
			setConnAndPS(sql);
			ps.setString(1, deptName);
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

	//根据id删除部门信息
	@Override
	public boolean deleteDepartment(int id) {
		boolean flag = false;
		String sql = "delete from Department where department_id = ?";
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

	//分页查询部门信息
	@Override
	public List<Department> queryDepartment(int pageSize, int pageNum) {
		List<Department> listDepart = new ArrayList<Department>();
		String sql = "select department_id, department_name from department limit ?,?";
		try {
			setConnAndPS(sql);
			ps.setInt(1, (pageNum-1)*pageSize);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			while(rs.next()){
				Department dept = new Department();
				dept.setId(rs.getInt("department_id"));
				dept.setName(rs.getString("department_name"));
				listDepart.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return listDepart;
	}

	//根据id查询部门信息
	@Override
	public Department queryDepartmentById(int id) {
		Department dept = new Department();
		String sql = "Select Department_id, Department_Name from Department where Department_id=?";
		try {
			setConnAndPS(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				dept.setId(rs.getInt("Department_id"));
				dept.setName(rs.getString("Department_Name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);			
		}
		return dept;
	}

	//根据部门名称查询部门信息
	@Override
	public Department queryDepartmentByName(String name) {
		Department dept = new Department();
		String sql = "Select Department_id, Department_Name from Department where Department_Name=?";
		try {
			setConnAndPS(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if(rs.next()){
				dept.setId(rs.getInt("Department_id"));
				dept.setName(rs.getString("Department_Name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);			
		}
		return dept;
	}

	//修改部门信息
	@Override
	public boolean updateDepartment(Department dept) {
		boolean flag = false;
		String sql = "update Department set Department_id=?, Department_Name=? where Department_id=?";
		try {
			setConnAndPS(sql);
			ps.setInt(1, dept.getId());
			ps.setString(2, dept.getName());
			ps.setInt(3, dept.getId());
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

	//获取部门信息条数
	@Override
	public int countDepartment() {
		int count = 0;
		String sql = "select count(Department_id) from Department";
		try {
			setConnAndPS(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				count = rs.getInt("count(Department_id)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return count;
	}

	@Override
	public boolean hasDept(String deptName) {
		boolean flag = false;
		String sql = "select Department_id from Department where Department_name = ?";
		try {
			setConnAndPS(sql);
			ps.setString(1, deptName);
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
	public List<Department> queryDepartmentByCondition(int page,int pageSize, String condition) {
		List<Department> listDepart = new ArrayList<Department>();
		String sql = "select department_id, department_name from department where department_name like ? limit ?,? ";
		try {
			setConnAndPS(sql);
			ps.setString(1, "%"+condition+"%");
			ps.setInt(2, (page-1)*pageSize);
			ps.setInt(3, pageSize);
			rs = ps.executeQuery();
			while(rs.next()){
				Department dept = new Department();
				dept.setId(rs.getInt("department_id"));
				dept.setName(rs.getString("department_name"));
				listDepart.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return listDepart;
	}

	@Override
	public int countByCondition(String condition) {
		int count = 0;
		String sql = "select count(Department_id) from Department where department_name like ?";
		try {
			setConnAndPS(sql);
			ps.setString(1, "%"+condition+"%");
			rs = ps.executeQuery();
			if(rs.next()){
				count = rs.getInt("count(Department_id)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return count;
	}
}
