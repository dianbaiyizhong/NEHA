/**
 *
 */
package hhm.neha.data.dao;

import hhm.neha.entity.SecurityAuthorize;

import java.util.List;
import java.util.Map;

public interface SecurityAuthorizeDao {
	/**
	 * 根据检索条件获取
	 * 
	 * @param params
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public List<SecurityAuthorize> getSecurityAuthorizeByParams(
			Map<String, Object> params, int firstResult, int maxResults);
}
