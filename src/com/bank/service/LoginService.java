package com.bank.service;

import java.util.List;

import com.bank.entity.Function;
import com.bank.entity.User;
import com.bank.entity.Xtymb;

public interface LoginService {

	/**
	 * 根据用户登录名和密码查找用户
	 * @param loginId 用户名
	 * @param loginPassword 密码
	 * @return
	 */
	public User findUser(String loginId, String loginPassword);

	/**
	 * 根据岗位 id 获得此岗位可操作的模块
	 * @param jobId 岗位 id
	 * @return
	 */
	public List<Function> findFunctionsByJobId(int jobId);

	/**
	 * 根据用户和模块 id 获得左侧子功能列表
	 * @param user 用户
	 * @param funcId 模块 id
	 * @return
	 */
	public List<Xtymb> leftList(User user, int funcId);
}
