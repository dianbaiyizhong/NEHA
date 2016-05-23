package hhm.neha.action;

import hhm.neha.controller.Hour_timeline;
import hhm.neha.model.Hour_timeline_pointsModel;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionSupport;

public class HourAction extends ActionSupport{
	public String searchEventIds;
	public String result;
	public String execute()throws Exception{
		String eventsIds[]=searchEventIds.split(",");
		List<Hour_timeline_pointsModel> h_Ap=new ArrayList<Hour_timeline_pointsModel>();
    	for(int i=0;i<eventsIds.length;i++){
    		Hour_timeline_pointsModel hour_points=Hour_timeline.JsonToJavaBean(Integer.parseInt(eventsIds[i]),0);
    		h_Ap.add(i,hour_points);
		}
    	JSONArray hourAp=JSONArray.fromObject(h_Ap);
    	this.result=hourAp.toString();
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
