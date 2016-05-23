<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<form id="pagerForm" method="post" action="<s:property value="absolutePath" />npo/center/events/index/viewChildList.do">
	<s:hidden name="event.eventTitle" />
	<s:hidden name="event.eventId" />
	<s:hidden name="event.eventStatus" />
	<s:hidden name="event.statusName" />
	<s:hidden name="event.eventTop" />
	<s:hidden name="event.eventStart" />
	<s:hidden name="event.eventExp" />
	<s:hidden name="event.eventOrder" />
	<s:hidden name="event.eventParent" />
	<s:hidden name="pageNum" />
	<s:hidden name="pageSize" />
</form>
<div class="pageContent">
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="5%"><s:text name="npo.center.events.index.event.id"/></th>
				<th width="45%"><s:text name="npo.center.events.index.event.title"/></th>
				<th width="10%"><s:text name="npo.center.events.index.event.start"/></th>
				<th width="10%"><s:text name="npo.center.events.index.event.exp"/></th>
				<th width="5%"><s:text name="npo.center.events.index.event.top"/></th>
				<th width="5%"><s:text name="npo.center.events.index.event.order"/></th>
				<th width="10%"><s:text name="npo.center.events.index.event.status"/></th>
				<th width="5%"><s:text name="npo.center.events.index.event.children"/></th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="events" var="e">
			<tr target="events_index_list" rel="<s:property value="#e.eventId" />">
				<td><s:property value="#e.eventId" /></td>
				<td><s:property value="#e.eventTitle" /></td>
				<td title="<s:date name="#e.eventStart" format="yyyy-MM-dd HH:mm" />"><s:date name="#e.eventStart" format="yyyy-MM-dd" /></td>
				<td title="<s:date name="#e.eventExp" format="yyyy-MM-dd HH:mm" />"><s:date name="#e.eventExp" format="yyyy-MM-dd" /></td>
				<td><s:if test="#e.eventTop" ><s:text name="npo.center.events.index.event.top.yes" /></s:if><s:else><s:text name="npo.center.events.index.event.top.no" /></s:else></td>
				<td><s:property value="#e.eventOrder" /></td>
				<td><s:property value="#e.status.aesName" /></td>
				<td><s:if test="#e.eventParent == 0" ><s:text name="npo.center.events.index.event.parent" /></s:if><s:else><s:text name="npo.center.events.index.event.children" /></s:else></td>
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
