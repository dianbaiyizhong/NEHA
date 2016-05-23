/**
 * 
 */
package hhm.neha.dao.impl;

import hhm.neha.dao.PointMultipleRealTimeDao;
import hhm.neha.entity.PointMultipleRealTime;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Ran Xu
 * @data 2014-3-6 上午10:27:14 
 * @company 浙江传媒学院-互联网与社会研究中心  CIS
 * @address 中国杭州下沙高教园区学源街998号
 * @tel 0571-86879294
 * @home www.cischina.org
 * @comment 
 *
 */
public class PointMultipleRealTimeDaoImpl extends HibernateDaoSupport implements PointMultipleRealTimeDao {

	/* (non-Javadoc)
	 * @see com.qawaa.dao.PointMultipleRealTimeDao#getNewPoint(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PointMultipleRealTime> getNewPoint(Integer eventid) {
		DetachedCriteria dc = DetachedCriteria.forClass(PointMultipleRealTime.class);
		dc.add(Restrictions.eq("ampEventId", eventid));
		dc.addOrder(Order.desc("ampId"));
		return this.getHibernateTemplate().findByCriteria(dc, 0, 1);
	}

	/* (non-Javadoc)
	 * @see com.qawaa.dao.PointMultipleRealTimeDao#save(com.qawaa.data.entity.PointMultipleRealTime)
	 */
	@Override
	public void save(PointMultipleRealTime entity) {
		if(entity != null)
			this.getHibernateTemplate().save(entity);

	}

}
