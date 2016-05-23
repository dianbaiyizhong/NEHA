/**
 * 
 */
package hhm.neha.framework.hibernate3;

import java.util.List;
import java.util.Map;

/**
 * 
 * @comment 用于定义dao接口的部分常用方法
 * 
 */
public interface HibernateDaoInterface {
	/**
	 * 根据主键获取
	 * 
	 * @param <T>
	 * @param id
	 * @return
	 */
	public <T> T get(Integer id);

	/**
	 * 保存或更新数据
	 * 
	 * @param entity
	 */
	public <T> void saveOrUpdate(T entity);

	/**
	 * 删除
	 * 
	 * @param entity
	 */
	public <T> void del(T entity);

	/**
	 * 根据主键删除
	 * 
	 * @param id
	 */
	public void del(Integer id);

	/**
	 * 根据检索条件和翻页参数获取
	 * 
	 * @param params
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public List<?> getEntitiesByParamsAndPages(Map<String, Object> params,
			int firstResult, int maxResults);

	/**
	 * 根据检索条件获取结果总数
	 * 
	 * @param params
	 * @return
	 */
	public List<Integer> getCountByParamsAndPages(Map<String, Object> params);
}
