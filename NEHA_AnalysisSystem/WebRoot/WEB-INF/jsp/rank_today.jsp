<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<title>网络空间舆情指数监测平台 1.1.5 Beta - 互联网与社会研究中心（CIS）</title>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
  <script type="text/javascript" src="js/highcharts-new.js"></script>
  <script type="text/javascript" src="js/exporting.js"></script>
  <script type="text/javascript" src="js/highcharts-3d.js"></script>
  <script type="text/javascript" src="js/3d-column.js"></script>
    <script>
  ﻿﻿$(function () {
	    // Set up the chart
	    var chart = new Highcharts.Chart({
	        chart: {
	            renderTo: 'container',
	            type: 'column',
	            margin: 75,
	            options3d: {
	                enabled: true,
	                alpha: 15,
	                beta: 15,
	                depth: 50,
	                viewDistance: 25
	            }
	        },
	        title: {
	            text: '每日热门舆情排行榜'
	        },
	        subtitle: {
	            text: '<s:date name="date" format="yyyy-MM-dd" />'
	        },
	        plotOptions: {
	            column: {
	                depth: 25
	            }
	        },
	        xAxis: {
	            categories: [<s:property value="titles" />],
	            labels: {
	        enabled: false
	    }
	        },
	        yAxis: {
	            title:{
	                text:'指数'
	            }
	        },
	        series: [{
	            name:'今日指数',
	            data: [<s:property value="pos" />]
	        }]
	    });
	    

	    // Activate the sliders
	    $('#R0').on('change', function(){
	        chart.options.chart.options3d.alpha = this.value;
	        showValues();
	        chart.redraw(false);
	    });
	    $('#R1').on('change', function(){
	        chart.options.chart.options3d.beta = this.value;
	        showValues();
	        chart.redraw(false);
	    });

	    function showValues() {
	        $('#R0-value').html(chart.options.chart.options3d.alpha);
	        $('#R1-value').html(chart.options.chart.options3d.beta);
	    }
	    showValues();
	});	
  </script>
</head>
<body>
  <div id="container" style="min-width:700px;height:400px"></div>
﻿	<div id="sliders" style="min-width:310px;max-width: 800px;margin: 0 auto;">
	</div></body>
</html>
