package ca.mcmaster.mybatis.mapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import ca.mcmaster.vo.Orders;
import ca.mcmaster.vo.OrdersCustom;
import ca.mcmaster.vo.User;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Mar 30, 2018 7:15:11 PM
 * @version 1.0
 */
public class OrdersMapperCustomTest {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
	}

	@Test
	public void testFindOrderUserList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom mapper = sqlSession.getMapper(OrdersMapperCustom.class);
		List<OrdersCustom> ordersCustomList = mapper.findOrderUserList();
		System.out.println(ordersCustomList);
		sqlSession.close();
	}

	@Test
	public void testFindOrderUserListByMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom mapper = sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> ordersList = mapper.findOrderUserListByMap();
		System.out.println(ordersList);
		sqlSession.close();
	}
	
	@Test
	public void testFindOrderAndOrderdetail() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom mapper = sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> ordersList = mapper.findOrderAndOrderdetail();
		System.out.println(ordersList);
		sqlSession.close();
	}
	
	@Test
	public void testFindUserOrderdetail() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom mapper = sqlSession.getMapper(OrdersMapperCustom.class);
		List<User> userList = mapper.findUserOrderdetail();
		System.out.println(userList);
		sqlSession.close();
	}
	
	@Test
	public void testFindOrderUserListLazyLoading() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom mapper = sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> orderList = mapper.findOrderUserListLazyLoading();
		User user = orderList.get(0).getUser();
		System.out.println(user);
		sqlSession.close();
	}
}
