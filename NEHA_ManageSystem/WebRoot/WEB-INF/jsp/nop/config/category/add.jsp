<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="pageContent">
	<form method="post" action="<s:property value="absolutePath" />npo/config/category/save.do" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<input type="hidden" name="navTabId" value="npo_config_category"/>
		<div class="pageFormContent" layoutH="58">
			<div class="unit">
				<label><s:text name="npo.config.category.id"/>: </label>
				<input name="cateEvent.cgeId" class="required number" max="3999" min="3001" size="30" type="text" />
				<span class="info"></span>
			</div>
			<div class="unit">
				<label><s:text name="npo.config.category.name"/>: </label>
				<input name="cateEvent.cgeName" class="required" maxlength="50" size="30" type="text" />
				<span class="info"></span>
			</div>
			<div class="unit">
				<label><s:text name="npo.config.category.order"/>: </label>
				<input name="cateEvent.cgeOrder" class="required number" max="9999" min="1" size="30" type="text" />
				<span class="info"></span>
			</div>
			<div class="unit">
				<label><s:text name="npo.config.category.status"/>: </label>
				<s:select list="#{'':'\u8bf7\u9009\u62e9','true':'\u6b63\u5e38','false':'\u505c\u7528'}" name="cateEvent.cgeStatus" theme="simple" cssClass="required combox"/>
				<span class="info"></span>
			</div>
			<div class="unit">
				<label><s:text name="npo.config.category.comment"/>: </label>
				<input name="cateEvent.cgeComment" class="" maxlength="500" size="30" type="text" />
				<span class="info"></span>
			</div>
			<div class="divider"></div>
			<div class="unit">
				<span class="info"><s:text name="npo.config.category.add.info"/></span>
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
