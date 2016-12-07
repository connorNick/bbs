package com.shareniu.bbs.dao;

import com.shareniu.bbs.common.common.PageVo;
import com.shareniu.bbs.common.common.Pageable;
import com.shareniu.bbs.domain.SysAuth;
import com.shareniu.bbs.interceptor.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SysAuthMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysAuth record);

    int insertSelective(SysAuth record);

    SysAuth selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysAuth record);

    int updateByPrimaryKey(SysAuth record);

    List<SysAuth> selectAuthListByRoleId(Map<String, Object> parmMap);

    List<SysAuth> getRootMenu();

    List<SysAuth> getChildMenu();
 

	PageList<SysAuth> findAuthList(@Param("vo") PageVo vo, Pageable pageable);

    void deleteRoleAuthByRoleId(@Param("roleId") int roleId);

    List<SysAuth> selectChildAuthListByParentId(Integer id);
}