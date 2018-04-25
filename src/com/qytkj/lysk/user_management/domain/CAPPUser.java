/**   
 * 功能描述：用户端APP的实体类
 * @Package: com.qytkj.lysk.user_management.domain 
 * @author: hudaojin   
 * @date: 2018年3月27日 上午10:28:47 
 */
package com.qytkj.lysk.user_management.domain;

import java.io.Serializable;
import java.util.Date;


/**
* @version: v1.0.0
* @author: hudaojin
* @date: 2018年3月27日 上午10:28:47 
*
* Modification History:
* Date         Author          Version       Description
*---------------------------------------------------------*
* 2018年3月27日     hudaojin         v1.0.0        创建用户端APP实体类
*/
public class CAPPUser implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int intId;//用户主键
	private String strPhoneNum;//用户手机号
	private String strPassword;//用户密码
	private String strNickname;//用户昵称
	private int intStatus;//状态
	private Date dateCreateTime;//创建时间
	private String strHeadPortrait;//用户头像
	private int intSex;//性别
	private String strInstitution;//机构
	private String strAddress;//地址
	
	public int getIntId() {
		return intId;
	}
	public void setIntId(int intId) {
		this.intId = intId;
	}
	public String getStrPhoneNum() {
		return strPhoneNum;
	}
	public void setStrPhoneNum(String strPhoneNum) {
		this.strPhoneNum = strPhoneNum;
	}
	public String getStrPassword() {
		return strPassword;
	}
	public void setStrPassword(String strPassword) {
		this.strPassword = strPassword;
	}
	public String getStrNickname() {
		return strNickname;
	}
	public void setStrNickname(String strNickname) {
		this.strNickname = strNickname;
	}
	public int getIntStatus() {
		return intStatus;
	}
	public void setIntStatus(int intStatus) {
		this.intStatus = intStatus;
	}
	//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getDateCreateTime() {
		return dateCreateTime;
	}
	public void setDateCreateTime(Date dateCreateTime) {
		this.dateCreateTime = dateCreateTime;
	}
	public String getStrHeadPortrait() {
		return strHeadPortrait;
	}
	public void setStrHeadPortrait(String strHeadPortrait) {
		this.strHeadPortrait = strHeadPortrait;
	}
	public int getIntSex() {
		return intSex;
	}
	public void setIntSex(int intSex) {
		this.intSex = intSex;
	}
	public String getStrInstitution() {
		return strInstitution;
	}
	public void setStrInstitution(String strInstitution) {
		this.strInstitution = strInstitution;
	}
	public String getStrAddress() {
		return strAddress;
	}
	public void setStrAddress(String strAddress) {
		this.strAddress = strAddress;
	}
	
	@Override
	public String toString() {
		return "CAPPUser [intId=" + intId + ", strPhoneNum=" + strPhoneNum + ", strPassword=" + strPassword
				+ ", strNickname=" + strNickname + ", intStatus=" + intStatus + ", dateCreateTime=" + dateCreateTime
				+ ", strHeadPortrait=" + strHeadPortrait + ", intSex=" + intSex + ", strInstitution=" + strInstitution
				+ ", strAddress=" + strAddress + "]";
	}
	
	
}
