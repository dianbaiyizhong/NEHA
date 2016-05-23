<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<form id="pagerForm" method="post" action="<s:property value="absolutePath" />npo/config/category/index.do">
	<s:hidden name="cateEvent.cgeId" />
	<s:hidden name="cateEvent.cgeName" />
	<s:hidden name="cateEvent.cgeStatus" />
	<s:hidden name="cateEvent.cgeOrder" />
	<s:hidden name="pageNum" />
	<s:hidden name="pageSize" />
</form>

<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="<s:property value="absolutePath" />npo/config/category/index.do" method="post">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					<s:text name="npo.config.category.name"/>: <s:textfield name="cateEvent.cgeName" maxlength="50" theme="simple"/>
				</td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit"><s:text name="gobal.button.search"/></button></div></div></li>
				<li><a class="button" href="<s:property value="absolutePath" />npo/config/category/advanceSearch.do" target="dialog" mask="true" rel="npo_config_category_advanceSearch" title="<s:text name="gobal.button.search.advance"/>"><span><s:text name="gobal.button.search.advance"/></span></a></li>
			</ul>
		</div>
	</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="<s:property value="absolutePath" />npo/config/category/add.do" target="dialog" mask="true" title="<s:text name="npo.config.category.add"/>" rel="npo_config_category_add"><span><s:text name="gobal.panelbar.add"/></span></a></li>
			<li class="line">line</li>
			<li><a class="edit" href="<s:property value="absolutePath" />npo/config/category/edit.do?cid={npo_config_category_index}" target="dialog" mask="true" target="navTab" rel="npo_config_category_edit" title="<s:text name="npo.config.category.edit"/>"><span><s:text name="gobal.panelbar.edit"/></span></a></li>
			<li class="line">line</li>
			<li><a class="delete" href="<s:property value="absolutePath" />npo/config/category/del.do?cid={npo_config_category_index}" target="ajaxTodo" title="<s:text name="gobal.alert.delete.sure"/>"><span><s:text name="gobal.panelbar.del"/></span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="5%" align="center"><s:text name="npo.config.category.id"/></th>
				<th width="25%"><s:text name="npo.config.category.name"/></th>
				<th width="5%" align="center"><s:text name="npo.config.category.status"/></th>
				<th width="5%" align="center"><s:text name="npo.config.category.order"/></th>
				<th width="60%"><s:text name="npo.config.category.comment"/></th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="cateEvents" var="ces">
			<tr target="npo_config_category_index" rel="<s:property value="#ces.cgeId" />">
				<td><s:property value="#ces.cgeId" escape="true" escapeJavaScript="true"/></td>
				<td><s:property value="#ces.cgeName" escape="true" escapeJavaScript="true"/></td>
				<td align="center"><s:if test="#ces.cgeStatus"><s:text name="gobal.page.true" /></s:if><s:else><s:text name="gobal.page.false" /></s:else></td>
				<td align="center"><s:property value="#ces.cgeOrder" escape="true" escapeJavaScript="true"/></td>
				<td><s:property value="#ces.cgeComment" escape="true" escapeJavaScript="true"/></td>
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
