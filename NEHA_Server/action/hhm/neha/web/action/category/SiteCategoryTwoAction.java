/**
 *
 */
package hhm.neha.web.action.category;

import hhm.neha.entity.CategorySiteTwo;
import hhm.neha.service.CategorySiteTwoService;
import hhm.neha.web.action.BaseAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @comment 网站类型二级分类
 */
public class SiteCategoryTwoAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7148050869535592659L;
	private CategorySiteTwoService categorySiteTwoService;
	private Integer class1_id;
	private Integer id;
	private Integer[] ids;
	private List<CategorySiteTwo> class2es;
	private Integer total;
	private Long time;

	/**
	 * @return the categorySiteTwoService
	 */
	public CategorySiteTwoService getCategorySiteTwoService() {
		return categorySiteTwoService;
	}

	/**
	 * @param categorySiteTwoService
	 *            the categorySiteTwoService to set
	 */
	public void setCategorySiteTwoService(
			CategorySiteTwoService categorySiteTwoService) {
		this.categorySiteTwoService = categorySiteTwoService;
	}

	/**
	 * @return the class1_id
	 */
	public Integer getClass1_id() {
		return class1_id;
	}

	/**
	 * @param class1_id
	 *            the class1_id to set
	 */
	public void setClass1_id(Integer class1_id) {
		this.class1_id = class1_id;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the ids
	 */
	public Integer[] getIds() {
		return ids;
	}

	/**
	 * @param ids
	 *            the ids to set
	 */
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	/**
	 * @return the class2s
	 */
	public List<CategorySiteTwo> getClass2es() {
		return class2es;
	}

	/**
	 * @param class2s
	 *            the class2s to set
	 */
	public void setClass2es(List<CategorySiteTwo> class2es) {
		this.class2es = class2es;
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
		Map<String, Object> params = new HashMap<String, Object>(4);
		params.put("cstStatus", true);
		if (this.class1_id == null) {
			request.setAttribute("error_code", 30101);
			return "error";
		}
		params.put("cstOneId", class1_id);
		if (this.id != null) {
			params.put("cstId", id);
		}
		if (this.ids != null && ids.length > 0) {
			params.put("ids", ids);
		}
		this.class2es = categorySiteTwoService
				.getCategorySiteTwoByParamsAndPage(params, 0, 100);
		this.total = class2es.size();
		time = System.currentTimeMillis();
		return super.execute();
	}

}
