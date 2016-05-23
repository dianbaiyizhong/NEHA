/**
 *
 */
package hhm.neha.listener;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.text.DecimalFormat;

import javax.swing.text.JTextComponent;

/**

 * @comment 监听组件内存的使用量
 */
public class MemoryListener extends Thread {
	private static final long TIME = 5000L;
	private JTextComponent component;

	/**
	 * @param component
	 */
	public MemoryListener(JTextComponent component) {
		super();
		this.component = component;
	}

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		do{
			MemoryMXBean mbean = ManagementFactory.getMemoryMXBean();
			long used = mbean.getHeapMemoryUsage().getUsed();
			long used_kb = used / 1000L;
			String s = new DecimalFormat(",###").format(used_kb) + " KB";
			component.setText(s);
			try {
				sleep(TIME);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(true);
	}
	
}
