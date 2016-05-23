/**
 *
 */
package hhm.neha.service.impl;

import hhm.neha.data.dao.CategoryAreaDao;
import hhm.neha.entity.CategoryArea;
import hhm.neha.service.CategoryAreaService;

import java.util.ArrayList;
import java.util.List;

public class CategoryAreaServiceImpl implements CategoryAreaService {
	private CategoryAreaDao dao;

	/**
	 * @return the dao
	 */
	public CategoryAreaDao getCategoryAreaDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setCategoryAreaDao(CategoryAreaDao dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qawaa.service.CategoryAreaService#loadNormal()
	 */
	@Override
	public List<CategoryArea> loadNormal() {
		List<CategoryArea> list = dao.loadNormal();
		if (list == null)
			list = new ArrayList<CategoryArea>(0);
		return list;
	}

}
