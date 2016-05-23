/**
 *
 */
package hhm.neha.web.action.point;

import hhm.neha.entity.PointMultipleRealTime;
import hhm.neha.service.PointMultipleRealTimeService;
import hhm.neha.web.action.BaseAction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @comment 根据多个事件ID批量获取这些事件的实时指数
 */
public class BatchMultipleRealTimePointAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4962332120605222011L;
	private PointMultipleRealTimeService pointMultipleRealTimeService;
	private Integer[] event_ids;
	private List<PointMultipleRealTime> points;
	private Integer total;
	private Integer next;
	private Long time;

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
	 * @return the event_ids
	 */
	public Integer[] getEvent_ids() {
		return event_ids;
	}

	/**
	 * @param event_ids
	 *            the event_ids to set
	 */
	public void setEvent_ids(Integer[] event_ids) {
		this.event_ids = event_ids;
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
		if (event_ids == null || event_ids.length == 0) {
			request.setAttribute("error_code", 20003);
			return "error";
		}
		points = new ArrayList<PointMultipleRealTime>();
		for (Integer id : event_ids) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("ampEventId", id);
			params.put("ampStatus", true);
			points.addAll(pointMultipleRealTimeService
					.getMultiplePointByParamsAndPage(params, 0, 1));
		}
		next = 0;
		time = System.currentTimeMillis();
		total = points.size();
		return super.execute();
	}

}
