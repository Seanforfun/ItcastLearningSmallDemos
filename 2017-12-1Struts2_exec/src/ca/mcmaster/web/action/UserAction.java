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
	private String uploadFileName;
	private String isUpload;

	public String getIsUpload() {
		return isUpload;
	}

	public void setIsUpload(String isUpload) {
		this.isUpload = isUpload;
	}

	public File getUpload() {
		return upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFilename) {
		this.uploadFileName = uploadFilename;
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

	@InputConfig(resultName = "login_input")
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

	@InputConfig(resultName = "add_input")
	public String add() throws IOException {
		File dest = new File("D:/upload",
				RandomUtils.getRandomName(uploadFileName));
		FileUtils.copyFile(upload, dest);
		this.getModel().setPath(dest.toString());
		this.getModel().setFilename(uploadFileName);
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

	@InputConfig(resultName = "search_input")
	public String search() {
		boolean hasResume = false;
		if (this.isUpload.equals("yes")) {
			hasResume = true;
		}
		UserService service = new UserService();
		try {
			System.out.println(this.getModel().toString());
			list = service.searchUser(this.getModel(), hasResume);
			if (null == list || list.size() == 0) {
				this.addActionError("No matched user found!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// throw new SearchUserException(e.getMessage());
			this.addActionError("Search User Faild! System error!");
		}
		return "search_success";
	}

	public String delete() {
		UserService service = new UserService();
		try {
			User result = service.findUserById(user.getUserID());
			if (result == null) {
				this.addActionError("Delete User Faild! System error!");
				return "delete_fail";
			}else{
				if(result.getPath() != null && result.getPath().trim().length() != 0){
					this.removeResume(result);
				}
			}
			service.deleteUser(this.getModel().getUserID());
		} catch (SQLException e) {
			e.printStackTrace();
			// throw new UserDeleteException(e.getMessage());
			this.addActionError("Delete User Faild! System error!");
		}
		return "delete_success";
	}

	private void removeResume(User result) {
		File resume = new File(result.getPath());
		if(resume.exists()){
			resume.delete();
		}
	}
	
	public String findUserById(){
		UserService service = new UserService();
		try {
			user = service.findUserById(user.getUserID());
			if(null == user){
				this.addActionError("Find User Faild! System error!");
				return "findUserById_fail";
			}
			ActionContext context = ActionContext.getContext();
			context.put("info", user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "findUserById_success";
	}
}
