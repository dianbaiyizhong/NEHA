/**
 *
 */
package hhm.neha.service.impl;

import hhm.neha.data.dao.CategorySiteTwoDao;
import hhm.neha.entity.CategorySiteTwo;
import hhm.neha.service.CategorySiteTwoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CategorySiteTwoServiceImpl implements CategorySiteTwoService {
	private CategorySiteTwoDao dao;

	/**
	 * @return the dao
	 */
	public CategorySiteTwoDao getCategorySiteTwoDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setCategorySiteTwoDao(CategorySiteTwoDao dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qawaa.service.CategorySiteTwoService#getCategorySiteTwoByParamsAndPage
	 * (java.util.Map, int, int)
	 */
	@Override
	public List<CategorySiteTwo> getCategorySiteTwoByParamsAndPage(
			Map<String, Object> params, int firstResult, int maxResults) {
		List<CategorySiteTwo> list = dao.getCategorySiteTwoByParamsAndPage(
				params, firstResult, maxResults);
		if (list == null)
			list = new ArrayList<CategorySiteTwo>(0);
		return list;
	}

}
