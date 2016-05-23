/**
 * 
 */
package hhm.neha.action;

import hhm.neha.controller.Event_intensity;
import hhm.neha.model.Event_intensity_intensityModel;
import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionSupport;


public class IntensityAction extends ActionSupport{
	
	private int event_id;
	private String result;
	
	/***
	 * 获取Event_intensity_intensityModel并转化为json
	 * @param event_id 事件编号
	 */
	public String execute() throws Exception{
		Event_intensity_intensityModel intensity = Event_intensity.JsonToBean(event_id);
		JSONArray i = JSONArray.fromObject(intensity);
		this.result = i.toString();
		return SUCCESS;
	}
	
	public int getEvent_id() {
		return event_id;
	}
	
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}

}
