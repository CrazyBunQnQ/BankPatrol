package com.bank.dao;

import java.util.Date;
import java.util.List;

import com.bank.entity.PiEquipment;

//设备巡检接口
public interface XunjianDao {
	//设备巡检信息添加
	public boolean addXunjian(PiEquipment piEquipment);
	
	//根据id进行设备巡检信息删除（逻辑删除）
	public boolean deleteXunjian(int id);
	
	//根据网点查询设备巡检信息
	public List<PiEquipment> queryByBankId(int bankId);
	
	//根据巡检组查询设备巡检信息
	public List<PiEquipment> queryByGroupId(int groupId);
	
	//根据巡检日期查询设备巡检信息
	public List<PiEquipment> queryByDate(Date date);
		
	//根据巡检状态查询设备巡检信息
	public List<PiEquipment> queryByPIState(int piState);
	
	//根据设备状态查询设备巡检信息
	public List<PiEquipment> queryByEvaluateState(int evaluateState);
	
	//修改设备巡检信息
	public boolean updatePIEquipment(PiEquipment piEquipment);
}
