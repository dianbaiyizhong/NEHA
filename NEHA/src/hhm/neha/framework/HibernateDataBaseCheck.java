/**
 * 
 */
package hhm.neha.framework;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**

 * @comment hibernate 与数据库连接测试类
 *
 */
public class HibernateDataBaseCheck extends HibernateDaoSupport {
	/**
	 * 连接成功返回true
	 * @return
	 */
	public static boolean check(){
		ApplicationContext context = ApplicationContextFactory.getInstance();
		try {
			SessionFactory sf = (SessionFactory) context.getBean("sessionFactory");
			Session session = sf.openSession();
			if (session == null)
				return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
