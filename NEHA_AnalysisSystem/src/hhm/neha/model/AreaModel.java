package hhm.neha.model;

import java.util.List;

public class AreaModel {
	public String time;
    public int total;
    public List<Area_areasModel> areas;
    
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
       public List<Area_areasModel> getAreas() {
           return areas;
       }
       public void setAreas(List<Area_areasModel> areas) {
           this.areas = areas;
       }
}
