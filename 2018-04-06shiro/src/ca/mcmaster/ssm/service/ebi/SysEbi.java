package ca.mcmaster.ssm.service.ebi;

import ca.mcmaster.ssm.po.ActiveUser;
import ca.mcmaster.ssm.po.SysUser;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 9, 2018 3:27:23 PM
 * @version 1.0
 */
public interface SysEbi {
	/**
	 * @Description: Authenticate a user by username and password
	 * @param usercode
	 * @param password
	 * @return
	 */
	public ActiveUser authenticate(String usercode, String password) throws Exception;
	
	public SysUser getSysUserByUsercode(String usercode);
}
