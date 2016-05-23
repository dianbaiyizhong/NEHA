/**
 *
 */
package hhm.neha.web.action.category;

import hhm.neha.entity.ConfigWarningLine;
import hhm.neha.service.ConfigWarningLineService;
import hhm.neha.web.action.BaseAction;

import java.util.List;

/**
 * 
 * @comment 读取舆情指数警戒线
 */
public class WarningLineConfigAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6638878428029815127L;
	private ConfigWarningLineService configWarningLineService;
	private List<ConfigWarningLine> lines;
	private Integer total;
	private Long time;

	/**
	 * @return the configWarningLineService
	 */
	public ConfigWarningLineService getConfigWarningLineService() {
		return configWarningLineService;
	}

	/**
	 * @param configWarningLineService
	 *            the configWarningLineService to set
	 */
	public void setConfigWarningLineService(
			ConfigWarningLineService configWarningLineService) {
		this.configWarningLineService = configWarningLineService;
	}

	/**
	 * @return the lines
	 */
	public List<ConfigWarningLine> getLines() {
		return lines;
	}

	/**
	 * @param lines
	 *            the lines to set
	 */
	public void setLines(List<ConfigWarningLine> lines) {
		this.lines = lines;
	}

	/**
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * @return the time
	 */
	public Long getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(Long time) {
		this.time = time;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		lines = configWarningLineService.loadNormalConfigWarningLine();
		total = lines.size();
		time = System.currentTimeMillis();
		return SUCCESS;
	}

}
