package com.shareniu.bbs.service.impl;

import com.shareniu.bbs.common.common.PageVo;
import com.shareniu.bbs.common.util.MD5Coding;
import com.shareniu.bbs.common.util.ServiceValidate;
import com.shareniu.bbs.dao.SysAuthMapper;
import com.shareniu.bbs.dao.SysRoleMapper;
import com.shareniu.bbs.dao.SysUserMapper;
import com.shareniu.bbs.domain.SysAuth;
import com.shareniu.bbs.domain.SysRole;
import com.shareniu.bbs.domain.SysUser;
import com.shareniu.bbs.interceptor.PageList;
import com.shareniu.bbs.service.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

import static com.shareniu.bbs.common.util.JdbcUtil.isSuccess;

/**
 * Created by zhishuo on 9/27/16.
 */
@Service
public class SysUserServiceImpl implements ISysUserService {
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysAuthMapper sysAuthMapper;


    public PageList<SysUser> findUserList(PageVo vo) {
        return sysUserMapper.findUserList(vo, vo.getPageable());
    }

    @Override
    public Set<String> getRoleNameSetByUsername(String username) {
        //TODO һ���û����ܶ�Ӧ�����ɫ���˴�ֻ�ǿ���һ���û�ֻ�Ƕ�Ӧһ����ɫ
        SysUser user = sysUserMapper.getUserByUserName(username);
        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(user.getRoleId());
        Set<String> roles = new HashSet<>();
        roles.add(sysRole.getName());
        return roles;
    }

    @Override
    public Set<String> getAuthSetByUsername(String username) {
        //TODO һ���û����ܶ�Ӧ�����ɫ���˴�ֻ�ǿ���һ���û�ֻ�Ƕ�Ӧһ����ɫ
        SysUser user = sysUserMapper.getUserByUserName(username);
        Set<String> auths = new HashSet<>();
        Map<String,Object> map = new HashMap();
        List list = new ArrayList();
        list.add(user.getRoleId());
        map.put("roleList",list);
        List<SysAuth> ls = sysAuthMapper.selectAuthListByRoleId(map);
        for(SysAuth s:ls){
            auths.add(s.getText());
        }
        return auths;
    }

    @Override
    public SysUser addUser(SysUser user) {
        ServiceValidate.isTrue(!StringUtils.isEmpty(user), "�û�����Ϊ��");
        user.setCreateTime(new Date(System.currentTimeMillis()));
        sysUserMapper.insertSelective(user);
        return user;
    }

    @Override
    public boolean delUser(int userId) {
        int result = sysUserMapper.deleteByPrimaryKey(userId);
        return result == 1;
    }

    @Override
    public boolean updateUser(SysUser user) {
        //���idΪ�� ���߶���Ϊ��
        if (StringUtils.isEmpty(user) || StringUtils.isEmpty(user.getId())) {
            ServiceValidate.isTrue(Boolean.FALSE, "�û�����Ϊ��");
        }
        user.setUpdateTime(new Date(System.currentTimeMillis()));
        int result = sysUserMapper.updateByPrimaryKeySelective(user);
        boolean state = isSuccess(result);
        ServiceValidate.isTrue(state, "����ʧ��");
        return state;
    }

    @Override
    public SysUser getUserById(int userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }


    @Override
    public SysUser getUserByUserName(String userName) {
        if (StringUtils.isEmpty(userName)) {
            ServiceValidate.isTrue(Boolean.FALSE, "�û�������Ϊ��");
        }
        return sysUserMapper.getUserByUserName(userName);
    }

    @Override
    public SysUser getUserByUserNameAndPwd(String userName, String pwd) {
        if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(pwd)) {
            ServiceValidate.isTrue(Boolean.FALSE, "�û��������벻��Ϊ��");
        }
       /* MD5Coding.encode()*/
        return sysUserMapper.getUserByUserNameAndPwd(userName, MD5Coding.encode2HexStr(pwd.getBytes()));
    }

    @Override
    public boolean modifyPassword(SysUser user, SysUser u) {
        user.setPassword(u.getPassword());
        user.setUpdateTime(new Date());
        user.setSalt(u.getSalt());
        user.setCredentialsSalt(u.getCredentialsSalt());
        //���idΪ�� ���߶���Ϊ��
        if (StringUtils.isEmpty(user) || StringUtils.isEmpty(user.getId())) {
            ServiceValidate.isTrue(Boolean.FALSE, "�û�����Ϊ��");
        }
        user.setUpdateTime(new Date(System.currentTimeMillis()));
        int result = sysUserMapper.updateByPrimaryKeySelective(user);
        boolean state = isSuccess(result);
        ServiceValidate.isTrue(state, "����ʧ��");
        return state;
    }



}
