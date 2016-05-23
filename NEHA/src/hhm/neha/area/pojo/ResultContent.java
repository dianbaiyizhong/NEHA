package hhm.neha.area.pojo;

public class ResultContent {

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "ResultContent [keyword=" + keyword + ", title=" + title
				+ ", url=" + url + "]";
	}

	private String url;
	private String title;
	private String keyword;
	
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	private int eventId;

}
