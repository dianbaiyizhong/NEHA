/**
 *
 */
package hhm.neha.web.action.system;

import hhm.neha.entity.SystemVersion;
import hhm.neha.service.SystemVersionService;
import hhm.neha.web.action.BaseAction;

public class VersionAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 836617839068899704L;
	private SystemVersionService systemVersionService;
	private String version;
	private String description;

	/**
	 * @return the systemVersionService
	 */
	public SystemVersionService getSystemVersionService() {
		return systemVersionService;
	}

	/**
	 * @param systemVersionService
	 *            the systemVersionService to set
	 */
	public void setSystemVersionService(
			SystemVersionService systemVersionService) {
		this.systemVersionService = systemVersionService;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		SystemVersion v = this.systemVersionService.now();
		this.version = v.getVerName();
		this.description = v.getVerComment();
		return SUCCESS;
	}

}
