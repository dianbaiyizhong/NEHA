/**
 * 
 */
package hhm.neha.service.impl;

import hhm.neha.dao.EventStatusDao;
import hhm.neha.data.entity.EventStatus;
import hhm.neha.service.EventStatusService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EventStatusServiceImpl implements EventStatusService {
	private EventStatusDao dao;
	/**
	 * @return the dao
	 */
	public EventStatusDao getEventStatusDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setEventStatusDao(EventStatusDao dao) {
		this.dao = dao;
	}

	/* (non-Javadoc)
	 * @see org.cischina.service.EventStatusService#get(java.lang.Integer)
	 */
	@Override
	public EventStatus get(Integer id) {
		return dao.get(id);
	}

	/* (non-Javadoc)
	 * @see org.cischina.service.EventStatusService#saveOrUpdate(org.cischina.data.entity.EventStatus)
	 */
	@Override
	public void saveOrUpdate(EventStatus entity) {
		dao.saveOrUpdate(entity);

	}

	/* (non-Javadoc)
	 * @see org.cischina.service.EventStatusService#del(org.cischina.data.entity.EventStatus)
	 */
	@Override
	public void del(EventStatus entity) {
		dao.del(entity);

	}

	/* (non-Javadoc)
	 * @see org.cischina.service.EventStatusService#del(java.lang.Integer)
	 */
	@Override
	public void del(Integer id) {
		dao.del(id);

	}

	/* (non-Javadoc)
	 * @see org.cischina.service.EventStatusService#getEntitiesByParamsAndPages(java.util.Map, int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EventStatus> getEntitiesByParamsAndPages(Map<String, Object> params, int firstResult, int maxResults) {
		List<EventStatus> list = (List<EventStatus>) dao.getEntitiesByParamsAndPages(params, firstResult, maxResults);
		if(list == null)
			list = new ArrayList<EventStatus>(0);
		return list;
	}

	/* (non-Javadoc)
	 * @see org.cischina.service.EventStatusService#getCountByParamsAndPages(java.util.Map)
	 */
	@Override
	public int getCountByParamsAndPages(Map<String, Object> params) {
		List<Integer> list = dao.getCountByParamsAndPages(params);
		if(list == null || list.size() == 0)
			return 0;
		return list.get(0);
	}

}
