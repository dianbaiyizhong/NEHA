/**
 *
 */
package hhm.neha.data.bean;

import java.util.Date;


public class OnlineUserBean {
	private Integer id;
	private String name;
	private String realName;
	private String loginIP;
	private Date loginTime;
	private Double code;
	private Integer companyId;
	private Integer groupId;
	private String lastLoginIp;
	private Date lastLoginTime;
	private Integer loginCount;
	private String lastLoginAddress;

	/**
	 * @param id
	 * @param name
	 * @param realName
	 * @param loginIP
	 * @param loginTime
	 * @param code
	 * @param company
	 * @param group
	 * @param lastLoginIp
	 * @param lastLoginTime
	 * @param loginCount
	 */
	public OnlineUserBean(Integer id, String name, String realName, String loginIP, Date loginTime, Double code, Integer companyId, Integer groupId, String lastLoginIp, Date lastLoginTime, Integer loginCount) {
		super();
		this.id = id;
		this.name = name;
		this.realName = realName;
		this.loginIP = loginIP;
		this.loginTime = loginTime;
		this.code = code;
		this.companyId = companyId;
		this.groupId = groupId;
		this.lastLoginIp = lastLoginIp;
		this.lastLoginTime = lastLoginTime;
		this.loginCount = loginCount;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the realName
	 */
	public String getRealName() {
		return realName;
	}
	/**
	 * @param realName the realName to set
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}
	/**
	 * @return the loginIP
	 */
	public String getLoginIP() {
		return loginIP;
	}
	/**
	 * @param loginIP the loginIP to set
	 */
	public void setLoginIP(String loginIP) {
		this.loginIP = loginIP;
	}
	/**
	 * @return the loginTime
	 */
	public Date getLoginTime() {
		return loginTime;
	}
	/**
	 * @param loginTime the loginTime to set
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	/**
	 * @return the code
	 */
	public Double getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(Double code) {
		this.code = code;
	}
	/**
	 * @return the company
	 */
	public Integer getCompanyId() {
		return companyId;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	/**
	 * @return the group
	 */
	public Integer getGroupId() {
		return groupId;
	}
	/**
	 * @param group the group to set
	 */
	public void setGroup(Integer groupId) {
		this.groupId = groupId;
	}
	/**
	 * @return the lastLoginIp
	 */
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	/**
	 * @param lastLoginIp the lastLoginIp to set
	 */
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	/**
	 * @return the lastLoginTime
	 */
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	/**
	 * @param lastLoginTime the lastLoginTime to set
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	/**
	 * @return the loginCount
	 */
	public Integer getLoginCount() {
		return loginCount;
	}
	/**
	 * @param loginCount the loginCount to set
	 */
	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}
	/**
	 * @return the lastLoginAddress
	 */
	public String getLastLoginAddress() {
		return lastLoginAddress;
	}
	/**
	 * @param lastLoginAddress the lastLoginAddress to set
	 */
	public void setLastLoginAddress(String lastLoginAddress) {
		this.lastLoginAddress = lastLoginAddress;
	}
	
}
