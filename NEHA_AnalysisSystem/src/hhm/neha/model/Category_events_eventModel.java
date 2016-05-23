package hhm.neha.model;


public class Category_events_eventModel {
	public String creat_at;
    public String exp;
    public int id;
    public String title;
    public Boolean top;
    
    public String getCreat_at(){
    	return creat_at;
    }
    public void setCreat_at(String creat_at){
    	this.creat_at=creat_at;
    }
    public String getExp(){
    	return exp;
    }
    public void setExp(String exp){
    	this.exp=exp;
    }
    public int  getId(){
    	return id;
    }
    public void setId(int id){
    	this.id=id;
    }
    public String getTitle(){
    	return title;
    }
    public void setTitle(String title){
    	this.title=title;
    }
    public Boolean getTop(){
    	return top;
    }
    public void setTop(Boolean top){
    	this.top=top;
    }
}
