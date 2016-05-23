/**
 *
 */
package hhm.neha.data.dao.impl;

import hhm.neha.data.bean.HotEventBean;
import hhm.neha.data.dao.PointMultipleDailyDao;
import hhm.neha.entity.PointMultipleDaily;
import hhm.neha.util.DateUtil;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PointMultipleDailyDaoImpl extends HibernateDaoSupport implements
		PointMultipleDailyDao {


	@Override
	@SuppressWarnings("unchecked")
	public List<PointMultipleDaily> getMultipleDayPointsByParamsAndPage(
			Map<String, Object> params, int firstResult, int maxResults) {
		DetachedCriteria dc = DetachedCriteria
				.forClass(PointMultipleDaily.class);
		this.setQuery(dc, params);
		dc.addOrder(Order.desc("mdpDate"));
		dc.addOrder(Order.desc("mdpId"));
		return this.getHibernateTemplate().findByCriteria(dc, firstResult,
				maxResults);
	}

	private void setQuery(DetachedCriteria dc, Map<String, Object> params) {
		if (params == null || params.isEmpty())
			return;
		if (params.containsKey("mdpId")) {
			dc.add(Restrictions.eq("mdpId", params.get("mdpId")));
		}
		if (params.containsKey("geMdpId")) {
			dc.add(Restrictions.ge("mdpId", params.get("geMdpId")));
		}
		if (params.containsKey("gtMdpId")) {
			dc.add(Restrictions.gt("mdpId", params.get("gtMdpId")));
		}
		if (params.containsKey("leMdpId")) {
			dc.add(Restrictions.le("mdpId", params.get("leMdpId")));
		}
		if (params.containsKey("ltMdpId")) {
			dc.add(Restrictions.lt("mdpId", params.get("ltMdpId")));
		}
		if (params.containsKey("mdpEventId")) {
			dc.add(Restrictions.eq("mdpEventId", params.get("mdpEventId")));
		}
		if (params.containsKey("mdpDate")) {
			dc.add(Restrictions.eq("mdpDate", params.get("mdpDate")));
		}
		if (params.containsKey("gtMdpDate")) {
			dc.add(Restrictions.gt("mdpDate", params.get("gtMdpDate")));
		}
		if (params.containsKey("ltMdpDate")) {
			dc.add(Restrictions.lt("mdpDate", params.get("ltMdpDate")));
		}
		if (params.containsKey("mdpStatus")) {
			dc.add(Restrictions.eq("mdpStatus", params.get("mdpStatus")));
		}
		if (params.containsKey("mdpEventIds")) {
			dc.add(Restrictions.in("mdpEventId",
					(Object[]) params.get("mdpEventIds")));
		}
	}


	@Override
	@SuppressWarnings("unchecked")
	public List<HotEventBean> getDailyHotEvent(Date date) {
		String hql = "select new com.qawaa.data.bean.HotEventBean(el.eventTitle, pmd.mdpPoint, pmd.mdpDate) from PointMultipleDaily as pmd, EventList as el where pmd.mdpDate = ? and pmd.mdpStatus = ? and pmd.mdpEventId=el.eventId order by pmd.mdpPoint desc";
		Query query = this.getSession().createQuery(hql);
		query.setTimestamp(0, new Timestamp(DateUtil.getBeginTimeOfDay(date)
				.getTime()));
		query.setBoolean(1, true);
		query.setMaxResults(25);
		List<HotEventBean> list = query.list();
		getSession().beginTransaction().commit();
		this.getSession().close();
		return list;
	}

}
