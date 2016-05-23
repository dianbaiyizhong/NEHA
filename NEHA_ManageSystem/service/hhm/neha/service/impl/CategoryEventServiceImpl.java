/**
 * 
 */
package hhm.neha.service.impl;

import hhm.neha.dao.CategoryEventDao;
import hhm.neha.data.entity.CategoryEvent;
import hhm.neha.service.CategoryEventService;
import hhm.neha.service.ServiceAbstract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class CategoryEventServiceImpl extends ServiceAbstract implements CategoryEventService {
	private CategoryEventDao dao;
	
	/**
	 * @return the dao
	 */
	public CategoryEventDao getCategoryEventDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setCategoryEventDao(CategoryEventDao dao) {
		this.dao = dao;
	}

	/* (non-Javadoc)
	 * @see org.cischina.service.CategoryEventService#get(java.lang.Integer)
	 */
	@Override
	public CategoryEvent get(Integer id) {
		if(id == null)
			return null;
		return dao.get(id);
	}

	/* (non-Javadoc)
	 * @see org.cischina.service.CategoryEventService#saveOrUpdate(org.cischina.data.entity.CategoryEvent)
	 */
	@Override
	public void saveOrUpdate(CategoryEvent entity) {
		if(entity != null)
			dao.saveOrUpdate(entity);
	}

	/* (non-Javadoc)
	 * @see org.cischina.service.CategoryEventService#del(org.cischina.data.entity.CategoryEvent)
	 */
	@Override
	public void del(CategoryEvent entity) {
		if(entity != null)
			dao.del(entity);

	}

	/* (non-Javadoc)
	 * @see org.cischina.service.CategoryEventService#del(java.lang.Integer)
	 */
	@Override
	public void del(Integer id) {
		if(id != null)
			dao.del(id);

	}

	/* (non-Javadoc)
	 * @see org.cischina.service.CategoryEventService#getEntitiesByParamsAndPages(java.util.Map, int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryEvent> getEntitiesByParamsAndPages(Map<String, Object> params, int firstResult, int maxResults) {
		List<CategoryEvent> list = (List<CategoryEvent>) dao.getEntitiesByParamsAndPages(params, firstResult, maxResults);
		if(list == null)
			list = new ArrayList<CategoryEvent>(0);
		return list;
	}

	/* (non-Javadoc)
	 * @see org.cischina.service.CategoryEventService#getCountByParamsAndPages(java.util.Map)
	 */
	@Override
	public int getCountByParamsAndPages(Map<String, Object> params) {
		return this.getCount(dao.getCountByParamsAndPages(params));
	}

	/* (non-Javadoc)
	 * @see org.cischina.service.CategoryEventService#isExistById(java.lang.Integer)
	 */
	@Override
	public boolean isExistById(Integer id) {
		if(id == null)
			return true;
		Map<String, Object> params = new HashMap<String, Object>(1);
		params.put("cgeId", id);
		int count = this.getCountByParamsAndPages(params);
		if(count > 0)
			return true;
		return false;
	}

	/* (non-Javadoc)
	 * @see org.cischina.service.CategoryEventService#isExistByName(java.lang.String, java.lang.Integer)
	 */
	@Override
	public boolean isExistByName(String name, Integer id) {
		if(StringUtils.isBlank(name))
			return true;
		Map<String, Object> params = new HashMap<String, Object>(1);
		params.put("cgeName", name);
		if(id != null){
			params.put("neCgeId", id);
		}
		int count = this.getCountByParamsAndPages(params);
		if(count > 0)
			return true;
		return false;
	}

}
