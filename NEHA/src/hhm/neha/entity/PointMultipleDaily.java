package hhm.neha.entity;

import java.sql.Timestamp;

/**
 * PointMultipleDaily entity. @author MyEclipse Persistence Tools
 */

public class PointMultipleDaily implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6095108488854626738L;
	private Integer mdpId;
	private Integer mdpEventId;
	private Integer mdpPoint;
	private Timestamp mdpDate;
	private Boolean mdpStatus;

	// Constructors

	/** default constructor */
	public PointMultipleDaily() {
	}

	/** full constructor */
	public PointMultipleDaily(Integer mdpEventId, Integer mdpPoint, Timestamp mdpDate, Boolean mdpStatus) {
		this.mdpEventId = mdpEventId;
		this.mdpPoint = mdpPoint;
		this.mdpDate = mdpDate;
		this.mdpStatus = mdpStatus;
	}

	// Property accessors

	public Integer getMdpId() {
		return this.mdpId;
	}

	public void setMdpId(Integer mdpId) {
		this.mdpId = mdpId;
	}

	public Integer getMdpEventId() {
		return this.mdpEventId;
	}

	public void setMdpEventId(Integer mdpEventId) {
		this.mdpEventId = mdpEventId;
	}

	public Integer getMdpPoint() {
		return this.mdpPoint;
	}

	public void setMdpPoint(Integer mdpPoint) {
		this.mdpPoint = mdpPoint;
	}

	public Timestamp getMdpDate() {
		return this.mdpDate;
	}

	public void setMdpDate(Timestamp mdpDate) {
		this.mdpDate = mdpDate;
	}

	public Boolean getMdpStatus() {
		return this.mdpStatus;
	}

	public void setMdpStatus(Boolean mdpStatus) {
		this.mdpStatus = mdpStatus;
	}

}