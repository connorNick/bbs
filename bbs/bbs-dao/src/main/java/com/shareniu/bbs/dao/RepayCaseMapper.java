package com.shareniu.bbs.dao;

import java.util.List;

import com.shareniu.bbs.common.common.PageVo;
import com.shareniu.bbs.common.common.Pageable;
import com.shareniu.bbs.domain.RepayCase;
import com.shareniu.bbs.interceptor.PageList;

import org.apache.ibatis.annotations.Param;

public interface RepayCaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RepayCase record);

    int insertSelective(RepayCase record);

    RepayCase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RepayCase record);

    int updateByPrimaryKey(RepayCase record);

    PageList<RepayCase> findCaseList(@Param("vo") PageVo vo, Pageable pageable);
    
    int updateReminderByIds(@Param("uidsList")List<Integer> uidList,@Param("reminder")Integer reminderId,@Param("flowStatus")Integer flowStatus,@Param("caseStatus")Integer caseStatus);
    
    int updateCompanyNameByIds(@Param("uidsList")List<Integer> uidList, @Param("companyId")Integer companyId,@Param("flowStatus")Integer flowStatus,@Param("caseStatus")Integer caseStatus);
    
    int updateFlowStatusByIds(@Param("ids")List<Integer> uidList,@Param("flowStatus")Integer flowStatus,@Param("caseStatus")Integer caseStatus);
}