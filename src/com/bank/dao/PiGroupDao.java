package com.bank.dao;

import java.util.List;

import com.bank.entity.PiGroup;

/**
 * 巡检组接口
 * 
 * @author lenovo
 *
 */
public interface PiGroupDao {

	/**
	 * 添加巡检组
	 * @param PiGroup
	 * @return
	 */
	public boolean addPiGroup(PiGroup PiGroup);
	
	/**
	 * 根据id删除巡检组
	 * @param id
	 * @return
	 */
	public boolean deletePiGroup(int id);
	
	/**
	 * 分页查询巡检组
	 * @param pageSize
	 * @param pageNum
	 * @param Group_Name
	 * @return
	 */
	public List<PiGroup> queryPiGroup(int pageSize, int pageNum);
	
	/**
	 * 修改巡检组
	 * @param PiGroup
	 * @return
	 */
	public boolean updatePiGroup(PiGroup PiGroup);
	
	/**
	 * 获取所有巡检小组
	 * @return
	 */
	public List<PiGroup> getAllGroup();
	
	/**
	 * 获取巡检组小组数量
	 * @return
	 */
	public int countPiGruop();
}

