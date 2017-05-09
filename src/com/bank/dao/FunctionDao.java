package com.bank.dao;

import java.util.List;

import com.bank.entity.Function;

public interface FunctionDao {

	/**
	 * 查询功能列表
	 * @return 数据集
	 */
	List<Function> queryFunctions();
}
