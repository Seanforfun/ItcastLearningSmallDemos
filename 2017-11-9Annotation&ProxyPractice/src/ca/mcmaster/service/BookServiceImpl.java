package ca.mcmaster.service;

import ca.mcmaster.vo.Users;

public class BookServiceImpl implements BookService {

	@Override
	public void addBook(Users u) throws Exception {
		System.out.println("addBook");
	}

	@Override
	public void deleteBook(Users u) throws Exception {
		System.out.println("deleteBook");
	}

	@Override
	public void updateBook(Users u) throws Exception {
		System.out.println("deleteBook");
	}

	@Override
	public void searchBook(Users u) throws Exception {
		System.out.println("searchBook");
	}

}
