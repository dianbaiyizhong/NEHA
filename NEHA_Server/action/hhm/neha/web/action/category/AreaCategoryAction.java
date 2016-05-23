/**
 *
 */
package hhm.neha.web.action.category;

import hhm.neha.entity.CategoryArea;
import hhm.neha.service.CategoryAreaService;
import hhm.neha.web.action.BaseAction;

import java.util.List;

/**
 * 
 * @comment 获取地区信息
 */
public class AreaCategoryAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9028718702903632319L;
	private CategoryAreaService categoryAreaService;
	private List<CategoryArea> areas;
	private Integer total;
	private Long time;

	/**
	 * @return the categoryAreaService
	 */
	public CategoryAreaService getCategoryAreaService() {
		return categoryAreaService;
	}

	/**
	 * @param categoryAreaService
	 *            the categoryAreaService to set
	 */
	public void setCategoryAreaService(CategoryAreaService categoryAreaService) {
		this.categoryAreaService = categoryAreaService;
	}

	/**
	 * @return the areas
	 */
	public List<CategoryArea> getAreas() {
		return areas;
	}

	/**
	 * @param areas
	 *            the areas to set
	 */
	public void setAreas(List<CategoryArea> areas) {
		this.areas = areas;
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
		areas = categoryAreaService.loadNormal();
		total = areas.size();
		time = System.currentTimeMillis();
		return SUCCESS;
	}

}
