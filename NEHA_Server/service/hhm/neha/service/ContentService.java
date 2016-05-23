package hhm.neha.service;

import hhm.neha.entity.Content;

import java.util.List;

public interface ContentService {

	public List<Content> getByEventId(int eventId);
}
