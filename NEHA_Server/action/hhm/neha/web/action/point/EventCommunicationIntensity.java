/**
 * 
 */
package hhm.neha.web.action.point;

import hhm.neha.service.PointEventIntensityService;
import hhm.neha.web.action.BaseAction;

/**
 * 
 * @comment 舆情传播强度
 * 
 */
public class EventCommunicationIntensity extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5723266752379573665L;
	private PointEventIntensityService pointEventIntensityService;
	private Integer event_id;
	private Integer intensity;
	private Integer total = 0;
	private Integer next = 0;
	private Long time = System.currentTimeMillis();

	/**
	 * @return the pointEventIntensityService
	 */
	public PointEventIntensityService getPointEventIntensityService() {
		return pointEventIntensityService;
	}

	/**
	 * @param pointEventIntensityService
	 *            the pointEventIntensityService to set
	 */
	public void setPointEventIntensityService(
			PointEventIntensityService pointEventIntensityService) {
		this.pointEventIntensityService = pointEventIntensityService;
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
	 * @return the intensity
	 */
	public Integer getIntensity() {
		return intensity;
	}

	/**
	 * @param intensity
	 *            the intensity to set
	 */
	public void setIntensity(Integer intensity) {
		this.intensity = intensity;
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
	 * 返回单条舆情事件的传播强度
	 * 
	 * @return
	 */
	public String singleIntensity() {
		if (event_id == null) {
			request.setAttribute("error_code", 20003);
			return "error";
		}
		this.intensity = pointEventIntensityService
				.getLastIntensityByEvent(event_id);
		this.total = 1;
		return SUCCESS;
	}
}
