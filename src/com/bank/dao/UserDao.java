package com.bank.dao;

import java.util.List;

import com.zrkc.syyh.model.UserModel;

public interface UserDao {

	List<UserModel> findListByPage(int from, int pageSize);

	int findCount();

}
