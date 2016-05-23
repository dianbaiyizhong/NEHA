package hhm.neha.model;

import java.util.List;

public class LinesModel {
	public String time;
    public int total;
    public List<Lines_lineModel> lines;
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
    public List<Lines_lineModel> getLines() {
        return lines;
    }
    public void setLines(List<Lines_lineModel> lines) {
        this.lines = lines;
    }
}
