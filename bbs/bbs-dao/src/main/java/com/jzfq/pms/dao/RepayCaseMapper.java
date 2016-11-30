package com.jzfq.pms.dao;

import java.util.List;

import com.jzfq.pms.common.common.PageVo;
import com.jzfq.pms.common.common.Pageable;
import com.jzfq.pms.domain.RepayCase;
import com.jzfq.pms.interceptor.PageList;

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