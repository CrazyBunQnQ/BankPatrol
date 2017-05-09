package com.bank.service.impl;

import java.util.List;

import com.bank.dao.UserDao;
import com.bank.dao.impl.UserDaoImpl;
import com.bank.entity.Department;
import com.bank.entity.Job;
import com.bank.entity.PageInfo;
import com.bank.entity.User;
import com.bank.service.UserService;

public class UserServiceImpl implements UserService{
    UserDao userDao = new UserDaoImpl();
	
	@Override
	public PageInfo<User> userList(String curpageStr) {
		PageInfo<User> data = new PageInfo<User>();
		int curPage = 1;
		if (curpageStr != null && !"".equals(curpageStr)) {
			curPage = Integer.parseInt(curpageStr);
		}
		data.setCurPage(curPage);
		List<User> list = userDao.queryUsers(data.getFrom(), data.getPageSize());
		// 查询总条数
		int num = 0;
		num = userDao.queryUsersCount();
		data.setTotalRecord(num);
		data.setPagedata(list);
		return data;
	}
	
	@Override
	public void deleteUser(String userId) {
		// 调用Dao
		userDao.deleteUser(userId);
	}

	@Override
	public List<Department> findAllDeprtments() {
		return userDao.findAllDepts();
	}

	@Override
	public List<Job> findAllJobs() {
		return userDao.findAllJobs();
	}

	@Override
	public void addUser(User user) {
          userDao.userAdd(user);		
	}
    
	@Override
	public User toUpdateUser(String loginId) {
		return userDao.queryUser(loginId);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}
}
