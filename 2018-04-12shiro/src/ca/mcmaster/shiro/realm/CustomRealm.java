package ca.mcmaster.shiro.realm;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
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
		String usercode = (String) principals.getPrimaryPrincipal();
		List<String> permissions = new ArrayList<>();
		permissions.add("user:create");
		permissions.add("items:add");
		
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addStringPermissions(permissions);
		
		return simpleAuthorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String usercode = (String) token.getPrincipal();
		String password_db = "1234567";
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
				usercode, password_db, this.getName());
//		return null;
		return authenticationInfo;
	}
}
