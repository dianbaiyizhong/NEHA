/**
 *
 */
package hhm.neha.web.action.category;

import hhm.neha.entity.CategoryEvent;
import hhm.neha.service.CategoryEventService;
import hhm.neha.web.action.BaseAction;

import java.util.List;

/**
 * 
 * @comment 舆情事件分类
 */
public class EventCategoryAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 986360437350888621L;
	private CategoryEventService categoryEventService;
	private List<CategoryEvent> categories;
	private Integer total;
	private Long time;

	/**
	 * @return the categoryEventService
	 */
	public CategoryEventService getCategoryEventService() {
		return categoryEventService;
	}

	/**
	 * @param categoryEventService
	 *            the categoryEventService to set
	 */
	public void setCategoryEventService(
			CategoryEventService categoryEventService) {
		this.categoryEventService = categoryEventService;
	}

	/**
	 * @return the categories
	 */
	public List<CategoryEvent> getCategories() {
		return categories;
	}

	/**
	 * @param categories
	 *            the categories to set
	 */
	public void setCategories(List<CategoryEvent> categories) {
		this.categories = categories;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		categories = categoryEventService.loadNormal();
		total = categories.size();
		time = System.currentTimeMillis();
		return super.execute();
	}

}
