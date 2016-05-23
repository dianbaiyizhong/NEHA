/**
 * 
 */
package hhm.neha.web.tag;
import hhm.neha.web.tag.components.CategoryCheckBox;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ContextBeanTag;

import com.opensymphony.xwork2.util.ValueStack;


public class CategoryCheckBoxTag extends ContextBeanTag {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4176591024554294432L;
	private String value;
	private String list;
	private String name;
	private boolean escape = true;

	/* (non-Javadoc)
	 * @see org.apache.struts2.views.jsp.ComponentTagSupport#getBean(com.opensymphony.xwork2.util.ValueStack, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public Component getBean(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
		return new CategoryCheckBox(stack);
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.views.jsp.ContextBeanTag#populateParams()
	 */
	@Override
	protected void populateParams() {
		super.populateParams();
		CategoryCheckBox s = (CategoryCheckBox)component;
		s.setEscape(escape);
		s.setValue(value);
		s.setList(list);
		s.setName(name);
	}

	/**
	 * @param list the list to set
	 */
	public void setList(String list) {
		this.list = list;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param values the values to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
