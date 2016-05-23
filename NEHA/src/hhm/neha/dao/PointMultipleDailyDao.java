/**
 * 
 */
package hhm.neha.dao;

import hhm.neha.entity.PointMultipleDaily;

import java.util.List;
import java.util.Map;

/**

 * @comment 
 *
 */
public interface PointMultipleDailyDao {
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
	
}
