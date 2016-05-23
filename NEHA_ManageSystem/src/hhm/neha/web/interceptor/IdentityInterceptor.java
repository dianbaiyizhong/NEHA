package hhm.neha.web.interceptor;

import hhm.neha.web.security.SessionCookieKey;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


/**

 * @comment 身份拦截器
 */
public class IdentityInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4918955296271244256L;

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		ActionContext actionContext = invocation.getInvocationContext();
		Map<String, Object> session = actionContext.getSession();
		if (session != null && session.get(SessionCookieKey.USER_VALIDATION_KEY) != null && session.get(SessionCookieKey.USER_INFO_KEY) != null) {
			return invocation.invoke();
		}
		return "identityFail";
		
	}
}