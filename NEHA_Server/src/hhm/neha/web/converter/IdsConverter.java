/**
 *
 */
package hhm.neha.web.converter;

import hhm.neha.util.NumberUtil;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.util.StrutsTypeConverter;

/**
 * 
 * @comment 多个id转换器，例如String:“id1,id2,...idn”转换为Integer[n]{id1,id2...idn}
 */
public class IdsConverter extends StrutsTypeConverter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts2.util.StrutsTypeConverter#convertFromString(java.util
	 * .Map, java.lang.String[], java.lang.Class)
	 */
	@Override
	public Object convertFromString(@SuppressWarnings("rawtypes") Map context,
			String[] values, @SuppressWarnings("rawtypes") Class toClass) {
		if (values == null || values.length == 0)
			return null;
		Set<Integer> idSet = new HashSet<Integer>(0);
		for (String value : values) {
			if (value == null || value.trim().isEmpty())
				continue;
			String[] s_ids = value.split(",");
			if (s_ids.length == 0)
				continue;
			for (String s_id : s_ids) {
				if (s_id == null || s_id.trim().isEmpty())
					continue;
				if (NumberUtil.isInteger(s_id))
					idSet.add(NumberUtil.string2Integer(s_id));
			}
		}
		if (idSet.size() == 0)
			return null;
		Integer[] ids = new Integer[idSet.size()];
		return idSet.toArray(ids);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts2.util.StrutsTypeConverter#convertToString(java.util
	 * .Map, java.lang.Object)
	 */
	@Override
	public String convertToString(@SuppressWarnings("rawtypes") Map context,
			Object obj) {
		if (obj == null)
			return "";
		Integer[] ids = (Integer[]) obj;
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < ids.length; i++) {
			buffer.append(ids[i]);
			if (i < (ids.length - 1)) {
				buffer.append(",");
			}
		}
		return buffer.toString();
	}

}
