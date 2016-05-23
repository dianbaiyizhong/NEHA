/**
 *
 */
package hhm.neha.service;

import hhm.neha.data.bean.HotEventBean;
import hhm.neha.entity.PointMultipleDaily;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface PointMultipleDailyService {
	/**
	 * 根据检索参数和翻页参数获取
	 * 
	 * @param params
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public List<PointMultipleDaily> getMultipleDayPointsByParamsAndPage(
			Map<String, Object> params, int firstResult, int maxResults);

	/**
	 * 根据时间获取当日热门事件
	 * 
	 * @param date
	 * @return
	 */
	public List<HotEventBean> getDailyHotEvent(Date date);
}
