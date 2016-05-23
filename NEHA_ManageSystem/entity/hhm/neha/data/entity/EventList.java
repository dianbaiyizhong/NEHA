package hhm.neha.data.entity;

import java.sql.Timestamp;

/**
 * EventList entity. @author MyEclipse Persistence Tools
 */

public class EventList implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -5346817201896093913L;
	private Integer eventId;
	private String eventTitle;
	private String eventShortTitle;
	private String eventAbstract;
	private Integer eventStatus;
	private EventStatus status;
	private String eventCategory;
	private String eventKeyword;
	private String statusName;
	private Integer eventExpand;
	private Timestamp eventStart;
	private Timestamp eventExp;
	private Boolean eventTop;
	private Integer eventOrder;
	private Timestamp eventDate;
	private Timestamp eventScanDate;
	private Integer eventParent;
	private String parentName;
	private Boolean eventRecovery;
	// Constructors

	/** default constructor */
	public EventList() {
	}

	/** full constructor */
	public EventList(String eventTitle, String eventShortTitle, String eventAbstract, Integer eventStatus, String eventCategory, String eventKeyword, Integer eventExpand, Timestamp eventStart, Timestamp eventExp, Boolean eventTop, Integer eventOrder, Timestamp eventDate, Timestamp eventScanDate, Integer eventParent,Boolean eventRecovery) {
		this.eventTitle = eventTitle;
		this.eventShortTitle = eventShortTitle;
		this.eventAbstract = eventAbstract;
		this.eventStatus = eventStatus;
		this.eventCategory = eventCategory;
		this.eventKeyword = eventKeyword;
		this.eventExpand = eventExpand;
		this.eventStart = eventStart;
		this.eventExp = eventExp;
		this.eventTop = eventTop;
		this.eventOrder = eventOrder;
		this.eventDate = eventDate;
		this.eventScanDate = eventScanDate;
		this.eventParent = eventParent;
		this.eventRecovery = eventRecovery;
	}

	// Property accessors

	public Integer getEventId() {
		return this.eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getEventTitle() {
		return this.eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	/**
	 * @return the eventShortTitle
	 */
	public String getEventShortTitle() {
		return eventShortTitle;
	}

	/**
	 * @param eventShortTitle the eventShortTitle to set
	 */
	public void setEventShortTitle(String eventShortTitle) {
		this.eventShortTitle = eventShortTitle;
	}

	/**
	 * @return the eventAbstract
	 */
	public String getEventAbstract() {
		return eventAbstract;
	}

	/**
	 * @param eventAbstract the eventAbstract to set
	 */
	public void setEventAbstract(String eventAbstract) {
		this.eventAbstract = eventAbstract;
	}

	public Integer getEventStatus() {
		return this.eventStatus;
	}

	public void setEventStatus(Integer eventStatus) {
		this.eventStatus = eventStatus;
	}

	/**
	 * @return the status
	 */
	public EventStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(EventStatus status) {
		this.status = status;
	}

	/**
	 * @return the statusName
	 */
	public String getStatusName() {
		return statusName;
	}

	/**
	 * @param statusName the statusName to set
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/**
	 * @return the eventCategory
	 */
	public String getEventCategory() {
		return eventCategory;
	}

	/**
	 * @param eventCategory the eventCategory to set
	 */
	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}

	/**
	 * @return the eventKeyword
	 */
	public String getEventKeyword() {
		return eventKeyword;
	}

	/**
	 * @param eventKeyword the eventKeyword to set
	 */
	public void setEventKeyword(String eventKeyword) {
		this.eventKeyword = eventKeyword;
	}

	public Integer getEventExpand() {
		return this.eventExpand;
	}

	public void setEventExpand(Integer eventExpand) {
		this.eventExpand = eventExpand;
	}

	public Timestamp getEventStart() {
		return this.eventStart;
	}

	public void setEventStart(Timestamp eventStart) {
		this.eventStart = eventStart;
	}

	public Timestamp getEventExp() {
		return this.eventExp;
	}

	public void setEventExp(Timestamp eventExp) {
		this.eventExp = eventExp;
	}

	public Boolean getEventTop() {
		return this.eventTop;
	}

	public void setEventTop(Boolean eventTop) {
		this.eventTop = eventTop;
	}

	public Integer getEventOrder() {
		return this.eventOrder;
	}

	public void setEventOrder(Integer eventOrder) {
		this.eventOrder = eventOrder;
	}

	public Timestamp getEventDate() {
		return this.eventDate;
	}

	public void setEventDate(Timestamp eventDate) {
		this.eventDate = eventDate;
	}

	/**
	 * @return the eventScanDate
	 */
	public Timestamp getEventScanDate() {
		return eventScanDate;
	}

	/**
	 * @param eventScanDate the eventScanDate to set
	 */
	public void setEventScanDate(Timestamp eventScanDate) {
		this.eventScanDate = eventScanDate;
	}

	public Integer getEventParent() {
		return this.eventParent;
	}

	public void setEventParent(Integer eventParent) {
		this.eventParent = eventParent;
	}

	/**
	 * @return the parentName
	 */
	public String getParentName() {
		return parentName;
	}

	/**
	 * @param parentName the parentName to set
	 */
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	/**
	 * @return the eventRecovery
	 */
	public Boolean getEventRecovery() {
		return eventRecovery;
	}

	/**
	 * @param eventRecovery the eventRecovery to set
	 */
	public void setEventRecovery(Boolean eventRecovery) {
		this.eventRecovery = eventRecovery;
	}

}