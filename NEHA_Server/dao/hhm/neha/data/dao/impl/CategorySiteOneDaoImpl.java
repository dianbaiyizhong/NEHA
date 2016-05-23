/**
 *
 */
package hhm.neha.data.dao.impl;

import hhm.neha.data.dao.CategorySiteOneDao;
import hhm.neha.entity.CategorySiteOne;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class CategorySiteOneDaoImpl extends HibernateDaoSupport implements
		CategorySiteOneDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.qawaa.data.dao.CategorySiteOneDao#loadAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<CategorySiteOne> loadAll() {
		DetachedCriteria dc = DetachedCriteria.forClass(CategorySiteOne.class);
		dc.add(Restrictions.eq("csoStatus", true));
		dc.addOrder(Order.desc("csoOrder"));
		return this.getHibernateTemplate().findByCriteria(dc, 0, 100);
	}

}
