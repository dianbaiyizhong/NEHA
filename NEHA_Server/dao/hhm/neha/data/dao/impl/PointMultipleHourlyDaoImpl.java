/**
 *
 */
package hhm.neha.data.dao.impl;

import hhm.neha.data.dao.PointMultipleHourlyDao;
import hhm.neha.entity.PointMultipleHourly;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PointMultipleHourlyDaoImpl extends HibernateDaoSupport implements
		PointMultipleHourlyDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qawaa.data.dao.PointMultipleHourlyDao#getMultipleHourPointByParamsAndPage
	 * (java.util.Map, int, int)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<PointMultipleHourly> getMultipleHourPointByParamsAndPage(
			Map<String, Object> params, int firstResult, int maxResults) {
		DetachedCriteria dc = DetachedCriteria
				.forClass(PointMultipleHourly.class);
		this.setQuery(dc, params);
		dc.addOrder(Order.desc("mhpId"));
		return this.getHibernateTemplate().findByCriteria(dc, firstResult,
				maxResults);
	}

	/**
	 * @param dc
	 * @param params
	 */
	private void setQuery(DetachedCriteria dc, Map<String, Object> params) {
		if (params == null || params.size() == 0)
			return;
		if (params.containsKey("mhpId")) {
			dc.add(Restrictions.eq("mhpId", params.get("mhpId")));
		}
		if (params.containsKey("gtMhpId")) {
			dc.add(Restrictions.gt("mhpId", params.get("gtMhpId")));
		}
		if (params.containsKey("ltMhpId")) {
			dc.add(Restrictions.lt("mhpId", params.get("ltMhpId")));
		}
		if (params.containsKey("mhpEventId")) {
			dc.add(Restrictions.eq("mhpEventId", params.get("mhpEventId")));
		}
		if (params.containsKey("gtMhpDate")) {
			dc.add(Restrictions.gt("mhpDate", params.get("gtMhpDate")));
		}
		if (params.containsKey("ltMhpDate")) {
			dc.add(Restrictions.lt("mhpDate", params.get("ltMhpDate")));
		}
		if (params.containsKey("mhpStatus")) {
			dc.add(Restrictions.eq("mhpStatus", params.get("mhpStatus")));
		}
		if (params.containsKey("geMhpId")) {
			dc.add(Restrictions.ge("mhpId", params.get("geMhpId")));
		}
		if (params.containsKey("leMhpId")) {
			dc.add(Restrictions.le("mhpId", params.get("leMhpId")));
		}
	}

}
