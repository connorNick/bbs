package com.shareniu.bbs.service.impl;

import com.shareniu.bbs.common.common.PageVo;
import com.shareniu.bbs.dao.SysAuthMapper;
import com.shareniu.bbs.domain.SysAuth;
import com.shareniu.bbs.interceptor.PageList;
import com.shareniu.bbs.service.ISysAuthService;
import com.shareniu.bbs.vo.RootMenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by klaus on 9/27/16.
 */
@Service
public class SysAuthServiceImpl  implements ISysAuthService {
    @Autowired
    private SysAuthMapper sysAuthMapper;

    private static final Logger log = LoggerFactory.getLogger(SysAuthServiceImpl.class);

    @Override
    public boolean addAuth(SysAuth auth) {
        auth.setDelFlag((byte)0);
        auth.setCreateTime(new Date(System.currentTimeMillis()));
        int result = sysAuthMapper.insert(auth);
        return result >0 ? true : false;
    }

    @Override
    public boolean delAuth(int authId) {
        int result = sysAuthMapper.deleteByPrimaryKey(authId);
        return result > 0 ? true : false;
    }

    @Override
    public boolean updateAuth(SysAuth auth) {
        auth.setUpdateTime(new Date(System.currentTimeMillis()));
        int result = sysAuthMapper.updateByPrimaryKeySelective(auth);
        return result > 0 ? true : false;
    }

    @Override
    public SysAuth getAuthById(int authId) {
        return sysAuthMapper.selectByPrimaryKey(authId);
    }

    /**
     * 获取所有主菜单页面
     */
    @Override
    public List<SysAuth> getRootMenu() {
        List<SysAuth> list = sysAuthMapper.getRootMenu();
        SysAuth sa = new SysAuth();
        sa.setId(0);
        sa.setText("根级菜单");
        list.add(sa);
        return list;
    }

    /**
     * 获取子菜单集合
     */
    @Override
    public List<SysAuth> getChildMenu() {
        return sysAuthMapper.getChildMenu();
    }

    /**
     * 通过roleId获取主菜单页面
     *
     * @param roleId
     */
    @Override
    public List<SysAuth> getRootMenuByRoleId( int roleId) {

        return new ArrayList<>() ;
    }

    /**
     * 通过roleId获取子菜单页面
     *
     * @param roleId
     */
    @Override
    public List<SysAuth> getChildMenuByRoleId( int roleId) {
        return new ArrayList<>();
    }


    @Override
    public PageList<SysAuth> queryAuthList(PageVo vo) {
        return sysAuthMapper.findAuthList(vo, vo.getPageable());
    }

    @Override
    public List<RootMenu> getRootMenuList() {

        List<RootMenu>  list = new ArrayList<>();
        List<SysAuth>  rootMenus = sysAuthMapper.getRootMenu();//顶级菜单
        for(SysAuth sysAuth:rootMenus){
            List<RootMenu.ChildMenu> childMenus = new ArrayList<>();
            List<SysAuth> childMenuList  = sysAuthMapper.selectChildAuthListByParentId(sysAuth.getId());
            for(SysAuth sa:childMenuList){
                List<SysAuth> childButtonLit = sysAuthMapper.selectChildAuthListByParentId(sa.getId());
                RootMenu.ChildMenu childMenu = new RootMenu.ChildMenu();
                childMenu.setChildMenuSysAuth(sa);
                childMenu.setChildButtons(childButtonLit);
                childMenus.add(childMenu);
            }
            RootMenu rm = new RootMenu();
            rm.setRootMenuSysAuth(sysAuth);
            rm.setChildMenus(childMenus);
            list.add(rm);
        }
        return list;
    }

    /**
     * 修改
     * @param roleId
     * @param authIdList
     * @return
     */
    @Override
    @Transactional
    public boolean editTreeMenuByRoleId(int roleId, List<Integer> authIdList) {
        //删除roleId对应的authId
        try {
            sysAuthMapper.deleteRoleAuthByRoleId(roleId);
            //插入新的roleId与authId关系中间表
            Map<String,Object> params = new HashMap<String, Object>();
            params.put("roleId", roleId);
            params.put("authIds", authIdList);

            return true;
        }catch (Exception e){
            e.printStackTrace();
            log.info("数据库异常");
            return false;
        }
    }
}
