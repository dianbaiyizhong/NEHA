package hhm.neha.entity;

import org.apache.struts2.json.annotations.JSON;

/**
 * CategoryEvent entity. @author MyEclipse Persistence Tools
 */

public class CategoryEvent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2728576643727509866L;
	private Integer cgeId;
	private String cgeName;
	private String cgeComment;
	private Boolean cgeStatus;
	private Integer cgeOrder;

	// Constructors

	/** default constructor */
	public CategoryEvent() {
	}

	/** full constructor */
	public CategoryEvent(Integer cgeId, String cgeName, String cgeComment,
			Boolean cgeStatus, Integer cgeOrder) {
		this.cgeId = cgeId;
		this.cgeName = cgeName;
		this.cgeComment = cgeComment;
		this.cgeStatus = cgeStatus;
		this.cgeOrder = cgeOrder;
	}

	// Property accessors
	@JSON(name = "id")
	public Integer getCgeId() {
		return this.cgeId;
	}

	public void setCgeId(Integer cgeId) {
		this.cgeId = cgeId;
	}

	@JSON(name = "name")
	public String getCgeName() {
		return this.cgeName;
	}

	public void setCgeName(String cgeName) {
		this.cgeName = cgeName;
	}

	public String getCgeComment() {
		return this.cgeComment;
	}

	public void setCgeComment(String cgeComment) {
		this.cgeComment = cgeComment;
	}

	public Boolean getCgeStatus() {
		return this.cgeStatus;
	}

	public void setCgeStatus(Boolean cgeStatus) {
		this.cgeStatus = cgeStatus;
	}

	public Integer getCgeOrder() {
		return this.cgeOrder;
	}

	public void setCgeOrder(Integer cgeOrder) {
		this.cgeOrder = cgeOrder;
	}

}