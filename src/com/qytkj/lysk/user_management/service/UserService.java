package com.qytkj.lysk.user_management.service;

import java.util.List;
import java.util.Map;

import com.qytkj.lysk.user_management.domain.User;

public interface UserService {
	/**
	 * 验证登录
	 * @param loginName
	 * @param pass
	 * @return
	 */
	User findUserByAccountAndPW(String loginName,String pass);
	/**
	 * 添加一个用户
	 * @param user
	 */
	void save(User user);
	/**
	 * 根据id查找用户
	 * @param id
	 * @return
	 */
	User getById(int id);
	/**
	 * 根据id删除用户
	 * @param id
	 */
	void delById(int id);
	/**
	 * 动态更新用户信息
	 * @param user
	 */
	void update(User user);
	/**
	 * 根据过滤条件查询符合条件用户的数量
	 * @param params
	 * @return
	 */
	
	int count(Map<String,Object> params);
	/**
	 * 根据过滤条件和分页信息查询用户
	 * @param params
	 * @return
	 */
	List<User> getByPage(Map<String,Object> params);
	
	
}

