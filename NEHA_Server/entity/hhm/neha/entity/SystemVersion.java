package hhm.neha.entity;

/**
 * SystemVersion entity. @author MyEclipse Persistence Tools
 */

public class SystemVersion implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 3645995770671490187L;
	private Integer verId;
	private String verName;
	private Boolean verStatus;
	private String verComment;

	// Constructors

	/** default constructor */
	public SystemVersion() {
	}

	/** minimal constructor */
	public SystemVersion(String verName, Boolean verStatus) {
		this.verName = verName;
		this.verStatus = verStatus;
	}

	/** full constructor */
	public SystemVersion(String verName, Boolean verStatus, String verComment) {
		this.verName = verName;
		this.verStatus = verStatus;
		this.verComment = verComment;
	}

	// Property accessors

	public Integer getVerId() {
		return this.verId;
	}

	public void setVerId(Integer verId) {
		this.verId = verId;
	}

	public String getVerName() {
		return this.verName;
	}

	public void setVerName(String verName) {
		this.verName = verName;
	}

	public Boolean getVerStatus() {
		return this.verStatus;
	}

	public void setVerStatus(Boolean verStatus) {
		this.verStatus = verStatus;
	}

	public String getVerComment() {
		return this.verComment;
	}

	public void setVerComment(String verComment) {
		this.verComment = verComment;
	}

}