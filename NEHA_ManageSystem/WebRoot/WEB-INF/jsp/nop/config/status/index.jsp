<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<form id="pagerForm" method="post" action="<s:property value="absolutePath" />npo/config/status/index.do">
	<s:hidden name="status.aesId" />
	<s:hidden name="status.aesName" />
	<s:hidden name="pageNum" />
	<s:hidden name="pageSize" />
</form>

<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="<s:property value="absolutePath" />npo/config/status/index.do" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					<s:text name="npo.config.status.name"/>: <s:textfield name="status.aesName" maxlength="50" theme="simple"/>
				</td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit"><s:text name="gobal.button.search"/></button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="5%" align="center"><s:text name="npo.config.status.id"/></th>
				<th width="35%"><s:text name="npo.config.status.name"/></th>
				<th width="60%"><s:text name="npo.config.status.comment"/></th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="statusList" var="st">
			<tr target="npo_config_status_index" rel="<s:property value="#st.aesId" />">
				<td><s:property value="#st.aesId" escape="true" escapeJavaScript="true"/></td>
				<td><s:property value="#st.aesName" escape="true" escapeJavaScript="true"/></td>
				<td><s:property value="#st.aesComment" escape="true" escapeJavaScript="true"/></td>
			</tr>
			</s:iterator>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<s:text name="gobal.page.select">
				<s:param><s:select list="pageSelect" cssClass="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})" theme="simple" value="pageSize"></s:select></s:param>
				<s:param><s:property value="page.count"/></s:param>
			</s:text>
		</div>
		
		<div class="pagination" targetType="navTab" totalCount="<s:property value="page.count"/>" numPerPage="<s:property value="pageSize"/>" pageNumShown="10" currentPage="<s:property value="pageNum"/>"></div>

	</div>
</div>
