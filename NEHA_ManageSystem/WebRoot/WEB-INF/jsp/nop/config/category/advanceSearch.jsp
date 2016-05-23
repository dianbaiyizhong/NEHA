<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="pageContent">
	<form method="post" action="<s:property value="absolutePath" />npo/config/category/index.do" class="pageForm" onsubmit="return navTabValidateSearch(this);">
		<div class="pageFormContent" layoutH="58">
			<input type="hidden" name="navTabId" value="npo_config_category"/>
			<div class="unit">
				<label><s:text name="gobal.page.search.advance"></s:text></label>
			</div>
			<div class="divider">divider</div>
			<div class="unit">
				<label><s:text name="npo.config.category.id" />: </label>
				<input type="text" size="25" name="cateEvent.cgeId" class="number"/>
				<span class="inputInfo"></span>
			</div>
			<div class="unit">
				<label><s:text name="npo.config.category.name" />: </label>
				<input type="text" size="25" name="cateEvent.cgeName" maxlength="30"/>
			</div>
			<div class="unit">
				<label><s:text name="npo.config.category.order" />: </label>
				<input type="text" size="25" name="cateEvent.cgeOrder" class="number"/>
				<span class="inputInfo"></span>
			</div>
			<div class="unit">
				<label><s:text name="npo.config.category.status"/>: </label>
				<s:select list="#{'':'\u8bf7\u9009\u62e9','true':'\u6b63\u5e38','false':'\u505c\u7528'}" name="cateEvent.cgeStatus" theme="simple" cssClass="required combox"/>
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
