package hhm.neha.area.service;

import hhm.neha.entity.Content;

import java.util.List;

public interface ContentService {

	public void save(Content content);

	public List<Content> getAll();

	public void update(Content content);

}
