package hhm.neha.model;

import java.util.List;

public class Class1Model {
	public String time;
    public int total;
    public List<Class1esModel> class1es;
    
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
    public List<Class1esModel> getClass1es() {
        return class1es;
    }
    public void setClass1es(List<Class1esModel> class1es) {
        this.class1es = class1es;
    }  
}
