package ca.mcmaster.service;

import ca.mcmaster.annotation.BookInfo;
import ca.mcmaster.vo.Users;

public interface BookService {
	@BookInfo("add book")
	public void addBook(Users u) throws Exception;
	
	@BookInfo("delete book")
	public void deleteBook(Users u) throws Exception;
	
	@BookInfo("update book")
	public void updateBook(Users u) throws Exception;
	
//	@BookInfo("search book")
	public void searchBook(Users u) throws Exception;
}
