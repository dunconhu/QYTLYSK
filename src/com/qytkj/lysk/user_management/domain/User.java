package com.qytkj.lysk.user_management.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 * 对应数据表 ht_tbluser
 * @author  s j
 * @Date 2018年03月23日上午9:36:23
 */
@SuppressWarnings("serial")
public class User implements Serializable{
	
	private Integer intId;//用户主键
	private String strLoginName;//登录名
	private String strPassword;//登录密码
	private String strStatus;//状态
	private String strRealName;//真实姓名
	private Date dateCreateTime;//创建时间
	public Integer getIntId() {
		return intId;
	}
	public void setIntId(Integer intId) {
		this.intId = intId;
	}
	public String getStrLoginName() {
		return strLoginName;
	}
	public void setStrLoginName(String strLoginName) {
		this.strLoginName = strLoginName;
	}
	public String getStrPassword() {
		return strPassword;
	}
	public void setStrPassword(String strPassword) {
		this.strPassword = strPassword;
	}
	public String getStrStatus() {
		return strStatus;
	}
	public void setStrStatus(String strStatus) {
		this.strStatus = strStatus;
	}
	public String getStrRealName() {
		return strRealName;
	}
	public void setStrRealName(String strRealName) {
		this.strRealName = strRealName;
	}
	public Date getDateCreateTime() {
		return dateCreateTime;
	}
	public void setDateCreateTime(Date dateCreateTime) {
		this.dateCreateTime = dateCreateTime;
	}
	@Override
	public String toString() {
		return "User [intId=" + intId + ", strLoginName=" + strLoginName + ", strPassword=" + strPassword
				+ ", strStatus=" + strStatus + ", strRealName=" + strRealName + ", dateCreateTime=" + dateCreateTime
				+ "]";
	}

}
