<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
[
	{"parentName":"无", "eventParent":"0"},
	<s:iterator value="events" var="e" status="es">
	{"parentName":"<s:property value="#e.eventTitle"/>", "eventParent":"<s:property value="#e.eventId"/>"}<s:if test="#es.last"></s:if><s:else>,</s:else>
	</s:iterator>
]
