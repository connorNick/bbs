package com.shareniu.bbs.service;

import com.shareniu.bbs.common.common.PageVo;
import com.shareniu.bbs.domain.RepayCase;
import com.shareniu.bbs.interceptor.PageList;

import java.util.List;

/**
 * Created by zhishuo on 9/27/16.
 */
public interface IRepayCaseService {

    PageList<RepayCase> findCaseList(PageVo vo);
    
    int updateReminderByIds(List<Integer> uidList,Integer reminder,Integer flowStatus,Integer caseStatus);
    
    int updateCompanyNameByIds(List<Integer> uidList,Integer companyId,Integer flowStatus,Integer caseStatus);

    int updateFlowStatusByIds(List<Integer> ids,Integer flowStatus,Integer caseStatus);
}
