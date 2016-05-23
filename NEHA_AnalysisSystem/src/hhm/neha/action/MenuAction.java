package hhm.neha.action;

import hhm.neha.common.CustomerHttpClient;
import hhm.neha.controller.Class2;
import hhm.neha.controller.Event;
import hhm.neha.controller.Recommend_timeline;
import hhm.neha.model.Class2esModel;
import hhm.neha.model.Event_categoriesModel;
import hhm.neha.model.Recommend_timeline_eventsModel;
import hhm.neha.util.PathUtil;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MenuAction extends ActionSupport {
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		session.clear();
		authorize();
		web10();
		web20();
		web30();
		type();
		Event();
		return SUCCESS;
	}

	private void Event() {
		List<Recommend_timeline_eventsModel> recommend_events = Recommend_timeline
				.JsonToJavaBean();
		Map session = ActionContext.getContext().getSession();
		session.put("event", recommend_events);
		
	}

	// 授权
	public void authorize() throws Exception {

		String remoteAdd = new PathUtil().getRemoteAdd();
		String url = remoteAdd + "authorize/pass.json?token=123";
		
		String response = CustomerHttpClient.get(url);
	}

	// web1.0
	public void web10() throws Exception {
		List<Class2esModel> web10 = Class2.JsonToJavaBean(10, 0, null);
		Map session = ActionContext.getContext().getSession();
		session.put("web10", web10);
	}

	// web2.0
	public void web20() throws Exception {
		List<Class2esModel> web20 = Class2.JsonToJavaBean(20, 0, null);
		Map session = ActionContext.getContext().getSession();
		session.put("web20", web20);
	}

	// web3.0
	public void web30() throws Exception {
		List<Class2esModel> web30 = Class2.JsonToJavaBean(30, 0, null);
		Map session = ActionContext.getContext().getSession();
		session.put("web30", web30);
	}

	// 事件类型
	public void type() throws Exception {
		List<Event_categoriesModel> type = Event.JsonToJavaBean();
		Map session = ActionContext.getContext().getSession();
		session.put("type", type);
	}
	//事件
	

}
