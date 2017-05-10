package com.bank.dao;

import java.util.List;

import com.bank.entity.Department;
import com.bank.entity.Function;
import com.bank.entity.Job;
import com.bank.entity.User;
import com.bank.entity.Xtymb;

public interface UserDao {

	/**
	 * 查询所有用户
	 * @param from 当前页数
	 * @param pageSize 每页显示数量
	 * @return
	 */
	List<User> queryUsers(int from, int pageSize);

	/**
	 * 查询列表信息（支持分页）
	 * @param from 当前页
	 * @param pageSize 每页显示数量
	 * @param u 用户信息
	 * @return list
	 */
	List<User> queryUsers(int from, int pageSize, User u);
	
	/**
	 * 查询用户数量
	 * @return
	 */
	int queryUsersCount();

	/**
	 * 查询总条数（支持分页）
	 * @param u 用户
	 * @return
	 */
	int queryUsersCount(User u);
	
	/**
	 * 删除指定 id 的用户
	 * @param userId 用户 id
	 * @return int 影响行数
	 */
	int deleteUser(String userId);

	/**
	 * 查询所有的部门
	 * @return
	 */
	List<Department> findAllDepts();

	/**
	 * 查询所有的岗位
	 * @return
	 */
	List<Job> findAllJobs();

	/**
	 * 添加一个用户
	 * @param user
	 * @return int 影响行数
	 */
	int userAdd(User user);

	/**
	 * 查询指定 id 的用户
	 * @param loginId
	 * @return
	 */
	User queryUser(String loginId);

	/**
	 * 更新一个用户
	 * @param user
	 * @return int 影响行数
	 */
	int updateUser(User user);
	
	/**
	 * 根据用户名和密码查找用户
	 * @param loginId
	 * @param loginPassword
	 * @return
	 */
	User findUser(String loginId, String loginPassword);

	/**
	 * 根据岗位 id 获得此岗们的可操作的模块
	 * @param jobId
	 * @return
	 */
	List<Function> findFunctionsByJobId(int jobId);

	/**
	 * 根据岗位 id 和模块 id 获得左侧子功能列表
	 * @param jobId
	 * @param funcId
	 * @return
	 */
	List<Xtymb> findXtymbList(int jobId, int funcId);

	/**
	 * 查询数据库中是否已包含给定的用户名
	 * @param uname 查询的用户名
	 * @return
	 */
	boolean hasUser(String uname);
}
