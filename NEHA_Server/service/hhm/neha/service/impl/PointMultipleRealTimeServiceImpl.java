/**
 *
 */
package hhm.neha.service.impl;

import hhm.neha.data.dao.PointMultipleRealTimeDao;
import hhm.neha.entity.PointMultipleRealTime;
import hhm.neha.service.PointMultipleRealTimeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PointMultipleRealTimeServiceImpl implements
		PointMultipleRealTimeService {
	private PointMultipleRealTimeDao dao;

	/**
	 * @return the dao
	 */
	public PointMultipleRealTimeDao getPointMultipleRealTimeDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setPointMultipleRealTimeDao(PointMultipleRealTimeDao dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qawaa.service.PointMultipleRealTimeService#
	 * getMultiplePointByParamsAndPage(java.util.Map, int, int)
	 */
	@Override
	public List<PointMultipleRealTime> getMultiplePointByParamsAndPage(
			Map<String, Object> params, int firstResult, int maxResults) {
		List<PointMultipleRealTime> list = dao.getMultiplePointByParamsAndPage(
				params, firstResult, maxResults);
		if (list == null)
			list = new ArrayList<PointMultipleRealTime>(0);
		return list;
	}

}
