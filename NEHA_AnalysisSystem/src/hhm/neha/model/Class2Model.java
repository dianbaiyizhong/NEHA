package hhm.neha.model;

import java.util.List;

public class Class2Model {
	 public String time;
     public int total;
     public List<Class2esModel> class2es;
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
        public List<Class2esModel> getClass2es() {
            return class2es;
        }
        public void setClass2es(List<Class2esModel> class2es) {
            this.class2es = class2es;
        }
}
