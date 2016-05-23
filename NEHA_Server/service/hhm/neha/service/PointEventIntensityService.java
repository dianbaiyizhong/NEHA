/**
 * 
 */
package hhm.neha.service;

public interface PointEventIntensityService {
	/**
	 * 根据事件ID获取最近的一条强度信息
	 * 
	 * @param eventId
	 * @return
	 */
	public int getLastIntensityByEvent(Integer eventId);

}
