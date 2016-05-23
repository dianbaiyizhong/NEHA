package hhm.neha.model;

public class Class2esModel {
	public int site_class2_id;
    public String site_class2_name;
    public Class2_class1Model class1;
    
    public int getSite_class2_id(){
    	return site_class2_id;
    }
    public void setSite_class2_id(int site_class2_id){
    	this.site_class2_id=site_class2_id;
    }
    public String getSite_class2_name(){
    	return site_class2_name;
    }
    public void setSite_class2_name(String site_class2_name){
    	this.site_class2_name=site_class2_name;
    }
    public Class2_class1Model getClass1() {
        return class1;
    }
    public void setClass1(Class2_class1Model class1) {
        this.class1 = class1;
    }
}
