<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
[
	<s:iterator value="statusList" var="s" status="ss">
	{"statusName":"<s:property value="#s.aesName"/>", "eventStatus":"<s:property value="#s.aesId"/>"}<s:if test="#ss.last"></s:if><s:else>,</s:else>
	</s:iterator>
]
