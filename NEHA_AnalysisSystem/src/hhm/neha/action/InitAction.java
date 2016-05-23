package hhm.neha.action;

import hhm.neha.common.CustomerHttpClient;
import hhm.neha.common.InitMethod;
import hhm.neha.controller.Event;
import hhm.neha.controller.Recommend_timeline;
import hhm.neha.model.EventList;
import hhm.neha.model.Event_categoriesModel;
import hhm.neha.model.Recommend_timeline_eventsModel;
import hhm.neha.util.PathUtil;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class InitAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 556615574265816967L;
	public String result;

	public String execute() throws Exception {
		authorize();
		List<Recommend_timeline_eventsModel> recommend_events = Recommend_timeline
				.JsonToJavaBean();
		JSONArray d_json = InitMethod.recommendDailyInit(recommend_events);
		JSONArray r_json = InitMethod.recommendRealtimeInit(recommend_events);
		JSONArray h_json = InitMethod.recommendHourInit(recommend_events);
		// List<Public_timeline_eventsModel>
		// eventsIds=Public_timeline.JsonToJavaBean(0,0,0);
		// JSONArray r_json=InitMethod.realtimeInit(eventsIds);
		// JSONArray h_json=InitMethod.hourInit(eventsIds);
		// JSONArray d_json=InitMethod.dailyInit(eventsIds);
		/*
		 * InitMethod.realtimeAdd(eventsIds);
		 * InitMethod.DailyAndHourAdd(eventsIds);
		 */
		this.result = "{jsond:" + d_json.toString() + ",jsonh:"
				+ h_json.toString() + ",jsonr:" + r_json.toString() + "}";
		
		
		

		
		return SUCCESS;
	}

	// 授权
	public void authorize() throws Exception {
		String remoteAdd = new PathUtil().getRemoteAdd();
		String url = remoteAdd + "authorize/pass.json?token=123";
		String response = CustomerHttpClient.get(url);
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
