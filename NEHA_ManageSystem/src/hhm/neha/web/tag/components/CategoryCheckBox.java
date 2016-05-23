/**
 * 
 */
package hhm.neha.web.tag.components;

import hhm.neha.data.entity.CategoryEvent;

import java.io.Writer;
import java.util.List;

import org.apache.struts2.components.ContextBean;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;

import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

@StrutsTag(name="categorycheckbox", tldBodyContent="empty", tldTagClass="org.cischina.web.tag.CategoryCheckBoxTag", description="category checkbox.")
public class CategoryCheckBox extends ContextBean {
	private static final Logger LOG = LoggerFactory.getLogger(CategoryCheckBox.class);
	
	private String value;
	private boolean escape = true;
	private String list;
	private String name;

	public CategoryCheckBox(ValueStack stack) {
		super(stack);
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	@StrutsTagAttribute(description="checkbox value", type="Object", required=true)
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the list
	 */
	public String getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	@StrutsTagAttribute(description="category list", type="Object", required=true)
	public void setList(String list) {
		this.list = list;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	@StrutsTagAttribute(description="checkbox name", type="String", required=true)
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the escape
	 */
	public boolean isEscape() {
		return escape;
	}

	/**
	 * @param escape the escape to set
	 */
	@StrutsTagAttribute(description=" Whether to escape HTML", type="Boolean", defaultValue="true")
	public void setEscape(boolean escape) {
		this.escape = escape;
	}
	
	/* (non-Javadoc)
	 * @see org.apache.struts2.components.Component#start(java.io.Writer)
	 */
	public boolean start(Writer writer) {
		boolean result = super.start(writer);
		List<?> listValue;
		Object actualValue = null;
		if (value == null || this.list == null) {
			LOG.warn("Value of tag :group tree was null");
			return result;
		} else {
			try {
				actualValue = findValue(list);
				if (actualValue instanceof List<?>) {
					listValue = (List<?>)actualValue;
					writer.write(creatCheckBox(listValue, (String) getStack().findValue(stripExpressionIfAltSyntax(value), String.class, throwExceptionOnELFailure), findString(name)));
				}else{
					return result;
				}
			} catch (Exception e) {
				
			}
		}

		return result;
    }
	
	private String creatCheckBox(List<?> list, String ids, String name){
		StringBuffer buffer = new StringBuffer();
		CategoryEvent ce;
		for(Object obj:list){
			if(obj instanceof CategoryEvent){
				ce = (CategoryEvent) obj;
				buffer.append("<label><input type=\"checkbox\" name=\"");
				buffer.append(name);
				buffer.append("\" value=\"");
				buffer.append(ce.getCgeId());
				buffer.append("\" ");
				String id = "#"+ce.getCgeId()+"#";
//				System.out.println(ids);
				if(ids.indexOf(id) != -1){
					buffer.append("checked=\"true\" ");
				}
				buffer.append("/>");
				buffer.append(ce.getCgeName());
				buffer.append("</label>");
			}
		}
		return buffer.toString();
	}
	
}
