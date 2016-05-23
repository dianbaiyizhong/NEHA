package hhm.neha.entity;

import java.sql.Timestamp;

/**
 * PointEventIntensity entity. @author MyEclipse Persistence Tools
 */

public class PointEventIntensity implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8290627571368464477L;
	private Integer pesId;
	private Integer pesEventId;
	private Integer pesIntensity;
	private Timestamp pesDate;
	private Boolean pesStatus;

	// Constructors

	/** default constructor */
	public PointEventIntensity() {
	}

	/** full constructor */
	public PointEventIntensity(Integer pesEventId, Integer pesIntensity,
			Timestamp pesDate, Boolean pesStatus) {
		this.pesEventId = pesEventId;
		this.pesIntensity = pesIntensity;
		this.pesDate = pesDate;
		this.pesStatus = pesStatus;
	}

	// Property accessors

	public Integer getPesId() {
		return this.pesId;
	}

	public void setPesId(Integer pesId) {
		this.pesId = pesId;
	}

	public Integer getPesEventId() {
		return this.pesEventId;
	}

	public void setPesEventId(Integer pesEventId) {
		this.pesEventId = pesEventId;
	}

	public Integer getPesIntensity() {
		return this.pesIntensity;
	}

	public void setPesIntensity(Integer pesIntensity) {
		this.pesIntensity = pesIntensity;
	}

	public Timestamp getPesDate() {
		return this.pesDate;
	}

	public void setPesDate(Timestamp pesDate) {
		this.pesDate = pesDate;
	}

	public Boolean getPesStatus() {
		return this.pesStatus;
	}

	public void setPesStatus(Boolean pesStatus) {
		this.pesStatus = pesStatus;
	}

}