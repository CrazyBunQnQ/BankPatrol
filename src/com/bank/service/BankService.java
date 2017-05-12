package com.bank.service;

import java.sql.SQLException;
import java.util.List;

import com.bank.entity.Bank;
import com.bank.entity.BankEquipment;
import com.bank.entity.EquipmentType;
import com.bank.entity.PageInfo;

public interface BankService {

	/**
	 * 获取银行列表信息的 Page 信息，包括页数等
	 * 
	 * @param page
	 *            当前页
	 * @return PageInfo 包括当前页内容和总页数等
	 * @throws SQLException
	 */
	PageInfo<Bank> getBanks(int page) throws SQLException;

	/**
	 * 添加银行
	 * 
	 * @param bank
	 *            待添加的银行
	 * @return 是否成功
	 */
	boolean insertBank(Bank bank);

	/**
	 * 检查指定银行 id 是否已存在
	 * 
	 * @param id
	 *            银行 id
	 * @return 1：已存在；0：不存在
	 */
	int checkBankId(String id);

	/**
	 * 根据 id 获取指定银行的信息
	 * 
	 * @param id
	 *            银行 id
	 * @return
	 */
	Bank getBank(String id);

	/**
	 * 更新指定 id 的银行信息
	 * 
	 * @param bank
	 *            银行
	 * @return
	 */
	boolean updateBank(Bank bank);

	/**
	 * 根据银行 id 查询该银行下的所有设备
	 * 
	 * @param bankId
	 *            银行 id
	 * @param page
	 *            当前页数
	 * @return PageInfo 包括当前页内容和总页数等
	 */
	PageInfo<BankEquipment> getEquipments(String bankId, int page);

	/**
	 * 获取银行的设备类型列表
	 * @return
	 */
	List<EquipmentType> getEquipmentTypes();

	/**
	 * 给指定 id 的银行添加设备
	 * @param be
	 * @return
	 */
	boolean insertEquipment(BankEquipment be);
}
