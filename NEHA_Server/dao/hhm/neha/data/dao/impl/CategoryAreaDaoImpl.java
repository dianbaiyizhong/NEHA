/**
 *
 */
package hhm.neha.data.dao.impl;

import hhm.neha.data.dao.CategoryAreaDao;
import hhm.neha.entity.CategoryArea;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CategoryAreaDaoImpl extends HibernateDaoSupport implements
		CategoryAreaDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qawaa.data.dao.CategoryAreaDao#loadNormal()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<CategoryArea> loadNormal() {
		DetachedCriteria dc = DetachedCriteria.forClass(CategoryArea.class);
		dc.add(Restrictions.eq("cgaStatus", true));
		dc.addOrder(Order.desc("cgaOrder"));
		return this.getHibernateTemplate().findByCriteria(dc, 0, 100);
	}

}
