package hhm.neha.controller;

import hhm.neha.common.CustomerHttpClient;
import hhm.neha.model.LinesModel;
import hhm.neha.model.Lines_lineModel;
import hhm.neha.util.PathUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

public class Lines {
	public static List<Lines_lineModel> JsonToJavaBean(){
		String remoteAdd = new PathUtil().getRemoteAdd();

		String url=remoteAdd +
				"category/warning/line.json";
		String response=CustomerHttpClient.get(url);
		JSONObject object = JSONObject.fromObject(response);
		Map<String, Class<?>> cmap = new HashMap<String, Class<?>>();
		cmap.put("lines", Lines_lineModel.class);
		LinesModel lines = (LinesModel) JSONObject.toBean(object, LinesModel.class,cmap);
		List<Lines_lineModel> line=lines.getLines();
		return line;
		}
}
