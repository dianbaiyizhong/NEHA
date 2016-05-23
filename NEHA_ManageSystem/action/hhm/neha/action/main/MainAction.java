/**
 *
 */
package hhm.neha.action.main;

import hhm.neha.action.BaseAction;
import hhm.neha.data.bean.OnlineUserBean;
import hhm.neha.web.security.SessionCookieKey;

/**

 * @comment 首页
 */
public class MainAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1196521124785489186L;
	private OnlineUserBean self;
	private int unReadMessage;
	/**
	 * @return the self
	 */
	public OnlineUserBean getSelf() {
		return self;
	}

	/**
	 * @param self the self to set
	 */
	public void setSelf(OnlineUserBean self) {
		this.self = self;
	}



	/**
	 * @return the unReadMessage
	 */
	public int getUnReadMessage() {
		return unReadMessage;
	}



	/**
	 * @param unReadMessage the unReadMessage to set
	 */
	public void setUnReadMessage(int unReadMessage) {
		this.unReadMessage = unReadMessage;
	}

	/**
	 * @return
	 */
	public String index(){
		this.self = (OnlineUserBean) session.get(SessionCookieKey.USER_INFO_KEY);
		this.unReadMessage = 0;
		return SUCCESS;
	}

}
