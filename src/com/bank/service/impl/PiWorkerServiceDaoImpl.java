package com.bank.service.impl;

import java.util.List;

import com.bank.dao.PiWorkerDao;
import com.bank.dao.impl.PiWorkerDaoImpl;
import com.bank.entity.PageInfo;
import com.bank.entity.PiWorker;
import com.bank.service.PIWorkerServiceDao;

public class PiWorkerServiceDaoImpl implements PIWorkerServiceDao {
	
	PiWorkerDao piWorkerDao = new PiWorkerDaoImpl();
	
	@Override
	public PageInfo<PiWorker> queryPiWoker(int pageNum, String condition) {
		PageInfo<PiWorker> pageInfo = new PageInfo<PiWorker>();
		List<PiWorker> piWorkers = piWorkerDao.queryPiWorker(pageInfo.getPageSize(), pageNum, condition);
		pageInfo.setPagedata(piWorkers);
		int count = piWorkerDao.countPiWorker(condition);
		int totalPage = (int)Math.ceil((double)count/pageInfo.getPageSize());
		pageInfo.setTotalPage(totalPage);
		pageInfo.setTotalRecord(count);
		return pageInfo;
	}

	@Override
	public boolean addPiWorker(PiWorker piWorker) {

		return piWorkerDao.addPiWorker(piWorker);
	}

	@Override
	public boolean deletePiWorker(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePiWorker(PiWorker piWorker) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasUser(long id) {
		return piWorkerDao.hasUser(id);
	}

}
