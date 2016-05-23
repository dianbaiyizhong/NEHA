/**
 *
 */
package hhm.neha.service;

import hhm.neha.entity.SystemVersion;

import java.util.List;
import java.util.Map;

public interface SystemVersionService {
	/**
	 * 根据检索和翻页参数获取
	 * 
	 * @param params
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public List<SystemVersion> getSystemVersionByParamsAndPage(
			Map<String, Object> params, int firstResult, int maxResults);

	/**
	 * 获取当前的系统版本
	 * 
	 * @return
	 */
	public SystemVersion now();
}
