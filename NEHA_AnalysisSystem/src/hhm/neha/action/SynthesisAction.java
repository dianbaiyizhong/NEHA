package hhm.neha.action;

import hhm.neha.common.CustomerHttpClient;
import hhm.neha.common.RankMethod;
import hhm.neha.controller.Recommend_timeline;
import hhm.neha.model.Recommend_timeline_eventsModel;
import hhm.neha.util.PathUtil;

import java.util.List;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionSupport;

public class SynthesisAction extends ActionSupport{
	public String result;
	public String execute()throws Exception{
	
		authorize();
		
		List<Recommend_timeline_eventsModel> Ids=Recommend_timeline.JsonToJavaBean();
		JSONArray r_json=RankMethod.realtimeInit(Ids);
		/*JSONArray h_json=RankMethod.hourInit(Ids);
		JSONArray d_json=RankMethod.dailyInit(Ids);
		RankMethod.realtimeAdd(Ids);
		RankMethod.DailyAndHourAdd(Ids);*/
		this.result=r_json.toString();
		//this.result=r_json.toString()+h_json.toString()+d_json.toString();
		return SUCCESS;
	}
	//授权
	public void authorize()throws Exception{
		
		String remoteAdd = new PathUtil().getRemoteAdd();

		String url=remoteAdd +
				"authorize/pass.json?token=123";
		String response=CustomerHttpClient.get(url);
	}
	
}
