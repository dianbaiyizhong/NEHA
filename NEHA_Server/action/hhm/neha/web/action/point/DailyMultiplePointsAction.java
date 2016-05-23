/**
 *
 */
package hhm.neha.web.action.point;

import hhm.neha.entity.EventList;
import hhm.neha.entity.PointMultipleDaily;
import hhm.neha.service.EventListService;
import hhm.neha.service.PointMultipleDailyService;
import hhm.neha.web.action.BaseAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.json.annotations.JSON;

/**
 * 
 * @comment 获取舆情事件的每天舆情指数
 */
public class DailyMultiplePointsAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4227370037737627547L;
	private PointMultipleDailyService pointMultipleDailyService;
	private EventListService eventListService;
	private PointMultipleDaily point;
	private List<PointMultipleDaily> points;
	private Integer event_id;
	private Integer max_point;
	private Integer min_point;
	private Integer count = 10;
	private Integer total = 0;
	private Integer next = 0;
	private Long time = System.currentTimeMillis();

	/**
	 * @return the pointMultipleDailyService
	 */
	public PointMultipleDailyService getPointMultipleDailyService() {
		return pointMultipleDailyService;
	}

	/**
	 * @param pointMultipleDailyService
	 *            the pointMultipleDailyService to set
	 */
	public void setPointMultipleDailyService(
			PointMultipleDailyService pointMultipleDailyService) {
		this.pointMultipleDailyService = pointMultipleDailyService;
	}

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
	 * @return the point
	 */
	@JSON(name = "p")
	public PointMultipleDaily getPoint() {
		return point;
	}

	/**
	 * @param point
	 *            the point to set
	 */
	public void setPoint(PointMultipleDaily point) {
		this.point = point;
	}

	/**
	 * @return the points
	 */
	public List<PointMultipleDaily> getPoints() {
		return points;
	}

	/**
	 * @param points
	 *            the points to set
	 */
	public void setPoints(List<PointMultipleDaily> points) {
		this.points = points;
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
	 * @return the max_point
	 */
	public Integer getMax_point() {
		return max_point;
	}

	/**
	 * @param max_point
	 *            the max_point to set
	 */
	public void setMax_point(Integer max_point) {
		this.max_point = max_point;
	}

	/**
	 * @return the min_point
	 */
	public Integer getMin_point() {
		return min_point;
	}

	/**
	 * @param min_point
	 *            the min_point to set
	 */
	public void setMin_point(Integer min_point) {
		this.min_point = min_point;
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

	/**
	 * 根据事件ID获取最新的一条数据
	 * 
	 * @return
	 */
	public String timeline() {
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
		params.put("mdpEventId", event_id);
		params.put("mdpStatus", true);
		if (min_point != null)
			params.put("gtMdpId", min_point);
		points = pointMultipleDailyService.getMultipleDayPointsByParamsAndPage(
				params, 0, 1);
		if (points.size() != 0) {
			point = points.get(0);
			total = 1;
			next = point.getMdpId();
		}
		return SUCCESS;
	}

	/**
	 * 根据事件ID获取多条数据
	 * 
	 * @return
	 */
	public String batch() {
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
		params.put("mdpEventId", event_id);
		params.put("mdpStatus", true);
		if (max_point != null)
			params.put("ltMdpId", max_point);
		if (count == null || count.intValue() > 100)
			count = 10;
		points = this.pointMultipleDailyService
				.getMultipleDayPointsByParamsAndPage(params, 0, count);
		total = points.size();
		if (total != 0) {
			next = points.get(total - 1).getMdpId();
		}
		return SUCCESS;
	}
}
