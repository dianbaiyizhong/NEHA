/**
 *
 */
package hhm.neha.web.action.rank;

import hhm.neha.data.bean.HotEventBean;
import hhm.neha.service.PointMultipleDailyService;
import hhm.neha.web.action.BaseAction;

import java.util.Date;
import java.util.List;

/**
 * 
 * @comment 每日指数最高事件排行榜
 */
public class HotRankDailyAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6695429394348155672L;

	private PointMultipleDailyService pointMultipleDailyService;
	private List<HotEventBean> hotEvents;
	private Long time = System.currentTimeMillis();
	private Integer total = 0;

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
	 * @return the hotEvents
	 */
	public List<HotEventBean> getHotEvents() {
		return hotEvents;
	}

	/**
	 * @param hotEvents
	 *            the hotEvents to set
	 */
	public void setHotEvents(List<HotEventBean> hotEvents) {
		this.hotEvents = hotEvents;
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

	public String today() {
		this.hotEvents = pointMultipleDailyService.getDailyHotEvent(new Date());
		total = hotEvents.size();
		return SUCCESS;
	}
}
