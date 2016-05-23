<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<title><s:text name="login.title" /> - <s:text name="gobal.system.title" /> <s:text name="gobal.system.version" />
</title>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<SCRIPT>
if(window.top !== window.self){ window.top.location = window.location;}
</SCRIPT>
<LINK href="favicon.ico" rel="shortcut icon" type="image/x-icon" />
<link href='<s:property value="absolutePath" />css/login.css' rel="stylesheet" type="text/css" />
</HEAD>
<BODY class='chl-reg'>
	<DIV id='page'>
		<DIV class='clearfix id=header'>
			<!--header-->
			<H1 id='logo'>
<!-- 				<SPAN class='sub-logo'><A href="#" target=_top><IMG alt="cischina" src='<s:property value="absolutePath" />images/reg.png'> </A> </SPAN> -->
			</H1>
			<!-- #header END -->
		</DIV>
		<DIV id='content' style="PADDING-TOP: 19px">
			<DIV class='login'>
				<DIV class="login-box module-static" id='J_LoginBox'>
					<DIV class='hd'></DIV>
					<DIV class='bd'>
						<DIV class='taobao-box'>
							<!--login box begin-->
							<!--登录的错误信息-->
							<DIV class="login-msg msg" id='J_Message' <s:if test="errCode == 0"> style="DISPLAY: none"</s:if> >
								<P class='error'>
									<s:if test="errCode == 110"><s:text name="login.err.fail" />: <s:text name="login.err.110"/>(<s:property value="errCode"/>)</s:if>
									<s:elseif test="errCode == 100"><s:text name="login.err.fail" />: <s:text name="login.err.100"/>(<s:property value="errCode"/>)</s:elseif>
									<s:elseif test="errCode == 101"><s:text name="login.err.fail" />: <s:text name="login.err.101"/>(<s:property value="errCode"/>)</s:elseif>
									<s:elseif test="errCode == 102"><s:text name="login.err.fail" />: <s:text name="login.err.102"/>(<s:property value="errCode"/>)</s:elseif>
									<s:elseif test="errCode == 103"><s:text name="login.err.fail" />: <s:text name="login.err.103"/>(<s:property value="errCode"/>)</s:elseif>
									<s:elseif test="errCode == 104"><s:text name="login.err.fail" />: <s:text name="login.err.104"/>(<s:property value="errCode"/>)</s:elseif>
								</P>
							</DIV>
							<!--登录的错误信息结束-->
							<!--标准登录框-->
							<DIV class='static' id='J_Static'>
								<FORM id='J_StaticForm' action='pass.do' method='post'>
									<DIV class="field ph-hide">
										<LABEL for='TPL_username_1'><s:text name="login.company.abbr"/></LABEL> <SPAN class='ph-label'><s:text name="login.company.abbr"/></SPAN> <INPUT name="companyname" disabled class="login-text J_UserName" type='text' value='<s:text name="gobal.system.company"/>'>
									</DIV>
									<DIV class="field ph-hide">
										<LABEL for='TPL_username_1'><s:text name="login.username" /></LABEL> <SPAN class='ph-label'><s:text name="login.username.info" /></SPAN> <INPUT name='username' tabIndex='2' class="login-text J_UserName" id='TPL_username_1' type='text' maxLength='32' value=''>
									</DIV>
									<DIV class=field>
										<LABEL id='password-label'><s:text name="login.password" /></LABEL> <SPAN id='J_StandardPwd'><INPUT name='password' tabIndex='3' class='login-text' aria-labelledby='password-label' type='password' maxLength='20' value=''> </SPAN><SPAN class='password-edit' id='J_PasswordEdit' style="DISPLAY: none"></SPAN><STRONG class='warning-tip' id='J_CapsLockTip' style="DISPLAY: none"><s:text name="login.password.info" /></STRONG>
									</DIV>
									<DIV class="field submit">
										<BUTTON tabIndex='5' class='J_Submit' type='submit'><s:text name="login.submit" /></BUTTON>
										<A tabIndex=6 class=forget-pw id=forget-pw-safe href="#" target=_blank><s:text name="login.lost.password" /></A>
									</DIV>
<!-- 									<UL class=entries> -->
<!-- 										<LI class=dynamic-pwd id=J_DynamicLink_1><A href="#" target=_top><IMG alt="" src='<s:property value="absolutePath" />images/register_1.png'> </A></LI> -->
<!-- 									</UL> -->
									<SPAN class=password-edit-tmp id=J_PasswordEditTmp></SPAN>
								</FORM>
							</DIV>
						</DIV>
					</DIV>
					<DIV class=ft></DIV>
				</DIV>
				<!-- .login-box END -->
				<DIV class=login-bg style="HEIGHT: 500px">
					<DIV style=" padding-left: 150px;">
						<img src='<s:property value="absolutePath" />images/main.png' />
					</DIV>
				</DIV>
			</DIV>
		</DIV>
		<DIV id=footer>
			<DIV id=copyright><s:text name="gobal.system.copyright" /></DIV>
		</DIV>
	</DIV>
</BODY>
</HTML>