package com.bank.service;

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

}
