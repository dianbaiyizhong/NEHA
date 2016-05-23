/**
 * 
 */
package hhm.neha.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ApplicationAware,ServletRequestAware, SessionAware,ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -560439219392059088L;
	
	protected Map<String, Object> session;
	protected Map<String, Object> application;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected String absolutePath;


	/**
	 * @param absolutePath the absolutePath to set
	 */
	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = request.getContextPath();
	}

	/**
	 * @return the absolutePath
	 */
	public String getAbsolutePath() {
		this.absolutePath = request.getContextPath() + "/";
		return absolutePath;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.ApplicationAware#setApplication(java.util.Map)
	 */
	public void setApplication(Map<String, Object> arg0) {
		application = arg0;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.ServletRequestAware#setServletRequest(javax.servlet.http.HttpServletRequest)
	 */
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
	}
	
	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.ServletResponseAware#setServletResponse(javax.servlet.http.HttpServletResponse)
	 */
	public void setServletResponse(HttpServletResponse response){
		this.response = response;
	}
}
