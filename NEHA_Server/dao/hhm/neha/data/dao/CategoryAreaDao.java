/**
 *
 */
package hhm.neha.data.dao;

import hhm.neha.entity.CategoryArea;

import java.util.List;

public interface CategoryAreaDao {
	/**
	 * 获取所有正常的数据
	 * 
	 * @return
	 */
	public List<CategoryArea> loadNormal();
}
