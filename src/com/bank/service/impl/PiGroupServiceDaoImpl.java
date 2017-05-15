package com.bank.service.impl;

import java.util.List;

import com.bank.dao.PiGroupDao;
import com.bank.dao.impl.PiGroupDaoImpl;
import com.bank.entity.PageInfo;
import com.bank.entity.PiGroup;
import com.bank.entity.PiWorker;
import com.bank.service.PiGroupSeviceDao;

public class PiGroupServiceDaoImpl implements PiGroupSeviceDao {

	PiGroupDao pgd = new PiGroupDaoImpl();
	@Override
	public PageInfo<PiGroup> queryPiGroup(int pageNum) {
		PageInfo<PiGroup> pageInfo = new PageInfo<PiGroup>();
		List<PiGroup> piGroups = pgd.queryPiGroup(pageInfo.getPageSize(), pageNum);
		pageInfo.setCurPage(pageNum);
		pageInfo.setPagedata(piGroups);
		int count = pgd.countPiGruop();
		int totalPage = (int)Math.ceil((double)count/pageInfo.getPageSize());
		pageInfo.setTotalPage(totalPage);
		pageInfo.setTotalRecord(count);
		return pageInfo;
	}

	@Override
	public boolean addPiGroup(PiGroup piGroup) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePiGroup(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePiGroup(PiGroup piGroup) {
		// TODO Auto-generated method stub
		return false;
	}

}
