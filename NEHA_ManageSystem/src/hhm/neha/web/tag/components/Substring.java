/**
 * 
 */
package hhm.neha.web.tag.components;

import java.io.IOException;
import java.io.Writer;

import org.apache.commons.lang.xwork.StringEscapeUtils;
import org.apache.struts2.components.ContextBean;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;

import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 *
 */
@StrutsTag(name="substring", tldBodyContent="empty", tldTagClass="com.qawaa.tag.SubstringTag", description="get a sub String.")
public class Substring extends ContextBean {
	private static final Logger LOG = LoggerFactory.getLogger(Substring.class);
	
	private String name;
	private Integer maxLength = Integer.MAX_VALUE;
	private String replace;
	private boolean escape = true;

	public Substring(ValueStack stack) {
		super(stack);
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
	@StrutsTagAttribute(description="name to be displayed", type="Object", defaultValue="&lt;top of stack&gt;", required=true)
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the maxLength
	 */
	public Integer getMaxLength() {
		return maxLength;
	}

	/**
	 * @param maxLength the maxLength to set
	 */
	@StrutsTagAttribute(description="string max length to display", type="Integer", defaultValue="Integer.MAX_VALUE")
	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}

	/**
	 * @return the replace
	 */
	public String getReplace() {
		return replace;
	}

	/**
	 * @param replace the replace to set
	 */
	@StrutsTagAttribute(description="replace excess string", type="Object", defaultValue="")
	public void setReplace(String replace) {
		this.replace = replace;
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

        String actualValue = null;

        if (name == null) {
            name = "top";
        }
        else {
        	name = stripExpressionIfAltSyntax(name);
        }

        // exception: don't call findString(), since we don't want the
        //            expression parsed in this one case. it really
        //            doesn't make sense, in fact.
        actualValue = (String) getStack().findValue(name, String.class, throwExceptionOnELFailure);

        try {
        	if (actualValue != null) {
                writer.write(prepare(actualValue));
            } else {
                writer.write(prepare(""));
            }
        } catch (IOException e) {
            LOG.info("Could not print out value '" + name + "'", e);
        }

        return result;
    }
	
    /**
     * @param value
     * @return
     */
    private String prepare(String value) {
    	String result = value;
    	if(maxLength < result.length()){
    		result = result.substring(0, maxLength);
    		if(replace != null && !replace.trim().equals("")){
    			result = result + replace;
    		}
    	}
        if (escape) {
        	result = StringEscapeUtils.escapeHtml(result);
        }
        return result;
    }
}
