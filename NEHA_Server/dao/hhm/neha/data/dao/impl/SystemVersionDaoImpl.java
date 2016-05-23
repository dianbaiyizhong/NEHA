/**
 *
 */
package hhm.neha.data.dao.impl;

import hhm.neha.data.dao.SystemVersionDao;
import hhm.neha.entity.SystemVersion;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class SystemVersionDaoImpl extends HibernateDaoSupport implements
		SystemVersionDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qawaa.data.dao.SystemVersionDao#getSystemVersionByParamsAndPage(java
	 * .util.Map, int, int)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<SystemVersion> getSystemVersionByParamsAndPage(
			Map<String, Object> params, int firstResult, int maxResults) {
		DetachedCriteria dc = DetachedCriteria.forClass(SystemVersion.class);
		this.setQuery(dc, params);
		dc.addOrder(Order.desc("verId"));
		return this.getHibernateTemplate().findByCriteria(dc, firstResult,
				maxResults);
	}

	private void setQuery(DetachedCriteria dc, Map<String, Object> params) {
		if (params == null || params.size() == 0)
			return;
		if (params.containsKey("verId")) {
			dc.add(Restrictions.eq("verId", params.get("verId")));
		}
		if (params.containsKey("verName")) {
			dc.add(Restrictions.eq("verName", params.get("verName")));
		}
		if (params.containsKey("verStatus")) {
			dc.add(Restrictions.eq("verStatus", params.get("verStatus")));
		}
	}

}
