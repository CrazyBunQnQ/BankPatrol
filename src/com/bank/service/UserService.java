package com.bank.service;

import java.util.List;

import com.bank.entity.Department;
import com.bank.entity.Function;
import com.bank.entity.Job;
import com.bank.entity.PageInfo;
import com.bank.entity.User;
import com.bank.entity.Xtymb;

public interface UserService {

	/**
	 * 根据指定的页码查询用户数据
	 * @param curpage 当前页
	 * @return
	 */
	PageInfo<User> userList(String curpage);
	
	/**
	 * 用户模糊查询
	 * @param curpage 当前页
	 * @param u 用户
	 * @return
	 */
	PageInfo<User> userList(String curpage, User u);

	/**
	 * 删除指定 id 的用户
	 * @param userId
	 */
	void deleteUser(String userId);

	/**
	 * 查询所有的部门信息
	 * @return
	 */
	List<Department> findAllDeprtments();

	/**
	 * 查询所有的岗位信息
	 * @return
	 */
	List<Job> findAllJobs();

	/**
	 * 添加用户
	 * @param user
	 * @return 是否成功
	 */
	boolean addUser(User user);

	/**
	 * 携带用户信息跳转到修改页面
	 * @param loginId 用户 id
	 * @return
	 */
	User toUpdateUser(String loginId);

	/**
	 * 更新用户
	 * @param user
	 */
	void updateUser(User user);

	/**
	 * 查询是否已存在该用户名
	 * @param uname
	 * @return
	 */
	boolean hasUser(String uname);
	
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
