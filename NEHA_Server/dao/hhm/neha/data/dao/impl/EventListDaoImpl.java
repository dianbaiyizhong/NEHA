/**
 *
 */
package hhm.neha.data.dao.impl;

import hhm.neha.data.dao.EventListDao;
import hhm.neha.entity.EventList;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class EventListDaoImpl extends HibernateDaoSupport implements
		EventListDao {


	@Override
	@SuppressWarnings("unchecked")
	public List<EventList> getEventListByParamsAndPage(
			Map<String, Object> params, Map<String, Boolean> orders,
			int firstResult, int maxResults) {
		DetachedCriteria dc = DetachedCriteria.forClass(EventList.class);
		this.setQuery(dc, params);
		this.setOrder(dc, orders);
		return this.getHibernateTemplate().findByCriteria(dc, firstResult,
				maxResults);
	}

	
	@Override
	@SuppressWarnings("unchecked")
	public List<Integer> getCountByParams(Map<String, Object> params) {
		DetachedCriteria dc = DetachedCriteria.forClass(EventList.class);
		this.setQuery(dc, params);
		dc.setProjection(Projections.count("eventId"));
		return this.getHibernateTemplate().findByCriteria(dc, 0, 1);
	}

	
	@Override
	public EventList get(Integer id) {
		if (id == null)
			return null;
		return this.getHibernateTemplate().get(EventList.class, id);
	}

	/**
	 * @param dc
	 * @param params
	 */
	private void setQuery(DetachedCriteria dc, Map<String, Object> params) {
		if (params == null) {
			return;
		}
		if (params.containsKey("eventId")) {
			dc.add(Restrictions.eq("eventId", params.get("eventId")));
		}
		if (params.containsKey("geEventId")) {
			dc.add(Restrictions.ge("eventId", params.get("geEventId")));
		}
		if (params.containsKey("gtEventId")) {
			dc.add(Restrictions.gt("eventId", params.get("gtEventId")));
		}
		if (params.containsKey("leEventId")) {
			dc.add(Restrictions.le("eventId", params.get("leEventId")));
		}
		if (params.containsKey("ltEventId")) {
			dc.add(Restrictions.lt("eventId", params.get("ltEventId")));
		}
		if (params.containsKey("neEventId")) {
			dc.add(Restrictions.ne("eventId", params.get("")));
		}
		if (params.containsKey("eventTitle")) {
			dc.add(Restrictions.eq("eventTitle", params.get("eventTitle")));
		}
		if (params.containsKey("ilikeEventTitle")) {
			dc.add(Restrictions.ilike("eventTitle",
					(String) params.get("ilikeEventTitle"), MatchMode.ANYWHERE));
		}
		if (params.containsKey("ilikeEventTitles")) {
			String[] values = (String[]) params.get("ilikeEventTitles");
			if (values != null && values.length > 0) {
				for (String val : values) {
					if (val != null && !val.trim().isEmpty()) {
						dc.add(Restrictions.ilike("eventTitle", val,
								MatchMode.ANYWHERE));
					}
				}
			}
		}

		if (params.containsKey("eventKeyword")) {
			dc.add(Restrictions.eq("eventKeyword", params.get("eventKeyword")));
		}
		if (params.containsKey("ilikeEventKeyword")) {
			dc.add(Restrictions.ilike("eventKeyword",
					(String) params.get("ilikeEventKeyword"),
					MatchMode.ANYWHERE));
		}
		if (params.containsKey("ilikeEventCategory")) {
			dc.add(Restrictions.ilike("eventCategory",
					(String) params.get("ilikeEventCategory"),
					MatchMode.ANYWHERE));
		}
		if (params.containsKey("eventDate")) {
			dc.add(Restrictions.eq("eventDate", params.get("eventDate")));
		}
		if (params.containsKey("geEventDate")) {
			dc.add(Restrictions.ge("eventDate", params.get("geEventDate")));
		}
		if (params.containsKey("leEventDate")) {
			dc.add(Restrictions.le("eventDate", params.get("leEventDate")));
		}
		if (params.containsKey("eventStatus")) {
			dc.add(Restrictions.eq("eventStatus", params.get("eventStatus")));
		}
		if (params.containsKey("neEventStatus")) {
			dc.add(Restrictions.ne("eventStatus", params.get("neEventStatus")));
		}
		if (params.containsKey("gtEventStatus")) {
			dc.add(Restrictions.gt("eventStatus", params.get("gtEventStatus")));
		}
		if (params.containsKey("ltEventStatus")) {
			dc.add(Restrictions.lt("eventStatus", params.get("ltEventStatus")));
		}
		if (params.containsKey("eventExpand")) {
			dc.add(Restrictions.eq("eventExpand", params.get("eventExpand")));
		}
		if (params.containsKey("eventExp")) {
			dc.add(Restrictions.eq("eventExp", params.get("eventExp")));
		}
		if (params.containsKey("eventTop")) {
			dc.add(Restrictions.eq("eventTop", params.get("eventTop")));
		}
		if (params.containsKey("eventOrder")) {
			dc.add(Restrictions.eq("eventOrder", params.get("eventOrder")));
		}
		if (params.containsKey("geEventExp")) {
			dc.add(Restrictions.ge("eventExp", params.get("geEventExp")));
		}
		if (params.containsKey("leEventExp")) {
			dc.add(Restrictions.le("eventExp", params.get("leEventExp")));
		}
		if (params.containsKey("eventRecovery")) {
			dc.add(Restrictions.eq("eventRecovery", params.get("eventRecovery")));
		}
	}

	private void setOrder(DetachedCriteria dc, Map<String, Boolean> orders) {
		if (orders == null || orders.size() == 0) {
			return;
		}
		if (orders.containsKey("eventTop")) {
			if (orders.get("eventTop")) {
				dc.addOrder(Order.asc("eventTop"));
			} else {
				dc.addOrder(Order.desc("eventTop"));
			}
		}
		if (orders.containsKey("eventOrder")) {
			if (orders.get("eventOrder")) {
				dc.addOrder(Order.asc("eventOrder"));
			} else {
				dc.addOrder(Order.desc("eventOrder"));
			}
		}
		if (orders.containsKey("eventStart")) {
			if (orders.get("eventStart")) {
				dc.addOrder(Order.asc("eventStart"));
			} else {
				dc.addOrder(Order.desc("eventStart"));
			}
		}
		if (orders.containsKey("eventId")) {
			if (orders.get("eventId")) {
				dc.addOrder(Order.asc("eventId"));
			} else {
				dc.addOrder(Order.desc("eventId"));
			}
		}

	}

}
