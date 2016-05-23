/**
 *
 */
package hhm.neha.service.impl;

import hhm.neha.dao.PointMultipleHourlyDao;
import hhm.neha.entity.PointMultipleHourly;
import hhm.neha.service.PointMultipleHourlyService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PointMultipleHourlyServiceImpl implements PointMultipleHourlyService {
	private PointMultipleHourlyDao dao;
	
	/**
	 * @return the dao
	 */
	public PointMultipleHourlyDao getPointMultipleHourlyDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setPointMultipleHourlyDao(PointMultipleHourlyDao dao) {
		this.dao = dao;
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.PointMultipleHourlyService#get(java.lang.Integer)
	 */
	@Override
	public PointMultipleHourly get(Integer id) {
		return dao.get(id);
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.PointMultipleHourlyService#save(com.qawaa.data.entity.PointMultipleHourly)
	 */
	@Override
	public void save(PointMultipleHourly entity) {
		dao.save(entity);

	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.PointMultipleHourlyService#getPointMultipleHourlyByParamsAndPage(java.util.Map, int, int)
	 */
	@Override
	public List<PointMultipleHourly> getPointMultipleHourlyByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults) {
		List<PointMultipleHourly> list = dao.getPointMultipleHourlyByParamsAndPage(params, firstResult, maxResults);
		return list;
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.PointMultipleHourlyService#getCountByParams(java.util.Map)
	 */
	@Override
	public int getCountByParams(Map<String, Object> params) {
		List<Integer> list = dao.getCountByParams(params);
		if(list == null || list.size()  == 0)
			return 0;
		return list.get(0);
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.PointMultipleHourlyService#getLastPointMultipleHourlyByEvent(java.lang.Integer)
	 */
	@Override
	public PointMultipleHourly getLastPointMultipleHourlyByEvent(Integer eventId) {
		if(eventId == null)
			return null;
		Map<String, Object> params = new HashMap<String, Object>(2);
		params.put("mhpEventId", eventId);
		params.put("mhpStatus", true);
		List<PointMultipleHourly> list = this.getPointMultipleHourlyByParamsAndPage(params, 0, 1);
		if(list == null || list.size() == 0)
			return null;
		return list.get(0);
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.PointMultipleHourlyService#getPointByEventAndDate(java.lang.Integer, java.util.Date)
	 */
	@Override
	public PointMultipleHourly getPointByEventAndDate(Integer eventid, Date date) {
		if(eventid == null || date == null)
			return null;
		Map<String, Object> params = new HashMap<String, Object>(3);
		params.put("mhpEventId", eventid);
		params.put("mhpDate", new Timestamp(date.getTime()));
		params.put("mhpStatus", true);
		List<PointMultipleHourly> list = this.getPointMultipleHourlyByParamsAndPage(params, 0, 1);
		if(list == null || list.size() == 0)
			return null;
		return list.get(0);
	}

}
