/**
 *
 */
package hhm.neha.web.action.exception;

import hhm.neha.web.action.BaseAction;

public class SQLExceptionAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5717017738982954567L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		request.setAttribute("error_code", 20001);
		return "error";
	}

}
