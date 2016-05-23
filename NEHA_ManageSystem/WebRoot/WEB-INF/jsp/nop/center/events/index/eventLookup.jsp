<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<form id="pagerForm" action="<s:property value="absolutePath" />npo/center/events/index/eventLookup.do">
	<s:hidden name="pageNum" />
	<s:hidden name="pageSize" />
	<s:hidden name="event.eventTitle" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" method="post" action="<s:property value="absolutePath" />npo/center/events/index/eventLookup.do" onsubmit="return dwzSearch(this, 'dialog');">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label><s:text name="npo.center.events.index.event.title" />: </label>
				<s:textfield name="event.eventTitle" cssClass="textInput" maxlength="50" theme="simple"/>
			</li>
		</ul>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit"><s:text name="gobal.button.search"/></button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">

	<table class="table" layoutH="118" targetType="dialog" width="100%">
		<thead>
			<tr>
				<th width="5%"><s:text name="npo.center.events.index.event.id"/></th>
				<th width="45%"><s:text name="npo.center.events.index.event.title"/></th>
				<th width="10%"><s:text name="npo.center.events.index.event.start"/></th>
				<th width="10%"><s:text name="npo.center.events.index.event.exp"/></th>
				<th width="5%"><s:text name="npo.center.events.index.event.top"/></th>
				<th width="5%"><s:text name="npo.center.events.index.event.order"/></th>
				<th width="10%"><s:text name="npo.center.events.index.event.status"/></th>
				<th width="10%"><s:text name="gobal.page.lookup"/></th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="events" var="e" status="es">
				<tr>
					<td><s:property value="#e.eventId" /></td>
					<td><s:property value="#e.eventTitle" /></td>
					<td title="<s:date name="#e.eventStart" format="yyyy-MM-dd HH:mm" />"><s:date name="#e.eventStart" format="yyyy-MM-dd" /></td>
					<td title="<s:date name="#e.eventExp" format="yyyy-MM-dd HH:mm" />"><s:date name="#e.eventExp" format="yyyy-MM-dd" /></td>
					<td><s:if test="#e.eventTop" ><s:text name="npo.center.events.index.event.top.yes" /></s:if><s:else><s:text name="npo.center.events.index.event.top.no" /></s:else></td>
					<td><s:property value="#e.eventOrder" /></td>
					<td><s:property value="#e.status.aesName" /></td>
					<td>
						<a class="btnSelect" href="javascript:$.bringBack({id:'<s:property value="#es.index" />', parentName:'<s:property value="#e.eventTitle" />', eventParent:'<s:property value="#e.eventId" />'})" title="<s:text name="gobal.page.lookup"/>"><s:text name="gobal.page.choose"/></a>
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>

	<div class="panelBar">
		<div class="pages">
			<s:text name="gobal.page.select">
				<s:param><s:select list="pageSelect" cssClass="combox" name="numPerPage" onchange="dialogPageBreak({numPerPage:this.value})" theme="simple" value="pageSize"></s:select></s:param>
				<s:param><s:property value="page.count"/></s:param>
			</s:text>
		</div>
		<div class="pagination" targetType="dialog" totalCount="<s:property value="page.count"/>" numPerPage="<s:property value="pageSize"/>" pageNumShown="5" currentPage="<s:property value="pageNum"/>"></div>
	</div>
</div>