package com.bank.service;

import com.bank.entity.PageInfo;
import com.bank.entity.PiWorker;

public interface PIWorkerServiceDao {

	/**
	 * 分页查询巡检工
	 * @param pageNum
	 * @param condition
	 * @return
	 */
	public PageInfo<PiWorker> queryPiWoker(int pageNum, String condition);
	
	/**
	 * 添加巡检工
	 * @param piWorker
	 * @return
	 */
	public boolean addPiWorker(PiWorker piWorker);
	
	/**
	 * 删除巡检工
	 * @param id
	 * @return
	 */
	public boolean deletePiWorker(long id);
	
	/**
	 * 更新巡检工信息
	 * @param piWorker
	 * @return
	 */
	public boolean updatePiWorker(PiWorker piWorker);
	
	/**
	 * 添加时确认是否有该用户
	 * @param id
	 * @return
	 */
	public boolean hasUser(long id);

	/**
	 * 判断巡检工表中是否存在该用户
	 * @param workId
	 * @return
	 */
	public boolean hasUserInPiWorker(long workId);

	/**
	 * 根据id查询巡检工信息
	 * @param id
	 * @return
	 */
	public PiWorker getPiWorkerById(long id);
}
