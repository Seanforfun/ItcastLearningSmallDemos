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
	public Object postProcessAfterInitialization(final Object arg0, String arg1)
			throws BeansException {
		System.out.println("Step8:postProcessAfterInitialization");
		if (arg0 instanceof BeanDemo) {
			Object bean = Proxy.newProxyInstance(arg0.getClass()
					.getClassLoader(), arg0.getClass().getInterfaces(),
					new InvocationHandler() {

						@Override
						public Object invoke(Object arg0, Method arg1,
								Object[] arg2) throws Throwable {
							System.out.println("Privilege control...");
							return arg1.invoke(arg0, arg2);
						}
					});
			return bean;
		}
		return arg0;
	}
	
//	public Object postProcessAfterInitialization(final Object bean, String beanName)
//			throws BeansException {
//		System.out.println("第八步:初始化后执行...");
//		// 动态代理:
////		if(beanName.equals("customerService")){
//			Object proxy = Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces() , new InvocationHandler() {
//				// 调用目标方法的时候,调用invoke方法.
//				public Object invoke(Object proxy, Method method, Object[] args)
//						throws Throwable {
//					if("add".equals(method.getName())){
//						System.out.println("权限校验...");
//						Object result = method.invoke(bean, args);
//						//System.out.println(System.currentTimeMillis());
//						return result;
//					}
//					return method.invoke(bean, args);
//				}
//			});
//			return proxy;
////		}
////		return bean;
//	}

	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1)
			throws BeansException {
		System.out.println("Step5:postProcessBeforeInitialization");
		return arg0;
	}

}
