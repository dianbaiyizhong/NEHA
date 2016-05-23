var chart_7 = {

    chart: {
        renderTo: 'container1',
        type: 'line',
        zoomType: 'xy',
        //width: 1200,
        //height:720,
		plotBackgroundImage: 'img/logobg.png',
        animation: Highcharts.svg
    },
    title: {
        text: '7天数据',
        x: 30 //center
    },

    xAxis: { 
    
        categories:[]
    },
    yAxis: {
        max: 10000,
        min: 0,
        gridLineDashStyle: 'longdashdot',
        minRange: 0,

        title: {
            text: ''
        },
        plotBands: [{
            color: 'rgba(150,150,150,0.05)',
            from: 2250,
            to: 3500,
            label: {
                text: '潜伏区',
                align: 'center',
                style: {
                    color: 'gray'
                }
            }
        },
        {
            color: 'rgba(150,150,150,0.2)',
            from: 3500,
            to: 5000,
            label: {
                text: '观察区',
                align: 'center',
                style: {
                    color: 'gray'
                }
            }
        },
        {
            color: 'rgba(150,150,150,0.35)',
            from: 5000,
            to: 7500,

            label: {
                text: '预警区',
                align: 'center',
                style: {
                    color: 'gray'
                }
            }
        },
        {
            color: 'rgba(150,150,150,0.5)',
            from: 7500,
            to: 10000,
            label: {
                text: '干预区',
                align: 'center',
                style: {
                    color: 'gray'
                }
            }
        }

        ],

        plotLines: [{
            value: 7500,

            color: '#ccc',
            zIndex: 1,
            width: 2

        },
        {
            value: 5000,
            color: '#ccc',
            width: 2,

            zIndex: 1

        },
        {
            value: 3500,
            color: '#ccc',

            zIndex: 1,
            width: 2
        },
        {
            value: 2250,
            color: '#CCC',

            zIndex: 1,
            width: 2
        }],
        labels: {
            formatter: function() {
                return this.value
            }
        }
    },
    tooltip: {
        formatter: function() {
            return '<b>' + this.series.name + '</b><br/>' + '<b>指数：</b>' + this.y;
        }
    },
    plotOptions: {
        line: {
            marker: {
                // enabled: false,
                radius: 3,
                lineColor: '#666666',
                lineWidth: 1
            }
        },
        series: {
            lineWidth: 4,
            cursor: 'pointer',
            point: {
                events: {
                    click: function() {
                        if (this.y >= 5000 && this.y < 7500) {
                            alert(this.series.name + '处于预警区，建议发布预警信号');
                        }
                        if (this.y > 7500) {
                            alert(this.series.name + '处于干预区，请立即采取干预手段');
                        }
                    }
                }
            }
        }

    },
    symbols: ['circle']
};
var chart_24 = {

    chart: {
        renderTo: 'container2',
        type: 'line',
        zoomType: 'xy',
        //	width: 1200,
        //	height:720,
	    plotBackgroundImage: 'img/logobg.png',
        animation: Highcharts.svg
    },
    title: {
        text: '24小时数据',
        x: 30 //center
    },

    xAxis: {
  //      categories: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10']
    	categories: []
 //categories: [ '九小时前', '1/3天前', '七小时前', '1/4天前', '五小时前', '1/6天前', '三小时前', '两小时前', '一小时前', '当前']
    },
    yAxis: {
        max: 10000,
        min: 0,
        gridLineDashStyle: 'longdashdot',
        title: {
            text: ''
        },
        plotBands: [{
            color: 'rgba(150,150,150,0.05)',
            from: 2250,
            to: 3500,
            label: {
                text: '潜伏区',
                align: 'center',
                style: {
                    color: 'gray'
                }
            }
        },
        {
            color: 'rgba(150,150,150,0.2)',
            from: 3500,
            to: 5000,
            label: {
                text: '观察区',
                align: 'center',
                style: {
                    color: 'gray'
                }
            }
        },
        {
            color: 'rgba(150,150,150,0.35)',
            from: 5000,
            to: 7500,

            label: {
                text: '预警区',
                align: 'center',
                style: {
                    color: 'gray'
                }
            }
        },
        {
            color: 'rgba(150,150,150,0.5)',
            from: 7500,
            to: 10000,
            label: {
                text: '干预区',
                align: 'center',
                style: {
                    color: 'gray'
                }
            }
        }

        ],
        plotLines: [{
            value: 7500,

            color: '#ccc',
            zIndex: 1,
            width: 2

        },
        {
            value: 5000,
            color: '#ccc',
            width: 2,

            zIndex: 1

        },
        {
            value: 3500,
            color: '#ccc',

            zIndex: 1,
            width: 2
        },
        {
            value: 2250,
            color: '#CCC',

            zIndex: 1,
            width: 2
        }],
        labels: {
            formatter: function() {
                return this.value
            }
        }
    },
    tooltip: {
        formatter: function() {

            return '<b>' + this.series.name + '</b><br/>' + '<b>' + ""+ '指数：</b>' + this.y;
        }
    },
    plotOptions: {
        line: {
            marker: {
                // enabled: false,
                radius: 3,
                lineColor: '#666666',
                lineWidth: 1
            }
        },
        series: {
            lineWidth: 4,
            cursor: 'pointer',
            point: {
                events: {
                    click: function() {
                        if (this.y >= 5000 && this.y < 7500) {
                            alert(this.series.name + '处于预警区，建议发布预警信号');
                        }
                        if (this.y > 7500) {
                            alert(this.series.name + '处于干预区，请立即采取干预手段');
                        }
                    }
                }
            }
        }

    },
    symbols: ['circle']

};

var chart_0 = {
    chart: {
        renderTo: 'container3',
        type: 'line',
        zoomType: 'xy',
        //  width: 1200,
        //height:720,
	    plotBackgroundImage: 'img/logobg.png',
        animation: Highcharts.svg // don't animate in old IE
    },
    title: {
        text: '实时数据',
        x: 30 //center
    },

    xAxis: {
    	labels: {
	        enabled:false,

	        },
        type: 'datetime',
        categories: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10']

    },
    yAxis: {
        max: 10000,
        min: 0,
        gridLineDashStyle: 'longdashdot',
        title: {
            text: ''
        },
         plotBands: [{
            color: 'rgba(150,150,150,0.05)',
            from: 2250,
            to: 3500,
            label: {
                text: '潜伏区',
                align: 'center',
                style: {
                    color: 'gray'
                }
            }
        },
        {
            color: 'rgba(150,150,150,0.2)',
            from: 3500,
            to: 5000,
            label: {
                text: '观察区',
                align: 'center',
                style: {
                    color: 'gray'
                }
            }
        },
        {
            color: 'rgba(150,150,150,0.35)',
            from: 5000,
            to: 7500,

            label: {
                text: '预警区',
                align: 'center',
                style: {
                    color: 'gray'
                }
            }
        },
        {
            color: 'rgba(150,150,150,0.5)',
            from: 7500,
            to: 10000,
            label: {
                text: '干预区',
                align: 'center',
                style: {
                    color: 'gray'
                }
            }
        }

        ],
        plotLines: [{
            value: 7500,

            color: '#ccc',
            zIndex: 1,
            width: 2

        },
        {
            value: 5000,
            color: '#ccc',
            width: 2,

            zIndex: 1

        },
        {
            value: 3500,
            color: '#ccc',

            zIndex: 1,
            width: 2
        },
        {
            value: 2250,
            color: '#CCC',

            zIndex: 1,
            width: 2
        }],
        labels: {
            formatter: function() {
                return this.value
            }
        }
    },
    tooltip: {
        formatter: function() {
            return '<b>' + this.series.name + '</b><br/>' + '<b>' + this.series.data[this.x - 1].time + '指数：</b>' + this.y;
        }
    },
    plotOptions: {
        line: {
            marker: {
                // enabled: false,
                radius: 3,
                lineColor: '#666666',
                lineWidth: 1
            }
        },
        series: {
            lineWidth: 4,
            cursor: 'pointer',
            point: {
                events: {
                    click: function() {
                        if (this.y >= 5000 && this.y < 7500) {
                            alert(this.series.name + '处于预警区，建议发布预警信号');
                        }
                        if (this.y > 7500) {
                            alert(this.series.name + '处于干预区，请立即采取干预手段');
                        }
                    }
                }
            }
        }

    },
    symbols: ['circle']
};

/* Highcharts.setOptions({
     colors: ['#94d6da','#009ad6','#145b7d','#11264f','#2468a2','#1b315e','#6a6da9','#6950a1','#472d56','#411445']
});*/
