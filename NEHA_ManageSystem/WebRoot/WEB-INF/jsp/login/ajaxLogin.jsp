<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="errCode==0">
{
	"statusCode":"200",
	"message":"\u91cd\u65b0\u767b\u5f55\u6210\u529f\uff01",
	"navTabId":"",
	"callbackType":"closeCurrent",
	"forwardUrl":""
}
</s:if>
<s:elseif test="errCode==100">
{
	"statusCode":"300",
	"message":"\u7528\u6237\u8f93\u5165\u4e0d\u5b8c\u6574",
	"navTabId":"",
	"callbackType":"",
	"forwardUrl":"<s:property value="absolutePath" />login/ajaxindex.do"
}
</s:elseif>
<s:elseif test="errCode==101">
{
	"statusCode":"300",
	"message":"\u5e10\u53f7\u7981\u7528",
	"navTabId":"",
	"callbackType":"",
	"forwardUrl":""
}
</s:elseif>
<s:elseif test="errCode==102">
{
	"statusCode":"300",
	"message":"ip\u4e0d\u5728\u5141\u8bb8\u8303\u56f4\u5185",
	"navTabId":"",
	"callbackType":"",
	"forwardUrl":""
}
</s:elseif>
<s:elseif test="errCode==103">
{
	"statusCode":"300",
	"message":"\u5e10\u53f7\u5df2\u5230\u671f",
	"navTabId":"",
	"callbackType":"",
	"forwardUrl":""
}
</s:elseif>
<s:elseif test="errCode==104">
{
	"statusCode":"300",
	"message":"\u9a8c\u8bc1\u7801\u9519\u8bef",
	"navTabId":"",
	"callbackType":"",
	"forwardUrl":""
}
</s:elseif>
<s:elseif test="errCode==105">
{
	"statusCode":"300",
	"message":"\u5f53\u524d\u72b6\u6001\u4e0b\u4e0d\u80fd\u4f7f\u7528\u5176\u5b83\u5e10\u53f7\u767b\u5f55",
	"navTabId":"",
	"callbackType":"",
	"forwardUrl":""
}
</s:elseif>
<s:elseif test="errCode==110">
{
	"statusCode":"300",
	"message":"\u7528\u6237\u540d\u4e0d\u5b58\u5728\u6216\u5bc6\u7801\u9519\u8bef",
	"navTabId":"",
	"callbackType":"forward",
	"forwardUrl":"<s:property value="absolutePath" />login/ajaxindex.do"
}
</s:elseif>
<s:else>
{
	"statusCode":"300",
	"message":"\u767b\u5f55\u5931\u8d25\uff0c\u8bf7\u786e\u8ba4\u7528\u6237\u540d\u53ca\u5bc6\u7801\u586b\u5199\u6b63\u786e\uff01",
	"navTabId":"",
	"callbackType":"forward",
	"forwardUrl":"<s:property value="absolutePath" />login/ajaxindex.do"
}
</s:else>