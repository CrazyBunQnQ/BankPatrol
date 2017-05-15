package com.bank.service;

import com.bank.entity.Department;
import com.bank.entity.PageInfo;

public interface DepartmentService {

	//查询部门分页显示
	public PageInfo<Department> queryDepart(int page, String name);
	
	//更新部门信息
	public boolean updateDepartment(Department dept);
	
	//添加部门
	public boolean addDepartment(String deptName);
	
	//删除部门根据id
	public boolean deleteDepartment(int depId);

	//查询是否有该部门名
	public boolean hasDept(String deptName);

	//根据id查询部门
	public Department getDeptById(int id);
	
	//根据条件查询部门分页显示
	public PageInfo<Department> queryDepartByCondition(int page, String condition); 
}
