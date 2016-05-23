package hhm.neha.entity;

import java.sql.Timestamp;

/**
 * EventList entity. @author MyEclipse Persistence Tools
 */

public class EventList implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8655615108163168491L;
	private Integer eventId;
	private String eventTitle;
	private String eventShortTitle;
	private String eventAbstract;
	private Integer eventStatus;
	private String eventCategory;
	private String eventKeyword;
	private Integer eventExpand;
	private Timestamp eventStart;
	private Timestamp eventExp;
	private Boolean eventTop;
	private Integer eventOrder;
	private Timestamp eventDate;
	private Timestamp eventScanDate;
	private Integer eventParent;
	private Boolean eventRecovery;

	// Constructors

	/** default constructor */
	public EventList() {
	}

	/** minimal constructor */
	public EventList(String eventTitle, Integer eventStatus, String eventCategory, String eventKeyword, Integer eventExpand, Timestamp eventStart, Timestamp eventExp, Boolean eventTop, Integer eventOrder, Timestamp eventDate, Timestamp eventScanDate, Integer eventParent, Boolean eventRecovery) {
		this.eventTitle = eventTitle;
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

	/** full constructor */
	public EventList(String eventTitle, String eventShortTitle, String eventAbstract, Integer eventStatus, String eventCategory, String eventKeyword, Integer eventExpand, Timestamp eventStart, Timestamp eventExp, Boolean eventTop, Integer eventOrder, Timestamp eventDate, Timestamp eventScanDate, Integer eventParent, Boolean eventRecovery) {
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

	public String getEventShortTitle() {
		return this.eventShortTitle;
	}

	public void setEventShortTitle(String eventShortTitle) {
		this.eventShortTitle = eventShortTitle;
	}

	public String getEventAbstract() {
		return this.eventAbstract;
	}

	public void setEventAbstract(String eventAbstract) {
		this.eventAbstract = eventAbstract;
	}

	public Integer getEventStatus() {
		return this.eventStatus;
	}

	public void setEventStatus(Integer eventStatus) {
		this.eventStatus = eventStatus;
	}

	public String getEventCategory() {
		return this.eventCategory;
	}

	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}

	public String getEventKeyword() {
		return this.eventKeyword;
	}

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

	public Timestamp getEventScanDate() {
		return this.eventScanDate;
	}

	public void setEventScanDate(Timestamp eventScanDate) {
		this.eventScanDate = eventScanDate;
	}

	public Integer getEventParent() {
		return this.eventParent;
	}

	public void setEventParent(Integer eventParent) {
		this.eventParent = eventParent;
	}

	public Boolean getEventRecovery() {
		return this.eventRecovery;
	}

	public void setEventRecovery(Boolean eventRecovery) {
		this.eventRecovery = eventRecovery;
	}

}