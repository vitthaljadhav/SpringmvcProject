package com.info.mvc.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.info.mvc.entity.HitCounter;

public class GlobalInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private HitCounter hitCounter;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		hitCounter.setHits(hitCounter.getHits()+1);
		System.out.println("Hits: "+hitCounter.getHits());
		//request.setAttribute("currentDate", new Date());
		return super.preHandle(request, response, handler);
	}

}
