package hhm.neha.entity;

import java.sql.Timestamp;

import org.apache.struts2.json.annotations.JSON;

/**
 * PointMultipleHourly entity. @author MyEclipse Persistence Tools
 */

public class PointMultipleHourly implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1676781743773444501L;
	private Integer mhpId;
	private Integer mhpEventId;
	private Integer mhpPoint;
	private Timestamp mhpDate;
	private Boolean mhpStatus;

	// Constructors

	/** default constructor */
	public PointMultipleHourly() {
	}

	/** full constructor */
	public PointMultipleHourly(Integer mhpEventId, Integer mhpPoint,
			Timestamp mhpDate, Boolean mhpStatus) {
		this.mhpEventId = mhpEventId;
		this.mhpPoint = mhpPoint;
		this.mhpDate = mhpDate;
		this.mhpStatus = mhpStatus;
	}

	// Property accessors
	@JSON(name = "id")
	public Integer getMhpId() {
		return this.mhpId;
	}

	public void setMhpId(Integer mhpId) {
		this.mhpId = mhpId;
	}

	@JSON(name = "event_id")
	public Integer getMhpEventId() {
		return this.mhpEventId;
	}

	public void setMhpEventId(Integer mhpEventId) {
		this.mhpEventId = mhpEventId;
	}

	@JSON(name = "point")
	public Integer getMhpPoint() {
		return this.mhpPoint;
	}

	public void setMhpPoint(Integer mhpPoint) {
		this.mhpPoint = mhpPoint;
	}

	@JSON(name = "date", format = "yyyy-MM-dd HH")
	public Timestamp getMhpDate() {
		return this.mhpDate;
	}

	public void setMhpDate(Timestamp mhpDate) {
		this.mhpDate = mhpDate;
	}

	public Boolean getMhpStatus() {
		return this.mhpStatus;
	}

	public void setMhpStatus(Boolean mhpStatus) {
		this.mhpStatus = mhpStatus;
	}

}