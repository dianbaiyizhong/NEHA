package hhm.neha.action;

import hhm.neha.common.CustomerHttpClient;
import hhm.neha.common.SearchMethod;
import hhm.neha.controller.Batch_timeline;
import hhm.neha.controller.SearchEvent;
import hhm.neha.model.Batch_timeline_pointsModel;
import hhm.neha.util.PathUtil;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport {
	public String result;
	public String keyword;
	public String searchEventIds;
	public String searchEventTitle;

	// 根据关键字搜索事件
	public String execute() throws Exception {
		authorize();
		List ids = SearchEvent.JsonToJavaBean(keyword, 0, 0, 0);
		JSONArray jsonArray = JSONArray.fromObject(ids);
		String json = jsonArray.toString();
		this.result = json.toString();
		return SUCCESS;
	}

	// 返回搜索事件的point值
	public String searchPoint() throws Exception {
		authorize();
		String eventsIds[] = searchEventIds.split(",");
		String eventTitle[] = searchEventTitle.split(",");
		// 实时批量获取
		List<Batch_timeline_pointsModel> r_Ap = Batch_timeline
				.JsonToJavaBean(searchEventIds);
		Collections.sort(r_Ap, new Comparator<Batch_timeline_pointsModel>() {
			public int compare(Batch_timeline_pointsModel p0,
					Batch_timeline_pointsModel p1) {
				try {
					int temp1 = p0.getEvent_id();
					int temp2 = p1.getEvent_id();
					return temp2 - temp1;
				} catch (Exception ex) {
				}
				return 0;
			}
		});
		JSONArray r_json = SearchMethod.realtimeInit(eventsIds, eventTitle);
		JSONArray h_json = SearchMethod.hourInit(eventsIds, eventTitle);
		JSONArray d_json = SearchMethod.dailyInit(eventsIds, eventTitle);
		/*
		 * SearchMethod.DailyAndHourAdd(eventsIds); Map
		 * session=ActionContext.getContext().getSession();
		 * session.put("realtimeAp", r_Ap);
		 */
		this.result = "{jsond:" + d_json.toString() + ",jsonh:"
				+ h_json.toString() + ",jsonr:" + r_json.toString() + "}";
		return SUCCESS;
	}

	public void authorize() throws Exception {

		String remoteAdd = new PathUtil().getRemoteAdd();

		String url = remoteAdd + "authorize/pass.json?token=123";
		String response = CustomerHttpClient.get(url);
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSearchEventIds() {
		return searchEventIds;
	}

	public void setSearchEventIds(String searchEventIds) {
		this.searchEventIds = searchEventIds;
	}

	public String getSearchEventTitle() {
		return searchEventTitle;
	}

	public void setSearchEventTitle(String searchEventTitle) {
		this.searchEventTitle = searchEventTitle;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
