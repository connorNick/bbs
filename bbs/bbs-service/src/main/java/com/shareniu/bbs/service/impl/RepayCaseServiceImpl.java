package com.shareniu.bbs.service.impl;

import com.shareniu.bbs.common.common.PageVo;
import com.shareniu.bbs.dao.RepayCaseMapper;
import com.shareniu.bbs.domain.RepayCase;
import com.shareniu.bbs.interceptor.PageList;
import com.shareniu.bbs.service.IRepayCaseService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhishuo on 9/27/16.
 */
@Service
public class RepayCaseServiceImpl implements IRepayCaseService {
    private static final Logger log = LoggerFactory.getLogger(RepayCaseServiceImpl.class);

    @Autowired
    private RepayCaseMapper repayCaseMapper;

    public PageList<RepayCase> findCaseList(PageVo vo) {
        return repayCaseMapper.findCaseList(vo, vo.getPageable());
    }

	@Override
	public int updateReminderByIds(List<Integer> uidList,Integer reminderId,Integer flowStatus,Integer caseStatus) {
		return repayCaseMapper.updateReminderByIds(uidList,reminderId,flowStatus,caseStatus);
	}

	@Override
	public int updateCompanyNameByIds(List<Integer> uidList, Integer companyId,Integer flowStatus,Integer caseStatus) {
		return repayCaseMapper.updateCompanyNameByIds(uidList,companyId,flowStatus,caseStatus);
	}

	@Override
	public int updateFlowStatusByIds(List<Integer> ids, Integer flowStatus,
			Integer caseStatus) {
		return repayCaseMapper.updateFlowStatusByIds(ids,flowStatus,caseStatus);
	}



}
