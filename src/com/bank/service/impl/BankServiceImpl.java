package com.bank.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bank.dao.impl.BankDaoImpl;
import com.bank.dao.impl.GwymDaoImpl;
import com.bank.entity.Bank;
import com.bank.service.BankService;
import com.google.gson.Gson;

public class BankServiceImpl implements BankService{
	
	private static final Logger LOGGER = LogManager.getLogger(GwymDaoImpl.class.getName());
	BankDaoImpl bdi = new BankDaoImpl();
	
	@Override
	public String getBanks(int page, int count) throws SQLException {
		List<Bank> banks = bdi.queryBanks(page, count);
		String data = new Gson().toJson(banks);
		LOGGER.info("银行网点第 " + (page + 1) + " 页的 " + count + " 个网点数据：" + data);
		return data;
	}
}
