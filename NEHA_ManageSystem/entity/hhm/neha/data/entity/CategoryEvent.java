package hhm.neha.data.entity;

/**
 * CategoryEvent entity. @author MyEclipse Persistence Tools
 */

public class CategoryEvent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5254856498578805204L;
	private Integer cgeId;
	private String cgeName;
	private String cgeComment;
	private Boolean cgeStatus;
	private Integer cgeOrder;

	// Constructors

	/** default constructor */
	public CategoryEvent() {
	}

	/** minimal constructor */
	public CategoryEvent(Integer cgeId, String cgeName, Boolean cgeStatus, Integer cgeOrder) {
		this.cgeId = cgeId;
		this.cgeName = cgeName;
		this.cgeStatus = cgeStatus;
		this.cgeOrder = cgeOrder;
	}

	/** full constructor */
	public CategoryEvent(Integer cgeId, String cgeName, String cgeComment, Boolean cgeStatus, Integer cgeOrder) {
		this.cgeId = cgeId;
		this.cgeName = cgeName;
		this.cgeComment = cgeComment;
		this.cgeStatus = cgeStatus;
		this.cgeOrder = cgeOrder;
	}

	// Property accessors

	public Integer getCgeId() {
		return this.cgeId;
	}

	public void setCgeId(Integer cgeId) {
		this.cgeId = cgeId;
	}

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