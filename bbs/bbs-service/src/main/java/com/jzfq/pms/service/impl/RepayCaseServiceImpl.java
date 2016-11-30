package com.jzfq.pms.service.impl;

import com.jzfq.pms.common.common.FlowStatusEnum;
import com.jzfq.pms.common.common.PageVo;
import com.jzfq.pms.common.util.ServiceValidate;
import com.jzfq.pms.dao.RepayCaseMapper;
import com.jzfq.pms.dao.SysUserMapper;
import com.jzfq.pms.domain.RepayCase;
import com.jzfq.pms.domain.SysUser;
import com.jzfq.pms.interceptor.PageList;
import com.jzfq.pms.service.IRepayCaseService;
import com.jzfq.pms.service.ISysUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.jzfq.pms.common.util.JdbcUtil.isSuccess;

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
