package com.qytkj.lysk.user_management.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.qytkj.lysk.user_management.domain.User;

public class AuthorizedInterceptor implements HandlerInterceptor {
	private static final String[] LOGIN_URI={"/login","/loginCheck","/404.html","/cAPPLogin","/cAPPRegister","/cAPPAliPay","/cAPPAliPayTest"};
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		boolean flag=false;
		String servletPath=request.getServletPath();
		for(String path:LOGIN_URI){
			if(servletPath.contains(path)){
				flag=true;
				break;
			}
		}
		if(!flag){
			User user=(User)request.getSession().getAttribute("user");
			if(user!=null){
				flag=true;
			}else{
				request.setAttribute("message", "请先登录再访问网站！");
				request.getRequestDispatcher("/login").forward(request, response);
			}
		}
		return flag;
	}

}
