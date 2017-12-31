package ca.mcmaster.dao;

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
}
