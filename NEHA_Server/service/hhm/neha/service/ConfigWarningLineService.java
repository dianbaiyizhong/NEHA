/**
 *
 */
package hhm.neha.service;

import hhm.neha.entity.ConfigWarningLine;

import java.util.List;

public interface ConfigWarningLineService {
	/**
	 * 获取所有状态正常的数据
	 * 
	 * @return
	 */
	public List<ConfigWarningLine> loadNormalConfigWarningLine();
}
