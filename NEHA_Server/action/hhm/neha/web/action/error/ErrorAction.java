/**
 *
 */
package hhm.neha.web.action.error;

import hhm.neha.data.bean.ErrorBean;
import hhm.neha.web.action.BaseAction;

/**
 * 
 * @comment
 */
public class ErrorAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -180102114871029517L;
	private ErrorBean error;

	/**
	 * @return the error
	 */
	public ErrorBean getError() {
		return error;
	}

	/**
	 * @param error
	 *            the error to set
	 */
	public void setError(ErrorBean error) {
		this.error = error;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		this.error = new ErrorBean();
		if (request.getMethod().equalsIgnoreCase("post")
				|| request.getAttribute("error_code") == null) {
			error.setError_code(20000);
			error.setError_msg(this.getText("error."
					+ error.getError_code().toString()));
			error.setRequest_uri(request.getRequestURI());
		} else {
			error.setError_code((Integer) request.getAttribute("error_code"));
			error.setError_msg(this.getText("error."
					+ error.getError_code().toString()));
			error.setRequest_uri(request.getRequestURI());
		}
		return SUCCESS;
	}

}
