/**
 * 
 */
package hhm.neha.control;



import hhm.neha.entity.EventList;
import hhm.neha.entity.PointMultipleHourly;
import hhm.neha.framework.ApplicationContextFactory;
import hhm.neha.service.EventListService;
import hhm.neha.service.PointMultipleHourlyService;

import java.util.Date;

import org.springframework.context.ApplicationContext;


public class EventHourlyPointAnalysisControl {
	private volatile static EventHourlyPointAnalysisControl Instance;
	private ApplicationContext context;
	private EventHourlyPointAnalysisControl(){
		context = ApplicationContextFactory.getInstance();
	}
	/**
	 * 实例化
	 * @return
	 */
	public static EventHourlyPointAnalysisControl getInstance(){
		if(Instance == null){
			synchronized(EventHourlyPointAnalysisControl.class){
				if(Instance == null){
					Instance = new EventHourlyPointAnalysisControl();
				}
			}
		}
		return Instance;
	}
	
	/**
	 * 获取主键下于指定值的下一个舆情事件，若不存在则返回第一个
	 * @param id
	 * @return
	 */
	public EventList getNextEventList(Integer id){
		EventListService service = (EventListService) context.getBean("eventListService");
		if(id.intValue() <= 0)
			return service.getLastNormalEvent();
		EventList event = service.getNextNormalEvent(id);
		if(event == null)
			event = service.getLastNormalEvent();
		return event;
	}
	
	/**
	 * 根据事件ID获取最新的一条每时指数数据
	 * @param eventId
	 * @return
	 */
	public PointMultipleHourly getLastPointMultipleHourlyByEvent(Integer eventId) {
		PointMultipleHourlyService service = (PointMultipleHourlyService) context.getBean("pointMultipleHourlyService");
		return service.getLastPointMultipleHourlyByEvent(eventId);
	}
	
	/**
	 * 保存
	 * @param entity
	 * @return
	 */
	public PointMultipleHourly save(PointMultipleHourly entity){
		PointMultipleHourlyService service = (PointMultipleHourlyService) context.getBean("pointMultipleHourlyService");
		service.save(entity);
		return entity;
	}

	/**
	 * 根据事件和指定时间获取每时指数数据
	 * @param eventId
	 * @param date
	 * @return
	 */
	public PointMultipleHourly getPointMultipleHourlyByEventAndDate(Integer eventId, Date date) {
		PointMultipleHourlyService service = (PointMultipleHourlyService) context.getBean("pointMultipleHourlyService");
		return service.getPointByEventAndDate(eventId, date);
	}
		
}
