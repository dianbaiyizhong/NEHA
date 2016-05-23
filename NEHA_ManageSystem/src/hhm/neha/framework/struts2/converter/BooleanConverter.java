/**
 *
 */
package hhm.neha.framework.struts2.converter;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.util.StrutsTypeConverter;
/**

 * @comment boolean转换器
 */
public class BooleanConverter extends StrutsTypeConverter {

	/* (non-Javadoc)
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertFromString(java.util.Map, java.lang.String[], java.lang.Class)
	 */
	@Override
	public Object convertFromString( @SuppressWarnings("rawtypes") Map context, String[] values, @SuppressWarnings("rawtypes") Class toClass) {
		if(values == null || values.length == 0)
			return null;
		String value = values[0];
		if(StringUtils.isBlank(value))
			return null;
		value = value.trim();
		if(value.equalsIgnoreCase("true"))
			return new Boolean(true);
		if(value.equalsIgnoreCase("false"))
			return new Boolean(false);
		return null;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.util.StrutsTypeConverter#convertToString(java.util.Map, java.lang.Object)
	 */
	@Override
	public String convertToString(@SuppressWarnings("rawtypes") Map context, Object obj) {
		if(obj == null)
			return "";
		Boolean b = (Boolean) obj;
		return b.toString();
	}

}
