package ca.mcmaster.ssm.service.ebo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ca.mcmaster.ssm.exception.CustomException;
import ca.mcmaster.ssm.mapper.SysUserMapper;
import ca.mcmaster.ssm.po.ActiveUser;
import ca.mcmaster.ssm.po.SysUser;
import ca.mcmaster.ssm.po.SysUserExample;
import ca.mcmaster.ssm.service.ebi.SysEbi;
import ca.mcmaster.ssm.utils.MD5;

/**
 * @author SeanForFun E-mail:xiaob6@mcmaster.ca
 * @date Apr 9, 2018 3:32:19 PM
 * @version 1.0
 */
public class SysEbo implements SysEbi {
	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public ActiveUser authenticate(String usercode, String password)
			throws Exception {
		SysUser sysUser = this.getSysUserByUsercode(usercode);
		if(null == sysUser){
			throw new CustomException("Usercode doesn't exist!");
		}else{
			String password_db = sysUser.getPassword();
			String password_input_md5 = new MD5().getMD5ofStr(password);
			if(password_input_md5.equalsIgnoreCase(password_db)){
				ActiveUser activeUser = new ActiveUser();
				activeUser.setUsername(usercode);
				activeUser.setUserid(sysUser.getId());
				return activeUser;
			}else {
				throw new CustomException("Wrong usercode or password!");
			}
		}
	}
	
	public SysUser getSysUserByUsercode(String usercode){
		SysUserExample sysUserExample = new SysUserExample();
		SysUserExample.Criteria criteria = sysUserExample.createCriteria();
		criteria.andUsercodeEqualTo(usercode);
		List<SysUser> userList = sysUserMapper.selectByExample(sysUserExample);
		return (userList != null && userList.size() == 1) ? userList.get(0):null;
	}
}
