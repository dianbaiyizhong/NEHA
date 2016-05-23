/**
 * 
 */
package hhm.neha.service;

import hhm.neha.entity.AnalysisSearchList;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**

 * @comment 
 *
 */
public interface AnalysisSearchListService {
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
	public int getCountByParams(Map<String, Object> params);
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(AnalysisSearchList entity);
	
	/**
	 * 根据url和eventid获取一个数据
	 * @param urlMd5
	 * @param eventId
	 * @return
	 */
	public AnalysisSearchList getAnalysisSearchListByURLAndEvent(String urlMd5, Integer eventId);
	
	/**
	 * 根据事件和时间获取改时间所在天的文章总数
	 * @param eventId
	 * @param date
	 * @return
	 */
	public int getWebCountByEventAndDate(Integer eventId, Timestamp date);
	
}
