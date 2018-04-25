package com.qytkj.lysk.user_management.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.qytkj.lysk.user_management.domain.User;

public interface UserDao {
	/**
	 * 根据id查询一个用户
	 * @param id
	 * @return
	 */
	User getById(Integer id);
	/**
	 * 根据id删除一个用户
	 * @param id
	 */
	void delById(Integer id);
	/**
	 * 动态更新用户
	 * @param user
	 */
	void update(User user);
	/**
	 * 增加一个用户
	 * @param user
	 */
	void save(User user);
	/**
	 * 根据分页信息（PageUtil）和过滤信息(User)动态查询用户
	 * @param params
	 * @return
	 */
	List<User> findByPage(Map<String,Object> params);
	/**
	 * 根据过滤条件，查询有多少个用户
	 * @param params
	 * @return
	 */
	int count(Map<String,Object> params);
	/**
	 * 根据登录名和密码查询用户
	 * @param loginName
	 * @param pass
	 * @return
	 */
	User findUserByAccountAndPW(@Param("strLoginName")String loginName,@Param("strPassword")String pass);
}

