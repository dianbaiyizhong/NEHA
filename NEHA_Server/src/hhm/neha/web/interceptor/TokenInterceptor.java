package hhm.neha.web.interceptor;

import hhm.neha.data.bean.AuthorizeBean;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 
 * @comment 身份拦截器
 */
public class TokenInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4918955296271244256L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com
	 * .opensymphony.xwork2.ActionInvocation)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext actionContext = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) actionContext
				.get(StrutsStatics.HTTP_REQUEST);
		HttpSession session = request.getSession();
		String token = (String) session.getAttribute("USER_TOKEN");

		if (token == null) {
			request.setAttribute("error_code", 20210);
			return "error";
		}
		ServletContext application = (ServletContext) actionContext
				.get(StrutsStatics.SERVLET_CONTEXT);
		Map<String, AuthorizeBean> tokens = (Map<String, AuthorizeBean>) application
				.getAttribute("USER_TOKENS");

		if (tokens == null) {
			request.setAttribute("error_code", 20106);
			return "error";
		}
		if (tokens.containsKey(token)) {
			AuthorizeBean bean = tokens.get(token);
			if (bean == null) {
				request.setAttribute("error_code", 20201);
				return "error";
			}
			if (!bean.isStatus()) {
				request.setAttribute("error_code", 20202);
				return "error";
			}
			if (bean.getExpTime() < System.currentTimeMillis()) {
				request.setAttribute("error_code", 20203);
				return "error";
			}
			return invocation.invoke();
		} else {
			request.setAttribute("error_code", 20201);
			return "error";
		}
	}
}