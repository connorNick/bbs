package com.jzfq.pms.dao;

import com.jzfq.pms.common.common.PageVo;
import com.jzfq.pms.common.common.Pageable;
import com.jzfq.pms.domain.SysUser;
import com.jzfq.pms.interceptor.PageList;

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