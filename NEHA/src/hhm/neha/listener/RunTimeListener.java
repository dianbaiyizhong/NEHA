/**
 *
 */
package hhm.neha.listener;

import javax.swing.text.JTextComponent;

/**

 * @comment 
 */
public class RunTimeListener extends Thread {
	private static final long TIME = 28L * 1240L;
	private JTextComponent component;
	private long start;
	/**
	 * @param component
	 * @param start
	 */
	public RunTimeListener(JTextComponent component) {
		super();
		this.component = component;
		this.start = System.currentTimeMillis();
	}
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		while(true){
			long now = System.currentTimeMillis();
			long t = now - start;
			component.setText(this.getRunTime(t));
			try {
				Thread.sleep(TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private String getRunTime(long time){
		StringBuffer buffer = new StringBuffer();
		long day = time/(24L*60L*60L*1000L);
		buffer.append(day);
		buffer.append(" 天 ");
		long last = time%(24L*60L*60L*1000L);
		long hour = last/(60L*60L*1000L);
		buffer.append(hour);
		buffer.append(" 小时 ");
		last = last % (60L*60L*1000L);
		long minute = last/(60L*1000L);
		buffer.append(minute);
		buffer.append(" 分钟");
		return buffer.toString();
	}
	
}
