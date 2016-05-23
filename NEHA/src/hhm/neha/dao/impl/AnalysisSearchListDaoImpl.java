/**
 * 
 */
package hhm.neha.dao.impl;

import hhm.neha.dao.AnalysisSearchListDao;
import hhm.neha.entity.AnalysisSearchList;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**

 * @comment 
 *
 */
public class AnalysisSearchListDaoImpl extends HibernateDaoSupport implements AnalysisSearchListDao {
	
	/* (non-Javadoc)
	 * @see com.qawaa.dao.AnalysisSearchListDao#get(java.lang.Integer)
	 */
	@Override
	public AnalysisSearchList get(Integer id) {
		if(id == null)
			return null;
		return this.getHibernateTemplate().get(AnalysisSearchList.class, id);
	}

	/* (non-Javadoc)
	 * @see com.qawaa.dao.AnalysisSearchListDao#getAnalysisSearchListByParamsAndPage(java.util.Map, int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<AnalysisSearchList> getAnalysisSearchListByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults) {
		DetachedCriteria dc = DetachedCriteria.forClass(AnalysisSearchList.class);
		this.setQuery(dc, params);
		dc.addOrder(Order.desc("aslPushDate"));
		return this.getHibernateTemplate().findByCriteria(dc, firstResult, maxResults);
	}

	/* (non-Javadoc)
	 * @see com.qawaa.dao.AnalysisSearchListDao#getCountByParams(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getCountByParams(Map<String, Object> params) {
		DetachedCriteria dc = DetachedCriteria.forClass(AnalysisSearchList.class);
		this.setQuery(dc, params);
		dc.setProjection(Projections.count("aslId"));
		return this.getHibernateTemplate().findByCriteria(dc, 0, 1);
	}


	@Override
	public void save(AnalysisSearchList entity) {
		if(entity != null)
			this.getHibernateTemplate().saveOrUpdate(entity);

	}
	
	/**
	 * @param dc
	 * @param params
	 */
	private void setQuery(DetachedCriteria dc, Map<String, Object> params){
		if(params == null || params.size() == 0)
			return;
		if(params.containsKey("aslId")){
			dc.add(Restrictions.eq("aslId", params.get("aslId")));
		}
		if(params.containsKey("aslEventId")){
			dc.add(Restrictions.eq("aslEventId", params.get("aslEventId")));
		}
		if(params.containsKey("aslUrl")){
			dc.add(Restrictions.eq("aslUrl", params.get("aslUrl")));
		}
		if(params.containsKey("aslUrlMd5")){
			dc.add(Restrictions.eq("aslUrlMd5", params.get("aslUrlMd5")));
		}
		if(params.containsKey("aslPushDate")){
			dc.add(Restrictions.eq("aslPushDate", params.get("aslPushDate")));
		}
		if(params.containsKey("aslCount")){
			dc.add(Restrictions.eq("aslCount", params.get("aslCount")));
		}
		if(params.containsKey("aslSearchDate")){
			dc.add(Restrictions.eq("aslSearchDate", params.get("aslSearchDate")));
		}
	}

	/* (non-Javadoc)
	 * @see com.qawaa.dao.AnalysisSearchListDao#getWebCountByEventAndDate(java.lang.Integer, java.sql.Timestamp, java.sql.Timestamp)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getWebCountByEventAndDate(Integer eventId, Timestamp startTime, Timestamp endTime) {
		DetachedCriteria dc = DetachedCriteria.forClass(AnalysisSearchList.class);
		dc.add(Restrictions.eq("aslEventId", eventId));
		dc.add(Restrictions.between("aslPushDate", startTime, endTime));
		dc.setProjection(Projections.sum("aslCount"));
		return this.getHibernateTemplate().findByCriteria(dc, 0, 1);
	}

}
