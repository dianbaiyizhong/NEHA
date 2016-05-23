/**
 *
 */
package hhm.neha.service.impl;

import hhm.neha.data.bean.HotEventBean;
import hhm.neha.data.dao.PointMultipleDailyDao;
import hhm.neha.entity.PointMultipleDaily;
import hhm.neha.service.PointMultipleDailyService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class PointMultipleDailyServiceImpl implements PointMultipleDailyService {
	private PointMultipleDailyDao dao;

	/**
	 * @return the dao
	 */
	public PointMultipleDailyDao getPointMultipleDailyDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setPointMultipleDailyDao(PointMultipleDailyDao dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qawaa.service.PointMultipleDailyService#
	 * getMultipleDayPointsByParamsAndPage(java.util.Map, int, int)
	 */
	@Override
	public List<PointMultipleDaily> getMultipleDayPointsByParamsAndPage(
			Map<String, Object> params, int firstResult, int maxResults) {
		List<PointMultipleDaily> list = dao
				.getMultipleDayPointsByParamsAndPage(params, firstResult,
						maxResults);
		if (list == null)
			list = new ArrayList<PointMultipleDaily>(0);
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qawaa.service.PointMultipleDailyService#getDailyHotEvent(java.util
	 * .Date)
	 */
	@Override
	public List<HotEventBean> getDailyHotEvent(Date date) {
		return dao.getDailyHotEvent(date);
	}

}
