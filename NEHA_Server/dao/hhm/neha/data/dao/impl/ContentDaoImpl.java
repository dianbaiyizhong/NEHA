package hhm.neha.data.dao.impl;

import hhm.neha.data.dao.ContentDao;
import hhm.neha.entity.Content;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ContentDaoImpl extends HibernateDaoSupport implements ContentDao {
	@SuppressWarnings("unchecked")
	public List<Content> getByEventId(int eventId) {
		DetachedCriteria dc = DetachedCriteria.forClass(Content.class);

		dc.add(Restrictions.eq("eventId", eventId));

		return this.getHibernateTemplate().findByCriteria(dc, 0, 100);
	}

}
