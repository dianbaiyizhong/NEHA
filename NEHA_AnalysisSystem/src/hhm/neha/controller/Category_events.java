package hhm.neha.controller;

import hhm.neha.common.CustomerHttpClient;
import hhm.neha.model.Category_eventsModel;
import hhm.neha.model.Category_events_categoryModel;
import hhm.neha.model.Category_events_eventModel;
import hhm.neha.util.PathUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

public class Category_events {
	public static List<Category_events_eventModel> JsonToJavaBean(int category_id,int max_id,int count){
		
		String remoteAdd = new PathUtil().getRemoteAdd();

		String url=remoteAdd +
				"events/category_events.json?";
		if(category_id!=0){
			url+="category_id="+category_id;
		}
		if(max_id!=0){
			url+="&max_id="+max_id;
		}
		if(count!=0){
			url+="&count="+count;
		}
		String response=CustomerHttpClient.get(url);
		JSONObject object = JSONObject.fromObject(response);
		Map<String, Class<?>> cmap = new HashMap<String, Class<?>>();
		cmap.put("events", Category_events_eventModel.class);
		cmap.put("category", Category_events_categoryModel.class);
		Category_eventsModel events = (Category_eventsModel)JSONObject.toBean(object, Category_eventsModel.class,cmap);
		List<Category_events_eventModel> event=events.getEvents();
		return event;
	}
}
