/**
 * 
 */
package hhm.neha.service;

import java.util.List;

/**
 * 
 * @comment 部分通用service方法
 * 
 */
public class ServiceAbstract {
	/**
	 * 获取结果总数
	 * 
	 * @param list
	 * @return
	 */
	protected int getCount(List<Integer> list) {
		if (list == null || list.size() == 0)
			return 0;
		return list.get(0).intValue();
	}
}
