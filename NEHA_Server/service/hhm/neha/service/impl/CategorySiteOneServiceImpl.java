/**
 *
 */
package hhm.neha.service.impl;

import hhm.neha.data.dao.CategorySiteOneDao;
import hhm.neha.entity.CategorySiteOne;
import hhm.neha.service.CategorySiteOneService;

import java.util.ArrayList;
import java.util.List;

public class CategorySiteOneServiceImpl implements CategorySiteOneService {
	private CategorySiteOneDao dao;

	/**
	 * @return the dao
	 */
	public CategorySiteOneDao getCategorySiteOneDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setCategorySiteOneDao(CategorySiteOneDao dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qawaa.service.CategorySiteOneService#loadAll()
	 */
	@Override
	public List<CategorySiteOne> loadAll() {
		List<CategorySiteOne> list = dao.loadAll();
		if (list == null)
			list = new ArrayList<CategorySiteOne>(0);
		return list;
	}

}
