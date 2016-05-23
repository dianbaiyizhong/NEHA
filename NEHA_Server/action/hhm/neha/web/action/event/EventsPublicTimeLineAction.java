/**
 *
 */
package hhm.neha.web.action.event;

import hhm.neha.entity.EventList;
import hhm.neha.service.EventListService;
import hhm.neha.web.action.BaseAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @comment 所有事件列表
 */
public class EventsPublicTimeLineAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3988110722023584645L;
	private EventListService eventListService;
	private List<EventList> events;
	private Integer next;
	private Integer total;
	private Long time;
	private Integer max_id;
	private Integer since_id;
	private Integer count;

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
	 * @return the since_id
	 */
	public Integer getSince_id() {
		return since_id;
	}

	/**
	 * @param since_id
	 *            the since_id to set
	 */
	public void setSince_id(Integer since_id) {
		this.since_id = since_id;
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
	 * 获取最新的几条数据
	 * 
	 * @return
	 */
	public String timeline() {
		if (this.count == null || this.count < 1 || this.count >= 100)
			this.count = 10;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("eventStatus", 20);
		if (this.max_id != null && this.max_id.intValue() > 0) {
			params.put("ltEventId", max_id);
		}
		if (this.since_id != null && this.since_id.intValue() > 0) {
			params.put("gtEventId", since_id);
		}
		Map<String, Boolean> orders = new HashMap<String, Boolean>();
		orders.put("eventId", false);
		events = eventListService.getEventListByParamsAndPage(params, orders,
				0, count);
		if (events.size() == 0) {
			next = 0;
		} else {
			next = events.get(events.size() - 1).getEventId();
		}
		total = events.size();
		time = System.currentTimeMillis();
		return SUCCESS;
	}

}
