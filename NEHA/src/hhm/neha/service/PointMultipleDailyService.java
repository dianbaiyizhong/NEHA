/**
 * 
 */
package hhm.neha.service;

import hhm.neha.entity.PointMultipleDaily;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**

 * @comment 
 *
 */
public interface PointMultipleDailyService {
	/**
	 * 保存
	 * @param entity
	 */
	public void save(PointMultipleDaily entity);
	
	/**
	 * 根据检索和翻页参数获取结果
	 * @param params
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public List<PointMultipleDaily> getPointMultipleDailyByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults);
	
	/**
	 * 根据事件ID获取最新的一条数据
	 * @param eventId
	 * @return
	 */
	public PointMultipleDaily getLastPointMultipleDailyByEvent(Integer eventId);
	
	/**
	 * 根据事件和指定时间获取数据
	 * @param date
	 * @return
	 */
	public PointMultipleDaily getPointMultipleDailyByEventAndDate(Integer eventId, Date date);
}
