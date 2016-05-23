/**
 *
 */
package hhm.neha.action;

import hhm.neha.data.bean.OnlineUserBean;
import hhm.neha.web.security.SessionCookieKey;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class AjaxBaseAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -365611382110436651L;
	public static final String AJAXSUCCESS = "AJAXSUCCESS";
	public static final String AJAXERROR = "AJAXERROR";
	private int statusCode;
	private String message;
	private String navTabId;
	private String rel;
	private String callbackType;
	private String forwardUrl;
	private Map<String, Integer> pageSelect;
	private OnlineUserBean userSelf;
	private Integer selfId;
	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the navTabId
	 */
	public String getNavTabId() {
		return navTabId;
	}
	/**
	 * @param navTabId the navTabId to set
	 */
	public void setNavTabId(String navTabId) {
		this.navTabId = navTabId;
	}
	/**
	 * @return the rel
	 */
	public String getRel() {
		return rel;
	}
	/**
	 * @param rel the rel to set
	 */
	public void setRel(String rel) {
		this.rel = rel;
	}
	/**
	 * @return the callbackType
	 */
	public String getCallbackType() {
		return callbackType;
	}
	/**
	 * @param callbackType the callbackType to set
	 */
	public void setCallbackType(String callbackType) {
		this.callbackType = callbackType;
	}
	/**
	 * @return the forwardUrl
	 */
	public String getForwardUrl() {
		return forwardUrl;
	}
	/**
	 * @param forwardUrl the forwardUrl to set
	 */
	public void setForwardUrl(String forwardUrl) {
		this.forwardUrl = forwardUrl;
	}
	
	/**
	 * @return the pageSelect
	 */
	public Map<String, Integer> getPageSelect() {
		pageSelect = new LinkedHashMap<String, Integer>();
		pageSelect.put("20", 20);
		pageSelect.put("50", 50);
		pageSelect.put("100", 100);
		pageSelect.put("200", 200);
		return pageSelect;
	}
	/**
	 * @param pageSelect the pageSelect to set
	 */
	public void setPageSelect(Map<String, Integer> pageSelect) {
		this.pageSelect = pageSelect;
	}
	/**
	 * 设置AJAX参数
	 * @param statusCode
	 * @param message
	 * @param navTabId
	 * @param rel
	 * @param callbackType
	 * @param forwardUrl
	 */
	protected void setAjaxJson( String message, String navTabId, String rel, String callbackType, String forwardUrl) {
		try {
			this.message = URLEncoder.encode(message, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			this.message = this.getText("gobal.alert.fail.params.error");
		}
		this.navTabId = navTabId;
		this.rel = rel;
		this.callbackType = callbackType;
		this.forwardUrl = forwardUrl;
	}
	
	/**
	 * @return the userSelf
	 */
	public OnlineUserBean getUserSelf() {
		userSelf = (OnlineUserBean) session.get(SessionCookieKey.USER_INFO_KEY);
		return userSelf;
	}
	/**
	 * @param userSelf the userSelf to set
	 */
	public void setUserSelf(OnlineUserBean userSelf) {
		this.userSelf = userSelf;
	}
	/**
	 * @return the selfId
	 */
	public Integer getSelfId() {
		selfId = (Integer) session.get(SessionCookieKey.USER_VALIDATION_KEY);
		return selfId;
	}
	/**
	 * @param selfId the selfId to set
	 */
	public void setSelfId(Integer selfId) {
		this.selfId = selfId;
	}

}
