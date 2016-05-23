<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="pageContent">
	
	<form method="post" action="<s:property value="absolutePath" />login/pass.do" class="pageForm" onsubmit="return validateCallback(this, dialogAjaxDone)">
		<s:hidden name="ajaxLoginName"></s:hidden>
		<div class="pageFormContent" layoutH="58">
			<div class="unit">
				<label><s:text name="login.username" />: </label>
				<input type="text" name="username" size="30" class="required"/>
			</div>
			<div class="unit">
				<label><s:text name="login.password" />: </label>
				<input type="password" name="password" size="31" class="required"/>
			</div>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit"><s:text name="gobal.button.submit" /></button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close"><s:text name="gobal.button.cancal" /></button></div></div></li>
			</ul>
		</div>
		<input type="hidden" name="ajax" value="1" />
	</form>
	
</div>

