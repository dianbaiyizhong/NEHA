/**
 *
 */
package hhm.neha.web.action.login;

import hhm.neha.data.bean.AuthorizeBean;
import hhm.neha.web.action.BaseAction;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.time.DateFormatUtils;

/**
 * 
 * @comment 系统登录action
 */
public class LoginAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -567800321583729639L;
	private String token;
	private String result[];

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token
	 *            the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the result
	 */
	public String[] getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(String result[]) {
		this.result = result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		String token = request.getParameter("token");
		if (token == null || token.trim().isEmpty()) {
			request.setAttribute("error_code", 20101);
			return "error";
		}
		Object uto = application.get("USER_TOKENS");
		if (uto == null) {
			request.setAttribute("error_code", 20106);
			return "error";
		}
		if (!(uto instanceof Map<?, ?>)) {
			request.setAttribute("error_code", 20106);
			return "error";
		}
		@SuppressWarnings("unchecked")
		Map<String, AuthorizeBean> tokens = (Map<String, AuthorizeBean>) uto;
		if (tokens.containsKey(token)) {
			AuthorizeBean bean = tokens.get(token);
			if (bean == null) {
				request.setAttribute("error_code", 20110);
				return "error";
			}
			if (!bean.isStatus()) {
				request.setAttribute("error_code", 20113);
				return "error";
			}
			if (bean.getExpTime() < System.currentTimeMillis()) {
				request.setAttribute("error_code", 20117);
				return "error";
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("USER_TOKEN", token);
			//session1.put("USER_TOKEN", token);
			String[] _result = {
					"token pass",
					DateFormatUtils.format(new Date(),
							"yyyy-MM-dd HH:mm:ss.SSS") };
			this.setResult(_result);
			return SUCCESS;
		} else {
			request.setAttribute("error_code", 20110);
			return "error";
		}
	}

}
