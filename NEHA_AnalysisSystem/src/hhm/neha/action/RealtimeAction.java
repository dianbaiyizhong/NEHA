package hhm.neha.action;

import hhm.neha.controller.Batch_timeline;
import hhm.neha.model.Batch_timeline_pointsModel;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionSupport;

public class RealtimeAction extends ActionSupport {
	public String searchEventIds;
	public String result;

	public String execute() throws Exception {
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
		JSONArray realtimeAp = JSONArray.fromObject(r_Ap);
		this.result = realtimeAp.toString();
		return SUCCESS;
	}

	public String getSearchEventIds() {
		return searchEventIds;
	}

	public void setSearchEventIds(String searchEventIds) {
		this.searchEventIds = searchEventIds;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
