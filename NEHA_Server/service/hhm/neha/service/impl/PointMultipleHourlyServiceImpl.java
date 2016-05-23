/**
 *
 */
package hhm.neha.service.impl;

import hhm.neha.data.dao.PointMultipleHourlyDao;
import hhm.neha.entity.PointMultipleHourly;
import hhm.neha.service.PointMultipleHourlyService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PointMultipleHourlyServiceImpl implements
		PointMultipleHourlyService {
	private PointMultipleHourlyDao dao;

	/**
	 * @return the dao
	 */
	public PointMultipleHourlyDao getPointMultipleHourlyDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setPointMultipleHourlyDao(PointMultipleHourlyDao dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qawaa.service.PointMultipleHourlyService#
	 * getMultipleHourPointByParamsAndPage(java.util.Map, int, int)
	 */
	@Override
	public List<PointMultipleHourly> getMultipleHourPointByParamsAndPage(
			Map<String, Object> params, int firstResult, int maxResults) {
		List<PointMultipleHourly> list = dao
				.getMultipleHourPointByParamsAndPage(params, firstResult,
						maxResults);
		if (list == null)
			list = new ArrayList<PointMultipleHourly>(0);
		return list;
	}

}
