package hhm.neha.controller;

import hhm.neha.common.CustomerHttpClient;
import hhm.neha.model.VersionModel;
import hhm.neha.util.PathUtil;
import net.sf.json.JSONObject;

public class Version {
	public static String JsonToJavaBean() {

		String remoteAdd = new PathUtil().getRemoteAdd();

		String url = remoteAdd + "version.json";
		String response = CustomerHttpClient.get(url);
		JSONObject object = JSONObject.fromObject(response);
		VersionModel versionM = (VersionModel) JSONObject.toBean(object,
				VersionModel.class);
		String version = versionM.getVersion();
		return version;
	}
}
