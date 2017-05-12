package com.bank.service.impl;

import java.util.List;

import com.bank.dao.BankDao;
import com.bank.dao.BankEquipmentDao;
import com.bank.dao.EquipmentTypeDao;
import com.bank.dao.impl.BankDaoImpl;
import com.bank.dao.impl.BankEquipmentDaoImpl;
import com.bank.dao.impl.EquipmentTypeDaoImpl;
import com.bank.entity.Bank;
import com.bank.entity.BankEquipment;
import com.bank.entity.EquipmentType;
import com.bank.entity.PageInfo;
import com.bank.service.BankService;

public class BankServiceImpl implements BankService {

	BankDao bdi = new BankDaoImpl();
	BankEquipmentDao bedi = new BankEquipmentDaoImpl();
	EquipmentTypeDao etdi = new EquipmentTypeDaoImpl();

	@Override
	public PageInfo<Bank> getBanks(int page) {
		PageInfo<Bank> data = new PageInfo<Bank>();
		data.setCurPage(page);
		List<Bank> banks = bdi.queryBanks(data.getFrom(), data.getPageSize());
		int count = bdi.queryBankesCount();
		data.setTotalRecord(count);
		data.setPagedata(banks);
		return data;
	}

	@Override
	public boolean insertBank(Bank bank) {
		return bdi.insertBank(bank) > 0;
	}

	@Override
	public int checkBankId(String id) {
		return bdi.hasBank(id) ? 1 : 0;
	}

	@Override
	public Bank getBank(String id) {
		return bdi.queryBank(id);
	}

	@Override
	public boolean updateBank(Bank bank) {
		return bdi.updateBank(bank) > 0;
	}

	@Override
	public PageInfo<BankEquipment> getEquipments(String bankId, int page) {
		PageInfo<BankEquipment> data = new PageInfo<BankEquipment>();
		data.setCurPage(page);
		List<BankEquipment> equipments = bedi.queryBankEquipments(bankId, data.getFrom(), data.getPageSize());
		int count = bedi.queryBankEquipmentsCount(bankId);
		data.setPagedata(equipments);
		data.setTotalPage(count);
		return data;
	}

	@Override
	public List<EquipmentType> getEquipmentTypes() {
		return etdi.queryTyps();
	}

	public int checkEquipmentId(String id) {
		return bedi.hasEquipmentId(id) ? 1 : 0;
	}

	@Override
	public boolean insertEquipment(BankEquipment be) {
		return bedi.insertBank(be) > 0;
	}
}
