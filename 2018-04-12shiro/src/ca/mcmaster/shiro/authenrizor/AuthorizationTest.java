package ca.mcmaster.shiro.authenrizor;

import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 12, 2018 8:49:14 PM
 * @version 1.0
 */
public class AuthorizationTest {
	@Test
	public void testAuthorization(){
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro_permission.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		
		Subject subject = SecurityUtils.getSubject();
		
		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "1234567");
		
		try {
			subject.login(token);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//基于角色的授权
		System.out.println(subject.isAuthenticated());
		System.out.println(subject.hasRole("role1"));
		System.out.println(subject.hasAllRoles(Arrays.asList("role1", "role3")));
		//基于资源的授权
		System.out.println(subject.isPermitted("user:create"));
	}
	
	@Test
	public void testCustomAuthoriztionRealm() {
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(
				"classpath:shiro_realm.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);

		Subject subject = SecurityUtils.getSubject();

		UsernamePasswordToken token = new UsernamePasswordToken("zhangsan",
				"1234567");

		try {
			subject.login(token);
		} catch (Exception e) {
			e.printStackTrace();
		}

//		// 基于角色的授权
//		System.out.println(subject.isAuthenticated());
//		System.out.println(subject.hasRole("role1"));
//		System.out
//				.println(subject.hasAllRoles(Arrays.asList("role1", "role3")));
		// 基于资源的授权
		System.out.println(subject.isPermitted("user:create"));
	}
}
