/**
 * 
 */
package hhm.neha.model;

/**
 * @author Ran Xu
 * @data 2014-6-5 上午9:12:12 
 * @company 浙江传媒学院-互联网与社会研究中心  CIS
 * @address 中国杭州下沙高教园区学源街998号
 * @tel 0571-86879294
 * @home www.cischina.org
 * @comment 
 *
 */
public class TodayHotRankPointBean {
	private String title;
	private Integer point;
	private String datetime;
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the point
	 */
	public Integer getPoint() {
		return point;
	}
	/**
	 * @param point the point to set
	 */
	public void setPoint(Integer point) {
		this.point = point;
	}
	/**
	 * @return the datetime
	 */
	public String getDatetime() {
		return datetime;
	}
	/**
	 * @param datetime the datetime to set
	 */
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	/**
	 * @param title
	 * @param point
	 * @param datetime
	 */
	public TodayHotRankPointBean(String title, Integer point, String datetime) {
		super();
		this.title = title;
		this.point = point;
		this.datetime = datetime;
	}
	/**
	 * 
	 */
	public TodayHotRankPointBean() {
		super();
	}
	
}
