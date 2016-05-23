/**
 *
 */
package hhm.neha.web.action.point;

import hhm.neha.entity.EventList;
import hhm.neha.entity.PointMultipleRealTime;
import hhm.neha.service.EventListService;
import hhm.neha.service.PointMultipleRealTimeService;
import hhm.neha.web.action.BaseAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @comment 获取某一舆情事件的多条实时指数数据
 */
public class MultipleEventPointsAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1331999663424428347L;
	private EventListService eventListService;
	private PointMultipleRealTimeService pointMultipleRealTimeService;
	private Integer event_id;
	private List<PointMultipleRealTime> points;
	private Integer max_id;
	private Integer count;
	private Integer total;
	private Integer next;
	private Long time;

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
	 * @return the pointMultipleRealTimeService
	 */
	public PointMultipleRealTimeService getPointMultipleRealTimeService() {
		return pointMultipleRealTimeService;
	}

	/**
	 * @param pointMultipleRealTimeService
	 *            the pointMultipleRealTimeService to set
	 */
	public void setPointMultipleRealTimeService(
			PointMultipleRealTimeService pointMultipleRealTimeService) {
		this.pointMultipleRealTimeService = pointMultipleRealTimeService;
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
	 * @return the points
	 */
	public List<PointMultipleRealTime> getPoints() {
		return points;
	}

	/**
	 * @param points
	 *            the points to set
	 */
	public void setPoints(List<PointMultipleRealTime> points) {
		this.points = points;
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
		if (event_id == null) {
			request.setAttribute("error_code", 20003);
			return "error";
		}
		EventList event = eventListService.get(event_id);
		if (event == null || event.getEventStatus().intValue() <= 10) {
			request.setAttribute("error_code", 30201);
			return "error";
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ampEventId", event_id);
		params.put("ampStatus", true);
		if (max_id != null) {
			params.put("ltAmpId", max_id);
		}
		if (count == null || count.intValue() > 100) {
			count = 20;
		}
		points = pointMultipleRealTimeService.getMultiplePointByParamsAndPage(
				params, 0, count.intValue());
		total = points.size();
		if (total.intValue() < 1) {
			next = 0;
		} else {
			next = points.get(total - 1).getAmpId();
		}
		time = System.currentTimeMillis();
		return SUCCESS;
	}

}
