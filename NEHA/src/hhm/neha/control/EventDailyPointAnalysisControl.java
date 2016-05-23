/**
 * 
 */
package hhm.neha.control;



import hhm.neha.entity.EventList;
import hhm.neha.entity.PointMultipleDaily;
import hhm.neha.framework.ApplicationContextFactory;
import hhm.neha.service.EventListService;
import hhm.neha.service.PointMultipleDailyService;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.ApplicationContext;

import com.qawaa.utils.DateUtil;


public class EventDailyPointAnalysisControl {
	private volatile static EventDailyPointAnalysisControl Instance;
	private ApplicationContext context;
	private EventDailyPointAnalysisControl(){
		context = ApplicationContextFactory.getInstance();
	}
	/**
	 * 实例化
	 * @return
	 */
	public static EventDailyPointAnalysisControl getInstance(){
		if(Instance == null){
			synchronized(EventDailyPointAnalysisControl.class){
				if(Instance == null){
					Instance = new EventDailyPointAnalysisControl();
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
	 * 根据事件ID获取最新的一条每日指数数据
	 * @param eventId
	 * @return
	 */
	public PointMultipleDaily getLastPointMultipleDailyByEvent(Integer eventId) {
		PointMultipleDailyService service = (PointMultipleDailyService) context.getBean("pointMultipleDailyService");
		return service.getLastPointMultipleDailyByEvent(eventId);
	}

	/**
	 * 根据事件和指定时间获取每日指数数据
	 * @param eventId
	 * @param date
	 * @return
	 */
	public PointMultipleDaily getPointMultipleDailyByEventAndDate(Integer eventId, Date date) {
		PointMultipleDailyService service = (PointMultipleDailyService) context.getBean("pointMultipleDailyService");
		return service.getPointMultipleDailyByEventAndDate(eventId, date);
	}
	
	/**
	 * 根据事件和指定时间获取每日指数
	 * @param eventId
	 * @param date
	 * @return
	 */
	public int getPointByEventAndDate(Integer eventId, Date date) {
		PointMultipleDaily entity = this.getPointMultipleDailyByEventAndDate(eventId, date);
		if(entity == null)
			return 0;
		return entity.getMdpPoint().intValue();
	}
	
	/**
	 * 插入新数据
	 * @param eventId
	 * @param date
	 * @return
	 */
	public PointMultipleDaily insert(Integer eventId, Date date, Integer point){
		PointMultipleDaily entity = new PointMultipleDaily();
		entity.setMdpEventId(eventId);
		entity.setMdpPoint(point);
		entity.setMdpDate(new Timestamp(DateUtil.getBeginTimeOfDay(date).getTime()));
		entity.setMdpStatus(true);
		PointMultipleDailyService service = (PointMultipleDailyService) context.getBean("pointMultipleDailyService");
		service.save(entity);
		return entity;
	}
	
	/**
	 * 更新
	 * @return
	 */
	public PointMultipleDaily update(PointMultipleDaily entity){
		PointMultipleDailyService service = (PointMultipleDailyService) context.getBean("pointMultipleDailyService");
		service.save(entity);
		return entity;
	}
	
}
