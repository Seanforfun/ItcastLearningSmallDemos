package ca.mcmaster.shiro.authentication;

import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 12, 2018 6:18:08 PM
 * @version 1.0
 */
public class AuthenticationTest {
	@Test
	public void login() {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:shiro_first.ini");
		SecurityManager manager = factory.getInstance();
		SecurityUtils.setSecurityManager(manager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan",
				"1234567");

		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		System.out.println(subject.isAuthenticated());
		subject.logout();
		System.out.println(subject.isAuthenticated());
	}

	@Test
	public void testCustomRealm() {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:shiro_realm.ini");
		SecurityManager manager = factory.getInstance();
		SecurityUtils.setSecurityManager(manager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan",
				"1234567");

		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		System.out.println(subject.isAuthenticated());
		subject.logout();
		System.out.println(subject.isAuthenticated());
	}

	public void loginout() {

	}
}
