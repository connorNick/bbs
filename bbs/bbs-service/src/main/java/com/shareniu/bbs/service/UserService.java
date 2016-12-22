package com.shareniu.bbs.service;

import com.shareniu.bbs.common.common.PageVo;
import com.shareniu.bbs.domain.User;
import com.shareniu.bbs.interceptor.PageList;

import java.util.List;

public interface UserService {


    User getUserByUserName(String username);

    User getUserByEmail(String email);

    int save(User user);

    int updateUser(User user);
}
