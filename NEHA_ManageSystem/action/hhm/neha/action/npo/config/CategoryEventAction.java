/**
 * 
 */
package hhm.neha.action.npo.config;

import hhm.neha.action.AjaxBaseAction;
import hhm.neha.data.entity.CategoryEvent;
import hhm.neha.service.CategoryEventService;
import hhm.neha.web.page.PageUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @comment 舆情事件分类配置
 * 
 */
public class CategoryEventAction extends AjaxBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3262382753031142959L;
	private CategoryEventService categoryEventService;
	private List<CategoryEvent> cateEvents;
	private CategoryEvent cateEvent;
	private Integer cid;
	private int pageNum = 1;
	private int pageSize = 20;
	private PageUtil page;

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
	 * @return the cateEvents
	 */
	public List<CategoryEvent> getCateEvents() {
		return cateEvents;
	}

	/**
	 * @param cateEvents
	 *            the cateEvents to set
	 */
	public void setCateEvents(List<CategoryEvent> cateEvents) {
		this.cateEvents = cateEvents;
	}

	/**
	 * @return the cateEvent
	 */
	public CategoryEvent getCateEvent() {
		return cateEvent;
	}

	/**
	 * @param cateEvent
	 *            the cateEvent to set
	 */
	public void setCateEvent(CategoryEvent cateEvent) {
		this.cateEvent = cateEvent;
	}

	/**
	 * @return the cid
	 */
	public Integer getCid() {
		return cid;
	}

	/**
	 * @param cid
	 *            the cid to set
	 */
	public void setCid(Integer cid) {
		this.cid = cid;
	}

	/**
	 * @return the pageNum
	 */
	public int getPageNum() {
		return pageNum;
	}

	/**
	 * @param pageNum
	 *            the pageNum to set
	 */
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the page
	 */
	public PageUtil getPage() {
		return page;
	}

	/**
	 * @param page
	 *            the page to set
	 */
	public void setPage(PageUtil page) {
		this.page = page;
	}

	/**
	 * 列表
	 * 
	 * @return
	 */
	public String index() {
		Map<String, Object> params = null;
		if (cateEvent != null) {
			params = new HashMap<String, Object>();
			if (cateEvent.getCgeId() != null) {
				params.put("cgeId", cateEvent.getCgeId());
			}
			if (StringUtils.isNotBlank(cateEvent.getCgeName())) {
				params.put("ilikeCgeName", cateEvent.getCgeName().trim());
			}
			if (cateEvent.getCgeStatus() != null) {
				params.put("cgeStatus", cateEvent.getCgeStatus());
			}
			if (cateEvent.getCgeOrder() != null) {
				params.put("cgeOrder", cateEvent.getCgeOrder());
			}
		}
		int count = this.categoryEventService.getCountByParamsAndPages(params);
		page = new PageUtil(pageNum, pageSize, count);
		cateEvents = this.categoryEventService.getEntitiesByParamsAndPages(
				params, page.getStartData(), pageSize);
		return SUCCESS;
	}

	/**
	 * 添加
	 * 
	 * @return
	 */
	public String add() {
		return SUCCESS;
	}

	/**
	 * 编辑
	 * 
	 * @return
	 */
	public String edit() {
		if (this.cid == null) {
			this.setAjaxJson(this.getText("gobal.alert.fail.params.null"), "",
					"", "closeCurrent", "");
			return AJAXERROR;
		}
		this.cateEvent = this.categoryEventService.get(cid);
		if (cateEvent == null) {
			this.setAjaxJson(this.getText("gobal.alert.save.fail.unexist"), "",
					"", "closeCurrent", "");
			return AJAXERROR;
		}
		return SUCCESS;
	}

	/**
	 * 保存
	 * 
	 * @return
	 */
	public String save() {
		if (categoryEventService.isExistByName(cateEvent.getCgeName(), cid)) {
			String[] args = { cateEvent.getCgeName() };
			this.setAjaxJson(this.getText(
					"npo.config.category.save.name.exist", args), "", "", "",
					"");
			return AJAXERROR;
		}
		if (cid == null) {
			if (this.categoryEventService.isExistById(cateEvent.getCgeId())) {
				String[] args = { cateEvent.getCgeId().toString() };
				this.setAjaxJson(this.getText(
						"npo.config.category.save.id.exist", args), "", "", "",
						"");
				return AJAXERROR;
			}
			this.categoryEventService.saveOrUpdate(cateEvent);
		} else {
			CategoryEvent entity = this.categoryEventService.get(cid);
			if (entity == null) {
				this.setAjaxJson(this.getText("gobal.alert.save.fail.unexist"),
						"", "", "closeCurrent", "");
				return AJAXERROR;
			}
			entity.setCgeName(cateEvent.getCgeName());
			entity.setCgeOrder(cateEvent.getCgeOrder());
			entity.setCgeStatus(cateEvent.getCgeStatus());
			entity.setCgeComment(cateEvent.getCgeComment());
			this.categoryEventService.saveOrUpdate(entity);
		}
		this.setAjaxJson(this.getText("gobal.alert.save.success"), this
				.getNavTabId(), "", "closeCurrent", "");
		return AJAXSUCCESS;
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String del() {
		if (cid == null) {
			this.setAjaxJson(this.getText("gobal.alert.fail.params.null"), "",
					"", "", "");
			return AJAXERROR;
		}
		this.categoryEventService.del(cid);
		this.setAjaxJson(this.getText("gobal.alert.del.success"), this
				.getNavTabId(), "", "", "");
		return AJAXSUCCESS;
	}

	/**
	 * 高级检索
	 * 
	 * @return
	 */
	public String advanceSearch() {
		return SUCCESS;
	}
}
