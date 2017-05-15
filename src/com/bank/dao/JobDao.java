package com.bank.dao;

import java.util.List;

import com.bank.entity.Job;

public interface JobDao {

	/**
	 * 查询岗位的数量
	 * @return
	 */
	int queryJobsCount();
	
	/**
	 * 查询岗位
	 * @param page 当前页（第一页为0）
	 * @param count 每页显示数量
	 * @return List
	 */
	List<Job> queryJobs(int page, int count);
	
	/**
	 * 增加岗位
	 * @param job
	 * @return int 影响行数
	 */
	int insertJob(Job job);
	
	/**
	 * 更新岗位（不更新 id 和 group）
	 * @param job
	 * @return int 影响行数
	 */
	int updateJob(Job job);
	
	/**
	 * 删除指定 id 的岗位
	 * @param jobId 要删除的岗位 id
	 * @return int 影响行数
	 */
	int deleteJob(int jobId);

}
