/**
 *
 */
package hhm.neha.web.action.event;

import hhm.neha.entity.CategoryEvent;
import hhm.neha.entity.EventList;
import hhm.neha.service.CategoryEventService;
import hhm.neha.service.EventListService;
import hhm.neha.web.action.BaseAction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventCategoryAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8817305375427985378L;
	private EventListService eventListService;
	private CategoryEventService categoryEventService;
	private List<EventList> events;
	private CategoryEvent category;
	private Integer category_id;
	private Integer event_id;
	private Integer count = 10;
	private Integer max_id;
	private Integer next = 0;
	private Integer total = 0;
	private Long time = System.currentTimeMillis();

	/**
	 * @return the eventListService
	 */
	public EventListService getEventListService() {
		return eventListService;
	}

	/**
	 * @param eventListService
	 *            the eventListService to set
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
	 * @param categoryEventService
	 *            the categoryEventService to set
	 */
	public void setCategoryEventService(
			CategoryEventService categoryEventService) {
		this.categoryEventService = categoryEventService;
	}

	/**
	 * @return the events
	 */
	public List<EventList> getEvents() {
		return events;
	}

	/**
	 * @param events
	 *            the events to set
	 */
	public void setEvents(List<EventList> events) {
		this.events = events;
	}

	/**
	 * @return the category
	 */
	public CategoryEvent getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(CategoryEvent category) {
		this.category = category;
	}

	/**
	 * @return the category_id
	 */
	public Integer getCategory_id() {
		return category_id;
	}

	/**
	 * @param category_id
	 *            the category_id to set
	 */
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	/**
	 * @return the event_id
	 */
	public Integer getEvent_id() {
		return event_id;
	}

	/**
	 * @param event_id
	 *            the event_id to set
	 */
	public void setEvent_id(Integer event_id) {
		this.event_id = event_id;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * @return the max_id
	 */
	public Integer getMax_id() {
		return max_id;
	}

	/**
	 * @param max_id
	 *            the max_id to set
	 */
	public void setMax_id(Integer max_id) {
		this.max_id = max_id;
	}

	/**
	 * @return the next
	 */
	public Integer getNext() {
		return next;
	}

	/**
	 * @param next
	 *            the next to set
	 */
	public void setNext(Integer next) {
		this.next = next;
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
	 * 根据分类获取数据
	 * 
	 * @return
	 */
	public String category() {
		if (category_id == null || category_id.intValue() < 1) {
			if (event_id == null) {
				request.setAttribute("error_code", 20003);
				return "error";
			}
		}
		events = new ArrayList<EventList>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("eventRecovery", false);
		params.put("gtEventStatus", 11);
		params.put("ilikeEventCategory", "#" + category_id + "#");
		if (max_id != null) {
			params.put("ltEventId", max_id);
		}
		if (count == null || count.intValue() > 100) {
			count = 10;
		}
		Map<String, Boolean> orders = new HashMap<String, Boolean>();
		orders.put("eventTop", false);
		orders.put("eventOrder", false);
		orders.put("eventStart", false);
		events = this.eventListService.getEventListByParamsAndPage(params,
				orders, 0, count);
		total = events.size();
		if (total > 0) {
			category = categoryEventService.get(category_id);
		}
		return SUCCESS;
	}

}
