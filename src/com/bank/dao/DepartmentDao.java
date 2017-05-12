package com.bank.dao;

import java.util.List;

import com.bank.entity.Department;

/**
 * 部门接口
 * 
 * @author lenovo
 *
 */
public interface DepartmentDao {

	/**
	 * 添加部门
	 * @param dept
	 * @return
	 */
	public boolean addDepartment(Department dept);
	
	/**
	 * 根据id删除部门
	 * @param id
	 * @return
	 */
	public boolean deleteDepartment(int id);
	
	/**
	 * 分页查询部门
	 * @param pageSize
	 * @param pageNum
	 * @param depName
	 * @return
	 */
	public List<Department> queryDepartment(int pageSize, int pageNum, String depName);
	
	/**
	 * 根据id查询部门
	 * @param id
	 * @return
	 */
	public Department queryDepartmentById(int id);
	
	/**
	 * 根据部门名称查询部门
	 * @param name
	 * @return
	 */
	public Department queryDepartmentByName(String name);

	/**
	 * 修改部门
	 * @param dept
	 * @return
	 */
	public boolean updateDepartment(Department dept);
}
