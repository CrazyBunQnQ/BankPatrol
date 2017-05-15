package com.bank.service;


import com.bank.entity.PageInfo;
import com.bank.entity.PiGroup;


public interface PiGroupSeviceDao {

	//查询所有巡检组信息
	public PageInfo<PiGroup> queryPiGroup(int pageNum);
	
	//添加巡检组信息
	public boolean addPiGroup(PiGroup piGroup);
	
	//删除巡检组信息
	public boolean deletePiGroup(long id);
	
	//修改巡检组信息
	public boolean updatePiGroup(PiGroup piGroup);
}
