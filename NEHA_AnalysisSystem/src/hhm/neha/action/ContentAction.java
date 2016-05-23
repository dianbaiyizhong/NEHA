package hhm.neha.action;

import hhm.neha.common.CustomerHttpClient;
import hhm.neha.model.Content;
import hhm.neha.util.PathUtil;

import java.util.List;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionSupport;

public class ContentAction extends ActionSupport {

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	private int eventId;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	private String response;

	public String get() {

		String remoteAdd = new PathUtil().getRemoteAdd();
		String url = remoteAdd + "content/getContent.json?" + "eventId="
				+ eventId;

		String res = CustomerHttpClient.get(url);

		// Map<String, Class<?>> cmap = new HashMap<String, Class<?>>();
		// cmap.put("content", Content.class);
		// Content content = (Content) JSONObject.toBean(object, Content.class,
		// cmap);

		// System.out.println(response1);
		JSONArray jsonArray = JSONArray.fromObject(res);
		// // jsonArray.remove("id");
		// // jsonArray.remove("keyword");
		List<Content> list = jsonArray.toList(jsonArray, Content.class);

		// System.out.println(list.size());
		String result = "";
		for (int i = 0; i < list.size(); i++) {

			if (i != 0) {
				result = result + ",{name:'" + list.get(i).getCity()
						+ "',geoCoord:[" + list.get(i).getLal() + "]}";
			} else {

				result = result + "{name:'" + list.get(i).getCity()
						+ "',geoCoord:[" + list.get(i).getLal() + "]}";
			}

		}

		this.setResponse("[" + result + "]");
		return SUCCESS;

	}

}
