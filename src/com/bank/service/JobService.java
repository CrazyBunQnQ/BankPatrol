package com.bank.service;

import java.util.List;

import com.bank.entity.Function;
import com.bank.entity.Gwym;
import com.bank.entity.Job;
import com.bank.entity.PageInfo;

public interface JobService {

	/**
	 * 获取岗位列表及分页信息
	 * @param page
	 * @return
	 */
	PageInfo<Job> getJobs(int page);

	/**
	 * 检查岗位名称是否存在
	 * @param name 岗位名称
	 * @return
	 */
	int hasJob(String name);

	/**
	 * 判断添加岗位是否成功
	 * @param job 岗位
	 * @return
	 */
	boolean addJob(Job job);

	/**
	 * 判断更新岗位是否成功
	 * @param job 岗位
	 * @return
	 */
	boolean updateJob(Job job);

	/**
	 * 获取制定权限的可操作页面和所属模块
	 * @param jobId 查询的岗位 id
	 * @param page 当前页
	 * @return
	 */
	PageInfo<Gwym> getGws(int jobId, int page);

	/**
	 * 获取所有模块列表
	 * @return
	 */
	List<Function> getFuns();

	/**
	 * 获取指定岗位 id 和模块 id 的所有权限列表
	 * @param jobId 岗位 id
	 * @param funcId 模块 id
	 * @return
	 */
	List<Gwym> getQXList(int jobId, int funcId);

}
