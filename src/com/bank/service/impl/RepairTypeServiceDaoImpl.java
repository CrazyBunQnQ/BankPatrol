package com.bank.service.impl;

import java.util.List;

import com.bank.dao.RepairTypeDao;
import com.bank.dao.impl.RepairTypeDaoImpl;
import com.bank.entity.PageInfo;
import com.bank.entity.RepairType;
import com.bank.service.RepairTypeServiceDao;

public class RepairTypeServiceDaoImpl implements RepairTypeServiceDao {

	RepairTypeDao rtdi = new RepairTypeDaoImpl();
	
	@Override
	public PageInfo<RepairType> queryRepairType(int pageNum,String PITYPE_Value) {
		PageInfo<RepairType> pageInfo = new PageInfo<RepairType>();
		List<RepairType> repairType = rtdi.queryRepairType(pageInfo.getPageSize(), pageNum);
		pageInfo.setCurPage(pageNum);
		pageInfo.setPagedata(repairType);
		int count = rtdi.countRepairType(PITYPE_Value);
		int totalPage = (int)Math.ceil((double)count/pageInfo.getPageSize());
		pageInfo.setTotalPage(totalPage);
		pageInfo.setTotalRecord(count);
		return pageInfo;
	}

	@Override
	public PageInfo<RepairType> queryRepairTypeByPiType_Value(int pageNum, String PITYPE_Value) {
		PageInfo<RepairType> pageInfo = new PageInfo<RepairType>();
		List<RepairType> repairType = rtdi.queryRepairTypeByPiType_Value(pageInfo.getPageSize(), pageNum, PITYPE_Value);
		pageInfo.setCurPage(pageNum);
		pageInfo.setPagedata(repairType);
		int count = rtdi.countRepairType(PITYPE_Value);
		int totalPage = (int)Math.ceil((double)count/pageInfo.getPageSize());
		pageInfo.setTotalPage(totalPage);
		pageInfo.setTotalRecord(count);
		return pageInfo;
	}

	@Override
	public boolean addRepairType(RepairType repairType) {
		return rtdi.addRepairType(repairType);
	}

	@Override
	public boolean deleteRepairType(int id) {
		return rtdi.deleteRepairType(id);
	}

	@Override
	public boolean updateRepairType(RepairType repairType) {
		return rtdi.updateRepairType(repairType);
	}

	@Override
	public boolean hasType(String PITYPE_Value) {
		return rtdi.hasType(PITYPE_Value);
	}

	@Override
	public RepairType repairType2Update(int id) {
		return rtdi.queryRepairTypeById(id);
	}

}
