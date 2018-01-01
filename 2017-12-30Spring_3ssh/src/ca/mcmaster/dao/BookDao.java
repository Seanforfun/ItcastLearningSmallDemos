package ca.mcmaster.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ca.mcmaster.vo.Book;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 30, 2017 10:19:57 PM
 */
public class BookDao extends HibernateDaoSupport{

	public void addBook(Book book) {
		this.getHibernateTemplate().save(book);
	}
	
	public void update(Book book){
		Book bookObj = this.getHibernateTemplate().load(Book.class, book.getId());
		System.out.println(bookObj);
		bookObj.setName(book.getName());
		bookObj.setPrice(book.getPrice());
	}
	
	public void delete(Book book){
		Book retBook = this.getHibernateTemplate().load(Book.class, book.getId());
		this.getHibernateTemplate().delete(retBook);
	}
	
	public Book findById(Integer id){
		return this.getHibernateTemplate().get(Book.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Book> findAll() {
		return this.getHibernateTemplate().find("from Book");
	}
	
	public List<Book> findByCriteria(DetachedCriteria criteria){
		return this.getHibernateTemplate().findByCriteria(criteria);
	}
}
