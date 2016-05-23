/**
 * 
 */
package hhm.neha.service;

import hhm.neha.data.entity.EventList;

import java.util.List;
import java.util.Map;


public interface EventListService {
	/**
	 * 根据主键获取
	 * @param <T>
	 * @param id
	 * @return
	 */
	public EventList get(Integer id);
	
	/**
	 * 保存或更新数据
	 * @param entity
	 */
	public void saveOrUpdate(EventList entity);
	
	/**
	 * 删除
	 * @param entity
	 */
	public void del(EventList entity);
	
	/**
	 * 根据主键删除
	 * @param id
	 */
	public void del(Integer id);
	
	/**
	 * 根据检索条件和翻页参数获取
	 * @param params
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public List<EventList> getEntitiesByParamsAndPages(Map<String, Object> params, int firstResult, int maxResults);
	
	/**
	 * 根据检索条件获取结果总数
	 * @param params
	 * @return
	 */
	public int getCountByParamsAndPages(Map<String, Object> params);
	
	/**
	 * 根据标题判断是否已经存在，存在返回true
	 * @param title
	 * @param id
	 * @return
	 */
	public boolean isExistByTitle(String title, Integer id);
	
	/**
	 * 根据关键字判断是否已经存在，存在返回true
	 * @param keyword
	 * @param id
	 * @return
	 */
	public boolean isExistByKeyword(String keyword, Integer id);
	
	/**
	 * 根据ID判断是否已经存在，存在返回true
	 * @param id
	 * @return
	 */
	public boolean isExistById(Integer id);
	
	/**
	 * 根据ID判断是否存在子事件，存在返回true
	 * @param id
	 * @return
	 */
	public boolean isExistChildEvent(Integer id);
}
