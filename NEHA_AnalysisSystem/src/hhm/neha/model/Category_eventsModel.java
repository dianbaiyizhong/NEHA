package hhm.neha.model;

import java.util.List;

public class Category_eventsModel {
	public int next;
    public String time;
    public int total;
    public Category_events_categoryModel category;
    public List<Category_events_eventModel> events;
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
    public Category_events_categoryModel getCategory() {
        return category;
    }
    public void setCategory(Category_events_categoryModel category) {
        this.category = category;
    }
    public List<Category_events_eventModel> getEvents() {
        return events;
    }
    public void setEvents(List<Category_events_eventModel> events) {
        this.events = events;
    }
}
