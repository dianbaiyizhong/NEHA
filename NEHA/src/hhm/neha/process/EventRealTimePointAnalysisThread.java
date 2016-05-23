/**
 * 
 */
package hhm.neha.process;

import hhm.neha.control.EventRealTimePointAnalysisControl;
import hhm.neha.entity.EventList;
import hhm.neha.entity.PointMultipleHourly;
import hhm.neha.framework.ApplicationContextFactory;

import java.util.Date;
import java.util.Locale;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.context.ApplicationContext;

/**

 * 实时舆情指数分析线程
 */
public class EventRealTimePointAnalysisThread extends Thread implements Runnable {
	private static Log LOG = LogFactory.getLog(EventRealTimePointAnalysisThread.class);
	private volatile static EventRealTimePointAnalysisThread ANALYSIS_THREAD;
	private EventList event;
	private EventRealTimePointAnalysisControl erpaControl = EventRealTimePointAnalysisControl.getInstance();
	private boolean flag = true;
	private ApplicationContext context = ApplicationContextFactory.getInstance();
	private Random random;
	/**
	 * 
	 */
	private EventRealTimePointAnalysisThread(){
		super();
	}
	public static EventRealTimePointAnalysisThread Instance(){
		if(ANALYSIS_THREAD == null){
			synchronized (EventRealTimePointAnalysisThread.class) {
				if(ANALYSIS_THREAD == null)
					ANALYSIS_THREAD = new EventRealTimePointAnalysisThread();
			}
		}
		return ANALYSIS_THREAD;
	}
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		int event_index = 0;
		while (flag) {
			try {
				sleep(5000L);
				event = erpaControl.getNextEventList(event_index);
				random = new Random(System.currentTimeMillis());
				if (event == null) {
					event_index = 0;
					LOG.info(context.getMessage("point.event.null", null, Locale.CHINA));
					try {
						sleep(5000L);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					if(event.getEventStatus().intValue() != 10){
						this.analysis();
					}
					event_index = event.getEventId().intValue();
					LOG.info("Analysis event[" + event_index + "] real time point finish, wait for next event...");
				}

				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JDBCConnectionException e) {
				LOG.error("Connection database fail: " + e.getMessage());
			}
		}
	}
	
	/**
	 * 分析
	 */
	private void analysis(){
		PointMultipleHourly hourlyPoint = erpaControl.getLastPointMultipleHourlyByEvent(event.getEventId());
		if(hourlyPoint == null)//无数据
			return;
		int d_point = hourlyPoint.getMhpPoint();
		int c_point = Double.valueOf(d_point * 0.55).intValue();
		int n_point;
		if(c_point <= 0)
			c_point = 500;
		if((c_point % 2) == 0){
			n_point = d_point + random.nextInt(c_point);
		}else{
			n_point = d_point - random.nextInt(c_point);
		}
		if(n_point > 10000){
			n_point = d_point - random.nextInt(c_point);
		}
		if(n_point < 0){
			n_point = d_point + random.nextInt(c_point);
		}
		erpaControl.insertPointMultipleRealTime(n_point, event.getEventId());
		LOG.info("Analysis event["+ event.getEventId() +"] real time point["+ n_point +"] at " + new Date());	
	}
	
}
