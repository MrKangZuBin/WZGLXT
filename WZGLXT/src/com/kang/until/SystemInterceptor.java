package com.kang.until;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 
 * @author geloin
 * @date 2012-3-27 下午2:29:35
 */
@Repository
public class SystemInterceptor extends HandlerInterceptorAdapter {

	public void afterCompletion(HttpServletRequest arg0,

			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		String userName = (String)request.getSession().getAttribute("userName");
		List jurisdiction = (List) request.getSession().getAttribute("list");
		if (userName == null || jurisdiction == null) {
			// 用户没有登录
			response.sendRedirect(request.getContextPath() + "/loginerro.jsp");
			return false;
		} else {
			// 用户已经登录
			return true;

		}

	}

}