package com.bank.dao;

import java.util.List;

import com.bank.entity.PiGroup;
import com.bank.entity.PiWorker;

/**
 * 巡检工接口
 * 
 * @author lenovo
 *
 */
public interface PiWorkerDao {
	/**
	 * 添加巡检工
	 * @param pw
	 * @return
	 */
	public boolean addPiWorker(PiWorker pw);
	
	/**
	 * 根据id删除巡检工
	 * @param id
	 * @return
	 */
	public boolean deletePiWorker(int id);
	
	/**
	 * 分页查询巡检工
	 * @param pageSize
	 * @param pageNum
	 * @param piGroup
	 * @param tel1
	 * @param tel2
	 * @return
	 */
	public List<PiWorker> queryPiWorker(int pageSize, int pageNum, PiGroup piGroup, String tel1, String tel2);
	
	/**
	 * 修改巡检工
	 * @param pw
	 * @return
	 */
	public boolean updatePiWorker(PiWorker pw);
}
