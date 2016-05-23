package hhm.neha.model;

import java.util.List;

public class Public_timelineModel {
	public int next;
    public String time;
    public int total;
    public List<Public_timeline_eventsModel> events;
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
    public List<Public_timeline_eventsModel> getEvents() {
        return events;
    }
 
    public void setEvents(List<Public_timeline_eventsModel> events) {
        this.events = events;
    }
}
