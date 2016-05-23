package hhm.neha.model;

import java.util.List;

public class EventModel {
	public String time;
    public int total;
    public List<Event_categoriesModel> categories;
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
    public List<Event_categoriesModel> getCategories() {
        return categories;
    }
    public void setCategories(List<Event_categoriesModel> categories) {
        this.categories = categories;
    }
}
