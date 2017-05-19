package com.bank.service.impl;

import java.util.List;

import com.bank.dao.DepartmentDao;
import com.bank.dao.impl.DepartmentDaoImpl;
import com.bank.entity.Department;
import com.bank.entity.PageInfo;
import com.bank.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
	DepartmentDao dpi = new DepartmentDaoImpl();
	//获取部门分页对象
	@Override
	public PageInfo<Department> queryDepart(int page, String name) {
		//创建对象
		PageInfo<Department> data = new PageInfo<Department>();
		//设置当前页
		data.setCurPage(page);
		//定义部门集合，初值为空
		List<Department> depts = null;
		//定义部门总条数初值为0
		int count = 0;
		//name为空则条件分页查询，不为空则模糊分页查询
		if(name==null){
			depts = dpi.queryDepartment(data.getPageSize(), page);
			count = dpi.countDepartment();
		}else{
			depts = dpi.queryDepartmentByCondition(page, data.getPageSize(), name);
			count = dpi.countByCondition(name);
		}
		//获取部门信息总页数
		int totalPage = (int)Math.ceil((double)count/data.getPageSize());
		//设置总页数
		data.setTotalPage(totalPage);
		//设置总条数
		data.setTotalRecord(count);
		//设置部门信息
		data.setPagedata(depts);
		return data;
	}

	//更新部门
	@Override
	public boolean updateDepartment(Department dept) {
		return dpi.updateDepartment(dept);
	}

	//添加部门
	@Override
	public boolean addDepartment(String deptName) {
		return dpi.addDepartment(deptName);
	}

	//根据id删除部门
	@Override
	public boolean deleteDepartment(int depId) {
		return dpi.deleteDepartment(depId);
	}

	//判断是否存在该部门
	@Override
	public boolean hasDept(String deptName) {
		return dpi.hasDept(deptName);
	}

	//通过id查询部门
	@Override
	public Department getDeptById(int id) {
		return dpi.queryDepartmentById(id);
	}

	//通过条件模糊查询部门分页显示
	@Override
	public PageInfo<Department> queryDepartByCondition(int page, String condition) {
		//创建分页对象
		PageInfo<Department> data = new PageInfo<Department>();
		//设置当前页
		data.setCurPage(page);
		//获取当前页显示的部门信息
		List<Department> depts = dpi.queryDepartmentByCondition(page, data.getPageSize(), condition);
		//获取总条数
		int count = dpi.countByCondition(condition);
		//获取总页数
		int totalPage = (int)Math.ceil((double)count/data.getPageSize());
		//设置总页数
		data.setTotalPage(totalPage);
		//设置总条数
		data.setTotalRecord(count);
		//设置部门信息
		data.setPagedata(depts);
		return data;
	}
}