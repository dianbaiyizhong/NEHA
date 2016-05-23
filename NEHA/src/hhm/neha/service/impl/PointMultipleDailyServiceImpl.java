/**
 * 
 */
package hhm.neha.service.impl;

import hhm.neha.dao.PointMultipleDailyDao;
import hhm.neha.entity.PointMultipleDaily;
import hhm.neha.service.PointMultipleDailyService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ran Xu
 * @data 2014-3-12 下午4:18:16 
 * @company 浙江传媒学院-互联网与社会研究中心  CIS
 * @address 中国杭州下沙高教园区学源街998号
 * @tel 0571-86879294
 * @home www.cischina.org
 * @comment 
 *
 */
public class PointMultipleDailyServiceImpl implements PointMultipleDailyService {
	private PointMultipleDailyDao dao;
	
	/**
	 * @return the dao
	 */
	public PointMultipleDailyDao getPointMultipleDailyDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setPointMultipleDailyDao(PointMultipleDailyDao dao) {
		this.dao = dao;
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.PointMultipleDailyService#save(com.qawaa.data.entity.PointMultipleDaily)
	 */
	@Override
	public void save(PointMultipleDaily entity) {
		dao.save(entity);

	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.PointMultipleDailyService#getPointMultipleDailyByParamsAndPage(java.util.Map, int, int)
	 */
	@Override
	public List<PointMultipleDaily> getPointMultipleDailyByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults) {
		return dao.getPointMultipleDailyByParamsAndPage(params, firstResult, maxResults);
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.PointMultipleDailyService#getLastPointMultipleDailyByEvent(java.lang.Integer)
	 */
	@Override
	public PointMultipleDaily getLastPointMultipleDailyByEvent(Integer eventId) {
		Map<String, Object> params = new HashMap<String, Object>(2);
		params.put("mdpEventId", eventId);
		params.put("mdpStatus", true);
		List<PointMultipleDaily> list = this.getPointMultipleDailyByParamsAndPage(params, 0, 1);
		if(list == null || list.size() == 0)
			return null;
		return list.get(0);
	}

	/* (non-Javadoc)
	 * @see com.qawaa.service.PointMultipleDailyService#getPointMultipleDailyByEventAndDate(java.lang.Integer, java.util.Date)
	 */
	@Override
	public PointMultipleDaily getPointMultipleDailyByEventAndDate(Integer eventId, Date date) {
		Map<String, Object> params = new HashMap<String, Object>(3);
		params.put("mdpEventId", eventId);
		params.put("mdpDate", new Timestamp(date.getTime()));
		params.put("mdpStatus", true);
		List<PointMultipleDaily> list = this.getPointMultipleDailyByParamsAndPage(params, 0, 1);
		if(list == null || list.size() == 0)
			return null;
		return list.get(0);
	}

}
