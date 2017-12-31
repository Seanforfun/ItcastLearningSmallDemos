package ca.mcmaster.service;

import javax.annotation.Resource;

import ca.mcmaster.dao.BookDao;
import ca.mcmaster.vo.Book;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 30, 2017 10:20:05 PM
 */
public class BookService {
	@Resource(name="bookDao")
	private BookDao bookDao;

	public void addBook(Book book){
		bookDao.addBook(book);
	}
}
