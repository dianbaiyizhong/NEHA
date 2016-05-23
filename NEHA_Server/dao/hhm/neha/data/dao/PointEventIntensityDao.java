/**
 * 
 */
package hhm.neha.data.dao;

import hhm.neha.entity.PointEventIntensity;

import java.util.List;

public interface PointEventIntensityDao {
	/**
	 * 根据事件ID获取最近的一条强度信息
	 * 
	 * @param eventId
	 * @return
	 */
	public List<PointEventIntensity> getLastIntensityByEvent(Integer eventId);
}
