/**
 *
 */
package hhm.neha.data.dao.impl;

import hhm.neha.data.dao.PointMultipleRealTimeDao;
import hhm.neha.entity.PointMultipleRealTime;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PointMultipleRealTimeDaoImpl extends HibernateDaoSupport implements
		PointMultipleRealTimeDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qawaa.data.dao.PointMultipleRealTimeDao#getMultiplePointByParamsAndPage
	 * (java.util.Map, int, int)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<PointMultipleRealTime> getMultiplePointByParamsAndPage(
			Map<String, Object> params, int firstResult, int maxResults) {
		DetachedCriteria dc = DetachedCriteria
				.forClass(PointMultipleRealTime.class);
		this.setQuery(dc, params);
		dc.addOrder(Order.desc("ampDate"));
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
		if (params.containsKey("ampId")) {
			dc.add(Restrictions.eq("ampId", params.get("ampId")));
		}
		if (params.containsKey("geAmpId")) {
			dc.add(Restrictions.ge("ampId", params.get("geAmpId")));
		}
		if (params.containsKey("gtAmpId")) {
			dc.add(Restrictions.gt("ampId", params.get("gtAmpId")));
		}
		if (params.containsKey("leAmpId")) {
			dc.add(Restrictions.le("ampId", params.get("leAmpId")));
		}
		if (params.containsKey("ltAmpId")) {
			dc.add(Restrictions.lt("ampId", params.get("ltAmpId")));
		}
		if (params.containsKey("ampEventId")) {
			dc.add(Restrictions.eq("ampEventId", params.get("ampEventId")));
		}
		if (params.containsKey("ampEventIds")) {
			dc.add(Restrictions.in("ampEventId",
					(Object[]) params.get("ampEventIds")));
		}
		if (params.containsKey("geAmpDate")) {
			dc.add(Restrictions.ge("ampDate", params.get("geAmpDate")));
		}
		if (params.containsKey("gtAmpDate")) {
			dc.add(Restrictions.gt("ampDate", params.get("gtAmpDate")));
		}
		if (params.containsKey("leAmpDate")) {
			dc.add(Restrictions.le("ampDate", params.get("leAmpDate")));
		}
		if (params.containsKey("ltAmpDate")) {
			dc.add(Restrictions.lt("ampDate", params.get("ltAmpDate")));
		}
		if (params.containsKey("ampStatus")) {
			dc.add(Restrictions.eq("ampStatus", params.get("ampStatus")));
		}
	}

}
