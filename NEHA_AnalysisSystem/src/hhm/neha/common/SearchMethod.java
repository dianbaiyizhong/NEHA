package hhm.neha.common;

import hhm.neha.controller.Batch_timeline;
import hhm.neha.controller.Daily_points;
import hhm.neha.controller.Daily_timeline;
import hhm.neha.controller.Event_points;
import hhm.neha.controller.Hour_points;
import hhm.neha.controller.Hour_timeline;
import hhm.neha.model.Batch_timeline_pointsModel;
import hhm.neha.model.Daily_Databean;
import hhm.neha.model.Daily_pointsModel;
import hhm.neha.model.Daily_points_pointModel;
import hhm.neha.model.Daily_timeline_pointModel;
import hhm.neha.model.Databean;
import hhm.neha.model.Event_pointsModel;
import hhm.neha.model.Event_points_pointModel;
import hhm.neha.model.Hour_Databean;
import hhm.neha.model.Hour_pointsModel;
import hhm.neha.model.Hour_points_pointModel;
import hhm.neha.model.Hour_timeline_pointsModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import net.sf.json.JSONArray;

public class SearchMethod {
	//实时初始化
    public static JSONArray realtimeInit(String[] eventsIds,String[] eventTitle)throws Exception{
    	List<Databean> Model=new Vector<Databean>();
		for(int i=0;i<eventsIds.length;i++){
			Event_pointsModel points=Event_points.JsonToJavaBean(Integer.parseInt(eventsIds[i]),0,10);
			List<Event_points_pointModel> point=points.getPoints();	
			Collections.reverse(point);
			Databean bean=new Databean();
			bean.event_id=points.getEvent_id();
			bean.title=eventTitle[i];
			bean.points=point;
			Model.add(bean);
		}
		JSONArray jsonArray = JSONArray.fromObject(Model);
        return jsonArray;
    }
    //24小时初始化
    public static JSONArray hourInit(String[] eventsIds,String[] eventTitle)throws Exception{
    	List<Hour_Databean> Model=new Vector<Hour_Databean>();
    	for(int i=0;i<eventsIds.length;i++){
    		Hour_pointsModel points=Hour_points.JsonToJavaBean(Integer.parseInt(eventsIds[i]),0,10);
    		List<Hour_points_pointModel> point=points.getPoints();	
			Collections.reverse(point);
			Hour_Databean bean=new Hour_Databean();
			bean.event_id=points.getEvent_id();
			bean.title=eventTitle[i];
			bean.points=point;
			Model.add(bean);
		}
    	JSONArray jsonArray = JSONArray.fromObject(Model);
        return jsonArray;
    }
    //7天初始化
    public static JSONArray dailyInit(String[] eventsIds,String[] eventTitle)throws Exception{
    	List<Daily_Databean> Model=new Vector<Daily_Databean>();
    	for(int i=0;i<eventsIds.length;i++){
    		Daily_pointsModel points=Daily_points.JsonToJavaBean(Integer.parseInt(eventsIds[i]),0,10);
    		List<Daily_points_pointModel> point=points.getPoints();	
			Collections.reverse(point);
			Daily_Databean bean=new Daily_Databean();
			bean.event_id=points.getEvent_id();
			bean.title=eventTitle[i];
			bean.points=point;
			Model.add(bean);
		}
    	JSONArray jsonArray = JSONArray.fromObject(Model);
        return jsonArray;
    }
    //24小时和7天的单条数据获取
    public static void DailyAndHourAdd(String[] eventsIds)throws Exception{
    	//Map session=ActionContext.getContext().getSession();
    	List<Hour_timeline_pointsModel> hour_Ap=new ArrayList<Hour_timeline_pointsModel>();
    	List<Daily_timeline_pointModel> daily_Ap=new ArrayList<Daily_timeline_pointModel>();
    	for(int i=0;i<eventsIds.length;i++){
    		Hour_timeline_pointsModel hour_points=Hour_timeline.JsonToJavaBean(Integer.parseInt(eventsIds[i]),0);
    		Daily_timeline_pointModel daily_points=Daily_timeline.JsonToJavaBean(Integer.parseInt(eventsIds[i]),0);
    		hour_Ap.add(i,hour_points);
    		daily_Ap.add(i,daily_points);
		}
    	/*session.put("daily_Ap", daily_Ap);
    	session.put("hour_Ap", hour_Ap);*/
    }
  //实时批量获取
    public static void realtimeAdd(String[] eventsIds)throws Exception{
    	//Map session=ActionContext.getContext().getSession();
    	String events_ids ="";
		for (int i=0; i<eventsIds.length-1; i++) { 
			events_ids+=eventsIds[i]+",";
		}
		events_ids+=eventsIds[eventsIds.length-1];
		List<Batch_timeline_pointsModel> points=Batch_timeline.JsonToJavaBean(events_ids);
		Collections.sort(points, new Comparator<Batch_timeline_pointsModel>() {
            public int compare(Batch_timeline_pointsModel p0,Batch_timeline_pointsModel p1) {
                try {
                    int temp1= p0.getEvent_id();
                    int temp2=p1.getEvent_id(); 
                    return temp2-temp1;
                } catch (Exception ex) {
                }
                return 0;
            }
        });
    	//session.put("realtimeAp", points);
    }
}
