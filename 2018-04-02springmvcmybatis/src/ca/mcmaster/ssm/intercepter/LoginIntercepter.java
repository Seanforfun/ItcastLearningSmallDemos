package ca.mcmaster.ssm.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 5, 2018 7:16:14 PM
 * @version 1.0
 */
public class LoginIntercepter implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if(request.getRequestURI().contains("user") || request.getRequestURI().contains("login")){
			return true;
		}
		String usercode = (String) request.getSession().getAttribute("usercode"); 
		System.out.println(usercode);
		if(usercode != null && usercode.trim().length() != 0){
			return true;
		}
		else{
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
