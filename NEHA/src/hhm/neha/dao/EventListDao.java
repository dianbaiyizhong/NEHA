package hhm.neha.dao;

import hhm.neha.entity.EventList;

import java.util.List;
import java.util.Map;


/**

 * @comment 
 *
 */
public interface EventListDao {
	/**
	 * 根据主键获取
	 * @param id
	 * @return
	 */
	public EventList get(Integer id);
	
	/**
	 * 根据检索参数、起始值以及最大值参数获取
	 * @param params
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public List<EventList> getEventListByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults);
	
	/**
	 * 更新
	 * @param entity
	 */
	public void update(EventList entity);
	
	/**
	 * 根据主键更新状态
	 * @param id 主键
	 * @param status 状态码
	 */
	public void updateStatus(Integer id, Integer status);
	
	/**
	 * 根据检索参数获取结果总数
	 * @param params
	 * @return
	 */
	public List<Integer> getCountByParams(Map<String, Object> params);

	/**
	 * 获取最近一条的请求扫描的事件
	 * @return
	 */
	public List<EventList> getRequestEventList();
	
	/**
	 * 根据主键更新扫描时间
	 * @param id
	 */
	public void updateScanDate(Integer id);
}
