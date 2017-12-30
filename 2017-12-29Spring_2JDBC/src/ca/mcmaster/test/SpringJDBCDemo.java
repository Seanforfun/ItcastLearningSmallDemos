package ca.mcmaster.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 29, 2017 7:30:12 PM
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringJDBCDemo {

	@Resource(name="JDBCtemplate")
	private JdbcTemplate JDBCtemplate;
	@Test
	public void demo1() {
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName("com.mysql.jdbc.Driver");
		source.setUrl("jdbc:mysql:///springjdbc");
		source.setUsername("root");
		source.setPassword("911023");

		JdbcTemplate template = new JdbcTemplate(source);
		template.execute("create table user (id int primary key auto_increment, name varchar(20))");
	}

	@Test
	public void demo2() {
		JDBCtemplate.execute("insert into user values (null, 'test')");
	}
}
