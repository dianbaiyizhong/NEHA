/**
 * 
 */
package hhm.neha.data.dao.impl;

import hhm.neha.data.dao.PointEventIntensityDao;
import hhm.neha.entity.PointEventIntensity;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class PointEventIntensityDaoImpl extends HibernateDaoSupport implements
		PointEventIntensityDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qawaa.data.dao.PointEventIntensityDao#getLastIntensityByEvent(java
	 * .lang.Integer)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<PointEventIntensity> getLastIntensityByEvent(Integer eventId) {
		if (eventId == null)
			return null;
		DetachedCriteria dc = DetachedCriteria
				.forClass(PointEventIntensity.class);
		dc.add(Restrictions.eq("pesEventId", eventId));
		dc.add(Restrictions.eq("pesStatus", true));
		dc.addOrder(Order.desc("pesDate"));
		return this.getHibernateTemplate().findByCriteria(dc, 0, 1);
	}

}
