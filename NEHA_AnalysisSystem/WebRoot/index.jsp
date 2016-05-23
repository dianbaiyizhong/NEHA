<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>网络空间舆情指数监测平台 1.1.5 Beta - 互联网与社会研究中心（CIS）</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<link href="css/jquery.vector-map.css" media="screen" rel="stylesheet" type="text/css" />
<script>
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "//hm.baidu.com/hm.js?fdc637b3b114494e160bfc87b5778455";
  var s = document.getElementsByTagName("script")[0]; 
  s.parentNode.insertBefore(hm, s);
})();
</script>
</head>
<body>  
<s:action name="Menu"></s:action>
<div class="shade"><div class="dataLoading"><img src="img/loading.gif"/><span class="loadingText">数据加载中，请稍等</span></div></div>

<div class="sidebar">
<ul class="nav">
<li class="searchBar">搜索<span class="arrow"><img src="img/arrow.png"/></span></li>
<li id="compre">综合</li>
<!-- <li>网站 1.0
<ul class="navlist">
<s:iterator value="#session['web10']" id="web10">
				<li ><s:property value="#web10.site_class2_name"/></li>
				</s:iterator>
</ul>
</li>
<li>网站 2.0
<ul class="navlist">
<s:iterator value="#session['web20']" id="web20">
				<li><s:property value="#web20.site_class2_name"/></li>
				</s:iterator>
</ul></li>
<li>网站 3.0
<ul class="navlist">
<s:iterator value="#session['web30']" id="web30">
				<li><s:property value="#web30.site_class2_name"/></li>
				</s:iterator>
</ul></li> -->
<li>数据源位置分析
<ul class="navlist" style="z-index:9">
<s:iterator value="#session['event']" id="event">
				<li class=""><a  style="text-decoration:none;color: white;" href="content.action?eventId=<s:property value="id" />" ><s:property value="#event.title"/></a></li>
				</s:iterator>
</ul></li>
<li>选择类型
<ul class="navlist" style="z-index:9">
<s:iterator value="#session['type']" id="type">
				<li class="cateLi"><s:property value="#type.name"/><input type="hidden" value="<s:property value="#type.id"/>"></li>
				</s:iterator>
</ul></li>
<li id="chooseArea">选择地区</li>
<li id="alldata">所有数据</li>
<li id="daydata">7天数据</li>
<li id="hourdata">24小时数据</li>
<li id="realtimedata">实时数据</li>
<li id="hotrank"><a href="today_hot.action" style="color:#FFF;text-decoration:none;">每日排行榜</a></li>

<li id="setting">设置</li>
<div style="margin-top:100px;padding:0 0 0 10px;"> 
<img src="img/logo1.png"/></div>
<div style="padding:10px 0 0 10px;">
</ul>


</div>

<div id="map" class="mapBox"></div>
<div class="searchBox"><div class="boxContent">
<input class="searchInput" placeholder="输入搜索的内容.." type="text" ><span class="btnSearch" onclick="getSearchList()">搜索</span>
<div class="searchLoading"></div>
<div class="searchResult"></div>

</div>
</div>
<div class="setBox">
<div class="setContent"><span class="setico"><img src="img/set.png"/></span>样式选择:
<input type="radio" name="chartstyle" value="line" checked="true"/><span class="radioItem">折线图</span>
<input type="radio" name="chartstyle" value="spline" /><span class="radioItem">曲线图</span>
<input type="radio" name="chartstyle" value="column" /><span class="radioItem">柱状图</span>
<input type="radio" name="chartstyle" value="bar" /><span class="radioItem">条形图</span>
<span style="margin-left:20px">24小时刷新时间:</span>
<select id="allrefresh">
<option value="1803000">30分钟</option>
<option value="3603000">1小时</option>
</select>
<span style="margin-left:20px">实时刷新时间:</span>
<select id="realrefresh">
<option value="10000">10秒</option>
<option value="15000">15秒</option>
<option value="30000">30秒</option>
<option value="60000">1分钟</option>
</select>
<!--<span style="margin-left:20px">数据显示:</span>
 <select id="dataSelect">
<option value="all" >所有数据</option>
<option value="day">7天数据</option>
<option value="hour">24小时数据</option>
<option value="realtime">实时数据</option>
</select> -->
<span style="margin-left:20px">屏幕显示:</span>
 <select id="screenSelect">
<option value="horScreen" >横屏</option>
<option value="verScreen">竖屏</option>
</select>
</div>
</div>
<div id="container1" ></div>
<div id="container2" ></div>
<div id="container3"></div>
<script type="text/javascript" src="js/jquery-1.8.3.min.js" ></script>
<script type="text/javascript" src="js/highcharts.js"></script>
<script type="text/javascript" src="js/theme.js"></script>
<script type="text/javascript" src="js/execute.js"></script>
<script type="text/javascript" src="js/jquery.vector-map.js" ></script>  
<script type="text/javascript" src="js/map.js"></script>
<script type="text/javascript" src="js/china-zh.js"></script>
</body>
</html>