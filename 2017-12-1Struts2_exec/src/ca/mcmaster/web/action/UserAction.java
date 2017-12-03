package ca.mcmaster.web.action;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import ca.mcmaster.domain.User;
import ca.mcmaster.exception.FindUserException;
import ca.mcmaster.exception.LoginException;
import ca.mcmaster.web.service.UserService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User();
	private List<User> list;
	
	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	@Override
	public User getModel() {
		return user;
	}
	private UserService service = new UserService();
	public String login(){
		try {
			user = service.login(user);
			if(null == user){
				this.addActionError("Login Failed! Wrong login name or password!");
				return Action.LOGIN;
			}
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("userInfo", user);
		} catch (SQLException e) {
			e.printStackTrace();
//			throw new LoginException(e.getMessage());
			this.addActionError("Login Failed! System error!");
			return Action.LOGIN;
		}
		return "login_success";
	}
	
	public String list(){
		try {
			list = service.getUserList();
			if(null == list){
				this.addActionError("No user found!");
			}
//			ValueStack vs = ActionContext.getContext().getValueStack();
//			vs.set("userlist", list);
		} catch (SQLException e) {
			e.printStackTrace();
//			throw new FindUserException(e.getMessage());
			this.addActionError("Find User Faild! System error!");
		}
		return "list_success";
	}
}
