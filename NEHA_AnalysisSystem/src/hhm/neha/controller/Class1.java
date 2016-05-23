package hhm.neha.controller;

import hhm.neha.common.CustomerHttpClient;
import hhm.neha.model.Class1Model;
import hhm.neha.model.Class1esModel;
import hhm.neha.util.PathUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

public class Class1 {
	public static List<Class1esModel> JsonToJavaBean(){
		String remoteAdd = new PathUtil().getRemoteAdd();

		String url=remoteAdd +
				"category/site.class1.json";
		String response=CustomerHttpClient.get(url);
		JSONObject object = JSONObject.fromObject(response);
		Map<String, Class<?>> cmap = new HashMap<String, Class<?>>();
		cmap.put("class1es", Class1esModel.class);
		Class1Model class1es = (Class1Model) JSONObject.toBean(object, Class1Model.class,cmap);
		List<Class1esModel> class1=class1es.getClass1es();
		return class1;
		}
}
