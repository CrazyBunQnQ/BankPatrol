package com.bank.service.impl;

import java.util.List;

import com.bank.dao.UserDao;
import com.bank.dao.impl.UserDaoImpl;
import com.bank.entity.Function;
import com.bank.entity.User;
import com.bank.entity.Xtymb;
import com.bank.service.LoginService;


/**
 * 登录与登出模块
 * @author QU
 *
 */
public class LoginServiceImpl implements LoginService {
	UserDao userDao = new UserDaoImpl();

	@Override
	public User findUser(String loginId, String loginPassword) {
		return userDao.findUser(loginId,loginPassword);
	}
	
	@Override
	public List<Function> findFunctionsByJobId(int jobId) {
		return userDao.findFunctionsByJobId(jobId);
	}
	
	@Override
	public List<Xtymb> leftList(User user, int funcId) {
		return userDao.findXtymbList(user.getJobId(),funcId);
	}
}
