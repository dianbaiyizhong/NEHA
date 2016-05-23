<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="pageContent">
	<form method="post" action="<s:property value="absolutePath" />npo/center/events/index/list.do" class="pageForm" onsubmit="return navTabValidateSearch(this);">
		<div class="pageFormContent" layoutH="58">
			<input type="hidden" name="navTabId" value="npo_center_events_index_list"/>
			<div class="unit">
				<label><s:text name="gobal.page.search.advance"></s:text></label>
			</div>
			<div class="divider">divider</div>
			<div class="unit">
				<label><s:text name="npo.center.events.index.event.id" />: </label>
				<input type="text" size="25" name="event.eventId" class="number"/>
				<span class="inputInfo"></span>
			</div>
			<div class="unit">
				<label><s:text name="npo.center.events.index.event.title" />: </label>
				<input type="text" size="25" name="event.eventTitle" maxlength="30"/>
			</div>
			<div class="unit">
				<label><s:text name="npo.center.events.index.event.status" />: </label>
				<input name="event.statusName" readonly="readonly" type="text" value="<s:property value="event.statusName"/>" postField="keyword" suggestFields="eventStatus,statusName" suggestUrl="<s:property value="absolutePath" />npo/config/status/statusSuggest.do" lookupGroup="event"/>
				<input type="hidden" name="event.eventStatus"/>
				<span class="inputInfo"></span>
			</div>
			<div class="unit">
				<label><s:text name="npo.center.events.index.event.top"/>: </label>
				<s:select list="#{'':'\u8bf7\u9009\u62e9','true':'\u662f','false':'\u5426'}" name="event.eventTop" theme="simple" cssClass="required combox"/>
			</div>
			<div class="unit">
				<label><s:text name="npo.center.events.index.event.parent.type"/>: </label>
				<s:select list="#{'':'\u8bf7\u9009\u62e9','0':'\u7236\u4e8b\u4ef6','-1':'\u5b50\u4e8b\u4ef6'}" name="event.eventParent" theme="simple" cssClass="required combox"/>
			</div>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit"><s:text name="gobal.page.search.advance.submit" /></button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="reset"><s:text name="gobal.page.search.advance.cancel" /></button></div></div></li>
			</ul>
		</div>
	</form>
</div>
