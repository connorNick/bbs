package com.shareniu.bbs.service.impl;

import com.shareniu.bbs.common.common.PageVo;
import com.shareniu.bbs.dao.SysAuthMapper;
import com.shareniu.bbs.dao.SysRoleMapper;
import com.shareniu.bbs.domain.SysRole;
import com.shareniu.bbs.interceptor.PageList;
import com.shareniu.bbs.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by klaus on 9/27/16.
 */

@Service
public class SysRoleServiceImpl  implements ISysRoleService {

	@Autowired
	private SysRoleMapper sysRoleMapper;
	@Autowired
	private SysAuthMapper sysAuthMapper;

	@Transactional
	@Override
	public boolean addRole(SysRole role) {
		role.setCreateTime(new Date());
		role.setDelFlag((byte)0);
		sysRoleMapper.insert(role);
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("roleId", role.getId());
		params.put("authIds", role.getIdList());
		int i = sysRoleMapper.insertRoleAuth(params);
		return i==0 ? false : true;
	}

	@Override
	public boolean delRole(int roleId) {
		SysRole role= sysRoleMapper.selectByPrimaryKey(roleId);
		role.setDelFlag((byte)1);
		return sysRoleMapper.updateByPrimaryKeySelective(role) > 0 ? true
				: false;
	}

	@Transactional
	@Override
	public boolean updateRole(SysRole role) {
		if (null == role)
			return false;
		int result = 0;
		try {
			//Integer[] authIds = (Integer[])role.getIsList().toArray();

			/*if(StringUtils.isNotBlank(role.getAuthIds())){
				authIds = role.getAuthIds().split(";");
			}*/

			result = sysRoleMapper.updateByPrimaryKeySelective(role);
			//ɾ���м���еĶ�Ӧ��ϵ
			sysRoleMapper.delRoleAndAuthByRoleId(role.getId());

			//����м���еĶ�Ӧ��ϵ
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("roleId", role.getId());
			params.put("authIds", role.getIdList());
			sysRoleMapper.insertRoleAuth(params);

		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
			throw e;
		}
		return result > 0 ? true : false;
	}

	@Override
	public SysRole getRoleById(int roleId) {
		return sysRoleMapper.selectByPrimaryKey(roleId);
	}

	@Override
	public List<SysRole> listRoleByName(String name) {
		return sysRoleMapper.listByRoleName(name);
	}


	@Override
	public boolean checkRoleNameIsExist(String name) {
		return sysRoleMapper.listByRoleName(name).size() > 0 ? true : false;
	}

	/**
	 * ��ȡ�û�Ȩ�޲˵�
	 * @param userId
	 * @return
	 */
	@Override
	public List<String> getSysAuthList(Integer userId) {

		List<String> authUrlList = new ArrayList<>() ;

		return authUrlList;
	}

	/**
	 * ��ȡ�û���ɫ��Ӧ��
	 */
	@Override
	public List<Map<String, Object>> getAllRoleListToAuth() {
		List<Map<String,Object>> roleIdList = new ArrayList<>();
		return  roleIdList;
	}

	@Override
	public PageList<SysRole> queryRoleList(PageVo vo) {
		return sysRoleMapper.queryRoleList(vo, vo.getPageable());
	}

	@Override
	public List<SysRole> queryAllRoleList() {
		return sysRoleMapper.queryAllRoleList();
	}
}
