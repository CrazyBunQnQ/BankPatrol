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
	public boolean addDepartment(String deptName);
	
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
	public List<Department> queryDepartment(int pageSize, int pageNum);
	
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
	
	/**
	 * 获取部门信息条数
	 * @return
	 */
	public int countDepartment();

	/**
	 * 查询部门是否有要添加的部门名称
	 * @param deptName
	 * @return
	 */
	public boolean hasDept(String deptName);
	
	/**
	 * 根据条件查询部门
	 * @param page
	 * @param condition
	 * @return
	 */
	public List<Department> queryDepartmentByCondition(int page,int pageSize, String condition);

	/**
	 * 根据条件获取总条数
	 * @param condition
	 * @return
	 */
	public int countByCondition(String condition);
}
