/**
 *
 */
package hhm.neha.action.login;

import hhm.neha.action.BaseAction;
import hhm.neha.data.bean.OnlineUserBean;
import hhm.neha.web.security.SessionCookieKey;

import java.util.Date;

/**

 * @comment 用户登录action 
 */
public class LoginAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -567800321583729639L;
	
	private int errCode = 0;
	private String username;
	private String password;
	private int saveCookie;
	//是否使用验证码
	private int useCode = 1;
	private String code;
	private String ajaxLoginName;
	private int ajax = 0;
	
	/**
	 * @return the errCode
	 */
	public int getErrCode() {
		return errCode;
	}

	/**
	 * @param errCode the errCode to set
	 */
	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the saveCookie
	 */
	public int getSaveCookie() {
		return saveCookie;
	}

	/**
	 * @param saveCookie the saveCookie to set
	 */
	public void setSaveCookie(int saveCookie) {
		this.saveCookie = saveCookie;
	}

	/**
	 * @return the useCode
	 */
	public int getUseCode() {
		return useCode;
	}

	/**
	 * @param useCode the useCode to set
	 */
	public void setUseCode(int useCode) {
		this.useCode = useCode;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the ajaxLoginName
	 */
	public String getAjaxLoginName() {
		return ajaxLoginName;
	}

	/**
	 * @param ajaxLoginName the ajaxLoginName to set
	 */
	public void setAjaxLoginName(String ajaxLoginName) {
		this.ajaxLoginName = ajaxLoginName;
	}

	/**
	 * @return the ajax
	 */
	public int getAjax() {
		return ajax;
	}

	/**
	 * @param ajax the ajax to set
	 */
	public void setAjax(int ajax) {
		this.ajax = ajax;
	}

	/**
	 * 登录界面
	 * @return
	 */
	public String index(){
		if(ajax == 1){
			return "ajaxIndex";
		}
		Object session_validate = session.get(SessionCookieKey.USER_VALIDATION_KEY);
		Object session_userinfo = session.get(SessionCookieKey.USER_INFO_KEY);
		if(session_validate != null && session_userinfo != null){
			if(session_validate instanceof Integer){
				return "pass";
			}
		}
		Object session_errCode = session.get("errCode");
		if(session_errCode == null){
			errCode = 0;
		}else{
			errCode = (Integer)session_errCode;
		}
		Object session_usrname = session.get("username");
		if(session_usrname != null){
			username = (String) session_usrname;
		}
		return SUCCESS;
	}
	
	/**
	 * 登录。errCode：成功=0；用户输入不完整=100；用户名不存在或密码错误=110；帐号已到期=103；ip不在允许范围内=102；帐号禁用=101；验证码错误=104
	 * @return
	 */
	public String pass(){
		if(ajax == 1){
			if(ajaxLoginName == null || !ajaxLoginName.equals(username))
				return this.loginFail(105);
		}
		if(this.username == null || this.username.trim().isEmpty() || this.password == null || this.password.trim().isEmpty()){
			return this.loginFail(100);
		}
		if(this.username.equals("admin") && password.equals("admin")){
			//登录成功
			session.remove("errCode");
			session.remove("username");
			session.remove(SessionCookieKey.USER_LOGIN_CODE);
			
			this.setUserBeanSession();
			if(ajax == 1){
				return "ajaxSuccess";
			}else{
				return SUCCESS;
			}
		}else{
			return this.loginFail(110);
		}
	}
	/**
	 * timeout提示框
	 * @return
	 */
	public String timeout(){
		return SUCCESS;
	}
		
	/**
	 * 退出登录
	 * @return
	 */
	public String logout(){
		session.remove(SessionCookieKey.USER_VALIDATION_KEY);
		session.remove(SessionCookieKey.USER_INFO_KEY);
		session.clear();
		return SUCCESS;
	}
	

	/**
	 * 设置session相关 
	 * @param userOverview
	 * @param userLogin
	 */
	private void setUserBeanSession(){
		session.put(SessionCookieKey.USER_VALIDATION_KEY, 1);
		OnlineUserBean user = new OnlineUserBean(1, "cischina", "后台管理员", this.getIp(), new Date(), 0.0, 0, 0, this.getIp(), new Date(), 1);
		user.setLastLoginAddress("未知");
		session.put(SessionCookieKey.USER_INFO_KEY, user);
	}
	
	/**
	 * 登录失败处理
	 * @param code
	 * @return
	 */
	private String loginFail(int code){
		if(ajax == 1){
			this.errCode = code;
			return "ajaxFail";
		}
		session.put("errCode", code);
		session.put("username", username.trim());
		session.remove(SessionCookieKey.USER_LOGIN_CODE);
		return "fail";
	}
	
	/**
	 * 获取IP
	 * @return
	 */
	private String getIp() {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip.trim().equals("0:0:0:0:0:0:0:1"))
			ip = "127.0.0.1";
		return ip;
	}
	
}
