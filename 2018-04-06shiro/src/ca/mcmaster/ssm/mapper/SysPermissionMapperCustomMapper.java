package ca.mcmaster.ssm.mapper;

import java.util.List;

import ca.mcmaster.ssm.po.SysPermission;

public interface SysPermissionMapperCustomMapper {
	/**
	 * @Description: Find user's authenticated menu by user's id.
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<SysPermission> findMenuListByUserId(String id) throws Exception;
	
	/**
	 * @Description: Find user's permission by user's id.
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public List<SysPermission> findPermissionByUserId(String id) throws Exception;
}