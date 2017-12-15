package ca.mcmaster.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import ca.mcmaster.domain.Course;
import ca.mcmaster.domain.Customer;
import ca.mcmaster.domain.Order;
import ca.mcmaster.domain.Student;
import ca.mcmaster.utils.HibernateUtils;

public class TestDemos {
	
	@Test
	public void demo1(){
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Customer customer = new Customer();
		Order order = new Order();
		Order order1 = new Order();
		
		order.setCustomer(customer);
		order.setAddress("Hamilton");
		
		order1.setAddress("Windsor");
		order1.setCustomer(customer);
		
		customer.setName("Sean");
		customer.getOrders().add(order);
		customer.getOrders().add(order1);
		
		session.save(customer);
		transaction.commit();
		session.close();
	}
	
	@Test
	public void demo2(){
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Course course1 = new Course();
		Course course2 = new Course();
		Student student1 = new Student();
		Student student2 = new Student();
		
		course1.setCname("java");
		course2.setCname("C");
		student1.setSname("Sean");
		student2.setSname("Irene");
		
		course1.getStudents().add(student1);
		course1.getStudents().add(student2);
		course2.getStudents().add(student1);
		course2.getStudents().add(student2);
		
		session.save(course1);
		session.save(course2);
		
		transaction.commit();
		session.close();
	}
	
	@Test
	public void demo3(){
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		
		Student student = (Student) session.get(Student.class, 1);
//		Set<Course> courses = student.getCourses();
//		for(Course course:courses){
//			System.out.println(course.getCname());
//		}
		Course course = (Course) session.get(Course.class, 1);
//		System.out.println(course.getCname());
		student.getCourses().remove(course);
//		Set<Course> courses = student.getCourses();
//		for(Course c:courses){
//			System.out.println(1111);
//			System.out.println(c.getCname());
//		}
//		session.update(student);
		transaction.commit();
		session.close();
	}
}
