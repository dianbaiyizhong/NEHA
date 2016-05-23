package hhm.neha.web.action.content;

import hhm.neha.entity.Content;
import hhm.neha.service.ContentService;
import hhm.neha.web.action.BaseAction;

import java.util.List;

public class ContentAction extends BaseAction {
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLal() {
		return lal;
	}

	public void setLal(String lal) {
		this.lal = lal;
	}

	public ContentService getContentService() {
		return contentService;
	}

	public void setContentService(ContentService contentService) {
		this.contentService = contentService;
	}

	private ContentService contentService;
	private Integer id;
	private String url;
	private Integer eventId;
	private String keyword;
	private String ip;
	private String city;
	private String lal;

	public List<Content> getContentlist() {
		return contentlist;
	}

	public void setContentlist(List<Content> contentlist) {
		this.contentlist = contentlist;
	}

	private List<Content> contentlist;

	public String get() {

		List<Content> contentlis1t = this.contentService.getByEventId(eventId);

		this.setContentlist(contentlis1t);
		return SUCCESS;

	}

}
