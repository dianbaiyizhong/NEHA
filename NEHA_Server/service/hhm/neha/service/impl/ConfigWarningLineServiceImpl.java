/**
 *
 */
package hhm.neha.service.impl;

import hhm.neha.data.dao.ConfigWarningLineDao;
import hhm.neha.entity.ConfigWarningLine;
import hhm.neha.service.ConfigWarningLineService;

import java.util.ArrayList;
import java.util.List;

public class ConfigWarningLineServiceImpl implements ConfigWarningLineService {
	private ConfigWarningLineDao dao;

	/**
	 * @return the dao
	 */
	public ConfigWarningLineDao getConfigWarningLineDao() {
		return dao;
	}

	/**
	 * @param dao
	 *            the dao to set
	 */
	public void setConfigWarningLineDao(ConfigWarningLineDao dao) {
		this.dao = dao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qawaa.service.ConfigWarningLineService#loadNormalConfigWarningLine()
	 */
	@Override
	public List<ConfigWarningLine> loadNormalConfigWarningLine() {
		List<ConfigWarningLine> list = dao.loadNormalConfigWarningLine();
		if (list == null)
			list = new ArrayList<ConfigWarningLine>(0);
		return list;
	}

}
