/**
 *
 */
package hhm.neha.action.login;

import hhm.neha.action.BaseAction;
import hhm.neha.web.security.SessionCookieKey;
import hhm.neha.web.security.VerificationCodeFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;


/**

 * @comment 验证码
 */
public class VerificationCodeAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5322338230455612904L;

	private long date;
	private ByteArrayInputStream inputStream;
	private static int width = 100;
	private static int height = 30;

	/**
	 * @return the date
	 */
	public long getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(long date) {
		this.date = date;
	}

	/**
	 * @return the inputStream
	 */
	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}

	/**
	 * @param inputStream the inputStream to set
	 */
	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception {
		int type = 1;
		try{
			VerificationCodeFactory codeFactory = new VerificationCodeFactory(width, height, type);
			session.put(SessionCookieKey.USER_LOGIN_CODE, codeFactory.getCode());
			this.setInputStream(codeFactory.getImage());// 取得带有随机字符串的图片
		}catch(IOException e){
			// TODO 异常处理 
		}
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		return SUCCESS;
	}
}
