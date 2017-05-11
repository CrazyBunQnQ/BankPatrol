package com.bank.service.impl;

import java.util.List;

import com.bank.dao.BankDao;
import com.bank.dao.impl.BankDaoImpl;
import com.bank.entity.Bank;
import com.bank.entity.PageInfo;
import com.bank.service.BankService;

public class BankServiceImpl implements BankService {

	BankDao bdi = new BankDaoImpl();

	@Override
	public PageInfo<Bank> getBanks(int page) {
		PageInfo<Bank> data = new PageInfo<Bank>();
		data.setCurPage(page);
		List<Bank> banks = bdi.queryBanks(page, data.getPageSize());
		int num = bdi.queryBankesCount();
		data.setTotalRecord(num);
		data.setPagedata(banks);
		return data;
	}

	@Override
	public boolean insertBank(Bank bank) {
		return bdi.insertBank(bank) > 0;
	}

	@Override
	public int checkBankId(String id) {
		return bdi.hasBank(id)?1:0;
	}
}
