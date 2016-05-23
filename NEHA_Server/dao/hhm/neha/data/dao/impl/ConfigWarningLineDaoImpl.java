/**
 *
 */
package hhm.neha.data.dao.impl;

import hhm.neha.data.dao.ConfigWarningLineDao;
import hhm.neha.entity.ConfigWarningLine;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ConfigWarningLineDaoImpl extends HibernateDaoSupport implements
		ConfigWarningLineDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qawaa.data.dao.ConfigWarningLineDao#loadNormalConfigWarningLine()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<ConfigWarningLine> loadNormalConfigWarningLine() {
		DetachedCriteria dc = DetachedCriteria
				.forClass(ConfigWarningLine.class);
		dc.add(Restrictions.eq("wnlStatus", true));
		dc.addOrder(Order.desc("wnlOrder"));
		return this.getHibernateTemplate().findByCriteria(dc, 0, 10);
	}

}
