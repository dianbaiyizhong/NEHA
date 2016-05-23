/**
 * 
 */
package hhm.neha.control;



import hhm.neha.entity.EventList;
import hhm.neha.entity.PointMultipleHourly;
import hhm.neha.entity.PointMultipleRealTime;
import hhm.neha.framework.ApplicationContextFactory;
import hhm.neha.service.EventListService;
import hhm.neha.service.PointMultipleHourlyService;
import hhm.neha.service.PointMultipleRealTimeService;

import java.sql.Timestamp;

import org.springframework.context.ApplicationContext;


public class EventRealTimePointAnalysisControl {
	private volatile static EventRealTimePointAnalysisControl Instance;
	private ApplicationContext context;
	private EventRealTimePointAnalysisControl(){
		context = ApplicationContextFactory.getInstance();
	}
	/**
	 * 实例化
	 * @return
	 */
	public static EventRealTimePointAnalysisControl getInstance(){
		if(Instance == null){
			synchronized(EventRealTimePointAnalysisControl.class){
				if(Instance == null){
					Instance = new EventRealTimePointAnalysisControl();
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
	 * 插入新数据
	 * @param point
	 * @param eventId
	 */
	public void insertPointMultipleRealTime(Integer point, Integer eventId){
		PointMultipleRealTime entity = new PointMultipleRealTime();
		entity.setAmpEventId(eventId);
		entity.setAmpDate(new Timestamp(System.currentTimeMillis()));
		entity.setAmpPoint(point);
		entity.setAmpStatus(true);
		PointMultipleRealTimeService service = (PointMultipleRealTimeService) context.getBean("pointMultipleRealTimeService");
		service.save(entity);
	}
		
}
