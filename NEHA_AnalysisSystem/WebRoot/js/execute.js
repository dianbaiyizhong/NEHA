var allrft = 1803000;//初始24小时刷新30分钟+3秒，错开
var realrft = 10000; //初始实时刷新10秒
rt="";//设置自动实时刷新为空
ht="";//设置自动24小时刷新为空
setchart0="block";//默认显示
setchart7="block";//默认显示
setchart24="block";//默认显示
$(document).ready(function() {

    //IE兼容叠放顺序
    if ($.browser.msie) {
        $("#container1").css("z-index", "-1");
    }

    //初始化highcharts主题
    var chart = new Highcharts.Chart(chart_7);
    var chart2 = new Highcharts.Chart(chart_24);
    var chart3 = new Highcharts.Chart(chart_0);

    defaultHighcharts(chart_7);
    defaultHighcharts(chart_24);
    defaultHighcharts(chart_0);

   //调用初始化数据
    if(Init){
  Init();
    }
//初始化type
    
if(getCookie('chartType'))
{
	var selectType=getCookie('chartType');
	typeChange(selectType);
}
if(getCookie('screenType'))
{
	var screenType=getCookie('screenType');
	screenChange(screenType);
}else{
	screenChange('verScreen');
}
    //更改chart.type
    $('input[name=chartstyle]').change(function() {
        var selectType = $(this).val();
        setCookie('chartType',selectType,'15');
        typeChange(selectType);

    });
    


    //搜索区域弹出
    var searchBox = $('.searchBox');
    var arrow = $('.arrow');
    var setBox = $('.setBox');
    var setContent = $('.setContent');
    var isClick = false;
    var setClick = false;
    $('.searchBar').click(function() {

        if (isClick === false) {
            $('.searchResult').html("");
            $('.searchLoading').html("");
            $('.searchInput').val("");
            searchBox.stop().animate({
                left: '120px'
            },
            '500');

            isClick = true;
        } else if (isClick === true) {
            searchBox.stop().animate({
                left: '-280px'
            },
            '500');

            isClick = false;

        }
        arrow.toggleClass('rotateArrow');
    });
    //菜单经过
    $(".nav li").mousemove(function() {

        $(this).find('ul').show();
    });
    $(".nav li").mouseleave(function() {
        $(this).find('ul').hide();
    });
    $('#chooseArea').click(function() {
        $('.mapBox').toggle(500);
    });

    //设置弹出
    $('#setting').click(function() {

        if (setClick === false) {
            setBox.stop().animate({
                height: '60px'
            },
            '500');
            setContent.show();
            setClick = true;
        } else if (setClick === true) {
            setBox.stop().animate({
                height: '0px'
            },
            '500');
            setContent.fadeOut(200);
            setClick = false;

        }

    });
    $('#compre').click(function() {
//     	SynthesisRank(chart_7);
// 	    SynthesisRank(chart_24);
 //   	SynthesisRank(chart_0);
    	Init();
    });
    //设置刷新

    $('#allrefresh').change(function() {
        allrft = $(this).val();

    });

    $('#realrefresh').change(function() {
        realrft = $(this).val();

    });
    //屏幕选择
    $('#screenSelect').change(function() {
      var  screenType = $(this).val();
      setCookie('screenType',screenType,'15');
      screenChange(screenType);
      

    });

    //选择事件
    $('.cateLi').click(function() {

        var result = $(this).find('input:hidden').val();
        loadCategory(result);

    });
   //选择数据
    $('#alldata').click(function(){
    	  setchart0="block";
		  setchart7="block";
		  setchart24="block";
		  if(getCookie('screenType')=='horScreen')
			  {
		  $('#container1').css({display:"block",position:'absolute',left:"130px"});
		  $('#container2').css({display:"block",position:'absolute',left:"102%"});
		  $('#container3').css({display:"block",position:'absolute',left:"194%"});
			  }
		  else if(getCookie('screenType')=='verScreen')
			{
	       
	        	$('#container1').css({display:'block',float:'none',position:'relative',
	        	left:'130px'});
	        	$('#container2').css({display:'block',float:'none',position:'relative',
	            	left:'130px'});
	        	$('#container3').css({display:'block',float:'none',position:'relative',
	            	left:'130px'});
	        	}
    });
    $('#daydata').click(function(){
    	setchart7="block";
		setchart24="none";
		setchart0="none";	
		$('#container1').css({"display":"block",position:'absolute',"left":"130px"});
		$('#container2').css("display","none");
		$('#container3').css("display","none");
    });
    $('#hourdata').click(function(){
    	  setchart24="block";
		  setchart7="none";
		  setchart0="none";
		  $('#container2').css({"display":"block",position:'absolute',"left":"130px"});
		  $('#container1').css("display","none");
		  $('#container3').css("display","none");
    });
    $('#realtimedata').click(function(){
    	  setchart0="block";
		  setchart7="none";
		  setchart24="none";
		  $('#container3').css({"display":"block",position:'absolute',"left":"130px"});
		  $('#container1').css("display","none");
		  $('#container2').css("display","none");
    });
    
//设置7天X轴坐标   
    function GetDateStr(AddDayCount) {
        var dd = new Date();
        dd.setDate(dd.getDate()+AddDayCount);
        var m = dd.getMonth()+1;
        var d = dd.getDate();
        return m+"月"+d+"日";
    }

    function printday() { 

        for(var d=0;d<=9;d++)
        {
        	if(d<9)
        		{
        	chart_7.xAxis.categories.push(GetDateStr(d-9));
        		}
        	else
        		{
        		chart_7.xAxis.categories.push('今天');
        		}
    	
    	
    }
   }
if(printday)
	{
      printday();
	}
  
  
   /* $('#dataSelect').change(function() {
    	var _value=$(this).val();

    	  switch(_value)
    	  {
    		case 'all':
    		  {
    			  setchart0="block";
    			  setchart7="block";
    			  setchart24="block";
    			  $('#container1').css({"display":"block","left":"130px"});
    			  $('#container2').css({"display":"block","left":"102%"});
    			  $('#container3').css({"display":"block","left":"194%"});
    			  break;
    		  }
    		  case 'day':
    		  {
    			setchart7="block";
    			setchart24="none";
    			setchart0="none";	
    			$('#container1').css({"display":"block","left":"130px"});
    			$('#container2').css("display","none");
    			$('#container3').css("display","none");
    			  break;
    		  }
    		  case 'hour':
    		  {
    			  setchart24="block";
    			  setchart7="none";
    			  setchart0="none";
    			  $('#container2').css({"display":"block","left":"130px"});
    			  $('#container1').css("display","none");
    			  $('#container3').css("display","none");
    			  break;
    		  }
    		   case 'realtime':
    		  {
    			  setchart0="block";
    			  setchart7="none";
    			  setchart24="none";
    			  $('#container3').css({"display":"block","left":"130px"});
    			  $('#container1').css("display","none");
    			  $('#container2').css("display","none");
    			  break;
    		  }

    		  
    		  
    	  }
    	  
    	  });*/


});

//写入cookie
function setCookie(c_name,value,expiredays)
{
    var exdate=new Date();
    exdate.setDate(exdate.getDate()+expiredays);
    document.cookie=c_name+"="+escape(value)+((expiredays==null)?"":";expires="+exdate.toGMTString());

}
//读出cookie
function getCookie(c_name)
{
    if(document.cookie.length>0)
    {
        c_start=document.cookie.indexOf(c_name+"=");
    
    if(c_start>-1)
    {
        c_start=c_start+c_name.length+1;
        c_end=document.cookie.indexOf(";",c_start);
        if(c_end==-1) {
            c_end=document.cookie.length;
            }
        return unescape(document.cookie.substring(c_start,c_end));
        
    }
    }
}
//类型转换
function typeChange(selectType)
{
    switch(selectType)
    {
    case 'spline':{
        chart_7.chart.type = selectType;
        chart_24.chart.type = selectType;
    	chart_0.chart.type = selectType;
        chart = new Highcharts.Chart(chart_7);
        chart2 = new Highcharts.Chart(chart_24);
        chart3 = new Highcharts.Chart(chart_0);
        break;
    }
    case 'line':{
        chart_7.chart.type = selectType;
        chart_24.chart.type = selectType;
    	chart_0.chart.type = selectType;
        chart = new Highcharts.Chart(chart_7);
        chart2 = new Highcharts.Chart(chart_24);
        chart3 = new Highcharts.Chart(chart_0);
        break;
    	
    }
    case 'column':{
        chart_7.chart.type = selectType;
        chart_24.chart.type = selectType;
        chart = new Highcharts.Chart(chart_7);
        chart2 = new Highcharts.Chart(chart_24);
        break;

    }
    case 'bar':{
        chart_7.chart.type = selectType;
        chart = new Highcharts.Chart(chart_7);
        chart2 = new Highcharts.Chart(chart_24);
        break;
    }
}
}

//屏幕切换
function screenChange(screenType)
{
	  if(screenType=='horScreen'){
	     
		  $('.sidebar').css({position:'absolute'});
		  $('.searchBox').css({position:'absolute'});
	        if(setchart0=='block'&&setchart7=='block'&&setchart24=='block')
	        	{
	  		  $('#container1').css({float:'left',position:'absolute',left:"130px",});
			  $('#container2').css({float:'left',position:'absolute',left:"102%"});
			  $('#container3').css({float:'left',position:'absolute',left:"194%"});
	        	}
	        }
	        else
	        	{
	        	$('.sidebar').css({position:'fixed'});
	        	$('.searchBox').css({position:'fixed'});
	        	
	        	$('#container1').css({float:'none',position:'relative',
	        	left:'130px'});
	        	$('#container2').css({float:'none',position:'relative',
	            	left:'130px'});
	        	$('#container3').css({float:'none',position:'relative',
	            	left:'130px'});
	        	}
	}


//默认样式
function defaultHighcharts(_chart) {
    _chart.series = new Array();
    _chart.series[0] = new Object();
    var dat = [];
    _chart.series[0].name = 'None';
    _chart.series[0].data = eval(dat);
    chart = new Highcharts.Chart(_chart);
}

//加载综合数据
function SynthesisRank(_chart) {

    $.ajax({
        url: "Synthesis.action",
        type: "GET",
        dataType: "json",
        timeout: 20000,
        beforeSend: function() {
            $('.shade').show();
        },
        //添加loading信息
        success: function(data) {
            $('.shade').hide();
            if(rt!=""){ clearTimeout(rt,0);}
            _chart.series = new Array();
            var dataObj = eval("(" + data + ")");
            $.each(dataObj,
            function(index, item) {
                _chart.series[index] = new Object();
                _chart.series[index].name = item.title;
                var newData;
                newData = "[";
                $.each(item.points,
                        function(_index, _item) {
                        	newData+=checkLoadPoint(_item.point,_item.date);
                        });
                        newData += "]";
                        _chart.series[index].data = eval(newData);

            });

            chart = new Highcharts.Chart(_chart);
           defaultHighcharts(chart_7);
           defaultHighcharts(chart_24);
        },
        error: function() {
            $(".searchLoading").html("数据加载失败，请重试！");
        }

    });

}

//加载初始化数据
function Init() {
    $.ajax({
        url: "Init.action",
        type: "GET",
        dataType: "json",
        timeout: 20000,
        beforeSend: function() {
            $('.shade').show();
            if(rt!=""){ clearTimeout(rt,0);}
            if(ht!=""){ clearTimeout(ht,0);}
        },
        //添加loading信息
        success: function(data) {
            $('.shade').hide();
            loadData(data);
            
            setTimeout("realtimeSyn()",realrft);
            setTimeout("hourSyn()",allrft);

        },
        error: function() {
            $('.shade').hide();
            alert("数据加载失败，请重试！");
        }
    });
}

//获取关键字返回列表
function getSearchList() {
    var keyword = $.trim($(".searchInput").val());
    if (keyword == "") {
        alert("请输入搜索内容");
    } else {
        $.ajax({
            url: "SubmitKeyword.action",
            type: "POST",
            data: {
                "keyword": keyword
            },
            contentType: "application/x-www-form-urlencoded;charset=UTF-8",
            timeout: 20000,
            dataType: "json",
            beforeSend: function() {
                $('.searchResult').html("");
                $(".searchLoading").html("<img src=\"img/loading.gif\"/>");
            },
            //添加loading信息
            success: function(data) {
                $(".searchLoading").html("");
                $('.searchResult').html("");
                var dat = eval("(" + data + ")");
                if (dat.length > 0) {

                    $.each(dat,
                    function(index, item) {

                        $('.searchResult').append("<li class=\"searchItem\"><input type=\"checkbox\" name=\"searchCheck\"value=" + item.id + ">&nbsp;&nbsp;<span>" + item.title + "</span></li>");

                    });
                    $(".searchResult").append("<br><span class=\"submitItem\" onclick=\"loadSearchData()\">提交</span>");
                } else {
                    $(".searchResult").append("没有记录");
                }
            },
            error: function() {
                $(".searchLoading").html("搜索超时，请重试！");
            }
        });
    }
}

//加载事件数据
function loadCategory(result) {
    var category_id = result;
    $.ajax({
        url: "Classification.action",
        type: "POST",
        data: {
            "category_id": category_id
        },
        contentType: "application/x-www-form-urlencoded;charset=UTF-8",
        timeout: 20000,
        dataType: "json",
        beforeSend: function() {
            $('.shade').show();
            if(rt!=""){ clearTimeout(rt,0);}
            if(ht!=""){ clearTimeout(ht,0);}
        },
        //添加loading信息
        success: function(data) {
            $('.shade').hide();
            loadData(data);
            
            setTimeout("realtimeSyn()",realrft);
            setTimeout("hourSyn()",allrft);
       
        },
        error: function() {
            $('.shade').hide();
            alert("数据加载失败，请重试！");
        }
    });
}

//加载搜索数据
function loadSearchData() {
    var searchEventTitle = "";
    var searchEventIds = "";
    var checked = $('input[name=searchCheck]:checked');
    var length = checked.length;
    checked.each(function(index, item) {

        searchEventTitle += $(this).next().text() + ",";
        searchEventIds += item.value + ",";
    });
    $.ajax({
        url: "SubmitSearchIds.action",
        type: "POST",
        data: {
            "searchEventIds": searchEventIds,
            "searchEventTitle": searchEventTitle
        },
        contentType: "application/x-www-form-urlencoded;charset=UTF-8",
        timeout: 20000,
        dataType: "json",
        beforeSend: function() {
            $('.shade').show();
            if(rt!=""){ clearTimeout(rt,0);}
            if(ht!=""){ clearTimeout(ht,0);}
        },
        //添加loading信息
        success: function(data) {
            $('.shade').hide();

            loadData(data);
            setTimeout("realtimeSyn()",realrft);
            setTimeout("hourSyn()",allrft);
      
        },
        error: function() {
            $('.shade').hide();
            alert("数据加载失败，请重试！");
        }
    });
}
//7天同步
function dailySyn() {

    var searchEventIds;
    $.ajax({
        url: "GetDaily.action",
        type: "POST",
        data: {
            "searchEventIds": searchEventIds
        },
        contentType: "application/x-www-form-urlencoded;charset=UTF-8",
        dataType: "json",
        success: function(data) {

},
        error: function() {}
    });
}

//24小时同步
function hourSyn(){
    var searchEventIds="";
    $.each(chart_24.series,
    function(index, item) {

        searchEventIds += chart_24.series[index].id + ",";

    });

    $.ajax({
        url: "GetHour.action",
        type: "POST",
        data: {
            "searchEventIds": searchEventIds
        },
        contentType: "application/x-www-form-urlencoded;charset=UTF-8",
        dataType: "json",
        success: function(data) {
            var hourData = eval("(" + data + ")");       
            $.each(hourData,
            	function(index, item) {
                var newPoint;
                var pl= chart2.series[index].data.length;
                var lastTime=chart2.series[index].data[pl-1].time;
                newTime = eval("'" + item.date + "'");
//                console.log(lastTime+","+newTime);
                if(timeCheck(lastTime,newTime))
                {
                newPoint = eval(item.point);
                }
                if (newPoint != null) {
                	if(pl<10)
                		{
                		 chart2.series[index].addPoint(newPoint, true,false);
                		 chart2.series[index].data[pl].update(checkPoint(newPoint,newTime));
          		}
                	else
                	{   //直接替换
                		for (var i=0;i<pl-1;i++)
                		{
                	      chart2.series[index].data[i].update(checkPoint(chart2.series[index].data[i+1].y,chart3.series[index].data[i+1].time));
                		}
                		 chart2.series[index].data[pl-1].update(checkPoint(newPoint,newTime));		
                	}

                }

            });
        },
        error: function() {}
    });

ht=setTimeout("hourSyn()",allrft);
}

//实时同步

function realtimeSyn(){
    var searchEventIds="";

    $.each(chart_0.series,
    function(index, item) {
        searchEventIds += chart_0.series[index].id + ",";
    });

    $.ajax({
        url: "GetRealtime.action",
        type: "POST",
        data: {
            "searchEventIds": searchEventIds
        },
        contentType: "application/x-www-form-urlencoded;charset=UTF-8",
        dataType: "json",
        success: function(data) {
            var realtimeData = eval("(" + data + ")");
            $.each(realtimeData,
            function(index, item) {
                var newPoint;
                var pl= chart3.series[index].data.length;
                var lastTime=chart3.series[index].data[pl-1].time;
                newTime = eval("'" + item.date + "'");
//                console.log(lastTime+","+newTime);
                if(timeCheck(lastTime,newTime))
                {
                newPoint = eval(item.point);
                }
                if (newPoint != null) {
                	if(pl<10)
                		{
                		 chart3.series[index].addPoint(newPoint, true,false);
                		 chart3.series[index].data[pl].update(checkPoint(newPoint,newTime));
          		}
                	else
                	{   //直接替换
                		for (var i=0;i<pl-1;i++)
                		{
                	      chart3.series[index].data[i].update(checkPoint(chart3.series[index].data[i+1].y,chart3.series[index].data[i+1].time));
                		}
                		 chart3.series[index].data[pl-1].update(checkPoint(newPoint,newTime));		
                	}

                }

            });
        },
        error: function() {}
    });

rt=setTimeout("realtimeSyn()",realrft);
}

//时间判断大小
function timeCheck(otime, ntime) {
	if(otime.length==13&&ntime.length==13)
		{
			otime=otime+":00:00"
			ntime=ntime+":00:00"
		}
    otime = new Date(Date.parse(otime.replace(/\-/g, "/")));
    ntime = new Date(Date.parse(ntime.replace(/\-/g, "/")));
    var _otime = otime.getTime();
    var _ntime = ntime.getTime();
    if ((_ntime - _otime) > 0) {
        return true;
    } else {
        return false;
    }
}

//同步检测Point
function checkPoint(newPoint,newTime)
{
	var newData="{time:"+"'"+newTime+"'";
	if(newPoint<5000)
	{
		newData+=",y:"+newPoint+",marker:{symbol: 'circle'}}";
	}
	else if (newPoint >= 5000 && newPoint < 7500) {
		newData += ",y:" + newPoint + ",marker:{symbol: 'url(img/warn.gif)'}}";
		} 
	else {
		newData += ",y:" + newPoint + ",marker:{symbol: 'url(img/warn2.gif)'}}";
		}
	return eval('('+newData+')');
	
}
//加载检测Point
function checkLoadPoint(newPoint,newTime)
{
	var newData="{time:"+"'"+newTime+"'";
	if(newPoint<5000)
	{
		newData+=",y:"+newPoint+",marker:{symbol: 'circle'}},";
	}
	else if (newPoint >= 5000 && newPoint < 7500) {
		newData += ",y:" + newPoint + ",marker:{symbol: 'url(img/warn.gif)'}},";
		} 
	else {
		newData += ",y:" + newPoint + ",marker:{symbol: 'url(img/warn2.gif)'}},";
		}
	return newData;
	
}
//通用加载数据
function loadData(data) {

    var initData = eval("(" + data + ")");
    chart_7.series = new Array();
    chart_24.series = new Array();
    chart_0.series = new Array();
    jsond();
    jsonh();
    jsonr();
    function jsond() {
        if (initData.jsond != "") {
            $.each(initData.jsond,
            function(index, item) {
                chart_7.series[index] = new Object();
                chart_7.series[index].name = item.title;
                chart_7.series[index].id = item.event_id;
                var newData;
                newData = "[";
                var ipl=item.points.length;
                if(ipl<10)
                	{
                	for(var k=0;k<10-ipl;k++)
                		newData+=null+",";
                	
                	}

                $.each(item.points,
                function(_index, _item) {
                
                    if (_item.point >= 5000 && _item.point < 7500) {
                        newData += "{y:" + _item.point + ",marker: {symbol: 'url(img/warn.gif)'}},";

                    } else if (_item.point >= 7500) {
                        newData += "{y:" + _item.point + ",marker: {symbol: 'url(img/warn2.gif)'}},";

                    } else {
                        newData += _item.point + ",";
                    }

                });
                newData += "]";
                chart_7.series[index].data = eval(newData);

            });
            chart = new Highcharts.Chart(chart_7);
        } else {
            defaultHighcharts(chart_7);
        }
    }
    function jsonh() {
        if (initData.jsonh != "") {
            $.each(initData.jsonh,
            function(index, item) {
                chart_24.series[index] = new Object();
                chart_24.series[index].name = item.title;
                chart_24.series[index].id = item.event_id;
                var newData;
                newData = "[";
                $.each(item.points,
                function(_index, _item) {
                	newData+=checkLoadPoint(_item.point,_item.date);
                	chart_24.xAxis.categories.push(_item.date.substr(5)+"时");
                });
                newData += "]";
                chart_24.series[index].data = eval(newData);

            });
            chart2 = new Highcharts.Chart(chart_24);
        } else {
            defaultHighcharts(chart_0);
        }
    }
    function jsonr() {
        if (initData.jsonr != "") {
            $.each(initData.jsonr,
            function(index, item) {
                chart_0.series[index] = new Object();
                chart_0.series[index].name = item.title;
                chart_0.series[index].id = item.event_id;
                var newData;
                newData = "[";
                $.each(item.points,
                function(_index, _item) {
                	newData+=checkLoadPoint(_item.point,_item.date);
                });
                newData += "]";
                chart_0.series[index].data = eval(newData);

            });
            chart3 = new Highcharts.Chart(chart_0);
        } else {
            defaultHighcharts(chart_0);
        }
    }
}