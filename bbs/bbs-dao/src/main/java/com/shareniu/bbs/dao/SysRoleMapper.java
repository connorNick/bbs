package com.shareniu.bbs.dao;
import com.shareniu.bbs.common.common.PageVo;
import com.shareniu.bbs.common.common.Pageable;
import com.shareniu.bbs.domain.SysRole;
import com.shareniu.bbs.interceptor.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SysRoleMapper {
	
	/**
	 * 根据角色id删除角色
	 * @param id
	 * @return	删除的数�?
	 */
    int deleteByPrimaryKey(Integer id);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    /**
     * 根据角色id查询角色
     * @param id
     * @return	角色
     */
    SysRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
 
	
	/**
	 * 根据角色名称查询角色
	 * @param name
	 * @return	角色list
	 */
	List<SysRole> listByRoleName(String name);

	List<SysRole> queryAllRoleList();

 

	/**
	 * 查询�?��的角�?
	 * @return
	 */
	PageList<SysRole> queryRoleList(@Param("vo") PageVo vo, Pageable pageable);

	/**
	 * 删除角色权限中间�?
	 * @param roleId
	 */
	void delRoleAndAuthByRoleId(int roleId);

    int insertRoleAuth(Map<String, Object> params);


}