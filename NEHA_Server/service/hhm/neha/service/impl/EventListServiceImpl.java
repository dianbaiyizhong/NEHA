/**
 *
 */
package hhm.neha.service.impl;

import hhm.neha.data.dao.EventListDao;
import hhm.neha.entity.EventList;
import hhm.neha.service.EventListService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EventListServiceImpl implements EventListService {
	private EventListDao dao;

	/**
	 * @return the dao
	 */
	public EventListDao getEventListDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setEventListDao(EventListDao dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qawaa.service.EventListService#getEventListByParamsAndPage(java.util
	 * .Map, java.util.Map, int, int)
	 */
	@Override
	public List<EventList> getEventListByParamsAndPage(
			Map<String, Object> params, Map<String, Boolean> orders,
			int firstResult, int maxResults) {
		List<EventList> list = dao.getEventListByParamsAndPage(params, orders,
				firstResult, maxResults);
		if (list == null)
			list = new ArrayList<EventList>();
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qawaa.service.EventListService#getCountByParams(java.util.Map)
	 */
	@Override
	public Integer getCountByParams(Map<String, Object> params) {
		List<Integer> list = dao.getCountByParams(params);
		if (list == null || list.size() == 0)
			return 0;
		return list.get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qawaa.service.EventListService#get(java.lang.Integer)
	 */
	@Override
	public EventList get(Integer id) {
		return dao.get(id);
	}

}
