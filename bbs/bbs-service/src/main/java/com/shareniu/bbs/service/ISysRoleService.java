package com.shareniu.bbs.service;

import com.shareniu.bbs.common.common.PageVo;
import com.shareniu.bbs.domain.SysRole;
import com.shareniu.bbs.interceptor.PageList;

import java.util.List;
import java.util.Map;

/**
 * Created by klaus on 9/27/16.
 */
public interface ISysRoleService {


	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
    boolean addRole(SysRole role);

    /**
     * 通过角色id删除角色
     * @param roleId
     * @return
     */
    boolean delRole(int roleId);

    /**
     * 更新角色
     * @param role
     * @return
     */
    boolean updateRole(SysRole role);

    /**
     * 通过角色id查询角色
     * @param roleId
     * @return
     */
    SysRole getRoleById(int roleId);
    
    /**
     * 通过角色名称查询角色
     * @param roleId
     * @return
     */
    List<SysRole> listRoleByName(String name);
 
    
    /**
     * 查询角色名称 是否存在
     * @param name
     * @return	
     */
    public boolean checkRoleNameIsExist(String name);

    /**
     * 获取用户权限菜单
     * @param id
     * @return
     */
    List<String> getSysAuthList(Integer id);

    /**
     * 获取用户角色对应�?
     */
    List<Map<String,Object>> getAllRoleListToAuth();

    /**
     * 查询�?��角色
     * @return
     */
    PageList<SysRole> queryRoleList(PageVo vo);

    List<SysRole> queryAllRoleList();
}
