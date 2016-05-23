/**
 * 
 */
package hhm.neha.control;


import hhm.neha.entity.AnalysisSearchList;
import hhm.neha.framework.ApplicationContextFactory;
import hhm.neha.service.AnalysisSearchListService;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.ApplicationContext;

import com.qawaa.utils.security.MD5;


public class AnalysisSearchListControl {
	private volatile static AnalysisSearchListControl Instance;
	private ApplicationContext context;
	private AnalysisSearchListControl(){
		context = ApplicationContextFactory.getInstance();
	}
	/**
	 * 实例化
	 * @return
	 */
	public static AnalysisSearchListControl getInstance(){
		if(Instance == null){
			synchronized(AnalysisSearchListControl.class){
				if(Instance == null){
					Instance = new AnalysisSearchListControl();
				}
			}
		}
		return Instance;
	}
	
	/**
	 * 根据URL和事件ID获取，不存在时返回null
	 * @param url
	 * @param eventId
	 * @return
	 */
	public AnalysisSearchList getEventList(String url, Integer eventId){
		AnalysisSearchListService service = (AnalysisSearchListService) context.getBean("analysisSearchListService");
		return service.getAnalysisSearchListByURLAndEvent(MD5.MD5Encode(url), eventId);
	}
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(AnalysisSearchList entity){
		AnalysisSearchListService service = (AnalysisSearchListService) context.getBean("analysisSearchListService");
		service.save(entity);
	}
	
	/**
	 * 根据事件和时间获取改时间所在天的文章总数
	 * @param eventId
	 * @param date
	 * @return
	 */
	public int getWebCountByEventAndDate(Integer eventId, Date date) {
		AnalysisSearchListService service = (AnalysisSearchListService) context.getBean("analysisSearchListService");
		return service.getWebCountByEventAndDate(eventId, new Timestamp(date.getTime()));
	}
		
}
