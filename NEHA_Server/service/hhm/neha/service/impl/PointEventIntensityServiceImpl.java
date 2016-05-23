/**
 * 
 */
package hhm.neha.service.impl;

import hhm.neha.data.dao.PointEventIntensityDao;
import hhm.neha.entity.PointEventIntensity;
import hhm.neha.service.PointEventIntensityService;

import java.util.List;

public class PointEventIntensityServiceImpl implements
		PointEventIntensityService {
	private PointEventIntensityDao dao;

	/**
	 * @return the dao
	 */
	public PointEventIntensityDao getPointEventIntensityDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setPointEventIntensityDao(PointEventIntensityDao dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qawaa.service.PointEventIntensityService#getLastIntensityByEvent(
	 * java.lang.Integer)
	 */
	@Override
	public int getLastIntensityByEvent(Integer eventId) {
		List<PointEventIntensity> list = dao.getLastIntensityByEvent(eventId);
		if (list == null || list.size() == 0)
			return 0;
		return list.get(0).getPesIntensity().intValue();
	}

}
