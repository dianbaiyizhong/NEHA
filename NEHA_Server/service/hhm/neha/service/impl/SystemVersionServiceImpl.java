/**
 *
 */
package hhm.neha.service.impl;

import hhm.neha.data.dao.SystemVersionDao;
import hhm.neha.entity.SystemVersion;
import hhm.neha.service.SystemVersionService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SystemVersionServiceImpl implements SystemVersionService {
	private SystemVersionDao dao;

	/**
	 * @return the dao
	 */
	public SystemVersionDao getSystemVersionDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setSystemVersionDao(SystemVersionDao dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qawaa.service.SystemVersionService#getSystemVersionByParamsAndPage
	 * (java.util.Map, int, int)
	 */
	@Override
	public List<SystemVersion> getSystemVersionByParamsAndPage(
			Map<String, Object> params, int firstResult, int maxResults) {
		List<SystemVersion> list = dao.getSystemVersionByParamsAndPage(params,
				firstResult, maxResults);
		if (list == null)
			list = new ArrayList<SystemVersion>(0);
		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qawaa.service.SystemVersionService#now()
	 */
	@Override
	public SystemVersion now() {
		Map<String, Object> params = new HashMap<String, Object>(1);
		params.put("verStatus", true);
		List<SystemVersion> list = dao.getSystemVersionByParamsAndPage(params,
				0, 1);
		if (list.size() == 0) {
			SystemVersion version = new SystemVersion("error", true, "");
			return version;
		}
		return list.get(0);
	}

}
