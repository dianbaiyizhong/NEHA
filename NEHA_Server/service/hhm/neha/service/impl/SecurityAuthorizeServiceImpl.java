/**
 *
 */
package hhm.neha.service.impl;

import hhm.neha.data.dao.SecurityAuthorizeDao;
import hhm.neha.entity.SecurityAuthorize;
import hhm.neha.service.SecurityAuthorizeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SecurityAuthorizeServiceImpl implements SecurityAuthorizeService {
	private SecurityAuthorizeDao dao;

	/**
	 * @return the dao
	 */
	public SecurityAuthorizeDao getSecurityAuthorizeDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setSecurityAuthorizeDao(SecurityAuthorizeDao dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qawaa.service.SecurityAuthorizeService#getSecurityAuthorizeByParams
	 * (java.util.Map, int, int)
	 */
	@Override
	public List<SecurityAuthorize> getSecurityAuthorizeByParams(
			Map<String, Object> params, int firstResult, int maxResults) {
		List<SecurityAuthorize> list = dao.getSecurityAuthorizeByParams(params,
				firstResult, maxResults);
		if (list == null)
			list = new ArrayList<SecurityAuthorize>(0);
		return list;
	}

}
