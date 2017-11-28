package ca.mcmaster.action;

import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {
	public String add(){
		System.out.println("book add");
		return null;
	}
	public String research(){
		System.out.println("book research");
		return null;
	}
	public String update(){
		System.out.println("book update");
		return null;
	}
	public String delete(){
		System.out.println("book delete");
		return null;
	}
}
