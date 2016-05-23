package hhm.neha.controller;

import hhm.neha.common.CustomerHttpClient;
import hhm.neha.model.Public_timelineModel;
import hhm.neha.model.Public_timeline_eventsModel;
import hhm.neha.util.PathUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

public class Public_timeline {
	public static List<Public_timeline_eventsModel> JsonToJavaBean(int max_id,int since_id,int count){
		String remoteAdd = new PathUtil().getRemoteAdd();

		String url=remoteAdd +
				"events/public_timeline.json?";
		if(max_id!=0){
			url+="max_id="+max_id;
			if(since_id!=0){
				url+="&since_id="+since_id;
			}
			if(count!=0){
				url+="&count="+count;
			}
		}else{
			if(since_id!=0){
				url+="since_id="+since_id;
				if(count!=0){
					url+="&count="+count;
				}
			}
			else{
				if(count!=0){
					url+="count="+count;
				}
		    	}
		    }	
		String response=CustomerHttpClient.get(url);
		JSONObject object = JSONObject.fromObject(response);
		Map<String, Class<?>> cmap = new HashMap<String, Class<?>>();
		cmap.put("events", Public_timeline_eventsModel.class);
		Public_timelineModel events = (Public_timelineModel) JSONObject.toBean(object, Public_timelineModel.class,cmap);
		List<Public_timeline_eventsModel> event=events.getEvents();
		return event;
		}
}
