package com.shareniu.bbs.dao;

import com.shareniu.bbs.common.common.PageVo;
import com.shareniu.bbs.common.common.Pageable;
import com.shareniu.bbs.domain.SysUser;
import com.shareniu.bbs.interceptor.PageList;

import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

/*    int insert(SysUser record);*/

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);


    SysUser getUserByUserName(String username);

    /**
     * 查询登录信息
     *
     * @param username
     * @param pwd
     * @return
     */
    SysUser getUserByUserNameAndPwd(@Param("username") String username, @Param("pwd") String pwd);

    int modifyPassword(SysUser record);

    PageList<SysUser> findUserList(@Param("vo") PageVo vo, Pageable pageable);
}