/**
 *
 */
package hhm.neha.data.dao.impl;

import hhm.neha.data.dao.CategorySiteTwoDao;
import hhm.neha.entity.CategorySiteTwo;

import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CategorySiteTwoDaoImpl extends HibernateDaoSupport implements
		CategorySiteTwoDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.qawaa.data.dao.CategorySiteTwoDao#getCategorySiteTwoByParamsAndPage
	 * (java.util.Map, int, int)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<CategorySiteTwo> getCategorySiteTwoByParamsAndPage(
			Map<String, Object> params, int firstResult, int maxResults) {
		DetachedCriteria dc = DetachedCriteria.forClass(CategorySiteTwo.class);
		this.setQuery(dc, params);
		dc.addOrder(Order.desc("cstOrder"));
		return this.getHibernateTemplate().findByCriteria(dc, firstResult,
				maxResults);
	}

	private void setQuery(DetachedCriteria dc, Map<String, Object> params) {
		if (params == null || params.size() == 1)
			return;
		if (params.containsKey("cstId")) {
			dc.add(Restrictions.eq("cstId", params.get("cstId")));
		}
		if (params.containsKey("cstOneId")) {
			dc.add(Restrictions.eq("cstOneId", params.get("cstOneId")));
		}
		if (params.containsKey("cstStatus")) {
			dc.add(Restrictions.eq("cstStatus", params.get("cstStatus")));
		}
		if (params.containsKey("ids")) {
			dc.add(Restrictions.in("cstId", (Object[]) params.get("ids")));
		}
	}

}
