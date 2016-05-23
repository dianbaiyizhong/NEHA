package hhm.neha.model;

import java.util.List;


public class Event_pointsModel {
	 public int event_id;
	 public int next;
     public String time;
     public int total;
     public List<Event_points_pointModel> points;
     
     public int getEvent_id(){
    	 return event_id;
     }
     public void setEvent_id(int event_id){
    	 this.event_id=event_id;
     }
     public int getNext(){
    	 return next;
     }
     public void setNext(int next){
    	 this.next=next;
     }
     public String getTime(){
    	 return time;
     }
     public void setTime(String time){
    	 this.time=time;
     }
     public int getTotal(){
    	 return total;
     }
     public void setTotal(int total){
    	 this.total=total;
     }
     public List<Event_points_pointModel> getPoints() {
         return points;
     }
     public void setPoints(List<Event_points_pointModel> points) {
         this.points = points;
     }    
}

