package com.shareniu.bbs.service.impl;

import com.shareniu.bbs.common.common.PageVo;
import com.shareniu.bbs.common.util.MD5Coding;
import com.shareniu.bbs.common.util.ServiceValidate;
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

   public User getUserByUserName(String username){
       return null;
   }
}
