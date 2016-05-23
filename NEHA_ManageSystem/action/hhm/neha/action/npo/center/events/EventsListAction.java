/**
 * 
 */
package hhm.neha.action.npo.center.events;

import hhm.neha.action.AjaxBaseAction;
import hhm.neha.data.entity.CategoryEvent;
import hhm.neha.data.entity.EventList;
import hhm.neha.data.entity.EventStatus;
import hhm.neha.service.CategoryEventService;
import hhm.neha.service.EventListService;
import hhm.neha.service.EventStatusService;
import hhm.neha.web.page.PageUtil;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.qawaa.utils.DateUtil;
import com.qawaa.utils.NumberUtil;


/**

 * @comment 舆情事件action
 *
 */
public class EventsListAction extends AjaxBaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3634372066296579865L;
	private EventListService eventListService;
	private CategoryEventService categoryEventService;
	private EventStatusService eventStatusService;
	private List<CategoryEvent> categories;
	private List<EventList> events;
	private List<EventStatus> statuses;
	private EventList event;
	private EventList parentEvent;
	private Integer eventId;
	private int pageNum = 1;
	private int pageSize = 20;
	private PageUtil page;
	
	/**
	 * @return the eventListService
	 */
	public EventListService getEventListService() {
		return eventListService;
	}

	/**
	 * @param eventListService the eventListService to set
	 */
	public void setEventListService(EventListService eventListService) {
		this.eventListService = eventListService;
	}

	/**
	 * @return the categoryEventService
	 */
	public CategoryEventService getCategoryEventService() {
		return categoryEventService;
	}

	/**
	 * @param categoryEventService the categoryEventService to set
	 */
	public void setCategoryEventService(CategoryEventService categoryEventService) {
		this.categoryEventService = categoryEventService;
	}

	/**
	 * @return the eventStatusService
	 */
	public EventStatusService getEventStatusService() {
		return eventStatusService;
	}

	/**
	 * @param eventStatusService the eventStatusService to set
	 */
	public void setEventStatusService(EventStatusService eventStatusService) {
		this.eventStatusService = eventStatusService;
	}

	/**
	 * @return the categories
	 */
	public List<CategoryEvent> getCategories() {
		return categories;
	}

	/**
	 * @param categories the categories to set
	 */
	public void setCategories(List<CategoryEvent> categories) {
		this.categories = categories;
	}

	/**
	 * @return the events
	 */
	public List<EventList> getEvents() {
		return events;
	}

	/**
	 * @param events the events to set
	 */
	public void setEvents(List<EventList> events) {
		this.events = events;
	}

	/**
	 * @return the statuses
	 */
	public List<EventStatus> getStatuses() {
		return statuses;
	}

	/**
	 * @param statuses the statuses to set
	 */
	public void setStatuses(List<EventStatus> statuses) {
		this.statuses = statuses;
	}

	/**
	 * @return the event
	 */
	public EventList getEvent() {
		return event;
	}

	/**
	 * @param event the event to set
	 */
	public void setEvent(EventList event) {
		this.event = event;
	}

	/**
	 * @return the parentEvent
	 */
	public EventList getParentEvent() {
		return parentEvent;
	}

	/**
	 * @param parentEvent the parentEvent to set
	 */
	public void setParentEvent(EventList parentEvent) {
		this.parentEvent = parentEvent;
	}

	/**
	 * @return the eventId
	 */
	public Integer getEventId() {
		return eventId;
	}

	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	/**
	 * @return the pageNum
	 */
	public int getPageNum() {
		return pageNum;
	}

	/**
	 * @param pageNum the pageNum to set
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
	 * @param pageSize the pageSize to set
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
	 * @param page the page to set
	 */
	public void setPage(PageUtil page) {
		this.page = page;
	}
	
	/**
	 * 转换分类数组
	 * @param old
	 * @return
	 */
	private String transCategory(String old){
		if(StringUtils.isBlank(old))
			return null;
		String ids[] = old.split(",");
		if(ids.length == 0)
			return null;
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<ids.length;i++){
			if(!NumberUtil.isInteger(ids[i].trim()))
				continue;
			buffer.append("#");
			buffer.append(ids[i].trim());
			buffer.append("#");
			if(i != ids.length-1)
				buffer.append(",");
		}
		return buffer.toString();
	}

	/**
	 * 舆情事件列表
	 * @return
	 */
	public String list(){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("eventRecovery", false);
		if(event != null){
			
			if(StringUtils.isNotBlank(event.getEventTitle())){
				params.put("ilikEventTitle", event.getEventTitle().trim());
			}
			if(event.getEventId() != null){
				params.put("eventId", event.getEventId());
			}
			if(event.getEventTop() != null){
				params.put("eventTop", event.getEventTop());
			}
			if(event.getEventStatus() != null){
				params.put("eventStatus", event.getEventStatus());
			}
			if(event.getEventStart() != null){
				params.put("gEventStart", event.getEventStart());
			}
			if(event.getEventExp() != null){
				params.put("lEventExp", event.getEventExp());
			}
			if(event.getEventParent() != null){
				if(event.getEventParent().intValue() == 0){
					params.put("eventParent", 0);
				}else if(event.getEventParent().intValue() == -1){
					params.put("gtEventParent", 0);
				}else{
					params.put("eventParent", event.getEventParent());
				}
			}
		}
		int count = this.eventListService.getCountByParamsAndPages(params);
		page = new PageUtil(pageNum, pageSize, count);
		events = this.eventListService.getEntitiesByParamsAndPages(params, page.getStartData(), pageSize);
		return SUCCESS;
	}
	
	/**
	 * 详情
	 * @return
	 */
	public String view(){
		if(this.eventId == null){
			this.setAjaxJson(this.getText("gobal.alert.fail.params.null"), "", "", "closeCurrent", "");
			return AJAXERROR;
		}
		this.event = this.eventListService.get(eventId);
		if(event == null){
			this.setAjaxJson(this.getText("gobal.alert.save.fail.unexist"), "", "", "closeCurrent", "");
			return AJAXERROR;
		}
		if(event.getEventParent().intValue() == 0){
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("eventRecovery", false);
			params.put("eventParent", eventId);
			int count = this.eventListService.getCountByParamsAndPages(params);
			page = new PageUtil(pageNum, pageSize, count);
			events = this.eventListService.getEntitiesByParamsAndPages(params, page.getStartData(), pageSize);
		}else{
			this.parentEvent = eventListService.get(event.getEventParent());
		}
		int cate_count = this.categoryEventService.getCountByParamsAndPages(null);
		this.categories = this.categoryEventService.getEntitiesByParamsAndPages(null, 0, cate_count);
		return SUCCESS;
	}
	/**
	 * 添加
	 * @return
	 */
	public String add(){
		int cate_count = this.categoryEventService.getCountByParamsAndPages(null);
		this.categories = this.categoryEventService.getEntitiesByParamsAndPages(null, 0, cate_count);
		return SUCCESS;
	}
	/**
	 * 编辑
	 * @return
	 */
	public String edit(){
		if(this.eventId == null){
			this.setAjaxJson(this.getText("gobal.alert.fail.params.null"), "", "", "closeCurrent", "");
			return AJAXERROR;
		}
		this.event = this.eventListService.get(eventId);
		if(event == null){
			this.setAjaxJson(this.getText("gobal.alert.save.fail.unexist"), "", "", "closeCurrent", "");
			return AJAXERROR;
		}
		if(event.getEventParent().intValue() != 0){
			EventList entity = eventListService.get(event.getEventParent());
			if(entity == null){
				event.setParentName("");
				event.setEventParent(0);
			}else{
				event.setParentName(entity.getEventTitle());
			}	
		}
		int cate_count = this.categoryEventService.getCountByParamsAndPages(null);
		this.categories = this.categoryEventService.getEntitiesByParamsAndPages(null, 0, cate_count);
		int status_count = this.eventStatusService.getCountByParamsAndPages(null);
		this.statuses = this.eventStatusService.getEntitiesByParamsAndPages(null, 0, status_count);
		return SUCCESS;
	}
	/**
	 * 保存
	 * @return
	 */
	public String save(){
		if(event == null){
			this.setAjaxJson(this.getText("gobal.alert.fail.params.null"), "", "", "", "");
			return AJAXERROR;
		}
		String categoryIds = this.transCategory(event.getEventCategory());
		if(StringUtils.isBlank(categoryIds)){
			this.setAjaxJson(this.getText("npo.center.events.index.event.save.fail.category.null"), "", "", "", "");
			return AJAXERROR;
		}
		if(event.getEventParent() == null)
			event.setEventParent(0);
		if(eventListService.isExistByTitle(event.getEventTitle(), eventId)){
			String[] args = {event.getEventTitle()};
			this.setAjaxJson(this.getText("npo.center.events.index.event.save.fail.title.exist", args), "", "", "", "");
			return AJAXERROR;
		}
		if(eventListService.isExistByKeyword(event.getEventKeyword(), eventId)){
			String[] args = {event.getEventKeyword()};
			this.setAjaxJson(this.getText("npo.center.events.index.event.save.fail.keyword.exist", args), "", "", "", "");
			return AJAXERROR;
		}
		if(event.getEventParent() > 0 && !eventListService.isExistById(event.getEventParent())){
			String[] args = {event.getEventParent().toString()};
			this.setAjaxJson(this.getText("npo.center.events.index.event.save.fail.parent.unexist", args), "", "", "", "");
			return AJAXERROR;
		}
		if(eventId == null){
			event.setEventStatus(10);
			event.setEventCategory(categoryIds);
			event.setEventExpand(0);
			event.setEventStart(new Timestamp(DateUtil.getBeginTimeOfDay(event.getEventStart()).getTime()));
			event.setEventExp(new Timestamp(DateUtil.getLastTimeOfDay(event.getEventExp()).getTime()));
			event.setEventDate(new Timestamp(System.currentTimeMillis()));
			event.setEventScanDate(new Timestamp(0L));
			event.setEventRecovery(false);
			this.eventListService.saveOrUpdate(event);
		}else{
			if(event.getEventParent().intValue() == eventId.intValue()){
				this.setAjaxJson(this.getText("npo.center.events.index.event.save.fail.parent.self"), "", "", "closeCurrent", "");
				return AJAXERROR;
			}
			if(event.getEventParent().intValue() != 0 && eventListService.isExistChildEvent(eventId)){
				this.setAjaxJson(this.getText("npo.center.events.index.event.save.fail.haschildevent"), "", "", "closeCurrent", "");
				return AJAXERROR;
			}
			EventList entity = eventListService.get(eventId);
			if(entity == null){
				this.setAjaxJson(this.getText("gobal.alert.save.fail.unexist"), "", "", "closeCurrent", "");
				return AJAXERROR;
			}
			entity.setEventTitle(event.getEventTitle());
			entity.setEventShortTitle(event.getEventShortTitle());
			entity.setEventAbstract(event.getEventAbstract());
			entity.setEventStatus(event.getEventStatus());
			entity.setEventCategory(categoryIds);
			entity.setEventKeyword(event.getEventKeyword());
			entity.setEventStart(new Timestamp(DateUtil.getBeginTimeOfDay(event.getEventStart()).getTime()));
			entity.setEventExp(new Timestamp(DateUtil.getLastTimeOfDay(event.getEventExp()).getTime()));
			entity.setEventTop(event.getEventTop());
			entity.setEventOrder(event.getEventOrder());
			entity.setEventParent(event.getEventParent());
			this.eventListService.saveOrUpdate(entity);
		}
		this.setAjaxJson(this.getText("gobal.alert.save.success"), this.getNavTabId(), "", "closeCurrent", "");
		return AJAXSUCCESS;
	}
	/**
	 * 删除
	 * @return
	 */
	public String del(){
		if(this.eventId == null){
			this.setAjaxJson(this.getText("gobal.alert.fail.params.null"), "", "", "", "");
			return AJAXERROR;
		}
		eventListService.del(eventId);
		this.setAjaxJson(this.getText("gobal.alert.del.success"), this.getNavTabId(), "", "", "");
		return AJAXSUCCESS;
	}
	/**
	 * 高级检索
	 * @return
	 */
	public String advanceSearch(){
		return SUCCESS;
	}
	
	/**
	 * 查找建议
	 * @return
	 */
	public String suggest(){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("eventRecovery", false);
		params.put("eventParent", 0);
		if(eventId != null){
			params.put("nEventId", eventId);
		}
		events = this.eventListService.getEntitiesByParamsAndPages(params, 0, 5);
		return SUCCESS;
	}
	
	/**
	 * 查找带回
	 * @return
	 */
	public String lookup(){
		if(event == null)
			event = new EventList();
		event.setEventParent(0);
		event.setEventRecovery(false);
		return this.list();
	}
}
