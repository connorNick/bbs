package com.shareniu.bbs.service;

import com.shareniu.bbs.common.common.PageVo;
import com.shareniu.bbs.domain.SysUser;
import com.shareniu.bbs.interceptor.PageList;

import java.util.Set;

/**
 * Created by zhishuo on 9/27/16.
 */
public interface ISysUserService {


    SysUser addUser(SysUser user);

    boolean delUser(int userId);

    boolean updateUser(SysUser user);

    SysUser getUserById(int userId);

    SysUser getUserByUserName(String userName);

    SysUser getUserByUserNameAndPwd(String userName, String pwd);


    boolean modifyPassword(SysUser user, SysUser u);

    PageList<SysUser> findUserList(PageVo vo);

    Set<String> getRoleNameSetByUsername(String username);

    Set<String> getAuthSetByUsername(String username);
}
