package com.jzfq.pms.service;

import java.util.List;

import com.jzfq.pms.common.common.PageVo;
import com.jzfq.pms.domain.SysAuth;
import com.jzfq.pms.interceptor.PageList;
import com.jzfq.pms.vo.RootMenu;
import com.jzfq.pms.vo.SysAuthVo;

/**
 * Created by zhishuo on 9/27/16.
 */
public interface ISysAuthService {

    boolean addAuth(SysAuth auth);

    boolean delAuth(int authId);

    boolean updateAuth(SysAuth auth);

    SysAuth getAuthById(int authId);

    /**
     * 获取所有主菜单页面
     */
    List<SysAuth> getRootMenu();

    /**
     * 获取子菜单集合
     */
    List<SysAuth> getChildMenu();

    /**
     * 通过roleId获取主菜单页面
     */
    List<SysAuth> getRootMenuByRoleId( int roleId);

    /**
     * 通过roleId获取子菜单页面
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
	 * 查询所有权限
	 * @return
	 */
    PageList<SysAuth> queryAuthList(PageVo vo);

    List<RootMenu> getRootMenuList();
}
