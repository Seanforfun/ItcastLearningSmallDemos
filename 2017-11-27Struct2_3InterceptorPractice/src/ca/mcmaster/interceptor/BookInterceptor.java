package ca.mcmaster.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import ca.mcmaster.action.BookAction;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class BookInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("user") != null){
			return invocation.invoke();
		}else{
			BookAction action = (BookAction) invocation.getAction();
			action.addActionError("no privilege! Please login first!");
			return Action.LOGIN;
		}
	}
}
