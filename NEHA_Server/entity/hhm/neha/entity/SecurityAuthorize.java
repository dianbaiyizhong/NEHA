package hhm.neha.entity;

import java.sql.Timestamp;

/**
 * SecurityAuthorize entity. @author MyEclipse Persistence Tools
 */

public class SecurityAuthorize implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2637117537725667958L;
	private Integer autId;
	private String autToken;
	private String autUser;
	private Timestamp autExpDate;
	private Boolean autStatus;

	// Constructors

	/** default constructor */
	public SecurityAuthorize() {
	}

	/** full constructor */
	public SecurityAuthorize(String autToken, String autUser,
			Timestamp autExpDate, Boolean autStatus) {
		this.autToken = autToken;
		this.autUser = autUser;
		this.autExpDate = autExpDate;
		this.autStatus = autStatus;
	}

	// Property accessors

	public Integer getAutId() {
		return this.autId;
	}

	public void setAutId(Integer autId) {
		this.autId = autId;
	}

	public String getAutToken() {
		return this.autToken;
	}

	public void setAutToken(String autToken) {
		this.autToken = autToken;
	}

	public String getAutUser() {
		return this.autUser;
	}

	public void setAutUser(String autUser) {
		this.autUser = autUser;
	}

	public Timestamp getAutExpDate() {
		return this.autExpDate;
	}

	public void setAutExpDate(Timestamp autExpDate) {
		this.autExpDate = autExpDate;
	}

	public Boolean getAutStatus() {
		return this.autStatus;
	}

	public void setAutStatus(Boolean autStatus) {
		this.autStatus = autStatus;
	}

}