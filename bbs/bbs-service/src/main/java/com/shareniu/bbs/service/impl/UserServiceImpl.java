package com.shareniu.bbs.service.impl;

import com.shareniu.bbs.common.common.PageVo;
import com.shareniu.bbs.common.common.UserStatusEnum;
import com.shareniu.bbs.common.util.MD5Coding;
import com.shareniu.bbs.common.util.ServiceValidate;
import com.shareniu.bbs.dao.UserMapper;
import com.shareniu.bbs.domain.SysUser;
import com.shareniu.bbs.domain.User;
import com.shareniu.bbs.interceptor.PageList;

import com.shareniu.bbs.service.UserService;
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
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
   private UserMapper userMapper;
   public User getUserByUserName(String username){
       User user=new User();
       user.setUsername(username);
       List<User> ulist=userMapper.getUserByConf(user);
       if(ulist!=null&&ulist.size()>0){
           return ulist.get(0);
       }
       return null;
   }
   public  User getUserByEmail(String email){
       User user=new User();
       user.setEmail(email);
       List<User> ulist=userMapper.getUserByConf(user);
       if(ulist!=null&&ulist.size()>0){
           return ulist.get(0);
       }
       return null;
   }
   public int save(User user){
       user.setRegisterTime(new Date());
       user.setLastLoginTime(new Date());
       user.setStatus(UserStatusEnum.NORMAL.ordinal());
       return  userMapper.insert(user);
   }

   public  int updateUser(User user){
       return userMapper.updateByPrimaryKeySelective(user);
   }
}
