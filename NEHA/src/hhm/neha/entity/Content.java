package hhm.neha.entity;

/**
 * Content entity. @author MyEclipse Persistence Tools
 */

public class Content implements java.io.Serializable {

	// Fields

	private Integer id;
	@Override
	public String toString() {
		return "Content [city=" + city + ", eventId=" + eventId + ", id=" + id
				+ ", ip=" + ip + ", keyword=" + keyword + ", lal=" + lal
				+ ", url=" + url + "]";
	}

	private String url;
	private Integer eventId;
	private String keyword;
	private String ip;
	private String city;
	private String lal;

	// Constructors

	/** default constructor */
	public Content() {
	}

	/** full constructor */
	public Content(String url, Integer eventId, String keyword, String ip,
			String city, String lal) {
		this.url = url;
		this.eventId = eventId;
		this.keyword = keyword;
		this.ip = ip;
		this.city = city;
		this.lal = lal;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getEventId() {
		return this.eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLal() {
		return this.lal;
	}

	public void setLal(String lal) {
		this.lal = lal;
	}

}