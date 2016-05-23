/**
 *
 */
package hhm.neha.web.security;

import hhm.neha.data.bean.AuthorizeBean;
import hhm.neha.entity.SecurityAuthorize;
import hhm.neha.service.SecurityAuthorizeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

/**
 * 
 * @comment 授权定时加载器，单例模式
 */
public class TokenReload extends Thread implements Runnable {
	private static final int MAX_TOKENS = 100;
	private static final long SLEEP_TIME = 15L;
	private ServletContext application;
	private SecurityAuthorizeService securityAuthorizeService;
	private boolean runStatus;
	private static TokenReload self = null;

	public synchronized static TokenReload INIT() {
		if (self == null)
			self = new TokenReload();
		return self;
	}

	private TokenReload() {
		super();
		this.runStatus = true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		if (application.getAttribute("USER_TOKENS") == null) {
			application.setAttribute("USER_TOKENS",
					new HashMap<String, AuthorizeBean>());
		}
		while (true) {
			if (this.runStatus) {
				List<SecurityAuthorize> authorizes = securityAuthorizeService
						.getSecurityAuthorizeByParams(null, 0, MAX_TOKENS);
				Map<String, AuthorizeBean> tokens = new HashMap<String, AuthorizeBean>(
						0);
				for (SecurityAuthorize authorize : authorizes) {
					AuthorizeBean bean = new AuthorizeBean();
					bean.setId(authorize.getAutId());
					bean.setUser(authorize.getAutUser());
					bean.setStatus(authorize.getAutStatus());
					bean.setExpTime(authorize.getAutExpDate().getTime());
					tokens.put(authorize.getAutToken(), bean);
				}
				application.setAttribute("USER_TOKENS", tokens);
			}
			try {
				sleep(SLEEP_TIME * 60L * 1000L);
			} catch (InterruptedException e) {

			}
		}
	}

	/**
	 * @return the application
	 */
	public ServletContext getApplication() {
		return application;
	}

	/**
	 * @param application
	 *            the application to set
	 */
	public void setApplication(ServletContext application) {
		this.application = application;
	}

	/**
	 * @param securityAuthorizeService
	 *            the securityAuthorizeService to set
	 */
	public void setAuthorize(SecurityAuthorizeService securityAuthorizeService) {
		this.securityAuthorizeService = securityAuthorizeService;
	}

	/**
	 * @return the runStatus
	 */
	public boolean isRunStatus() {
		return runStatus;
	}

	/**
	 * @param runStatus
	 *            the runStatus to set
	 */
	public void setRunStatus(boolean runStatus) {
		this.runStatus = runStatus;
	}

}
