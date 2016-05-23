package hhm.neha.area.dao.impl;

import hhm.neha.area.dao.ContentDao;
import hhm.neha.entity.Content;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class ContentDaoImpl extends HibernateDaoSupport implements ContentDao {

	public void save(Content content) {
		if (content != null) {
			this.getHibernateTemplate().save(content);

		}

	}

	@Override
	public List<Content> getAll() {
		return this.getHibernateTemplate().find("from Content");
	}

	@Override
	public void update(Content content) {
		this.getHibernateTemplate().update(content);
	}
}
