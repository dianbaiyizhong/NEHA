$(function() {
　　/*id为中国省份标识符，name为对应省份名称，两者固定。event为活动情况，
　　url为活动列表页面地址，数据可后台动态生成，这两项有活动的地区填写，无则留空。*/
　　var dataStatus = [
　　　　{ id: 'HKG', name: '香港', event: '', url: '' },
　　　　{ id: 'HAI', name: '海南', event: '', url: '' },
　　　　{ id: 'YUN', name: '云南', event: '', url: '' },
　　　　{ id: 'BEJ', name: '北京', event: '', url: '' },
　　　　{ id: 'TAJ', name: '天津', event: '', url: '' },
　　　　{ id: 'XIN', name: '新疆', event: '', url: '' },
　　　　{ id: 'TIB', name: '西藏', event: '', url: '' },
　　　　{ id: 'QIH', name: '青海', event: '', url: '' },
　　　　{ id: 'GAN', name: '甘肃', event: '', url: '' },
　　　　{ id: 'NMG', name: '内蒙古', event: '', url: '' },
　　　　{ id: 'NXA', name: '宁夏', event: '', url: '' },
　　　　{ id: 'SHX', name: '山西', event: '', url: '' },
　　　　{ id: 'LIA', name: '辽宁', event: '', url: '' },
　　　　{ id: 'JIL', name: '吉林', event: '', url: '' },
　　　　{ id: 'HLJ', name: '黑龙江', event: '', url: '' },
　　　　{ id: 'HEB', name: '河北', event: '', url: '' },
　　　　{ id: 'SHD', name: '山东', event: '', url: '' },
　　　　{ id: 'HEN', name: '河南', event: '', url: '' },
　　　　{ id: 'SHA', name: '陕西', event: '', url: '' },
　　　　{ id: 'SCH', name: '四川', event: ' ', url: '/event/2' },
　　　　{ id: 'CHQ', name: '重庆', event: '', url: '' },
　　　　{ id: 'HUB', name: '湖北', event: ' ', url: '/event/3' },
　　　　{ id: 'ANH', name: '安徽', event: '', url: '' },
　　　　{ id: 'JSU', name: '江苏', event: '', url: '' },
　　　　{ id: 'SHH', name: '上海', event: '', url: '' },
　　　　{ id: 'ZHJ', name: '浙江', event: '', url: '' },
　　　　{ id: 'FUJ', name: '福建', event: '', url: '' },
　　　　{ id: 'TAI', name: '台湾', event: '', url: '' },
　　　　{ id: 'JXI', name: '江西', event: '', url: '' },
　　　　{ id: 'HUN', name: '湖南', event: '', url: '' },
　　　　{ id: 'GUI', name: '贵州', event: '', url: '' },
　　　　{ id: 'GXI', name: '广西', event: '', url: '' }, 
　　　　{ id: 'GUD', name: '广东', event: '', url: '' }
　　];

　　$('#map').vectorMap({
　　　　map: 'china_zh',
　　　　backgroundColor: false,
　　　　color: "#BBBBBB",
　　　　hoverColor: false,
　　　　//显示各地区名称和活动
　　　　onLabelShow: function (event, label, code) {
　　　　　　$.each(dataStatus, function (i, items) {
　　　　　　　　if (code == items.id) {
　　　　　　　　　　label.html(items.name + items.event);
　　　　　　　　}
　　　　　　});
　　　　},
　　　　//鼠标移入省份区域，改变鼠标状态
　　　　onRegionOver: function(event, code){
　　　　　　$.each(dataStatus, function (i, items) {
　　　　　　　　if ((code == items.id) && (items.event != '')) {
　　　　　　　　　　$('#map').css({cursor:'pointer'});
　　　　　　　　}
　　　　　　});
　　　　},
　　　　//鼠标移出省份区域，改回鼠标状态
　　　　onRegionOut: function(event, code){
　　　　　　$.each(dataStatus, function (i, items) {
　　　　　　　　if ((code == items.id) && (items.event != '')) {
　　　　　　　　　　$('#map').css({cursor:'auto'});
　　　　　　　　}
　　　　　　});
　　　　},
　　　　//点击有活动的省份区域，打开对应活动列表页面
　　　　onRegionClick: function(event, code){
　　　　　　$.each(dataStatus, function (i, items) {
　　　　　　　　if ((code == items.id) && (items.event != '')) {
　　　　　　　　　　window.location.href = items.url;
　　　　　　　　}
　　　　　　});
　　　　}　　
　　});
　　//改变有活动省份区域的颜色
　　$.each(dataStatus, function (i, items) {
　　　　if (items.event != '') {
　　　　　　var josnStr = "{" + items.id + ":'red'}";
　　　　　　$('#map').vectorMap('set', 'colors', eval('(' + josnStr + ')'));
　　　　}
　　});
});