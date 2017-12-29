package ca.mcmaster.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ca.mcmaster.vo.ProductDao;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 29, 2017 5:49:42 PM
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class AspectDemo1 {
	
	@Resource(name="productDao")
	private ProductDao productDao;
	@Test
	public void demo1(){
		productDao.add();
		productDao.delete();
		productDao.update();
		productDao.search();
	}
}
