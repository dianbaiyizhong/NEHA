/**
 *
 */
package hhm.neha.data.bean;

import org.apache.struts2.json.annotations.JSON;

public class ErrorBean {
	private Integer error_code;
	private String error_msg;
	private String request_uri;

	/**
	 * @return the error_code
	 */
	@JSON(name = "code")
	public Integer getError_code() {
		return error_code;
	}

	/**
	 * @param error_code
	 *            the error_code to set
	 */
	public void setError_code(Integer error_code) {
		this.error_code = error_code;
	}

	/**
	 * @return the error_msg
	 */
	@JSON(name = "msg")
	public String getError_msg() {
		return error_msg;
	}

	/**
	 * @param error_msg
	 *            the error_msg to set
	 */
	public void setError_msg(String error_msg) {
		this.error_msg = error_msg;
	}

	/**
	 * @return the request_uri
	 */
	@JSON(name = "uri")
	public String getRequest_uri() {
		return request_uri;
	}

	/**
	 * @param request_uri
	 *            the request_uri to set
	 */
	public void setRequest_uri(String request_uri) {
		this.request_uri = request_uri;
	}

	/**
	 * 
	 */
	public ErrorBean() {
		super();
	}

}
