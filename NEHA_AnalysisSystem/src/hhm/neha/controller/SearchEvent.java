package hhm.neha.controller;

import hhm.neha.common.CustomerHttpClient;
import hhm.neha.model.SearchEventModel;
import hhm.neha.model.SearchEvent_eventsModel;
import hhm.neha.util.PathUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

public class SearchEvent {
	public static List<SearchEvent_eventsModel> JsonToJavaBean(String q,
			int max_id, int since_id, int count)
			throws UnsupportedEncodingException {
		String remoteAdd = new PathUtil().getRemoteAdd();

		String url = remoteAdd + "search/suggest/event.json?";
		if (q != null) {
			url += "q=" + URLEncoder.encode(q, "utf-8");
		}
		if (max_id != 0) {
			url += "&max_id=" + max_id;
		}
		if (since_id != 0) {
			url += "&since_id" + since_id;
		}
		if (count != 0) {
			url += "&count" + count;
		}
		String response = CustomerHttpClient.get(url);
		JSONObject object = JSONObject.fromObject(response);
		Map<String, Class<?>> cmap = new HashMap<String, Class<?>>();
		cmap.put("events", SearchEvent_eventsModel.class);
		SearchEventModel events = (SearchEventModel) JSONObject.toBean(object,
				SearchEventModel.class, cmap);
		List<SearchEvent_eventsModel> event = events.getEvents();
		return event;
	}
}
