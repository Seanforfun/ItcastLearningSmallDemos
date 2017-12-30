package ca.mcmaster.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import ca.mcmaster.domain.User;

public class LoginAction extends ActionSupport {

	public String login(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username.equals("sean") && password.equals("1")){
			HttpSession session = request.getSession();
			User u = new User();
			u.setUsername(username);
			u.setPassword(password);
			session.setAttribute("userInfo", u);
			return SUCCESS;
		}else {
			return "fail";
		}
	}
}
