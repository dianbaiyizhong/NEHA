package hhm.neha.area.dao;

import hhm.neha.entity.Content;

import java.util.List;

public interface ContentDao {
	public void save(Content content);
	public void update(Content content);

	public List<Content> getAll();
}
