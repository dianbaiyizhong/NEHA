/**
 *
 */
package hhm.neha.web.security;


public class SessionCookieKey {
	/**
	 * KEY
	 */
	//session存放用户ID
	public static final String USER_VALIDATION_KEY = "usk1408";
	
	/**
	 * USER INFO
	 */
	//session存放用户信息
	public static final String USER_INFO_KEY = "user_info_33";
	
	/**
	 * GlOBAL USER SINGLE LOGIN KEY
	 */
	//application全局在线用户
	@SuppressWarnings("unused")
	private static final String GlOBAL_USER_SINGLE_LOGIN_KEY = "g_usl";
	
	/**
	 * AUTO LOGIN KEY
	 */
	//使用cookie自动登录
	public static final String USER_COOKIE_AUTO_LOGIN = "autolk";
	
	/**
	 * USER COOKIE AUTO LOGIN KEY
	 */
	//使用cookie自动登录
	public static final String USER_COOKIE_AUTO_LOGIN_KEY = "poams_ak";
	
	/**
	 * AUTO LOGIN VALUE
	 */
	//使用cookie自动登录
	public static final String USER_COOKIE_AUTO_LOGIN_TRUE = "1";
	
	/**
	 * AUTO LOGIN VALUE
	 */
	//不使用cookie自动登录
	public static final String USER_COOKIE_AUTO_LOGIN_FALSE = "0";
	
	/**
	 * USER COOKIE DEFAULT MAXAGE
	 */
	//默认cookie有效时间
	public static final int USER_COOKIE_DEFAULT_MAXAGE = 60*60*24*7;
	
	/**
	 * USER LOGIN CODE 
	 */
	//验证码
	public static final String USER_LOGIN_CODE = "loginCode";

}
