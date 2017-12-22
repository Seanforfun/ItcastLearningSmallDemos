package ca.mcmaster.vo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 21, 2017 2:03:14 PM
 */
public class BeanDemoImpl implements BeanDemo, BeanNameAware, BeanFactoryAware,
		ApplicationContextAware, InitializingBean, DisposableBean {

	private String name;

	public BeanDemoImpl() {
		System.out.println("Step1: InitializingBean");
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Step2: Populate Parameters");
	}

	@Override
	public void say() {
		System.out.println("Step9:Do service");
	}

	@Override
	public void setBeanName(String arg0) {
		System.out.println("Step3:setBeanName + name= " + arg0);
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("Step4:setBeanFactory + factory=" + arg0);
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		System.out.println("Step4_1:setApplicationContext");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Step6:afterPropertiesSet");
	}

	public void setup() {
		System.out.println("Step7:init-method='setup'");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Step10:destroy");
	}

	public void mydestroy(){
		System.out.println("Step11:destroy-method='mydestroy'");
	}
}
