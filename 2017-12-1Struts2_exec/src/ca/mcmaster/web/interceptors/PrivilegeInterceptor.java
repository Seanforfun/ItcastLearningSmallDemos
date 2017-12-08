package ca.mcmaster.web.interceptors;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import ca.mcmaster.domain.User;
import ca.mcmaster.web.action.UserAction;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class PrivilegeInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User loginUser = (User)session.getAttribute("userInfo");
		if(null == loginUser){
			UserAction action = (UserAction) invocation.getAction();
			action.addActionError("Please login before actions!");
			return "login";
		}else{
			return invocation.invoke();
		}
	}
}
