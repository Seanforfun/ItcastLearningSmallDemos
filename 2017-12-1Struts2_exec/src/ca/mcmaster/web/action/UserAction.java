package ca.mcmaster.web.action;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import ca.mcmaster.domain.User;
import ca.mcmaster.exception.FindUserException;
import ca.mcmaster.exception.LoginException;
import ca.mcmaster.utils.RandomUtils;
import ca.mcmaster.web.service.UserService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.opensymphony.xwork2.util.ValueStack;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User();
	private List<User> list = new ArrayList<User>();
	private File upload;
	private String uploadContentType;
	private String uploadFilename;

	public File getUpload() {
		return upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFilename() {
		return uploadFilename;
	}

	public void setUploadFilename(String uploadFilename) {
		this.uploadFilename = uploadFilename;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

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

	@InputConfig(resultName="login_input")
	public String login() {
		try {
			user = service.login(user);
			if (null == user) {
				this.addActionError("Login Failed! Wrong login name or password!");
				return Action.LOGIN;
			}
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			session.setAttribute("userInfo", user);
		} catch (SQLException e) {
			e.printStackTrace();
			// throw new LoginException(e.getMessage());
			this.addActionError("Login Failed! System error!");
			return Action.LOGIN;
		}
		return "login_success";
	}

	public String list() {
		try {
			list = service.getUserList();
			if (null == list) {
				this.addActionError("No user found!");
				return "login_success";
			}
			// ValueStack vs = ActionContext.getContext().getValueStack();
			// vs.set("userlist", list);
		} catch (SQLException e) {
			e.printStackTrace();
			// throw new FindUserException(e.getMessage());
			this.addActionError("Find User Faild! System error!");
			return "login_success";
		}
		return "list_success";
	}

	@InputConfig(resultName="add_input")
	public String add() throws IOException {
		File dest = new File("D:/upload", RandomUtils.getRandomName(uploadFilename));
		FileUtils.copyFile(upload, dest);
		this.getModel().setPath(dest.toString());
		this.getModel().setFilename(uploadFilename);
		UserService service = new UserService();
		try {
			service.addUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
			// throw new AddUserException(e.getMessage());
			this.addActionError("Add User Faild! System error!");
			return "add_input";
		}
		return "add_success";
	}
}
