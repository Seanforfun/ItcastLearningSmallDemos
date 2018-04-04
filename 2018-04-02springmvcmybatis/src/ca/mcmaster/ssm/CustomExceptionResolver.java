package ca.mcmaster.ssm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import ca.mcmaster.ssm.exception.CustomException;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 4, 2018 3:33:38 PM
 * @version 1.0
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		ex.printStackTrace();
		CustomException customException = null;
		if(ex instanceof CustomException){
			customException = (CustomException) ex;
		}else{
			customException = new CustomException("Unknown error!");
		}
		request.setAttribute("error", customException.getMessage());
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		return new ModelAndView();
	}

}
