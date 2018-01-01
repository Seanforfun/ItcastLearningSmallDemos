package ca.mcmaster.action;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import ca.mcmaster.service.BookService;
import ca.mcmaster.vo.Book;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 30, 2017 10:19:48 PM
 */
public class BookAction extends ActionSupport implements ModelDriven<Book> {
	
	@Resource(name="bookService")
	private BookService bookService;

	private Book book = new Book();
	@Override
	public Book getModel() {
		return book;
	}

	public String add() {
		bookService.addBook(book);
		return null;
	}
	
	public String find(){
		Book book = bookService.findByIdLazy(1);
		System.out.println(book);
		return null;
	}
}
