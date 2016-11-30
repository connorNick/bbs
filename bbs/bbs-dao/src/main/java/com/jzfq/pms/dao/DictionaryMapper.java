package com.jzfq.pms.dao;

import com.jzfq.pms.common.common.PageVo;
import com.jzfq.pms.common.common.Pageable;
import com.jzfq.pms.domain.Dictionary;
import com.jzfq.pms.interceptor.PageList;
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