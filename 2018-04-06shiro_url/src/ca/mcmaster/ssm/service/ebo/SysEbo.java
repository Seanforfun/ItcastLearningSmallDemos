package ca.mcmaster.ssm.service.ebo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ca.mcmaster.ssm.exception.CustomException;
import ca.mcmaster.ssm.mapper.SysPermissionMapperCustomMapper;
import ca.mcmaster.ssm.mapper.SysUserMapper;
import ca.mcmaster.ssm.po.ActiveUser;
import ca.mcmaster.ssm.po.SysPermission;
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
	@Autowired
	private SysPermissionMapperCustomMapper sysPermissionMapperCustomMapper;

	@Override
	public ActiveUser authenticate(String usercode, String password)
			throws Exception {
		SysUser sysUser = this.getSysUserByUsercode(usercode);
		if(null == sysUser){
			throw new CustomException("Usercode doesn't exist!");
		}else{
			String password_db = sysUser.getPassword();
			String password_input_md5 = new MD5().getMD5ofStr(password);
			if(!password_input_md5.equalsIgnoreCase(password_db)){
				throw new CustomException("Wrong usercode or password!");
			}
			String userId = sysUser.getId();
			List<SysPermission> menuList = sysPermissionMapperCustomMapper.findMenuListByUserId(userId);
			List<SysPermission> urlList = sysPermissionMapperCustomMapper.findPermissionByUserId(userId);
			
			ActiveUser activeUser = new ActiveUser();
			activeUser.setUsercode(usercode);
			activeUser.setUserid(sysUser.getId());
			activeUser.setMenus(menuList);
			activeUser.setPermissions(urlList);
			return activeUser;
		}
	}
	
	public SysUser getSysUserByUsercode(String usercode){
		SysUserExample sysUserExample = new SysUserExample();
		SysUserExample.Criteria criteria = sysUserExample.createCriteria();
		criteria.andUsercodeEqualTo(usercode);
		List<SysUser> userList = sysUserMapper.selectByExample(sysUserExample);
		return (userList != null && userList.size() == 1) ? userList.get(0):null;
	}

	@Override
	public List<SysPermission> findMenuListByUserId(String id)
			throws Exception {
		return sysPermissionMapperCustomMapper.findMenuListByUserId(id);
	}

	@Override
	public List<SysPermission> findPermissionByUserId(String id)
			throws Exception {
		return sysPermissionMapperCustomMapper.findPermissionByUserId(id);
	}
}
