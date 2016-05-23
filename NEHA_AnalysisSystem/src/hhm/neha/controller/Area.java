package hhm.neha.controller;

import hhm.neha.common.CustomerHttpClient;
import hhm.neha.model.AreaModel;
import hhm.neha.model.Area_areasModel;
import hhm.neha.util.PathUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

public class Area {
	public static List<Area_areasModel> JsonToJavaBean() {
		String remoteAdd = new PathUtil().getRemoteAdd();

		String url = remoteAdd + "category/area.json";
		String response = CustomerHttpClient.get(url);
		JSONObject object = JSONObject.fromObject(response);
		Map<String, Class<?>> cmap = new HashMap<String, Class<?>>();
		cmap.put("areas", Area_areasModel.class);
		AreaModel areas = (AreaModel) JSONObject.toBean(object,
				AreaModel.class, cmap);
		List<Area_areasModel> areas_area = areas.getAreas();
		return areas_area;
	}
}
