package hhm.neha.entity;

import org.apache.struts2.json.annotations.JSON;

/**
 * CategorySiteTwo entity. @author MyEclipse Persistence Tools
 */

public class CategorySiteTwo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4875986159533013975L;
	private Integer cstId;
	private Integer cstOneId;
	private CategorySiteOne category1;
	private String cstName;
	private String cstComment;
	private Boolean cstStatus;
	private Integer cstOrder;

	// Constructors

	/** default constructor */
	public CategorySiteTwo() {
	}

	/** minimal constructor */
	public CategorySiteTwo(Integer cstId, Integer cstOneId, String cstName,
			Boolean cstStatus, Integer cstOrder) {
		this.cstId = cstId;
		this.cstOneId = cstOneId;
		this.cstName = cstName;
		this.cstStatus = cstStatus;
		this.cstOrder = cstOrder;
	}

	/** full constructor */
	public CategorySiteTwo(Integer cstId, Integer cstOneId, String cstName,
			String cstComment, Boolean cstStatus, Integer cstOrder) {
		this.cstId = cstId;
		this.cstOneId = cstOneId;
		this.cstName = cstName;
		this.cstComment = cstComment;
		this.cstStatus = cstStatus;
		this.cstOrder = cstOrder;
	}

	// Property accessors
	@JSON(name = "site_class2_id")
	public Integer getCstId() {
		return this.cstId;
	}

	public void setCstId(Integer cstId) {
		this.cstId = cstId;
	}

	public Integer getCstOneId() {
		return this.cstOneId;
	}

	public void setCstOneId(Integer cstOneId) {
		this.cstOneId = cstOneId;
	}

	/**
	 * @return the category1
	 */
	@JSON(name = "class1")
	public CategorySiteOne getCategory1() {
		return category1;
	}

	/**
	 * @param category1
	 *            the category1 to set
	 */
	public void setCategory1(CategorySiteOne category1) {
		this.category1 = category1;
	}

	@JSON(name = "site_class2_name")
	public String getCstName() {
		return this.cstName;
	}

	public void setCstName(String cstName) {
		this.cstName = cstName;
	}

	public String getCstComment() {
		return this.cstComment;
	}

	public void setCstComment(String cstComment) {
		this.cstComment = cstComment;
	}

	public Boolean getCstStatus() {
		return this.cstStatus;
	}

	public void setCstStatus(Boolean cstStatus) {
		this.cstStatus = cstStatus;
	}

	public Integer getCstOrder() {
		return this.cstOrder;
	}

	public void setCstOrder(Integer cstOrder) {
		this.cstOrder = cstOrder;
	}

}