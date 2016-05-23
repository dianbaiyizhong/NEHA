package hhm.neha.action;

import hhm.neha.common.ClassMethod;
import hhm.neha.controller.Category_events;
import hhm.neha.model.Category_events_eventModel;

import java.util.List;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionSupport;

public class ClassificationAction extends ActionSupport{
	public int category_id;
	public String result;
	public String execute()throws Exception{
		List<Category_events_eventModel> eventsIds=Category_events.JsonToJavaBean(category_id, 0, 0);
		JSONArray r_json=ClassMethod.realtimeInit(eventsIds);
		JSONArray h_json=ClassMethod.hourInit(eventsIds);
		JSONArray d_json=ClassMethod.dailyInit(eventsIds);
		/*ClassMethod.DailyAndHourAdd(eventsIds);
		ClassMethod.realtimeAdd(eventsIds);*/
		this.result="{jsond:"+d_json.toString()+",jsonh:"+h_json.toString()+",jsonr:"+r_json.toString()+"}";
		return SUCCESS;
	}
	public int getCategory_id(){
		return category_id;
	}
	public void setCategory_id(int category_id){
		this.category_id=category_id;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
