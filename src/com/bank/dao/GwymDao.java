package com.bank.dao;

import java.util.List;

import com.bank.entity.Gwym;

public interface GwymDao {

	/**
	 * 查询指定岗位的可操作页面编号、可操作页面和可操作模块
	 * @param jobId 岗位 id
	 * @param page 当前页
	 * @param count 每页显示数量
	 * @return List
	 */
	List<Gwym> queryGwyms(int jobId, int page, int count);
	
	/**
	 * 查询指定岗位、指定操作模块的可操作页面编号和名称（分页）
	 * @param jobId 岗位 id
	 * @param funId 模块 id
	 * @param page 当前页
	 * @param count 每页显示数量
	 * @return List
	 */
	List<Gwym> queryGwyms(int jobId, int funId, int page, int count);
	
	/**
	 * 获取指定岗位的权限数量
	 * @param jobId 岗位 id
	 * @return
	 */
	int queryGwymsCount(int jobId);
	
	/**
	 * 查询指定模块的所有的操作页面编号和名称（分页）
	 * @param funId 模块 id
	 * @param page 当前页
	 * @param count 每页显示数量
	 * @return List
	 */
	List<Gwym> queryAllGwyms(int funId, int page, int count);
	
	/**
	 * 给指定岗位添加指定的子功能数组
	 * @param jobId 岗位 id
	 * @param ymbh 子功能 id 数组
	 * @return int 影响行数
	 */
	int insertGwyms(int jobId, int[] ymbh);
	
	/**
	 * 删除指定岗位的某些子功能
	 * @param jobId 岗位 id
	 * @param ymbh 子功能 id 数组
	 * @return int 影响行数
	 */
	int deleteGwyms(int jobId, int[] ymbh);

	/**
	 * 查询指定模块的所有 权限（不分页）
	 * @param funId 模块 id
	 * @return
	 */
	List<Gwym> queryAllGwyms(int funId);

	/**
	 * 查询指定岗位 id 和模块 id 的所有权限（不分页）
	 * @param jobId 岗位 id
	 * @param funId 模块 id
	 * @return
	 */
	List<Gwym> queryGwyms(int jobId, int funId);

}
