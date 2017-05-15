package com.bank.service.impl;

import java.util.List;

import com.bank.dao.BankDao;
import com.bank.dao.BankEquipmentDao;
import com.bank.dao.DepartmentDao;
import com.bank.dao.EquipmentTypeDao;
import com.bank.dao.impl.BankDaoImpl;
import com.bank.dao.impl.BankEquipmentDaoImpl;
import com.bank.dao.impl.DepartmentDaoImpl;
import com.bank.dao.impl.EquipmentTypeDaoImpl;
import com.bank.entity.Bank;
import com.bank.entity.Department;
import com.bank.entity.PageInfo;
import com.bank.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

	DepartmentDao dpi = new DepartmentDaoImpl();
	//BankEquipmentDao bedi = new BankEquipmentDaoImpl();
	//EquipmentTypeDao etdi = new EquipmentTypeDaoImpl();
	@Override
	public PageInfo<Department> queryDepart(int page, String name) {
		PageInfo<Department> data = new PageInfo<Department>();
		data.setCurPage(page);
		List<Department> depts = null;
		int count = 0;
		if(name==null){
			depts = dpi.queryDepartment(data.getPageSize(), page);
			count = dpi.countDepartment();
		}else{
			depts = dpi.queryDepartmentByCondition(page, data.getPageSize(), name);
			count = dpi.countByCondition(name);
		}
		
		int totalPage = (int)Math.ceil((double)count/data.getPageSize());
		data.setTotalPage(totalPage);
		data.setTotalRecord(count);
		data.setPagedata(depts);
		return data;
	}

	@Override
	public boolean updateDepartment(Department dept) {
		
		return dpi.updateDepartment(dept);
	}

	@Override
	public boolean addDepartment(String deptName) {
		boolean flag = dpi.addDepartment(deptName);
		return flag;
	}

	@Override
	public boolean deleteDepartment(int depId) {
		return dpi.deleteDepartment(depId);
	}

	@Override
	public boolean hasDept(String deptName) {
		
		return dpi.hasDept(deptName);
	}

	@Override
	public Department getDeptById(int id) {
		
		return dpi.queryDepartmentById(id);
	}

	@Override
	public PageInfo<Department> queryDepartByCondition(int page, String condition) {
		PageInfo<Department> data = new PageInfo<Department>();
		data.setCurPage(page);
		List<Department> depts = dpi.queryDepartmentByCondition(page, data.getPageSize(), condition);
		int count = dpi.countByCondition(condition);
		int totalPage = (int)Math.ceil((double)count/data.getPageSize());
		data.setTotalPage(totalPage);
		data.setTotalRecord(count);
		data.setPagedata(depts);
		return data;
	}

}
