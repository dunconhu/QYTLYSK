package com.qytkj.lysk.user_management.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.qytkj.lysk.common.util.PageUtil;
import com.qytkj.lysk.user_management.domain.User;
import com.qytkj.lysk.user_management.service.UserService;

/**
 * @function UserAction
 * @author s j
 *
 */
@Controller
public class UserAction {

	@Autowired
	private UserService userService;
	
	/**
	 * @param 返回登录页面
	 * @return
	 */
	@RequestMapping("/{pageName}")
	public String login(@PathVariable("pageName")String pageName){
		return pageName;
	}
	
	/**
	 * @param 登录校验
	 * @return return 1 用户名或密码为空||return 2用户名或密码错误||return 3 登录成功
	 */
	@RequestMapping("/loginCheck")
	@ResponseBody
	public String loginCheck(@RequestParam("username")String username,
			@RequestParam("password")String password,
			HttpSession session){
		
		if(username==null||username.trim()==""||
				password==null||password.trim()==""){
			return "1";
		}
		User user=userService.findUserByAccountAndPW(username.trim(), password.trim());
		if(user!=null){
			session.setAttribute("user", user);
			return "3";
		}
		return "2";
	}
	
	/**
	 * @param 注销
	 * @return 登陆页
	 */
	@RequestMapping("/login_logout")
	public String logOut(HttpSession session){
		session.invalidate();
		return "login";
	}
	
	/**
	 * @param 用户列表
	 * @return 
	 */
	@RequestMapping("/user/backstageUserList")
	public String listPage(){
		return "user/backstageUserList";
	}
	
	/**
	 * @param 分页查询
	 * @return 
	 */
	@RequestMapping("/user/paginationFun")
	@ResponseBody
	public Map<String,Object> paginationList(
			@RequestParam(value="pageIndex",required=false)String pageIndex ,
			@RequestParam(value="pageSize",required=false)String pageSize ,
			@RequestParam(value="strLoginName",required=false)String loginName ,
			@RequestParam(value="strRealName",required=false)String strRealName ,
			@RequestParam(value="dateCreateTime",required=false)String dateCreateTime ,
			@RequestParam(value="strStatus",required=false)String strStatus){
		//初始化分页信息和过滤信息
		if(pageIndex==null){
			pageIndex="1";
		}
		if(pageSize==null){
			pageSize="20";
		}
		Map<String,Object> params=new HashMap<String,Object>();
		PageUtil page=new PageUtil();
		page.setPageIndex(Integer.parseInt(pageIndex));
		page.setPageSize(Integer.parseInt(pageSize));
		page.setStartNum((page.getPageIndex()-1)*page.getPageSize());
		User user=new User();
		if(loginName!=null){
			user.setStrLoginName(loginName.trim());			
		}
		if(strRealName!=null){
			user.setStrRealName(strRealName.trim());			
		}
		Date createDate=null;
		if(dateCreateTime!=null){
			try {
				createDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateCreateTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		user.setDateCreateTime(createDate);
		if(strStatus != null){
			user.setStrStatus(strStatus);				
		}
		params.put("page", page);
		if(user.getDateCreateTime()==null
				&&user.getStrRealName()==null
				&&user.getStrLoginName()==null){	
		}else{
			params.put("user", user);
		}
		//根据分页信息和过滤信息进行查询
		List<User> users = userService.getByPage(params);
		params.remove("user");
		int count=userService.count(params);
		page.setCount(count);
		Map<String,Object> result=new HashMap<String,Object>();
		result.put("total", page.getCount());
		result.put("rows", users);
		//System.out.println(result.toString());
		
		return result;
	}
	
	/**
	 * @param 增加用户
	 * @return 增加用户页面
	 */
	@RequestMapping("/user/addBackstageUser")
	public ModelAndView add(ModelAndView mav){
		mav.setViewName("user/addBackstageUser");
		return mav;
	}
	

	
	
}

