/**
 * 
 */
package hhm.neha.dao;

import hhm.neha.entity.AnalysisSearchList;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**

 * @comment 
 *
 */
public interface AnalysisSearchListDao {
	/**
	 * 根据主键获取
	 * @param id
	 * @return
	 */
	public AnalysisSearchList get(Integer id);
	
	/**
	 * 根据检索条件和翻页参数获取
	 * @param params
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public List<AnalysisSearchList> getAnalysisSearchListByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults);
	
	/**
	 * 根据检索条件获取结果总数
	 * @param params
	 * @return
	 */
	public List<Integer> getCountByParams(Map<String, Object> params);
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(AnalysisSearchList entity);
	
	/**
	 * 根据事件和时间段的文章总数
	 * @param eventId
	 * @param date
	 * @return
	 */
	public List<Integer> getWebCountByEventAndDate(Integer eventId, Timestamp startTime, Timestamp endTime);
}
