/**
 *
 */
package hhm.neha.data.dao.impl;

import hhm.neha.data.dao.CategoryEventDao;
import hhm.neha.entity.CategoryEvent;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CategoryEventDaoImpl extends HibernateDaoSupport implements
		CategoryEventDao {


	@Override
	@SuppressWarnings("unchecked")
	public List<CategoryEvent> loadNormal() {
		DetachedCriteria dc = DetachedCriteria.forClass(CategoryEvent.class);
		dc.add(Restrictions.eq("cgeStatus", true));
		dc.addOrder(Order.desc("cgeOrder"));
		return this.getHibernateTemplate().findByCriteria(dc, 0, 100);
	}

	
	@Override
	public CategoryEvent get(Integer id) {
		if (id == null)
			return null;
		return this.getHibernateTemplate().get(CategoryEvent.class, id);
	}

}
