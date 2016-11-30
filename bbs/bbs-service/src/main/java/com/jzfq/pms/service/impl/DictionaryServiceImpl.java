package com.jzfq.pms.service.impl;


import com.jzfq.pms.common.common.PageVo;
import com.jzfq.pms.common.util.ServiceValidate;
import com.jzfq.pms.dao.DictionaryMapper;
import com.jzfq.pms.domain.Dictionary;
import com.jzfq.pms.interceptor.PageList;
import com.jzfq.pms.service.IDictionaryService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.jzfq.pms.common.util.JdbcUtil.isSuccess;


/**
 * 数据字典
 */
@Service
public class DictionaryServiceImpl implements IDictionaryService {

	@Autowired
	private DictionaryMapper dictionaryMapper;

	@Override
	public List<Dictionary> getDictionaryListByType(String type) {
		if(StringUtils.isBlank(type)){
			return null;
		}
		return dictionaryMapper.getDictionaryListByType(type);
	}

	@Override
	public PageList<Dictionary> findDictionaryList(PageVo vo) {
		return dictionaryMapper.findDictionaryList(vo, vo.getPageable());
	}

	@Override
	public boolean addDictionary(Dictionary d) {
		ServiceValidate.isTrue(!org.springframework.util.StringUtils.isEmpty(d), "字典对象不能为空");
		d.setCreateTime(new Date(System.currentTimeMillis()));
		return dictionaryMapper.insertSelective(d)>0 ? true : false;
	}

	@Override
	public boolean delDictionary(int dictionaryId) {
		Dictionary d= dictionaryMapper.selectByPrimaryKey(dictionaryId);
		d.setDelFlag((byte)1);
		return dictionaryMapper.updateByPrimaryKeySelective(d) > 0 ? true : false;
	}

	@Override
	public boolean updateDictionary(Dictionary d) {
		//如果id为空 或者对象为空
		if (org.springframework.util.StringUtils.isEmpty(d) || org.springframework.util.StringUtils.isEmpty(d.getId())) {
			ServiceValidate.isTrue(Boolean.FALSE, "字典对象不能为空");
		}
		d.setUpdateTime(new Date(System.currentTimeMillis()));
		int result = dictionaryMapper.updateByPrimaryKeySelective(d);
		boolean state = isSuccess(result);
		ServiceValidate.isTrue(state, "更新失败");
		return state;
	}

	@Override
	public Dictionary getDictionaryById(int dictionaryId) {
		return dictionaryMapper.selectByPrimaryKey(dictionaryId);
	}


}
