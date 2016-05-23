package hhm.neha.controller;

import hhm.neha.common.CustomerHttpClient;
import hhm.neha.model.EventModel;
import hhm.neha.model.Event_categoriesModel;
import hhm.neha.util.PathUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

public class Event {
	public static List<Event_categoriesModel> JsonToJavaBean(){
		
		String remoteAdd = new PathUtil().getRemoteAdd();

		String url=remoteAdd +
				"category/event.json";
		String response=CustomerHttpClient.get(url);
		JSONObject object = JSONObject.fromObject(response);
		Map<String, Class<?>> cmap = new HashMap<String, Class<?>>();
		cmap.put("categories", Event_categoriesModel.class);
		EventModel categories = (EventModel) JSONObject.toBean(object, EventModel.class,cmap);
		List<Event_categoriesModel> category=categories.getCategories();
		return category;
		}
}
