/**
 *
 */
package hhm.neha.common;

import java.lang.management.ManagementFactory;

/**

 * @comment 返回此虚拟机的系统PID
 */
public class JvmPid {
	/**
	 * 返回此虚拟机的系统PID
	 * @return
	 */
	public static String getPID(){
		try{
			return ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
		}catch(Exception e){
			return "UNKNOW";
		}
	}
	
}
