<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<title><s:text name="gobal.system.title" /> <s:text name="gobal.system.version" /></title>

<link href="themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="<s:property value="absolutePath" />css/c.css" rel="stylesheet" type="text/css"/>
<!--[if IE]>
<link href="themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->

<script src="js/speedup.js" type="text/javascript"></script>
<script src="js/jquery-1.7.1.js" type="text/javascript"></script>
<script src="js/jquery.cookie.js" type="text/javascript"></script>
<script src="js/jquery.validate.js" type="text/javascript"></script>
<script src="js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="xheditor/xheditor-1.1.13-zh-cn.min.js" type="text/javascript"></script>
<script src="uploadify/scripts/swfobject.js" type="text/javascript"></script>
<script src="uploadify/scripts/jquery.uploadify.v2.1.0.js" type="text/javascript"></script>

<!-- svg图表  supports Firefox 3.0+, Safari 3.0+, Chrome 5.0+, Opera 9.5+ and Internet Explorer 6.0+ -->
<script type="text/javascript" src="chart/raphael.js"></script>
<script type="text/javascript" src="chart/g.raphael.js"></script>
<script type="text/javascript" src="chart/g.bar.js"></script>
<script type="text/javascript" src="chart/g.line.js"></script>
<script type="text/javascript" src="chart/g.pie.js"></script>
<script type="text/javascript" src="chart/g.dot.js"></script>

<script src="js/dwz.core.js" type="text/javascript"></script>
<script src="js/dwz.util.date.js" type="text/javascript"></script>
<script src="js/dwz.validate.method.js" type="text/javascript"></script>
<script src="js/dwz.regional.zh.js" type="text/javascript"></script>
<script src="js/dwz.barDrag.js" type="text/javascript"></script>
<script src="js/dwz.drag.js" type="text/javascript"></script>
<script src="js/dwz.tree.js" type="text/javascript"></script>
<script src="js/dwz.accordion.js" type="text/javascript"></script>
<script src="js/dwz.ui.js" type="text/javascript"></script>
<script src="js/dwz.theme.js" type="text/javascript"></script>
<script src="js/dwz.switchEnv.js" type="text/javascript"></script>
<script src="js/dwz.alertMsg.js" type="text/javascript"></script>
<script src="js/dwz.contextmenu.js" type="text/javascript"></script>
<script src="js/dwz.navTab.js" type="text/javascript"></script>
<script src="js/dwz.tab.js" type="text/javascript"></script>
<script src="js/dwz.resize.js" type="text/javascript"></script>
<script src="js/dwz.dialog.js" type="text/javascript"></script>
<script src="js/dwz.dialogDrag.js" type="text/javascript"></script>
<script src="js/dwz.sortDrag.js" type="text/javascript"></script>
<script src="js/dwz.cssTable.js" type="text/javascript"></script>
<script src="js/dwz.stable.js" type="text/javascript"></script>
<script src="js/dwz.taskBar.js" type="text/javascript"></script>
<script src="js/dwz.ajax.js" type="text/javascript"></script>
<script src="js/dwz.pagination.js" type="text/javascript"></script>
<script src="js/dwz.database.js" type="text/javascript"></script>
<script src="js/dwz.datepicker.js" type="text/javascript"></script>
<script src="js/dwz.effects.js" type="text/javascript"></script>
<script src="js/dwz.panel.js" type="text/javascript"></script>
<script src="js/dwz.checkbox.js" type="text/javascript"></script>
<script src="js/dwz.history.js" type="text/javascript"></script>
<script src="js/dwz.combox.js" type="text/javascript"></script>
<script src="js/dwz.print.js" type="text/javascript"></script>
<!--
<script src="bin/dwz.min.js" type="text/javascript"></script>
-->
<script src="js/dwz.regional.zh.js" type="text/javascript"></script>

<script type="text/javascript">
$(function(){
	DWZ.init("dwz.frag.xml", {
		loginUrl:"<s:property value="absolutePath" />login/index.do?ajax=1&ajaxLoginName=<s:property value="self.name"/>", loginTitle:"登录",	// 弹出登录对话框
//		loginUrl:"login.html",	// 跳到登录页面
		statusCode:{ok:200, error:300, timeout:301}, //【可选】
		pageInfo:{pageNum:"pageNum", numPerPage:"pageSize", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"themes"}); // themeBase 相对于index页面的主题base路径
		}
	});
});
</script>
</head>

	<body scroll="no">
		<div id="layout">
			<div id="header">
				<div class="headerNav">
					<a class="logo" href="javascript:;">Logo</a>
					<ul class="nav">
<!-- 						<li> -->
<!-- 							<a href="http://www.chinacis.cn/" target="_blank">购买</a> -->
<!-- 						</li> -->
<!-- 						<li> -->
<!-- 							<a href="http://www.chinacis.cn/" target="_blank">博客</a> -->
<!-- 						</li> -->
<!-- 						<li> -->
<!-- 							<a href="http://e.weibo.com/kwcc" target="_blank">微博</a> -->
<!-- 						</li> -->
<!-- 						<li> -->
<!-- 							<a href="http://www.chinacis.cn/" target="_blank">论坛</a> -->
<!-- 						</li> -->
						<li>
							<a href="<s:property value="absolutePath" />login/logout.do"><s:text name="login.logout"/></a>
						</li>
					</ul>
					<ul class="themeList" id="themeList">
						<li theme="default">
							<div class="selected">
								<s:text name="gobal.color.blue"/>
							</div>
						</li>
						<li theme="green">
							<div>
								<s:text name="gobal.color.green"/>
							</div>
						</li>
						<!--<li theme="red"><div>红色</div></li>-->
						<li theme="purple">
							<div>
								<s:text name="gobal.color.purple"/>
							</div>
						</li>
						<li theme="silver">
							<div>
								<s:text name="gobal.color.silver"/>
							</div>
						</li>
						<li theme="azure">
							<div>
								<s:text name="gobal.color.azure"/>
							</div>
						</li>
					</ul>
				</div>

				<!-- navMenu -->

			</div>

			<div id="leftside">
				<div id="sidebar_s">
					<div class="collapse">
						<div class="toggleCollapse">
							<div></div>
						</div>
					</div>
				</div>
				<div id="sidebar">
					<div class="toggleCollapse">
						<h2>
							<s:text name="nav.left.menu"/>
						</h2>
						<div>
							<s:text name="nav.left.min"/>
						</div>
					</div>

					<div class="accordion" fillSpace="sidebar">
						<div class="accordionHeader">
							<h2>
								<span>Folder</span><s:text name="nav.left.npo.center"/>
							</h2>
						</div>
						<div class="accordionContent">
							<ul class="tree treeFolder">
								<li><a href="<s:property value="absolutePath" />npo/center/events/index/list.do" target="navTab" rel="npo_center_events_index_list" title="<s:text name="npo.center.events.index.list"/>" fresh="true"><s:text name="nav.left.npo.center.events.index"/></a></li>
							</ul>
						</div>
						
						<div class="accordionHeader">
							<h2>
								<span>Folder</span><s:text name="nav.left.npo.config"/>
							</h2>
						</div>
						<div class="accordionContent">
							<ul class="tree treeFolder">

								<li>
									<a><s:text name="nav.left.npo.config"/></a>
									<ul>
										<li>
											<a href="<s:property value="absolutePath" />npo/config/status/index.do" target="navTab" rel="npo_config_status_index" title="<s:text name="npo.config.status.index"/>" fresh="true"><s:text name="nav.left.npo.config.status"/></a>
										</li>
										<li>
											<a href="<s:property value="absolutePath" />npo/config/category/index.do" target="navTab" rel="npo_config_category" title="<s:text name="npo.config.category"/>" fresh="true"><s:text name="nav.left.npo.config.category"/></a>
										</li>
									</ul>
								</li>
							</ul>
						</div>
					</div>	
				</div>
			</div>
			<div id="container">
				<div id="navTab" class="tabsPage">
					<div class="tabsPageHeader">
						<div class="tabsPageHeaderContent">
							<!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
							<ul class="navTab-tab">
								<li tabid="main" class="main">
									<a href="javascript:;"><span><span class="home_icon"><s:text name="myindex.title" /></span>
									</span>
									</a>
								</li>
							</ul>
						</div>
						<div class="tabsLeft">
							left
						</div>
						<!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
						<div class="tabsRight">
							right
						</div>
						<!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
						<div class="tabsMore">
							more
						</div>
					</div>
					<ul class="tabsMoreList">
						<li>
							<a href="javascript:;"><s:text name="myindex.title" /></a>
						</li>
					</ul>
					<div class="navTab-panel tabsPageContent layoutBox">
						<div class="page unitBox">
							<div class="accountInfo">
								<div class="alertInfo">
									<h2>
										<s:text name="myindex.notices" />
									</h2>
									<ul>
										<s:iterator value="notice" var="nt">
										<li class="main_notice"><a href="<s:property value="absolutePath" />sysinfo/notice/read.do?noticeId=<s:property value="#nt.noticeId" />" target="dialog" maxable="false" resizable="false" fresh="true" rel="sysinfo_notice_read"><s:property value="#nt.noticeTitle" /></a><span class="main_notice_date"><s:date name="#nt.noticePushDate" format="yyyy-MM-dd" /></span></li>
										</s:iterator>
									</ul>
									
								</div>
								<p>
									<span><s:text name="myindex.welcome"><s:param><s:property value="self.realName"/></s:param><s:param><s:property value="self.name"/></s:param></s:text></span>
								</p>
									<div class="main_user_face">
										<span><img class="main_user_face_img" src="<s:property value="absolutePath" />images/face_man.jpg" alt="" align="middle" width="100" height="100"/></span>
									</div>
									<div class="main_user_info">
										<ul>
											<li><s:text name="myindex.lastLoginTime" />:<span class="main_user_info_d"><s:date name="self.lastLoginTime" format="yyyy-MM-dd HH:mm:ss"/></span></li>
											<li><s:text name="myindex.lastLoginIP" />:<span class="main_user_info_d"><s:property value="self.lastLoginIp" /> [<s:property value="self.lastLoginAddress" />]</span></li>
											<li><s:text name="myindex.loginCount" />:<span class="main_user_info_d"><s:property value="self.loginCount" /><a href="<s:property value="absolutePath" />log/login/loginSelf.do" target="navTab" rel="log_login_self" title="<s:text name="myindex.myLogin.log"/>" fresh="true"><s:text name="myindex.myLogin.detail"/></a></span></li>
											<li><s:text name="myindex.myMessage" />:<span class="main_user_info_d">[0]<s:text name="myindex.myMessage.end" /></span></li>
										</ul>
									</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>

		<div id="footer">
			<s:text name="gobal.system.copyright" />
		</div>
	</body>
</html>