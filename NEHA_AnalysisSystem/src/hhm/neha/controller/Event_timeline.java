package hhm.neha.controller;

import hhm.neha.common.CustomerHttpClient;
import hhm.neha.model.Event_timelineModel;
import hhm.neha.model.Event_timeline_pointsModel;
import hhm.neha.util.PathUtil;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

public class Event_timeline {
	public static Event_timeline_pointsModel JsonToJavaBean(int event_id,
			int point_id) {
		String remoteAdd = new PathUtil().getRemoteAdd();

		String url = remoteAdd + "point/event_timeline.json?";
		if (event_id != 0) {
			url += "event_id=" + event_id;
		}
		if (point_id != 0) {
			url += "&point_id=" + point_id;
		}
		String response = CustomerHttpClient.get(url);
		JSONObject object = JSONObject.fromObject(response);
		Map<String, Class<?>> cmap = new HashMap<String, Class<?>>();
		cmap.put("p", Event_timeline_pointsModel.class);
		Event_timelineModel points = (Event_timelineModel) JSONObject.toBean(
				object, Event_timelineModel.class, cmap);
		Event_timeline_pointsModel point = points.getP();
		return point;
	}
}
