/**
 *
 */
package hhm.neha.web.action.category;

import hhm.neha.entity.CategorySiteOne;
import hhm.neha.service.CategorySiteOneService;
import hhm.neha.web.action.BaseAction;

import java.util.List;

public class SiteCategoryOneAction extends BaseAction {
	private CategorySiteOneService categorySiteOneService;
	private List<CategorySiteOne> class1es;
	private Integer total;
	private Long time;

	/**
	 * @return the categorySiteOneService
	 */
	public CategorySiteOneService getCategorySiteOneService() {
		return categorySiteOneService;
	}

	/**
	 * @param categorySiteOneService
	 *            the categorySiteOneService to set
	 */
	public void setCategorySiteOneService(
			CategorySiteOneService categorySiteOneService) {
		this.categorySiteOneService = categorySiteOneService;
	}

	/**
	 * @return the class1es
	 */
	public List<CategorySiteOne> getClass1es() {
		return class1es;
	}

	/**
	 * @param class1es
	 *            the class1es to set
	 */
	public void setClass1es(List<CategorySiteOne> class1es) {
		this.class1es = class1es;
	}

	/**
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * @return the time
	 */
	public Long getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(Long time) {
		this.time = time;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7976754678934826507L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		this.class1es = categorySiteOneService.loadAll();
		this.total = class1es.size();
		time = System.currentTimeMillis();
		return SUCCESS;
	}

}
