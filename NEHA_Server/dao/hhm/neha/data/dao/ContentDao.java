package hhm.neha.data.dao;

import hhm.neha.entity.Content;

import java.util.List;


public interface ContentDao {

	public List<Content> getByEventId(int eventId);

}
