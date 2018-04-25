/**   
 * 功能描述：
 * @Package: com.qytkj.lysk.user_management.service.impl 
 * @author: hudaojin   
 * @date: 2018年3月27日 上午11:47:54 
 */
package com.qytkj.lysk.user_management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qytkj.lysk.user_management.dao.CAPPUserDao;
import com.qytkj.lysk.user_management.domain.CAPPUser;
import com.qytkj.lysk.user_management.service.CAPPUserService;

@Service
@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
public class CAPPUserServiceImpl implements CAPPUserService {

	@Autowired
	private CAPPUserDao cAPPUserDao;
	
	@Override
	public int addCAPPUser(CAPPUser cAPPUser) {
		
		return cAPPUserDao.addCAPPUser(cAPPUser);
	}
	
	@Override
	public CAPPUser findUserByAccountAndPW(String loginName, String pass) {
		return cAPPUserDao.findUserByAccountAndPW(loginName, pass);
	}

	
}
