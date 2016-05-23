package hhm.neha.area.service.impl;

import hhm.neha.area.dao.ContentDao;
import hhm.neha.area.service.ContentService;
import hhm.neha.entity.Content;

import java.util.List;

public class ContentServiceImpl implements ContentService {

	public ContentDao getContentDao() {
		return contentDao;
	}

	public void setContentDao(ContentDao contentDao) {
		this.contentDao = contentDao;
	}

	private ContentDao contentDao;

	@Override
	public void save(Content content) {

		contentDao.save(content);
	}

	@Override
	public List<Content> getAll() {
		// TODO Auto-generated method stub
		return contentDao.getAll();
	}

	@Override
	public void update(Content content) {
		contentDao.update(content);
	}

}
