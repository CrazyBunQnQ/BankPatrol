package com.bank.service.impl;

import java.util.List;

import com.bank.dao.PiWorkerDao;
import com.bank.dao.impl.PiWorkerDaoImpl;
import com.bank.entity.PageInfo;
import com.bank.entity.PiWorker;
import com.bank.service.PIWorkerServiceDao;

public class PiWorkerServiceDaoImpl implements PIWorkerServiceDao {
	PiWorkerDao piWorkerDao = new PiWorkerDaoImpl();
	//获取部门分页对象
	@Override
	public PageInfo<PiWorker> queryPiWoker(int pageNum, String condition) {
		//获取巡检工分页对象
		PageInfo<PiWorker> pageInfo = new PageInfo<PiWorker>();
		//创建对象
		List<PiWorker> piWorkers = piWorkerDao.queryPiWorker(pageInfo.getPageSize(), pageNum, condition);
		//设置巡检工信息
		pageInfo.setPagedata(piWorkers);
		//定义部门总条数
		int count = piWorkerDao.countPiWorker(condition);
		//获取部门信息总页数
		int totalPage = (int)Math.ceil((double)count/pageInfo.getPageSize());
		//设置总页数
		pageInfo.setTotalPage(totalPage);
		//设置总条数
		pageInfo.setTotalRecord(count);
		return pageInfo;
	}

	//添加巡检工
	@Override
	public boolean addPiWorker(PiWorker piWorker) {
		return piWorkerDao.addPiWorker(piWorker);
	}

	//删除巡检工
	@Override
	public boolean deletePiWorker(long id) {
		return piWorkerDao.deletePiWorker(id);
	}

	//更新巡检工
	@Override
	public boolean updatePiWorker(PiWorker piWorker) {
		return piWorkerDao.updatePiWorker(piWorker);
	}

	//判断是否存在该用户
	@Override
	public boolean hasUser(long id) {
		return piWorkerDao.hasUser(id);
	}

	//判断巡检工中是否存在该用户
	@Override
	public boolean hasUserInPiWorker(long workId) {
		return piWorkerDao.hasInPiWorker(workId);
	}

	//通过id查询巡检工
	@Override
	public PiWorker getPiWorkerById(long id) {
		return piWorkerDao.getPiWorkerById(id);
	}
}
