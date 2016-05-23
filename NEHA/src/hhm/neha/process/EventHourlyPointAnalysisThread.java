/**
 * 
 */
package hhm.neha.process;

import hhm.neha.control.EventDailyPointAnalysisControl;
import hhm.neha.control.EventHourlyPointAnalysisControl;
import hhm.neha.entity.EventList;
import hhm.neha.entity.PointMultipleDaily;
import hhm.neha.entity.PointMultipleHourly;
import hhm.neha.framework.ApplicationContextFactory;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.context.ApplicationContext;

import com.qawaa.utils.DateUtil;

/**
 * 
 * 每小时舆情指数分析线程
 */
public class EventHourlyPointAnalysisThread extends Thread implements Runnable {
	private static Log LOG = LogFactory
			.getLog(EventHourlyPointAnalysisThread.class);
	private volatile static EventHourlyPointAnalysisThread ANALYSIS_THREAD;
	private EventList event;
	private EventDailyPointAnalysisControl edpaControl = EventDailyPointAnalysisControl
			.getInstance();
	private EventHourlyPointAnalysisControl ehpaControl = EventHourlyPointAnalysisControl
			.getInstance();
	private boolean flag = true;
	private ApplicationContext context = ApplicationContextFactory
			.getInstance();
	private Random random;

	/**
	 * 
	 */
	private EventHourlyPointAnalysisThread() {
		super();
	}

	public static EventHourlyPointAnalysisThread Instance() {
		if (ANALYSIS_THREAD == null) {
			synchronized (EventHourlyPointAnalysisThread.class) {
				if (ANALYSIS_THREAD == null)
					ANALYSIS_THREAD = new EventHourlyPointAnalysisThread();
			}
		}
		return ANALYSIS_THREAD;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		int event_index = 0;
		while (flag) {
			try {
				event = ehpaControl.getNextEventList(event_index);
				random = new Random(System.currentTimeMillis());
				if (event == null) {
					event_index = 0;
					LOG.info(context.getMessage("point.event.null", null,
							Locale.CHINA));
					try {
						sleep(5000L);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					if (event.getEventStatus().intValue() != 10) {
						this.analysis();
					}
					event_index = event.getEventId().intValue();
					LOG.info("Analysis event[" + event_index
							+ "] hourly finish, wait for next event...");
				}

				sleep(5000L);
			} catch (InterruptedException e) {
				try {
					sleep(5000L);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
	 * 分析
	 */
	private void analysis() {
		Date date;
		PointMultipleHourly hourlyPoint = ehpaControl
				.getLastPointMultipleHourlyByEvent(event.getEventId());
		if (hourlyPoint == null) {// 无数据
			date = DateUtil.getBeginTimeOfDay(event.getEventStart());
			if (DateUtil.isBefore(DateUtil.getBeginTimeOfDay(new Date()), date)) {
				return;// 大于当前日期
			}
		} else {
			date = hourlyPoint.getMhpDate();
		}
		date = this.save(date);
		while (hasNext(date)) {
			date = this.save(date);
			try {
				sleep(1500L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	/**
	 * 保存一个时间的指数
	 * 
	 * @param date
	 * @return
	 */
	private Date save(Date date) {
		PointMultipleDaily dailyPoint = edpaControl
				.getPointMultipleDailyByEventAndDate(event.getEventId(),
						DateUtil.getBeginTimeOfDay(date));
		if (dailyPoint == null)
			return null;
		int d_point = dailyPoint.getMdpPoint();
		int c_point = Double.valueOf(d_point * 0.50).intValue();
		int n_point;
		int r_point = 0;
		if (d_point > 0 && d_point <= 1000) {
			r_point = random.nextInt(1000);
			if (r_point < 500)
				r_point = r_point + 500;
		}
		if (d_point > 1000 && d_point <= 2000) {
			r_point = random.nextInt(1000);
			if (r_point < 500)
				r_point = 1000 - r_point;
		}
		if (d_point > 2000 && d_point <= 3000) {
			r_point = random.nextInt(3000);
			if (r_point < 750)
				r_point = r_point + 750;
		}
		if (d_point > 3000 && d_point <= 5000) {
			r_point = random.nextInt(3000);
			if (r_point < 1000)
				r_point = r_point + 1000;
		}
		if (d_point > 5000 && d_point <= 7000) {
			r_point = random.nextInt(3000);
			if (r_point < 1750)
				r_point = r_point + 1250;
		}
		if (d_point > 7000 && d_point <= 9000) {
			r_point = random.nextInt(3500);
			if (r_point < 1000)
				r_point = r_point + 1000;
		}
		if (d_point > 9000) {
			r_point = random.nextInt(2500);
			if (r_point < 1250)
				r_point = r_point + 1200;
		}
		if ((c_point % 2) == 0) {
			n_point = d_point + r_point;
		} else {
			n_point = d_point - r_point;
		}
		if (n_point > 10000) {
			n_point = d_point - r_point;
		}
		if (n_point < 0) {
			n_point = d_point + r_point;
		}
		PointMultipleHourly hourlyPoint = ehpaControl
				.getPointMultipleHourlyByEventAndDate(event.getEventId(),
						DateUtil.getBeginTimeOfHour(date));
		if (hourlyPoint == null) {
			hourlyPoint = new PointMultipleHourly();
			hourlyPoint.setMhpDate(new Timestamp(DateUtil.getBeginTimeOfHour(
					date).getTime()));
			hourlyPoint.setMhpEventId(event.getEventId());
			hourlyPoint.setMhpStatus(true);
		}
		hourlyPoint.setMhpPoint(n_point);
		hourlyPoint = ehpaControl.save(hourlyPoint);
		LOG.info("Analysis event[" + hourlyPoint.getMhpEventId()
				+ "] hourly point[" + hourlyPoint.getMhpPoint() + "] at "
				+ hourlyPoint.getMhpDate());
		return DateUtil.getBeginTimeOfHour(new Date(hourlyPoint.getMhpDate()
				.getTime() + 65L * 60L * 1000L));
	}

	/**
	 * 根据时间判断是否进行下一个分析，进行返回true
	 * 
	 * @param date
	 * @return
	 */
	private boolean hasNext(Date date) {
		if (date == null)
			return false;
		long t = date.getTime();
		long n = System.currentTimeMillis();
		return (t - n) < 0L;
	}

}
