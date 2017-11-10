package ca.mcmaster.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.mcmaster.service.BookService;
import ca.mcmaster.service.BookServiceFactory;
import ca.mcmaster.service.BookServiceImpl;
import ca.mcmaster.vo.Users;

public class BookServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		
		if("add".equals(method)){
			add(request, response);
		}else if("update".equals(method)){
			update(request, response);
		}else if("delete".equals(method)){
			delete(request, response);
		}else if("search".equals(method)){
			search(request, response);
		}
	}
	
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService service = BookServiceFactory.getInstance();
		Users u = (Users) request.getSession().getAttribute("user");
		try {
			service.addBook(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService service = BookServiceFactory.getInstance();
		Users u = (Users) request.getSession().getAttribute("user");
		try {
			service.deleteBook(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService service = BookServiceFactory.getInstance();
		Users u = (Users) request.getSession().getAttribute("user");
		try {
			service.updateBook(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService service = BookServiceFactory.getInstance();
		Users u = (Users) request.getSession().getAttribute("user");
		try {
			service.searchBook(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
