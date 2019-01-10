package com.info.mvc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
@Component
public class GlobalHandlerExceptionResolver implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("global_error");
		return modelAndView;
	}
	
}




//OR
/*@ControllerAdvice
public class GlobalHandlerExceptionResolver {

	@ExceptionHandler(Exception.class)
	public String handleException()
	{
		return "global_error";
		
	}
}*/
