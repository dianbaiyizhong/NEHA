/**
 *
 */
package hhm.neha.service.impl;

import hhm.neha.data.dao.CategoryEventDao;
import hhm.neha.entity.CategoryEvent;
import hhm.neha.service.CategoryEventService;

import java.util.ArrayList;
import java.util.List;

public class CategoryEventServiceImpl implements CategoryEventService {
	private CategoryEventDao dao;

	/**
	 * @return the dao
	 */
	public CategoryEventDao getCategoryEventDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setCategoryEventDao(CategoryEventDao dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qawaa.service.CategoryEventService#loadNormal()
	 */
	@Override
	public List<CategoryEvent> loadNormal() {
		List<CategoryEvent> list = dao.loadNormal();
		if (list == null)
			list = new ArrayList<CategoryEvent>(0);
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qawaa.service.CategoryEventService#get(java.lang.Integer)
	 */
	@Override
	public CategoryEvent get(Integer id) {
		return dao.get(id);
	}

}
