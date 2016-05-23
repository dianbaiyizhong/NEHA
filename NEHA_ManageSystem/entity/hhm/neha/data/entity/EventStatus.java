package hhm.neha.data.entity;

/**
 * EventStatus entity. @author MyEclipse Persistence Tools
 */

public class EventStatus implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 4819515450920617343L;
	private Integer aesId;
	private String aesName;
	private String aesComment;

	// Constructors

	/** default constructor */
	public EventStatus() {
	}

	/** minimal constructor */
	public EventStatus(Integer aesId, String aesName) {
		this.aesId = aesId;
		this.aesName = aesName;
	}

	/** full constructor */
	public EventStatus(Integer aesId, String aesName, String aesComment) {
		this.aesId = aesId;
		this.aesName = aesName;
		this.aesComment = aesComment;
	}

	// Property accessors

	public Integer getAesId() {
		return this.aesId;
	}

	public void setAesId(Integer aesId) {
		this.aesId = aesId;
	}

	public String getAesName() {
		return this.aesName;
	}

	public void setAesName(String aesName) {
		this.aesName = aesName;
	}

	public String getAesComment() {
		return this.aesComment;
	}

	public void setAesComment(String aesComment) {
		this.aesComment = aesComment;
	}

}