/**
 *
 */
package hhm.neha.dao;

import hhm.neha.entity.PointMultipleHourly;

import java.util.List;
import java.util.Map;

/**
 * @author Ryan
 * @datetime 2014-3-15 下午10:10:31
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public interface PointMultipleHourlyDao {
	/**
	 * 根据主键获取
	 * @param id
	 * @return
	 */
	public PointMultipleHourly get(Integer id);
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(PointMultipleHourly entity);
	
	/**
	 * 根据检索和翻页参数获取结果集
	 * @param params
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public List<PointMultipleHourly> getPointMultipleHourlyByParamsAndPage(Map<String, Object> params, int firstResult, int maxResults);
	
	/**
	 * 根据检索参数获取结果总数
	 * @param params
	 * @return
	 */
	public List<Integer> getCountByParams(Map<String, Object> params);
}
