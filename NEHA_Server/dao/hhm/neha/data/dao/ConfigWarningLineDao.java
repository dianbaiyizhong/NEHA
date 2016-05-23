/**
 *
 */
package hhm.neha.data.dao;

import hhm.neha.entity.ConfigWarningLine;

import java.util.List;

public interface ConfigWarningLineDao {
	/**
	 * 获取所有状态正常的数据
	 * 
	 * @return
	 */
	public List<ConfigWarningLine> loadNormalConfigWarningLine();
}
