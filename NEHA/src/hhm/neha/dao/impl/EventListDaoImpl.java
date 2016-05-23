package hhm.neha.dao.impl;
import hhm.neha.dao.EventListDao;
import hhm.neha.entity.EventList;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



public class EventListDaoImpl extends HibernateDaoSupport implements
		EventListDao {

	/* (non-Javadoc)
	 * @see com.qawaa.dao.EventListDao#get(java.lang.Integer)
	 */
	@Override
	public EventList get(Integer id) {
		if(id == null)
			return null;
		return this.getHibernateTemplate().get(EventList.class, id);
	}

	/* (non-Javadoc)
	 * @see com.qawaa.dao.EventListDao#getEventListByParamsAndPage(java.util.Map, int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EventList> getEventListByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults) {
		DetachedCriteria dc = DetachedCriteria.forClass(EventList.class);
		this.setQuery(dc, params);
		dc.addOrder(Order.desc("eventId"));
		return this.getHibernateTemplate().findByCriteria(dc, firstResult, maxResults);
	}


	@Override
	public void update(EventList entity) {
		if(entity != null)
			this.getHibernateTemplate().update(entity);

	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getCountByParams(Map<String, Object> params) {
		DetachedCriteria dc = DetachedCriteria.forClass(EventList.class);
		this.setQuery(dc, params);
		dc.setProjection(Projections.count("eventId"));
		return this.getHibernateTemplate().findByCriteria(dc, 0, 1);
	}
	
	/**
	 * @param dc
	 * @param params
	 */
	private void setQuery(DetachedCriteria dc, Map<String, Object> params){
		if(params == null || params.size() == 0)
			return;
		if(params.containsKey("eventId")){
			dc.add(Restrictions.eq("eventId", params.get("eventId")));
		}
		if(params.containsKey("ltEventId")){
			dc.add(Restrictions.lt("eventId", params.get("ltEventId")));
		}
		if(params.containsKey("eventStatus")){
			dc.add(Restrictions.eq("eventStatus", params.get("eventStatus")));
		}
		if(params.containsKey("eventAnalysisId")){
			dc.add(Restrictions.eq("eventAnalysisId", params.get("eventAnalysisId")));
		}
		if(params.containsKey("eventExpand")){
			dc.add(Restrictions.eq("eventExpand", params.get("eventExpand")));
		}
		if(params.containsKey("eventTop")){
			dc.add(Restrictions.eq("eventTop", params.get("eventTop")));
		}
		if(params.containsKey("eventOrder")){
			dc.add(Restrictions.eq("eventOrder", params.get("eventOrder")));
		}
		if(params.containsKey("eventDate")){
			dc.add(Restrictions.eq("eventDate", params.get("eventDate")));
		}
	}

	/* (non-Javadoc)
	 * @see com.qawaa.dao.EventListDao#updateStatus(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public void updateStatus(Integer id, Integer status) {
		if(id == null || status == null)
			return;
		String hql = "update EventList set eventStatus = ? where eventId = ?";
		Object values[] = {status, id};
		this.getHibernateTemplate().bulkUpdate(hql, values);
	}

	/* (non-Javadoc)
	 * @see com.qawaa.dao.EventListDao#getRequestEventList()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EventList> getRequestEventList() {
		String hql = "from EventList where eventStatus = ? or eventStatus = ? and eventRecovery = ? order by eventScanDate asc";
		Query query = this.getSession().createQuery(hql);
		query.setInteger(0, 10);
		query.setInteger(1, 20);
		query.setBoolean(2, false);
		query.setMaxResults(1);
		return query.list();
	}

	/* (non-Javadoc)
	 * @see com.qawaa.dao.EventListDao#updateScanDate(java.lang.Integer)
	 */
	@Override
	public void updateScanDate(Integer id) {
		if(id == null)
			return;
		String hql = "update EventList set eventScanDate = ? where eventId = ?";
		Object values[] = {new Timestamp(System.currentTimeMillis()), id};
		this.getHibernateTemplate().bulkUpdate(hql, values);
		
	}

}
