package com.bank.service.impl;

import java.util.List;

import com.bank.dao.impl.FunctionDaoImpl;
import com.bank.dao.impl.GwymDaoImpl;
import com.bank.dao.impl.JobDaoImpl;
import com.bank.entity.Function;
import com.bank.entity.Gwym;
import com.bank.entity.Job;
import com.bank.entity.PageInfo;
import com.bank.service.JobService;

public class JobServiceImpl implements JobService {
	JobDaoImpl jdi = new JobDaoImpl();
	GwymDaoImpl gdi = new GwymDaoImpl();
	FunctionDaoImpl fdi = new FunctionDaoImpl();

	@Override
	public PageInfo<Job> getJobs(int page) {
		PageInfo<Job> data = new PageInfo<Job>();
		data.setCurPage(page);
		List<Job> list = jdi.queryJobs(data.getFrom(), data.getPageSize());
		int count = jdi.queryJobsCount();
		data.setPagedata(list);
		data.setTotalRecord(count);
		return data;
	}

	@Override
	public int hasJob(String name) {
		return jdi.hasJob(name) ? 1 : 0;
	}

	@Override
	public boolean addJob(Job job) {
		return jdi.insertJob(job) > 0;
	}

	@Override
	public boolean updateJob(Job job) {
		return jdi.updateJob(job) > 0;
	}

	@Override
	public PageInfo<Gwym> getGws(int jobId, int page) {
		PageInfo<Gwym> data = new PageInfo<Gwym>();
		data.setCurPage(page);
		List<Gwym> gws = gdi.queryGwyms(jobId, data.getFrom(), data.getPageSize());
		int count = gdi.queryGwymsCount(jobId);
		data.setPagedata(gws);
		data.setTotalRecord(count);
		return data;
	}

	@Override
	public List<Function> getFuns() {
		List<Function> list = fdi.queryFunctions();
		return list;
	}

	@Override
	public List<Gwym> getQXList(int jobId, int funcId) {
		List<Gwym> list = gdi.queryAllGwyms(funcId);
		List<Gwym> someList = gdi.queryGwyms(jobId, funcId);
		for (int i = 0; i < list.size(); i ++) {
			for (int j = 0; j < someList.size(); j ++) {
				if (list.get(i).getXtymbId()==someList.get(j).getXtymbId()) {
					list.get(i).setIsOpen(true);
					break;
				}
			}
		}
		return list;
	}

	@Override
	public boolean updateXtyms(int jobId, int funcId, String[] ymbhs) {
		int[] ymbh = new int[ymbhs.length];
		for (int i = 0; i < ymbhs.length; i++) {
			ymbh[i] = Integer.parseInt(ymbhs[i]);
		}
		return gdi.updateXtyms(jobId, funcId, ymbh) > 0;
	}
}
