package com.jzfq.pms.dao;

import com.jzfq.pms.domain.RepayCompany;

public interface RepayCompanyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RepayCompany record);

    int insertSelective(RepayCompany record);

    RepayCompany selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RepayCompany record);

    int updateByPrimaryKey(RepayCompany record);
}