package ca.mcmaster.vo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @version Dec 21, 2017 2:24:22 PM
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(final Object bean, String arg1)
			throws BeansException {
		System.out.println("Step8:postProcessAfterInitialization");
		if (bean instanceof BeanDemo) {
			 return Proxy.newProxyInstance(bean.getClass()
					.getClassLoader(), bean.getClass().getInterfaces(),
					new InvocationHandler() {
				 		
						@Override
						public Object invoke(Object proxy, Method method,
								Object[] para) throws Throwable {
							if("say".equals(method.getName())){
								System.out.println("Privilege control...");
								return method.invoke(bean, para);
							}
							return method.invoke(bean, para);
						}
					});
		}
		return bean;
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1)
			throws BeansException {
		System.out.println("Step5:postProcessBeforeInitialization");
		return arg0;
	}

}
