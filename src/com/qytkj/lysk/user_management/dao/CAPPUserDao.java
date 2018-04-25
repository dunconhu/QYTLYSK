/**   
 * 功能描述：
 * @Package: com.qytkj.lysk.user_management.dao 
 * @author: hudaojin   
 * @date: 2018年3月27日 上午11:41:15 
 */
package com.qytkj.lysk.user_management.dao;

import org.apache.ibatis.annotations.Param;

import com.qytkj.lysk.user_management.domain.CAPPUser;

public interface CAPPUserDao {

	/**
	 * 增加一个用户
	 * @param user
	 */
	int addCAPPUser(CAPPUser cAPPUser);
	
	/**
	 * 根据登录名和密码查询用户
	 * @param loginName
	 * @param pass
	 * @return
	 */
	CAPPUser findUserByAccountAndPW(@Param("strLoginName")String loginName,@Param("strPassword")String pass);
	
	
}
