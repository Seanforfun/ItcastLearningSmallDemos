package ca.mcmaster.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 12, 2018 7:20:54 PM
 * @version 1.0
 */
public class CustomRealm extends AuthorizingRealm {

	@Override
	public void setName(String name) {
		super.setName("CustomRealm");
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String usercode = (String) token.getPrincipal();
		String password_db = "1234567";
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				usercode, password_db, this.getName());
		return null;
//		return authenticationInfo;
	}
}
