/**
 *
 */
package hhm.neha.framework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**

 * @comment 加载spring Application Context,单例模式
 */
public class ApplicationContextFactory {
	private volatile static ApplicationContextFactory factory;
	private ApplicationContext context;
	
	private ApplicationContextFactory(){
		super();
		context = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
	}
	
	/**
	 * 实例化
	 * @return
	 */
	public static ApplicationContext getInstance(){
		if(factory == null){
			synchronized(ApplicationContextFactory.class){
				if(factory == null){
					factory = new ApplicationContextFactory();
				}
			}
		}
		return factory.context;
	}
}
