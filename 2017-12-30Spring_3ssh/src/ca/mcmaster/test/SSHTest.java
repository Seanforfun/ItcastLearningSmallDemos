package ca.mcmaster.test;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.mcmaster.service.BookService;
import ca.mcmaster.vo.Book;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 31, 2017 6:08:26 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SSHTest {
	
	@Resource(name="bookService")
	private BookService bookService;

	@Test
	public void demo1(){
		Book book = new Book();
		book.setId(2);
		book.setName("test update122222222");
		book.setPrice(121d);
		bookService.updateBook(book);
	}
	
	@Test
	public void demo2(){
		Book book = new Book();
		book.setName("test add");
		book.setPrice(1212d);
		bookService.addBook(book);
	}
	
	@Test
	public void demo3(){
		Book book = new Book();
		book.setId(2);
		bookService.deleteBook(book);
	}
	
	@Test
	public void demo4(){
		Book book1 = bookService.findBookById(1);
		System.out.println(book1);
	}
	
	@Test
	public void demo5(){
		List<Book> list = bookService.findAll();
		for (Book book : list) {
			System.out.println(book);
		}
	}
	
	@Test
	public void demo6(){
		DetachedCriteria criteria = DetachedCriteria.forClass(Book.class);
		criteria.add(Restrictions.eq("name", "SeanForFun"));
		List<Book> list = bookService.findByCriteria(criteria);
		for (Book book : list) {
			System.out.println(book);
		}
	}
}
