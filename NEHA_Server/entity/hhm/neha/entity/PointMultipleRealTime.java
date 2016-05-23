package hhm.neha.entity;

import java.sql.Timestamp;

import org.apache.struts2.json.annotations.JSON;

/**
 * PointMultipleRealTime entity. @author MyEclipse Persistence Tools
 */

public class PointMultipleRealTime implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -3347475138583318398L;
	private Integer ampId;
	private Integer ampEventId;
	private Integer ampPoint;
	private Timestamp ampDate;
	private Boolean ampStatus;

	// Constructors

	/** default constructor */
	public PointMultipleRealTime() {
	}

	/** full constructor */
	public PointMultipleRealTime(Integer ampEventId, Integer ampPoint,
			Timestamp ampDate, Boolean ampStatus) {
		this.ampEventId = ampEventId;
		this.ampPoint = ampPoint;
		this.ampDate = ampDate;
		this.ampStatus = ampStatus;
	}

	// Property accessors
	@JSON(name = "id")
	public Integer getAmpId() {
		return this.ampId;
	}

	public void setAmpId(Integer ampId) {
		this.ampId = ampId;
	}

	@JSON(name = "event_id")
	public Integer getAmpEventId() {
		return this.ampEventId;
	}

	public void setAmpEventId(Integer ampEventId) {
		this.ampEventId = ampEventId;
	}

	@JSON(name = "point")
	public Integer getAmpPoint() {
		return this.ampPoint;
	}

	public void setAmpPoint(Integer ampPoint) {
		this.ampPoint = ampPoint;
	}

	@JSON(name = "date", format = "yyyy-MM-dd HH:mm:ss z")
	public Timestamp getAmpDate() {
		return this.ampDate;
	}

	public void setAmpDate(Timestamp ampDate) {
		this.ampDate = ampDate;
	}

	public Boolean getAmpStatus() {
		return this.ampStatus;
	}

	public void setAmpStatus(Boolean ampStatus) {
		this.ampStatus = ampStatus;
	}

}