package hhm.neha.action;

import hhm.neha.controller.Daily_timeline;
import hhm.neha.model.Daily_timeline_pointModel;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionSupport;

public class DailyAction extends ActionSupport{
	public String searchEventIds;
	public String result;
	public String execute()throws Exception{
		String eventsIds[]=searchEventIds.split(",");
    	List<Daily_timeline_pointModel> d_Ap=new ArrayList<Daily_timeline_pointModel>();
    	for(int i=0;i<eventsIds.length;i++){
    		Daily_timeline_pointModel daily_points=Daily_timeline.JsonToJavaBean(Integer.parseInt(eventsIds[i]),0);
    		d_Ap.add(i,daily_points);
		}
    	JSONArray dailyAp=JSONArray.fromObject(d_Ap);
    	this.result=dailyAp.toString();
		return SUCCESS;
	}
	public String getSearchEventIds(){
		return searchEventIds;
	}
	public void setSearchEventIds(String searchEventIds){
		this.searchEventIds=searchEventIds;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
