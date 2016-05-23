package hhm.neha.model;

public class Daily_timelineModel {
	public int next;
    public String time;
    public int total;
    public Daily_timeline_pointModel p;
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
    public Daily_timeline_pointModel getP() {
        return p;
    }
    public void setP(Daily_timeline_pointModel p) {
        this.p = p;
    }
}
