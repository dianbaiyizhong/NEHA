package hhm.neha.entity;

import java.sql.Timestamp;

import org.apache.struts2.json.annotations.JSON;

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

	/**
	 * @param eventId
	 * @param eventTitle
	 * @param eventStatus
	 * @param eventCategory
	 * @param eventKeyword
	 * @param eventExpand
	 * @param eventStart
	 * @param eventExp
	 * @param eventTop
	 * @param eventOrder
	 * @param eventDate
	 * @param eventScanDate
	 * @param eventParent
	 * @param eventRecovery
	 */
	public EventList(Integer eventId, String eventTitle, Integer eventStatus,
			String eventCategory, String eventKeyword, Integer eventExpand,
			Timestamp eventStart, Timestamp eventExp, Boolean eventTop,
			Integer eventOrder, Timestamp eventDate, Timestamp eventScanDate,
			Integer eventParent, Boolean eventRecovery) {
		super();
		this.eventId = eventId;
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

	/**
	 * @param eventId
	 * @param eventTitle
	 * @param eventShortTitle
	 * @param eventAbstract
	 * @param eventStatus
	 * @param eventCategory
	 * @param eventKeyword
	 * @param eventExpand
	 * @param eventStart
	 * @param eventExp
	 * @param eventTop
	 * @param eventOrder
	 * @param eventDate
	 * @param eventScanDate
	 * @param eventParent
	 * @param eventRecovery
	 */
	public EventList(Integer eventId, String eventTitle,
			String eventShortTitle, String eventAbstract, Integer eventStatus,
			String eventCategory, String eventKeyword, Integer eventExpand,
			Timestamp eventStart, Timestamp eventExp, Boolean eventTop,
			Integer eventOrder, Timestamp eventDate, Timestamp eventScanDate,
			Integer eventParent, Boolean eventRecovery) {
		super();
		this.eventId = eventId;
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
	@JSON(name = "id")
	public Integer getEventId() {
		return this.eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	@JSON(name = "title")
	public String getEventTitle() {
		return this.eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public Integer getEventStatus() {
		return this.eventStatus;
	}

	public void setEventStatus(Integer eventStatus) {
		this.eventStatus = eventStatus;
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

	@JSON(name = "exp", format = "yyyy-MM-dd HH:mm:ss z")
	public Timestamp getEventExp() {
		return this.eventExp;
	}

	public void setEventExp(Timestamp eventExp) {
		this.eventExp = eventExp;
	}

	@JSON(name = "top")
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

	@JSON(name = "creat_at", format = "yyyy-MM-dd HH:mm:ss z")
	public Timestamp getEventDate() {
		return this.eventDate;
	}

	public void setEventDate(Timestamp eventDate) {
		this.eventDate = eventDate;
	}

	public Integer getEventParent() {
		return this.eventParent;
	}

	public void setEventParent(Integer eventParent) {
		this.eventParent = eventParent;
	}

	/**
	 * @return the eventShortTitle
	 */
	public String getEventShortTitle() {
		return eventShortTitle;
	}

	/**
	 * @param eventShortTitle
	 *            the eventShortTitle to set
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
	 * @param eventAbstract
	 *            the eventAbstract to set
	 */
	public void setEventAbstract(String eventAbstract) {
		this.eventAbstract = eventAbstract;
	}

	/**
	 * @return the eventCategory
	 */
	public String getEventCategory() {
		return eventCategory;
	}

	/**
	 * @param eventCategory
	 *            the eventCategory to set
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
	 * @param eventKeyword
	 *            the eventKeyword to set
	 */
	public void setEventKeyword(String eventKeyword) {
		this.eventKeyword = eventKeyword;
	}

	/**
	 * @return the eventScanDate
	 */
	public Timestamp getEventScanDate() {
		return eventScanDate;
	}

	/**
	 * @param eventScanDate
	 *            the eventScanDate to set
	 */
	public void setEventScanDate(Timestamp eventScanDate) {
		this.eventScanDate = eventScanDate;
	}

	/**
	 * @return the eventRecovery
	 */
	public Boolean getEventRecovery() {
		return eventRecovery;
	}

	/**
	 * @param eventRecovery
	 *            the eventRecovery to set
	 */
	public void setEventRecovery(Boolean eventRecovery) {
		this.eventRecovery = eventRecovery;
	}
}