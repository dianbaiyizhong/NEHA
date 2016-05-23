/**
 * 
 */
package hhm.neha.process;

import hhm.neha.control.AnalysisSearchListControl;
import hhm.neha.control.EventDailyPointAnalysisControl;
import hhm.neha.entity.EventList;
import hhm.neha.entity.PointMultipleDaily;
import hhm.neha.framework.ApplicationContextFactory;

import java.util.Date;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.context.ApplicationContext;

import com.qawaa.utils.DateUtil;


public class EventDailyPointAnalysisThread extends Thread implements Runnable {
	private static Log LOG = LogFactory.getLog(EventDailyPointAnalysisThread.class);
	private volatile static EventDailyPointAnalysisThread ANALYSIS_THREAD;
	private EventList event;
//	private Integer category;
	private EventDailyPointAnalysisControl edpaControl = EventDailyPointAnalysisControl.getInstance();
	private AnalysisSearchListControl aslControl = AnalysisSearchListControl.getInstance();
	private boolean flag = true;
	private ApplicationContext context = ApplicationContextFactory.getInstance();
	/**
	 * 
	 */
	private EventDailyPointAnalysisThread(){
		super();
	}
	public static EventDailyPointAnalysisThread Instance(){
		if(ANALYSIS_THREAD == null){
			synchronized (EventDailyPointAnalysisThread.class) {
				if(ANALYSIS_THREAD == null)
					ANALYSIS_THREAD = new EventDailyPointAnalysisThread();
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
				event = edpaControl.getNextEventList(event_index);
				if (event == null) {
					event_index = 0;
					LOG.info(context.getMessage("point.event.null", null, Locale.CHINA));
					try {
						sleep(60000L);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					if(event.getEventStatus().intValue() != 10){
						this.analysis();
					}
					event_index = event.getEventId().intValue();
					LOG.info("Analysis event[" + event_index + "] daily finish, wait for next event...");
				}

				sleep(500L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JDBCConnectionException e) {
				LOG.error("Connection database fail: " + e.getMessage());
				try {
					sleep(60000L);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 
	 */
	private void analysis(){
		Date date;
		Date today = new Date();
		PointMultipleDaily dailyPoint = edpaControl.getLastPointMultipleDailyByEvent(event.getEventId());
		if(dailyPoint == null){//无数据
			date = DateUtil.getBeginTimeOfDay(event.getEventStart());
			if(DateUtil.isBefore(DateUtil.getBeginTimeOfDay(new Date()), date)){
				return;//大于当前日期
			}
			
			int point = analysisPointByDate(0, date);
			dailyPoint = edpaControl.insert(event.getEventId(), date, point);
			LOG.info("Insert event["+ event.getEventId() +"] daily point["+point+"] at " + date);
		}else{
			date = dailyPoint.getMdpDate();
		}
		int yesterDayPoint = edpaControl.getPointByEventAndDate(event.getEventId(), DateUtil.getBeginTimeOfDay(DateUtil.getBeforeDate(date)));
		this.update(dailyPoint, yesterDayPoint);
		date = DateUtil.getBeginTimeOfDay(DateUtil.getNextDate(dailyPoint.getMdpDate()));
		while((date.getTime() - DateUtil.getBeginTimeOfDay(today).getTime()) <= 0L){
			yesterDayPoint = edpaControl.getPointByEventAndDate(event.getEventId(), DateUtil.getBeginTimeOfDay(DateUtil.getBeforeDate(date)));
			dailyPoint = edpaControl.getPointMultipleDailyByEventAndDate(event.getEventId(), date);
			if(dailyPoint == null){
				dailyPoint = edpaControl.insert(event.getEventId(), date, this.analysisPointByDate(yesterDayPoint, date));
				LOG.info("Insert event["+ event.getEventId() +"] daily point["+dailyPoint.getMdpPoint()+"] at " + date);
			}else{
				this.update(dailyPoint, yesterDayPoint);
			}
			date = DateUtil.getBeginTimeOfDay(DateUtil.getNextDate(dailyPoint.getMdpDate()));
		}
			
	}
	
	private int analysisPointByDate(int yesterDayPoint, Date date) {
//		int cate = this.category.intValue();
//		switch(cate){
//		case 3006:
//			return this.analysis3006(yesterDayPoint, date);
//			default:
//				return this.analysisDefault(yesterDayPoint, date);
//		}
		return this.analysisDefault(yesterDayPoint, date);
	}
	
//	private int analysis3006(int yesterDayPoint, Date date) {
//		double tp = 0.0;
//		int tc = aslControl.getWebCountByEventAndDate(event.getEventId(), date);
//		if (tc <= 10) {
//			tp = tc * 50;
//		} else {
//			tp = tp + 500.0;
//			if (tc <= 50) {
//				tp = tp + ((tc - 10) * 30.0);
//			} else {
//				tp = tp + 1200.0;
//				if (tc <= 200) {
//					tp = tp + ((tc - 50) * 10.0);
//				} else {
//					tp = tp + 1500.0;
//					if (tc <= 1000) {
//						tp = tp + ((tc - 200) * 5.0);
//					} else {
//						tp = tp + 1500.0;
//						if (tc <= 2500) {
//							tp = tp + ((tc - 1500) * 2.0);
//						} else {
//							tp = tp + 3000.0;
//							if (tc <= 5000) {
//								tp = tp + ((tc - 2500) * 0.5);
//							} else {
//								tp = tp + 825;
//								tp = tp + Math.log(tc - 5000) * Math.log(tc - 5000) * Math.PI * Math.E;
//							}
//						}
//					}
//				}
//			}
//		}
//		if (yesterDayPoint > 0)
//			tp = ((yesterDayPoint * 1.0) + tp) * 0.5;
//		return Double.valueOf(tp).intValue();
//	}
	/**
	 * 根据前一日的值和日期计算指数
	 * @param yesterDayPoint
	 * @param date
	 * @return
	 */
	private int analysisDefault(int yesterDayPoint, Date date) {
		double tp = 0.0;
		int tc = aslControl.getWebCountByEventAndDate(event.getEventId(), date);
		if (tc <= 100) {
			tp = tc * 8.5;
		} else {
			tp = tp + 850.0;
			if (tc <= 300) {
				tp = tp + ((tc - 100) * 6.0);
			} else {
				tp = tp + 1200.0;
				if (tc <= 500) {
					tp = tp + ((tc - 300) * 4.0);
				} else {
					tp = tp + 2000.0;
					if (tc <= 1500) {
						tp = tp + ((tc - 500) * 2.5);
					} else {
						tp = tp + 2500.0;
						if (tc <= 4500) {
							tp = tp + ((tc - 1500) * 0.55);
						} else {
							tp = tp + 2250.0;
							if (tc <= 8000) {
								tp = tp + ((tc - 4500) * 0.3);
							} else {
								tp = tp + 1750;
								if (tc <= 15000) {
									tp = tp + ((tc - 8000) * 0.1);
								} else {
									tp = tp + 1050;
									if (tc <= 45000) {
										tp = tp + ((tc - 15000) * 0.015);
									} else {
										tp = tp + 1050;
										if (tp <= 100000) {
											tp = tp + ((tc - 45000) * 0.005);
										} else {
											tp = tp + 825;
											tp = tp + Math.log(tc - 100000) * Math.log(tc - 100000) * Math.PI * Math.E;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if (yesterDayPoint > 0)
			tp = ((yesterDayPoint * 1.0) + tp) * 0.5;
		if(tp > 10000)
			tp = 9900 + (tp/100000)*100;
		return Double.valueOf(tp).intValue();
	}
	
	/**
	 * 更新一条数据
	 * @param dailyPoint
	 * @param yesterDayPoint
	 */
	private void update(PointMultipleDaily dailyPoint, int yesterDayPoint){
		int point = this.analysisPointByDate(yesterDayPoint, dailyPoint.getMdpDate());
		dailyPoint.setMdpPoint(point);
		LOG.info("Update event["+ event.getEventId() +"] daily point["+point+"] at " + dailyPoint.getMdpDate());
		edpaControl.update(dailyPoint);
	}
	
}
