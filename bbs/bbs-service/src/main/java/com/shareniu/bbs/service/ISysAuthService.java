package com.shareniu.bbs.service;

import com.shareniu.bbs.common.common.PageVo;
import com.shareniu.bbs.domain.SysAuth;
import com.shareniu.bbs.interceptor.PageList;
import com.shareniu.bbs.vo.RootMenu;

import java.util.List;

/**
 * Created by zhishuo on 9/27/16.
 */
public interface ISysAuthService {

    boolean addAuth(SysAuth auth);

    boolean delAuth(int authId);

    boolean updateAuth(SysAuth auth);

    SysAuth getAuthById(int authId);

    /**
     * 获取�?��主菜单页�?
     */
    List<SysAuth> getRootMenu();

    /**
     * 获取子菜单集�?
     */
    List<SysAuth> getChildMenu();

    /**
     * 通过roleId获取主菜单页�?
     */
    List<SysAuth> getRootMenuByRoleId(int roleId);

    /**
     * 通过roleId获取子菜单页�?
     */
    List<SysAuth> getChildMenuByRoleId(int roleId);


    /**
     * 修改
     * @param roleId
     * @param authIdList
     * @return
     */
    boolean editTreeMenuByRoleId(int roleId, List<Integer> authIdList);

	/**
	 * 查询�?��权限
	 * @return
	 */
    PageList<SysAuth> queryAuthList(PageVo vo);

    List<RootMenu> getRootMenuList();
}
