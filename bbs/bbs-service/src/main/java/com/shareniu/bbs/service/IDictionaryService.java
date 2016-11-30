package com.shareniu.bbs.service;

import com.shareniu.bbs.common.common.PageVo;
import com.shareniu.bbs.domain.Dictionary;
import com.shareniu.bbs.interceptor.PageList;

import java.util.List;

public interface IDictionaryService {	
	/**
	 * 根据字典类型查询
	 * @param type
	 * @return
	 */
	List<Dictionary> getDictionaryListByType(String type);

	PageList<Dictionary> findDictionaryList(PageVo vo);

	/**
	 * 添加字典
	 * @param d
	 * @return
	 */
	boolean addDictionary(Dictionary d);

	/**
	 * 通过角色id删除角色
	 * @param dictionaryId
	 * @return
	 */
	boolean delDictionary(int dictionaryId);

	/**
	 * 更新字典
	 * @param d
	 * @return
	 */
	boolean updateDictionary(Dictionary d);

	/**
	 * 通过字典id查询字典
	 * @param dictionaryId
	 * @return
	 */
	Dictionary getDictionaryById(int dictionaryId);
}
