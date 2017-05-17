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
			//获取数据库连接对象Connection及PreparedStatement对象
			setConnAndPS(sql);
			//给占位符赋值
			ps.setString(1, deptName);
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

	//根据id删除部门信息
	@Override
	public boolean deleteDepartment(int id) {
		boolean flag = false;
		String sql = "delete from Department where department_id = ?";
		try {
			//获取数据库连接对象Connection及PreparedStatement对象
			setConnAndPS(sql);
			//给占位符赋值
			ps.setInt(1, id);
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

	//分页查询部门信息
	@Override
	public List<Department> queryDepartment(int pageSize, int pageNum) {
		//创建对象
		List<Department> listDepart = new ArrayList<Department>();
		String sql = "select department_id, department_name from department limit ?,?";
		try {
			//获取数据库连接对象Connection及PreparedStatement对象
			setConnAndPS(sql);
			//给占位符赋值
			ps.setInt(1, (pageNum-1)*pageSize);
			ps.setInt(2, pageSize);
			//执行sql语句，返回影响行数
			rs = ps.executeQuery();
			//循环输出查询结果
			while(rs.next()){
				//创建对象
				Department dept = new Department();
				//设置id
				dept.setId(rs.getInt("department_id"));
				//设置部门名称
				dept.setName(rs.getString("department_name"));
				//添加到集合
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
		//创建对象
		Department dept = new Department();
		String sql = "Select Department_id, Department_Name from Department where Department_id=?";
		try {
			//获取数据库连接对象Connection及PreparedStatement对象
			setConnAndPS(sql);
			//给占位符赋值
			ps.setInt(1, id);
			//执行sql语句，返回影响行数
			rs = ps.executeQuery();
			//若查询结果不为空，则进入条件
			if(rs.next()){
				//设置id
				dept.setId(rs.getInt("Department_id"));
				//设置部门名称
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
		//创建对象
		Department dept = new Department();
		String sql = "Select Department_id, Department_Name from Department where Department_Name=?";
		try {
			//获取数据库连接对象Connection及PreparedStatement对象
			setConnAndPS(sql);
			//给占位符赋值
			ps.setString(1, name);
			//执行sql语句，返回影响行数
			rs = ps.executeQuery();
			//若查询结果不为空，则进入条件
			if(rs.next()){
				//设置id
				dept.setId(rs.getInt("Department_id"));
				//设置部门名称
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
			//获取数据库连接对象Connection及PreparedStatement对象
			setConnAndPS(sql);
			//给占位符赋值
			ps.setInt(1, dept.getId());
			ps.setString(2, dept.getName());
			ps.setInt(3, dept.getId());
			//执行sql语句，返回影响行数
			int a =ps.executeUpdate();
			//受影响行数大于0则修改成功
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
		//定义部门信息条数，初值为0
		int count = 0;
		String sql = "select count(Department_id) from Department";
		try {
			//获取数据库连接对象Connection及PreparedStatement对象
			setConnAndPS(sql);
			//执行sql语句，返回影响行数
			rs = ps.executeQuery();
			//若查询结果不为空，则给部门信息条数赋值
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

	//查询部门是否有要添加的部门名称
	@Override
	public boolean hasDept(String deptName) {
		boolean flag = false;
		String sql = "select Department_id from Department where Department_name = ?";
		try {
			//获取数据库连接对象Connection及PreparedStatement对象
			setConnAndPS(sql);
			//给占位符赋值
			ps.setString(1, deptName);
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

	//根据条件获取部门信息
	@Override
	public List<Department> queryDepartmentByCondition(int page,int pageSize, String condition) {
		//创建对象
		List<Department> listDepart = new ArrayList<Department>();
		String sql = "select department_id, department_name from department where department_name like ? limit ?,? ";
		try {
			//获取数据库连接对象Connection及PreparedStatement对象
			setConnAndPS(sql);
			//给占位符赋值
			ps.setString(1, "%"+condition+"%");
			ps.setInt(2, (page-1)*pageSize);
			ps.setInt(3, pageSize);
			//执行sql语句，返回影响行数
			rs = ps.executeQuery();
			//循环输出查询结果
			while(rs.next()){
				//创建对象
				Department dept = new Department();
				//设置id
				dept.setId(rs.getInt("department_id"));
				//设置部门名称
				dept.setName(rs.getString("department_name"));
				//添加到集合
				listDepart.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.closeConnection(conn, rs, ps);
		}
		return listDepart;
	}

	////添加到集合
	@Override
	public int countByCondition(String condition) {
		//定义部门信息条数，初值为0
		int count = 0;
		String sql = "select count(Department_id) from Department where department_name like ?";
		try {
			//获取数据库连接对象Connection及PreparedStatement对象
			setConnAndPS(sql);
			//给占位符赋值
			ps.setString(1, "%"+condition+"%");
			//执行sql语句，返回影响行数
			rs = ps.executeQuery();
			//若查询结果不为空，则给条数赋值
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
