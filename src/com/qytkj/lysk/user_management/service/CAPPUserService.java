/**   
 * 功能描述：
 * @Package: com.qytkj.lysk.user_management.service 
 * @author: hudaojin   
 * @date: 2018年3月27日 上午11:45:58 
 */
package com.qytkj.lysk.user_management.service;

import com.qytkj.lysk.user_management.domain.CAPPUser;
import com.qytkj.lysk.user_management.domain.User;

public interface CAPPUserService {

	/**
	 * 添加一个用户
	 * @param cAPPUser
	 */
	int addCAPPUser(CAPPUser cAPPUser);
	
	/**
	 * 验证登录
	 * @param loginName
	 * @param pass
	 * @return
	 */
	CAPPUser findUserByAccountAndPW(String loginName,String pass);
	
}
