package com.shareniu.bbs.dao;

import com.shareniu.bbs.common.common.PageVo;
import com.shareniu.bbs.common.common.Pageable;
import com.shareniu.bbs.domain.Dictionary;
import com.shareniu.bbs.interceptor.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictionaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    Dictionary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);

    List<Dictionary> getDictionaryListByType(String type);

    PageList<Dictionary> findDictionaryList(@Param("vo") PageVo vo, Pageable pageable);
}