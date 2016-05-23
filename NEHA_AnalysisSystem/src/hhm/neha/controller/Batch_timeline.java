package hhm.neha.controller;

import hhm.neha.common.CustomerHttpClient;
import hhm.neha.model.Batch_timelineModel;
import hhm.neha.model.Batch_timeline_pointsModel;
import hhm.neha.util.PathUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

public class Batch_timeline {
	public static List<Batch_timeline_pointsModel> JsonToJavaBean(
			String event_ids) {
		String remoteAdd = new PathUtil().getRemoteAdd();
		String url = remoteAdd + "point/batch_timeline.json?";
		if (event_ids != null) {
			url += "event_ids=" + event_ids;
		}
		String response = CustomerHttpClient.get(url);
		JSONObject object = JSONObject.fromObject(response);
		Map<String, Class<?>> cmap = new HashMap<String, Class<?>>();
		cmap.put("points", Batch_timeline_pointsModel.class);

		List<Batch_timeline_pointsModel> list = new ArrayList<>();
		try {
			Batch_timelineModel points = (Batch_timelineModel) JSONObject
					.toBean(object, Batch_timelineModel.class, cmap);

			list = points.getPoints();
			return list;

		} catch (Exception e) {

			return list;
		}
	}
}
