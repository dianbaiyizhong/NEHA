package hhm.neha.model;

public class Event_timelineModel {
    public Event_timeline_pointsModel p;
    public int next;
    public String time;
    public int total;
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
    public Event_timeline_pointsModel getP() {
        return p;
    }
    public void setP(Event_timeline_pointsModel p) {
        this.p = p;
    }    
}
