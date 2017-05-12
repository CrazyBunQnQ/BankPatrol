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
	public boolean addDepartment(Department dept) {
		boolean flag = false;
		String sql = "INSERT INTO Department (Department_id,Department_Name) VALUES (?,?)";
		try {
			setConnAndPS(sql);
			ps.setInt(1, dept.getId());
			ps.setString(2, dept.getName());
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
		String sql = "delete from Department where id = ?";
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
	public List<Department> queryDepartment(int pageSize, int pageNum, String depName) {
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
			// TODO Auto-generated catch block
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
}
