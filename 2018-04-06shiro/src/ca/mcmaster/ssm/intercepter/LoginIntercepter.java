package ca.mcmaster.ssm.intercepter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import ca.mcmaster.ssm.po.ActiveUser;
import ca.mcmaster.ssm.utils.ResourcesUtil;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 5, 2018 7:16:14 PM
 * @version 1.0
 */
public class LoginIntercepter implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String uri = request.getRequestURI();
		List<String> anonymousUrls = ResourcesUtil.getkeyList("anonymousUrl");
		for(String anonymousUrl : anonymousUrls){
			if(uri.indexOf(anonymousUrl) > 0){
				return true;
			}
		}
		ActiveUser activeUser = (ActiveUser) request.getSession().getAttribute("activeUser"); 
		if(activeUser != null){
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
