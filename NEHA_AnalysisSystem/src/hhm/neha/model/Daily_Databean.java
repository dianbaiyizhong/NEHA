package hhm.neha.model;

import java.util.List;

public class Daily_Databean {
	public int event_id;
    public String title;
    public List<Daily_points_pointModel> points;
    public int getEvent_id(){
   	 return event_id;
    }
    public void setEvent_id(int event_id){
   	 this.event_id=event_id;
    }
    public String getTitle(){
    	return title;
    }
    public void setTitle(String title){
    	this.title=title;
    }
    public List<Daily_points_pointModel> getPoints() {
        return points;
    }
    public void setPoints(List<Daily_points_pointModel> points) {
        this.points = points;
    }
}
