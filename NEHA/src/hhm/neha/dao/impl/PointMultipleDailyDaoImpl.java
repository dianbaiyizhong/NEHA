/**
 * 
 */
package hhm.neha.dao.impl;

import hhm.neha.dao.PointMultipleDailyDao;
import hhm.neha.entity.PointMultipleDaily;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class PointMultipleDailyDaoImpl extends HibernateDaoSupport implements PointMultipleDailyDao {

	/* (non-Javadoc)
	 * @see com.qawaa.dao.PointMultipleDailyDao#save(com.qawaa.data.entity.PointMultipleDaily)
	 */
	@Override
	public void save(PointMultipleDaily entity) {
		if(entity != null)
			this.getHibernateTemplate().saveOrUpdate(entity);

	}

	/* (non-Javadoc)
	 * @see com.qawaa.dao.PointMultipleDailyDao#getPointMultipleDailyByParamsAndPage(java.util.Map, int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PointMultipleDaily> getPointMultipleDailyByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults) {
		DetachedCriteria dc = DetachedCriteria.forClass(PointMultipleDaily.class);
		this.setQuery(dc, params);
		dc.addOrder(Order.desc("mdpDate"));
		return this.getHibernateTemplate().findByCriteria(dc, firstResult, maxResults);
	}
	
	private void setQuery(DetachedCriteria dc, Map<String, Object> params){
		if(params == null || params.size() == 0)
			return;
		if(params.containsKey("mdpId")){
			dc.add(Restrictions.eq("mdpId", params.get("mdpId")));
		}
		if(params.containsKey("mdpEventId")){
			dc.add(Restrictions.eq("mdpEventId", params.get("mdpEventId")));
		}
		if(params.containsKey("mdpPoint")){
			dc.add(Restrictions.eq("mdpPoint", params.get("mdpPoint")));
		}
		if(params.containsKey("mdpDate")){
			dc.add(Restrictions.eq("mdpDate", params.get("mdpDate")));
		}
		if(params.containsKey("mdpStatus")){
			dc.add(Restrictions.eq("mdpStatus", params.get("mdpStatus")));
		}
	}

}
