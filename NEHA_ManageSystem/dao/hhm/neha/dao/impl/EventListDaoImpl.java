/**
 * 
 */
package hhm.neha.dao.impl;

import hhm.neha.dao.EventListDao;
import hhm.neha.data.entity.EventList;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class EventListDaoImpl extends HibernateDaoSupport implements EventListDao {

	/* (non-Javadoc)
	 * @see org.cischina.framework.hibernate3.HibernateDaoInterface#get(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EventList get(Integer id) {
		if(id == null)
			return null;
		return this.getHibernateTemplate().get(EventList.class, id);
	}

	/* (non-Javadoc)
	 * @see org.cischina.framework.hibernate3.HibernateDaoInterface#saveOrUpdate(java.lang.Object)
	 */
	@Override
	public <T> void saveOrUpdate(T entity) {
		if(entity != null)
			this.getHibernateTemplate().saveOrUpdate(EventList.class.getName(), entity);

	}

	/* (non-Javadoc)
	 * @see org.cischina.framework.hibernate3.HibernateDaoInterface#del(java.lang.Object)
	 */
	@Override
	public <T> void del(T entity) {
		if(entity != null)
			this.getHibernateTemplate().delete(EventList.class.getName(), entity);

	}

	/* (non-Javadoc)
	 * @see org.cischina.framework.hibernate3.HibernateDaoInterface#del(java.lang.Integer)
	 */
	@Override
	public void del(Integer id) {
		String hql = "delete EventList where eventId='"+id+"'";
		this.getHibernateTemplate().bulkUpdate(hql);
	}

	/* (non-Javadoc)
	 * @see org.cischina.framework.hibernate3.HibernateDaoInterface#getEntitiesByParamsAndPages(java.util.Map, int, int)
	 */
	@Override
	public List<?> getEntitiesByParamsAndPages(Map<String, Object> params, int firstResult, int maxResults) {
		DetachedCriteria dc = DetachedCriteria.forClass(EventList.class);
		this.setQuery(params, dc);
		dc.addOrder(Order.desc("eventId"));
		return this.getHibernateTemplate().findByCriteria(dc, firstResult, maxResults);
	}

	/* (non-Javadoc)
	 * @see org.cischina.framework.hibernate3.HibernateDaoInterface#getCountByParamsAndPages(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getCountByParamsAndPages(Map<String, Object> params) {
		DetachedCriteria dc = DetachedCriteria.forClass(EventList.class);
		this.setQuery(params, dc);
		dc.setProjection(Projections.count("eventId"));
		return this.getHibernateTemplate().findByCriteria(dc, 0, 1);
	}
	
	private void setQuery(Map<String, Object> params, DetachedCriteria dc){
		if(params == null || params.size() == 0)
			return;
		if(params.containsKey("eventId")){
			dc.add(Restrictions.eq("eventId", params.get("eventId")));
		}
		if(params.containsKey("nEventId")){
			dc.add(Restrictions.ne("eventId", params.get("nEventId")));
		}
		if(params.containsKey("eventTitle")){
			dc.add(Restrictions.eq("eventTitle", params.get("eventTitle")));
		}
		if(params.containsKey("ilikEventTitle")){
			dc.add(Restrictions.ilike("eventTitle", (String) params.get("ilikEventTitle"),MatchMode.ANYWHERE));
		}
		if(params.containsKey("eventStatus")){
			dc.add(Restrictions.eq("eventStatus", params.get("eventStatus")));
		}
		if(params.containsKey("eventCategory")){
			dc.add(Restrictions.eq("eventCategory", params.get("eventCategory")));
		}
		if(params.containsKey("ilikEventCategory")){
			dc.add(Restrictions.ilike("eventCategory", (String) params.get("ilikEventCategory"),MatchMode.ANYWHERE));
		}
		if(params.containsKey("eventKeyword")){
			dc.add(Restrictions.eq("eventKeyword", params.get("eventKeyword")));
		}
		if(params.containsKey("ilikEventKeyword")){
			dc.add(Restrictions.ilike("eventKeyword", (String) params.get("ilikEventKeyword"),MatchMode.ANYWHERE));
		}
		if(params.containsKey("eventExpand")){
			dc.add(Restrictions.eq("eventExpand", params.get("eventExpand")));
		}
		if(params.containsKey("eventStart")){
			dc.add(Restrictions.eq("eventStart", params.get("eventStart")));
		}
		if(params.containsKey("gEventStart")){
			dc.add(Restrictions.ge("eventStart", params.get("gEventStart")));
		}
		if(params.containsKey("lEventStart")){
			dc.add(Restrictions.le("eventStart", params.get("lEventStart")));
		}
		if(params.containsKey("gEventExp")){
			dc.add(Restrictions.ge("eventExp", params.get("gEventExp")));
		}
		if(params.containsKey("lEventExp")){
			dc.add(Restrictions.le("eventExp", params.get("lEventExp")));
		}
		if(params.containsKey("eventTop")){
			dc.add(Restrictions.eq("eventTop", params.get("eventTop")));
		}
		if(params.containsKey("eventOrder")){
			dc.add(Restrictions.eq("eventOrder", params.get("eventOrder")));
		}
		if(params.containsKey("gEventOrder")){
			dc.add(Restrictions.ge("eventOrder", params.get("gEventOrder")));
		}
		if(params.containsKey("lEventOrder")){
			dc.add(Restrictions.le("eventOrder", params.get("lEventOrder")));
		}
		if(params.containsKey("gEventDate")){
			dc.add(Restrictions.ge("eventDate", params.get("gEventDate")));
		}
		if(params.containsKey("lEventDate")){
			dc.add(Restrictions.le("eventDate", params.get("lEventDate")));
		}
		if(params.containsKey("eventParent")){
			dc.add(Restrictions.eq("eventParent", params.get("eventParent")));
		}
		if(params.containsKey("gtEventParent")){
			dc.add(Restrictions.gt("eventParent", params.get("gtEventParent")));
		}
		if(params.containsKey("eventRecovery")){
			dc.add(Restrictions.eq("eventRecovery", params.get("eventRecovery")));
		}
	}

}
