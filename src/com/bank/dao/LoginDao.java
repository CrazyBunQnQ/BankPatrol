package com.bank.dao;

import java.util.List;

import com.bank.entity.Function;
import com.bank.entity.User;
import com.bank.entity.Xtymb;
/**
 * 
 * @author Qu
 *
 */
public interface LoginDao {

	public User findUser(String loginId, String loginPassword);

	public List<Function> findFunctionsByJobId(Long jobId);

	public List<Xtymb> findXtymbList(long jobId, long funcId);


	

	

}
