package hhm.neha.entity;

import java.sql.Timestamp;

import org.apache.struts2.json.annotations.JSON;

/**
 * PointMultipleDaily entity. @author MyEclipse Persistence Tools
 */

public class PointMultipleDaily implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -846407301521373582L;
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
	public PointMultipleDaily(Integer mdpEventId, Integer mdpPoint,
			Timestamp mdpDate, Boolean mdpStatus) {
		this.mdpEventId = mdpEventId;
		this.mdpPoint = mdpPoint;
		this.mdpDate = mdpDate;
		this.mdpStatus = mdpStatus;
	}

	// Property accessors
	@JSON(name = "id")
	public Integer getMdpId() {
		return this.mdpId;
	}

	public void setMdpId(Integer mdpId) {
		this.mdpId = mdpId;
	}

	@JSON(name = "event_id")
	public Integer getMdpEventId() {
		return this.mdpEventId;
	}

	public void setMdpEventId(Integer mdpEventId) {
		this.mdpEventId = mdpEventId;
	}

	@JSON(name = "point")
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