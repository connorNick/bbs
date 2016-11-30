package com.jzfq.pms.service;

import com.jzfq.pms.common.common.PageVo;
import com.jzfq.pms.domain.RepayCase;
import com.jzfq.pms.domain.SysUser;
import com.jzfq.pms.interceptor.PageList;

import java.util.List;
import java.util.Set;

/**
 * Created by zhishuo on 9/27/16.
 */
public interface IRepayCaseService {

    PageList<RepayCase> findCaseList(PageVo vo);
    
    int updateReminderByIds(List<Integer> uidList,Integer reminder,Integer flowStatus,Integer caseStatus);
    
    int updateCompanyNameByIds(List<Integer> uidList,Integer companyId,Integer flowStatus,Integer caseStatus);

    int updateFlowStatusByIds(List<Integer> ids,Integer flowStatus,Integer caseStatus);
}
