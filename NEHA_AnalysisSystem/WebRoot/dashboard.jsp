<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>

  </head>
  
  <body>
 输入ID<input id="dashid" type="test"/>
 <button id="btn-dash" onclick="Intensity()">提交</button>
<div id="container" style="width: 800px; height: 400px;overflow:hidden "></div>
<script src="js/jquery-1.8.3.min.js"></script>
<script src="js/highcharts.js"></script>
<script src="js/highcharts-more.js"></script>
		<script type="text/javascript">
   var panel = {
	    chart: {
	    renderTo: 'container',
	        type: 'gauge',
	        plotBackgroundColor: null,
	        plotBackgroundImage: null,
	        plotBorderWidth: 0,
	        plotShadow: false
	    },
	    title: {
	        text: '仪表盘',
	        y:150
	    },
	    
	      pane: {
	           startAngle: -80,
	        endAngle: 80,
			center: ['50%', '102%'],
	        background: [{
	            backgroundColor: {
	                linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
	                stops: [
	                    [0, '#FFF'],
	                    [1, '#333']
	                ]
	            },
	            borderWidth: 1,
	            outerRadius: '119%'
	        }, {
	            backgroundColor: {
	                linearGradient: { x1: 0, y1: 0, x2: 0, y2: 1 },
	                stops: [
	                    [0, '#333'],
	                    [1, '#FFF']
	                ]
	            },
	            borderWidth: 1,
	            outerRadius: '107%'
	        }, {
	            // default background
	        }, {
	            backgroundColor: '#DDD',
	            borderWidth: 0,
	            outerRadius: '105%',
	            innerRadius: '103%'
	        }]
	    },
	    
	       
	    // the value axis
	    yAxis: {
	        min: 0,
	        max: 10000,
	        
	        minorTickInterval: 'auto',
	        minorTickWidth: 1,
	        minorTickLength: 10,
	        minorTickPosition: 'inside',
	        minorTickColor: '#666',
	
	        tickPixelInterval: 30,
	        tickWidth: 2,
	        tickPosition: 'inside',
	        tickLength: 2,
	        tickColor: '#666',
	        labels: {
	        enabled:false,

	        },
	        plotBands: [{
	            from: 0,
	            to: 2000,
	            color: '#483D8B'
	        }, 
	        {
	            from: 2000,
	            to: 4000,
	            color: '#63B8FF' 
	        }, 
	        {
	            from: 4000,
	            to: 6000,
	            color: '#55BF3B' // green
	        }, {
	            from: 6000,
	            to: 8000,
	            color: '#DDDF0D' // yellow
	        }, {
	            from: 8000,
	            to: 10000,
	            color: '#DF5353' // red
	        }]        
	    },
	
	    series: [{
	        name: '指数',
	        data: [0]
	    }]
	}

var panel1=new Highcharts.Chart(panel);

var panelt="";

function Intensity() {
var event_id=$("#dashid").val();
    $.ajax({
        url: "GetIntensity.action",
        type: "POST",
        data:{"event_id":event_id},
        dataType: "json",
        timeout: 20000,
        beforeSend: function() {
        if(panelt!=""){clearTimeout(panelt,0);}
        },
        success: function(data) {
        var iData=eval('('+data+')');
        var point="["+iData[0].intensity+"]";
        panel1.series[0].setData(eval(point));
        panelt=setTimeout("Intensity()",15000);
        },
        error: function() {
            alert("数据加载失败，请重试！");
        }
    });
}
		</script>

  </body>
</html>
