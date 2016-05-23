/**
 * 
 */
package hhm.neha.model;

import java.util.List;

/**
 * @author Ran Xu
 * @data 2014-6-5 上午9:14:39 
 * @company 浙江传媒学院-互联网与社会研究中心  CIS
 * @address 中国杭州下沙高教园区学源街998号
 * @tel 0571-86879294
 * @home www.cischina.org
 * @comment 
 *
 */
public class TodayHotRankBean {
	public String time;
    public int total;
    public List<TodayHotRankPointBean> hotEvents;
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	/**
	 * @return the hotEvents
	 */
	public List<TodayHotRankPointBean> getHotEvents() {
		return hotEvents;
	}
	/**
	 * @param hotEvents the hotEvents to set
	 */
	public void setHotEvents(List<TodayHotRankPointBean> hotEvents) {
		this.hotEvents = hotEvents;
	}
    
}
