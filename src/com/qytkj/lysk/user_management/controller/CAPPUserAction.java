/**   
 * 功能描述：
 * @Package: com.qytkj.lysk.user_management.controller 
 * @author: hudaojin   
 * @date: 2018年3月27日 上午11:56:17 
 */
package com.qytkj.lysk.user_management.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConstants;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.qytkj.lysk.alipay.util.AlipayUtil;
import com.qytkj.lysk.alipay.util.PayUtil;
import com.qytkj.lysk.user_management.domain.CAPPUser;
import com.qytkj.lysk.user_management.service.CAPPUserService;
import com.alipay.config.AlipayConfig;
import com.alipay.util.UtilDate;

@Controller
public class CAPPUserAction {

	@Autowired
	private CAPPUserService cAPPUserService;
	
	/**
	* @Description: APP用户注册
	* @param:phoneNum:手机号，password:密码，nickname:昵称
	* @return：0 用户名或密码为空,1 注册成功,-1注册失败,2手机号码已存在 
	*/
	@RequestMapping("/cAPPRegister")
	@ResponseBody
	public String addCAPPUser(@RequestParam("phone")String phoneNum,
			@RequestParam("password")String password,@RequestParam("nickname")String nickname){
		//return 0 用户名或密码为空
		//return 1 注册成功
		//return -1注册失败
		//return 2手机号码已存在
		if(phoneNum==null||phoneNum.trim()==""||password==null||password.trim()==""||nickname.trim()==null||nickname.trim()==""){
			return "0";
		}
		//获取当前时间
		Date date = new Date();
		
		CAPPUser cAPPUser = new CAPPUser();
		cAPPUser.setStrPhoneNum(phoneNum);
		cAPPUser.setStrPassword(password);
		cAPPUser.setStrNickname(nickname);
		cAPPUser.setIntStatus(1);
		cAPPUser.setDateCreateTime(date);
		int res = cAPPUserService.addCAPPUser(cAPPUser);
		//System.out.println(res);
		if(res > 0){
			return "1";
		}else if (res == 0) {
			return "2";
		}else{
			return "-1";
		}
		
	}
	
	/**
	 * @param 登录校验
	 * @return return 1 用户名或密码为空||return 2用户名或密码错误||return 3 登录成功
	 */
	@RequestMapping("/cAPPLogin")
	@ResponseBody
	public String cAPPLogin(@RequestParam("username")String username,
			@RequestParam("password")String password,
			HttpSession session){
		
		if(username==null||username.trim()==""||
				password==null||password.trim()==""){
			return "1";
		}
		
		CAPPUser cAPPUser=cAPPUserService.findUserByAccountAndPW(username.trim(), password.trim());
		if(cAPPUser!=null){
			session.setAttribute("cAPPUser", cAPPUser);
			return "3";
		}
		return "2";
	}
	
	/**
	 * app用户退出登录操作
	 */
	@RequestMapping("/cAPPLogout")
	@ResponseBody
	public String logout(HttpSession session){
		session.removeAttribute("cAPPUser");
		return "1";
	}
	
	/**
	 * 
	* @Description: 获取APP传进来的订单数据，返回组装加签订单
	*
	* @param:content:订单描述；title:订单标题；totalAmount:订单总金额
	* @return：orderStr:返回组装加签并编码好的订单
	* @throws：异常描述
	* 
	* @version: v1.0.0
	* @author: hudaojin
	* @date: 2018年4月15日 上午8:59:40 
	*
	 */
	@RequestMapping("/cAPPAliPay")
	@ResponseBody
	public String cAPPAliPay(@RequestParam("content")String content,
			@RequestParam("title")String title,@RequestParam("totalAmount")String totalAmount){
		String orderStr = "";
		Map<String, Object> pcont = new HashMap<>();
        // 支付业务请求参数
        pcont.put("body", content);// 对交易或商品的描述
        pcont.put("out_trade_no", UtilDate.getOrderNum()); // 商户订单号
        pcont.put("product_code", "QUICK_MSECURITY_PAY");// 销售产品码       
        pcont.put("seller_id", AlipayUtil.SELLER_ID);
        pcont.put("subject", title); // 订单标题
        pcont.put("timeout_express", "30m");//超时
        pcont.put("total_amount", totalAmount);// 交易金额
		
		Map<String, String> param = new HashMap<>();
        // 公共请求参数
        param.put("app_id", AlipayUtil.ALIPAY_APPID);// 商户订单号
        param.put("biz_content", JSON.toJSONString(pcont)); // 业务请求参数  不需要对json字符串转义 
        param.put("charset", AlipayConstants.CHARSET_UTF8);//编码
        param.put("format", AlipayConstants.FORMAT_JSON);//格式
        param.put("method", "alipay.trade.app.pay");// 交易金额
        param.put("notify_url", "http://yhui3m.natappfree.cc/QYTLYSK/cAPPAlipayNotify"); // 支付宝服务器主动通知商户服务
        param.put("sign_type", AlipayConstants.SIGN_TYPE_RSA2);//签名算法
        param.put("timestamp", UtilDate.getDateFormatter());//时间戳
        param.put("version", "1.0");//版本号               
        
        try {
            param.put("sign", PayUtil.getSign(param, AlipayUtil.APP_PRIVATE_KEY)); // 业务请求参数，进行签名
            orderStr = PayUtil.getSignEncodeUrl(param, true);//将签名后的请求参数进行编码
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(orderStr);
		return orderStr;
	}
	
	@RequestMapping("/cAPPAliPayTest")
	@ResponseBody
	public String cAPPAliPayTest(){
		Map<String, Object> pcont = new HashMap<>();
        // 支付业务请求参数
        pcont.put("body", "hdj");// 对交易或商品的描述
        pcont.put("out_trade_no", UtilDate.getOrderNum()); // 商户订单号
        pcont.put("product_code", "QUICK_MSECURITY_PAY");// 销售产品码       
        pcont.put("seller_id", AlipayUtil.SELLER_ID);
        pcont.put("subject", "测试支付"); // 订单标题
        pcont.put("timeout_express", "30m");//超时
        pcont.put("total_amount", "0.01");// 交易金额
		
		Map<String, String> param = new HashMap<>();
        // 公共请求参数
        param.put("app_id", AlipayUtil.ALIPAY_APPID);// 商户订单号
        param.put("biz_content", JSON.toJSONString(pcont)); // 业务请求参数  不需要对json字符串转义 
        param.put("charset", AlipayConstants.CHARSET_UTF8);//编码
        param.put("format", AlipayConstants.FORMAT_JSON);//格式
        param.put("method", "alipay.trade.app.pay");// 交易金额
        param.put("notify_url", "http://x3imis.natappfree.cc/QYTLYSK/notify_url.jsp"); // 支付宝服务器主动通知商户服务
        param.put("sign_type", AlipayConstants.SIGN_TYPE_RSA2);//签名算法
        param.put("timestamp", UtilDate.getDateFormatter());//时间戳
        param.put("version", "1.0");//版本号        
       
//        /**
//         * 测试编码前的数据
//         */
//        String sTmp = null;
//        sTmp = "app_id=" + AlipayUtil.ALIPAY_APPID + 
//        		"&biz_content=" + JSON.toJSONString(pcont) + 
//        		"&charset=" + AlipayConstants.CHARSET_UTF8 + 
//        		"&format=" + AlipayConstants.FORMAT_JSON + 
//        		"&method=" + "alipay.trade.app.pay" + 
//        		"&notify_url=" + "http://x3imis.natappfree.cc/QYTLYSK/notify_url.jsp" + 
//        		"&sign_type=" + AlipayConstants.SIGN_TYPE_RSA2 + 
//        		"&timestamp=" + UtilDate.getDateFormatter() + 
//        		"&version=1.0" ; 
//        System.out.println(String.format("sTmp=[%s]", sTmp));
        /////////////////////////////////////////////////////////////////////////////////////////

        
        Map<String, String> payMap = new HashMap<>();
        try {
            param.put("sign", PayUtil.getSign(param, AlipayUtil.APP_PRIVATE_KEY)); // 业务请求参数
            //System.out.println(String.format("biz_content[%s]", URLDecoder.decode(param.get("biz_content"))));
            payMap.put("orderStr", PayUtil.getSignEncodeUrl(param, true));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(payMap.get("orderStr"));
		return payMap.get("orderStr");
	}
	
	/**
	 * 
	* @Description: 支付宝支付成功的回调通知
	*
	* @return：跳转到notify_url.jsp界面
	*
	* @version: v1.0.0
	* @author: hudaojin
	* @date: 2018年4月19日 上午8:59:40 
	*
	 */
	@RequestMapping("/cAPPAliPayNotify")
	public ModelAndView cAPPAliPayNotify(){
		return new ModelAndView("/notify_url");
	}
	
	
}
