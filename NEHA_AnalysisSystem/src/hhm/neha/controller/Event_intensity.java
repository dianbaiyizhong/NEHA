/**
 * 
 */
package hhm.neha.controller;

import hhm.neha.common.CustomerHttpClient;
import hhm.neha.model.Event_intensity_intensityModel;
import hhm.neha.util.PathUtil;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

/**
 * @author Liu Te
 * @data 2014-3-10 上午11:34:17 
 * @company 浙江传媒学院-互联网与社会研究中心  CIS
 * @address 中国杭州下沙高教园区学源街998号
 * @tel 0571-86879294
 * @home www.cischina.org
 * @comment 
 *
 */
public class Event_intensity {
	
	/***
	 * 根据url地址和event_id获取intendity(强度)
	 * @param event_id 事件编号
	 * @return Event_intensity_intensityModel（强度实体）
	 */
	public static Event_intensity_intensityModel JsonToBean(int event_id){
		
		String remoteAdd = new PathUtil().getRemoteAdd();

		String url = remoteAdd +
				"point/intensity.json?";
		if(event_id!=0){
			url+="event_id="+event_id;
		}
		String response = CustomerHttpClient.get(url);
		JSONObject object = JSONObject.fromObject(response);
		Map<String,Class<?>> cmap = new HashMap<String, Class<?>>();
		cmap.put("intensity", Event_intensity_intensityModel.class);
		Event_intensity_intensityModel intendity = (Event_intensity_intensityModel) JSONObject.toBean(object, Event_intensity_intensityModel.class,cmap);
		return intendity;
	}

}








