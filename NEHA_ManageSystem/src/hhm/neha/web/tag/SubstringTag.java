/**
 * 
 */
package hhm.neha.web.tag;

import hhm.neha.web.tag.components.Substring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ContextBeanTag;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * 字符串子串
 */
public class SubstringTag extends ContextBeanTag {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4176591024554294432L;
	private String name;
	private Integer maxLength = Integer.MAX_VALUE;
	private String replace;
	private boolean escape = true;

	/* (non-Javadoc)
	 * @see org.apache.struts2.views.jsp.ComponentTagSupport#getBean(com.opensymphony.xwork2.util.ValueStack, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public Component getBean(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
		return new Substring(stack);
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.views.jsp.ContextBeanTag#populateParams()
	 */
	@Override
	protected void populateParams() {
		super.populateParams();
		Substring s = (Substring)component;
		s.setEscape(escape);
		s.setMaxLength(maxLength);
		s.setName(name);
		s.setReplace(replace);
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param maxLength the maxLength to set
	 */
	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}

	/**
	 * @param replace the replace to set
	 */
	public void setReplace(String replace) {
		this.replace = replace;
	}

	/**
	 * @param escape the escape to set
	 */
	public void setEscape(boolean escape) {
		this.escape = escape;
	}
	
	

}
