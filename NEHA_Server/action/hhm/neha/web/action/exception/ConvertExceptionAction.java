/**
 *
 */
package hhm.neha.web.action.exception;

import hhm.neha.web.action.BaseAction;

public class ConvertExceptionAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8928290977788719421L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		request.setAttribute("error_code", 20002);
		return "error";
	}

}
