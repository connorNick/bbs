package com.shareniu.bbs.dao;

import com.shareniu.bbs.common.common.PageVo;
import com.shareniu.bbs.common.common.Pageable;
import com.shareniu.bbs.domain.SysUser;
import com.shareniu.bbs.domain.Topic;
import com.shareniu.bbs.interceptor.PageList;
import org.apache.ibatis.annotations.Param;

public interface TopicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Topic record);

    int insertSelective(Topic record);

    Topic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Topic record);

    int updateByPrimaryKeyWithBLOBs(Topic record);

    int updateByPrimaryKey(Topic record);

    PageList<Topic> findTopicList(@Param("vo") PageVo vo, Pageable pageable);
}