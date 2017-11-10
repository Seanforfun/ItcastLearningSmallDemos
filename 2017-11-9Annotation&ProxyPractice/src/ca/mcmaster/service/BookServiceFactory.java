package ca.mcmaster.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import ca.mcmaster.annotation.BookInfo;
import ca.mcmaster.utils.DataSourceUtils;
import ca.mcmaster.vo.Users;

public class BookServiceFactory {

	private static BookService bs = new BookServiceImpl();

	public static BookService getInstance() {
		BookService proxy = (BookService) Proxy.newProxyInstance(bs.getClass()
				.getClassLoader(), bs.getClass().getInterfaces(),
				new InvocationHandler() {

					@Override
					public Object invoke(Object arg0, Method arg1, Object[] arg2)
							throws Throwable {
						BookInfo info = arg1.getAnnotation(BookInfo.class);

						if (arg1.isAnnotationPresent(BookInfo.class)) {
							String pName = info.value();
							Users u = (Users) arg2[0];

							if (null == u) {
								throw new RuntimeException(
										"Please login before doing actions!");
							}

							// check the user's privilege from database.
							String sql = "SELECT PRIVILEGES.name FROM users, PRIVILEGES, userprivilege WHERE users.id=userprivilege.user_id AND PRIVILEGES.id = userprivilege.privilege_id AND users.id = ?";
							QueryRunner runner = new QueryRunner(
									DataSourceUtils.getDataSource());
							List<Object> pnames = runner.query(sql,
									new ColumnListHandler(), u.getId());
							System.out.println(pnames);
							Object object = null;
							if (pnames.contains(pName)) {
								object = arg1.invoke(bs, arg2);
							} else {
								throw new RuntimeException("No privilege!");
							}

							return object;
						} else {
							return arg1.invoke(bs, arg2);
						}
					}
				});

		return proxy;
	}
}
