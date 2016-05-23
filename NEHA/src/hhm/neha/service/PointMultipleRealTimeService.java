/**
 * 
 */
package hhm.neha.service;


import hhm.neha.entity.PointMultipleRealTime;

/**
 * @author Ran Xu
 * @data 2014-3-6 上午10:30:12 
 * @company 浙江传媒学院-互联网与社会研究中心  CIS
 * @address 中国杭州下沙高教园区学源街998号
 * @tel 0571-86879294
 * @home www.cischina.org
 * @comment 
 *
 */
public interface PointMultipleRealTimeService {
	/**
	 * 获取最新的一条数据
	 * @param eventid
	 * @return
	 */
	public PointMultipleRealTime getNewPoint(Integer eventid);
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(PointMultipleRealTime entity);
}
