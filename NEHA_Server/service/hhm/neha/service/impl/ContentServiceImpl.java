package hhm.neha.service.impl;

import hhm.neha.data.dao.ContentDao;
import hhm.neha.entity.Content;
import hhm.neha.service.ContentService;

import java.util.List;

public class ContentServiceImpl implements ContentService {

	public ContentDao getContentDao() {
		return contentDao;
	}

	public void setContentDao(ContentDao contentDao) {
		this.contentDao = contentDao;
	}

	private ContentDao contentDao;

	public List<Content> getByEventId(int eventId) {

		return contentDao.getByEventId(eventId);
	}

}
