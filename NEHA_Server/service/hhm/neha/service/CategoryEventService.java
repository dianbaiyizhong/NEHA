/**
 *
 */
package hhm.neha.service;

import hhm.neha.entity.CategoryEvent;

import java.util.List;

public interface CategoryEventService {
	/**
	 * 获取所有状态正常的数据
	 * 
	 * @return
	 */
	public List<CategoryEvent> loadNormal();

	/**
	 * @param id
	 * @return
	 */
	public CategoryEvent get(Integer id);
}
