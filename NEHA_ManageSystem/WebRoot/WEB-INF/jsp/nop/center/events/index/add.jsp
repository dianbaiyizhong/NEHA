<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="pageContent">
	<form method="post" action="<s:property value="absolutePath" />npo/center/events/index/save.do" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<input type="hidden" name="navTabId" value="npo_center_events_index_list"/>
		<div class="pageFormContent" layoutH="58">
			<div class="unit">
				<label><s:text name="npo.center.events.index.event.title"/>: </label>
				<input name="event.eventTitle" class="required" maxlength="100" size="45" type="text" />
				<span class="info"></span>
			</div>
			<div class="unit">
				<label><s:text name="npo.center.events.index.event.shorttitle"/>: </label>
				<input name="event.eventShortTitle" class="text" maxlength="50" size="45" type="text" />
				<span class="info"></span>
			</div>
			<div class="unit">
				<label><s:text name="npo.center.events.index.event.keyword"/>: </label>
				<input name="event.eventKeyword" class="required" maxlength="200" size="45" type="text" />
				<span class="info"><s:text name="npo.center.events.index.event.keyword.info"/></span>
			</div>
			<div class="unit">
				<label><s:text name="npo.center.events.index.event.start"/>: </label>
				<input type="text" size="45" name="event.eventStart" maxlength="20" class="required date" minDate="2013-01-01" maxDate="2020-12-31" readonly="readonly"/>
				<span class="info"></span>
			</div>
			<div class="unit">
				<label><s:text name="npo.center.events.index.event.exp"/>: </label>
				<input type="text" size="45" name="event.eventExp" maxlength="20" class="required date" minDate="2013-01-01" maxDate="2020-12-31" readonly="readonly"/>
				<span class="info"></span>
			</div>
			<div class="unit">
				<label><s:text name="npo.center.events.index.event.top"/>: </label>
				<s:select list="#{'':'\u8bf7\u9009\u62e9','true':'\u662f','false':'\u5426'}" name="event.eventTop" theme="simple" cssClass="required combox"/>
			</div>
			<div class="unit">
				<label><s:text name="npo.center.events.index.event.order"/>: </label>
				<input name="event.eventOrder" class="required number" maxlength="3" size="45" type="text" />
				<span class="info"><s:text name="npo.center.events.index.event.order.info"/></span>
			</div>
			<div class="unit">
				<label><s:text name="npo.center.events.index.event.parent"/>: </label>
				<input name="event.parentName" class="text" readonly="readonly" type="text" postField="event" suggestFields="eventParent,parentName" suggestUrl="<s:property value="absolutePath" />npo/center/events/index/eventSuggest.do" lookupGroup="event"/>
				<input type="hidden" name="event.eventParent"/>
				<a class="define_lookup" title="<s:text name="npo.center.events.index.event.parent.choose" />" href="<s:property value="absolutePath" />npo/center/events/index/eventLookup.do" lookupGroup="event">&nbsp; &nbsp; &nbsp; &nbsp;</a>
				<span class="info"><s:text name="npo.center.events.index.event.parent.info"/></span>
			</div>
			<div class="unit">
				<label><s:text name="npo.center.events.index.event.abstract"/>: </label>
				<textarea style="margin: 0px; height: 90px; width: 251px;" name="event.eventAbstract"></textarea>
			</div>
			<div class="divider"></div>
			<div class="unit">
				<label><s:text name="npo.center.events.index.event.category"/>: </label>
			</div>
			<div class="unit">
				<s:iterator value="categories" var="c">
					<label><input type="checkbox" name="event.eventCategory" value="<s:property value="#c.cgeId" />" /><s:property value="#c.cgeName" /></label>
				</s:iterator>
			</div>
		</div>
		<div class="formBar">
			<ul>
				<li>
					<div class="buttonActive"><div class="buttonContent"><button type="submit"><s:text name="gobal.button.save"/></button></div></div>
				</li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close"><s:text name="gobal.button.cancal"/></button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>
