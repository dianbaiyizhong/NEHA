/**
 *
 */
package hhm.neha.data.bean;

/**
 * 
 * @comment 授权信息BEAN
 */
public class AuthorizeBean {
	private Integer id;
	private String user;
	private boolean status;
	private long expTime;

	/**
	 * 
	 */
	public AuthorizeBean() {
		super();
	}

	/**
	 * @param id
	 * @param user
	 * @param status
	 * @param expTime
	 */
	public AuthorizeBean(Integer id, String user, boolean status, long expTime) {
		super();
		this.id = id;
		this.user = user;
		this.status = status;
		this.expTime = expTime;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the expTime
	 */
	public long getExpTime() {
		return expTime;
	}

	/**
	 * @param expTime
	 *            the expTime to set
	 */
	public void setExpTime(long expTime) {
		this.expTime = expTime;
	}
}
