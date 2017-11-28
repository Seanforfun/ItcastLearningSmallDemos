package ca.mcmaster.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.components.Else;

import ca.mcmaster.domain.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}

	public String login(){
		User u = this.user;
//		System.out.println(u.toString());
		if(u.getUsername().equals("sean") && u.getPassword().equals("1")){
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			return SUCCESS;
		}else {
			return "fail";
		}
	}
}
