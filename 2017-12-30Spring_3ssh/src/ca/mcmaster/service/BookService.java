package ca.mcmaster.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ca.mcmaster.dao.BookDao;
import ca.mcmaster.vo.Book;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 30, 2017 10:20:05 PM
 */
@Transactional(propagation=Propagation.REQUIRED)
public class BookService {
	@Resource(name="bookDao")
	private BookDao bookDao;

	public void addBook(Book book){
		bookDao.addBook(book);
	}
	
	public void updateBook(Book book){
		bookDao.update(book);
	}
	
	public void deleteBook(Book book){
		bookDao.delete(book);
	}
	
	public Book findBookById(Integer id) {
		return bookDao.findById(id);
	}
	
	public List<Book> findAll(){
		return bookDao.findAll();
	}
	
	public List<Book> findByCriteria(DetachedCriteria criteria){
		return bookDao.findByCriteria(criteria);
	}
	
	public Book findByIdLazy(Integer id){
		return bookDao.findByIdLazy(id);
	}
}
