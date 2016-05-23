package hhm.neha.model;


public class Event_timeline_pointsModel {
	public String date;
    public int event_id;
    public int point;
    
    public String getDate(){
    	return date;
    }
    public void setDate(String date){
    	this.date=date;
    }
    public int getEvent_id(){
   	 return event_id;
    }
    public void setEvent_id(int event_id){
   	 this.event_id=event_id;
    }
    public int getPoint(){
    	return point;
    }
    public void setPoint(int point){
    	this.point=point;
    }
}
