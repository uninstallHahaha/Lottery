//layer
function showSearchList(slist) {
	//iframe窗
	layer.open({
		type: 2,
		title: false,
		closeBtn: 1, //不显示关闭按钮
		shade: [0],
		area: ['340px', '215px'],
		offset: 'rb', //右下角弹出
		time: 0,
		anim: 2,
		content: [slist, 'no'], //iframe的url，no代表不显示滚动条
	});
}

//nav-地点搜索
function placeSearch() {
	var address = $('#poiInput').val()
	searchPOI(address)
}

var timer;
//route-地点搜索
var inputN;

function routePoiSearch(f) {
	var address = '';
	f == 1 ? address = $('#start').val() : address = $('#end').val()
	f == 1 ? inputN = 1 : inputN = 2
	if(address == '' || address == null || address == undefined) {
		fadeOutt()
	}
	if(timer != null) {
		clearTimeout(timer)
		timer = null
	}

	timer = setTimeout(function() {
		searchPOI(address)
		timer = null
	}, 200)
}

//搜索poi - 返回相关点列表
function searchPOI(address) {

	//清除过期标记点
	//	clearPOI()

	//输出搜索结果
	var options = {
		renderOptions: {
			map: map
		},
		onSearchComplete: function(results) {
			if(local.getStatus() == BMAP_STATUS_SUCCESS) {
				// 判断状态是否正确      
				var slist = []
				var s = [];
				for(var i = 0; i < results.getCurrentNumPois(); i++) {
					s.push(results.getPoi(i).title + ", " + results.getPoi(i).address);
					slist.push({
						title: results.getPoi(i).title,
						address: results.getPoi(i).address,
						point: results.getPoi(1).point,
					})
				}
				//待选poi出现
				fadeInn(slist)
			}
		}
	};
	var local = new BMap.LocalSearch(map, options);
	local.search(address);
}

//自动获取定位
//		var geolocation = new BMap.Geolocation();
//		geolocation.getCurrentPosition(function(r) {
//			if(this.getStatus() == BMAP_STATUS_SUCCESS) {
//				var mk = new BMap.Marker(r.point);
//				map.addOverlay(mk);
//				map.panTo(r.point);
//				alert('您的位置：' + r.point.lng + ',' + r.point.lat);
//			} else {
//				alert('failed' + this.getStatus());
//			}
//		}, {
//			enableHighAccuracy: true
//		})

function routePlan() {
	//路线规划
	//	var startPoi = $('#start').val()
	//	var endPoi = $('#end').val()
	var transit = new BMap.TransitRoute(map, {
		renderOptions: {
			map: map,
			autoViewport: true

		},
		// 配置跨城公交的换成策略为优先出发早
		intercityPolicy: BMAP_INTERCITY_POLICY_EARLY_START,
		// 配置跨城公交的交通方式策略为飞机优先
		transitTypePolicy: BMAP_TRANSIT_TYPE_POLICY_AIRPLANE
	});
	//	var start = startPoint;
	//	var end =endPoint;
	transit.search(startPoint, endPoint);
}

//poi panel fadein and load poi list
function fadeInn(slist) {
	$("#planPoi").animate({
		top: '76px',
		opacity: '1.0'
	}, 250);

	var innerlist = ""
	slist.forEach((item, index) => {
		innerlist += "<li class='waitli' onclick=choosePOI(this) name='" + item.title + "' lng='" + item.point.lng + "'  lat='" + item.point.lat + "'>" + item.title + "</li>"
	})
	$("#waitPOI").html(innerlist)
}

function fadeOutt() {

	$("#planPoi").animate({
		top: '70px',
		opacity: '0'
	}, 250);
}

//loaction
var startPoint;
var endPoint;
//choose poi & set lng and lat
function choosePOI(q) {
	title = q.getAttribute('name')
	inputN == 1 ? $('#start').val(title) : $('#end').val(title)
	fadeOutt()
	inputN == 1 ? startPoint = new BMap.Point(q.getAttribute('lng'), q.getAttribute('lat')) : endPoint = new BMap.Point(q.getAttribute('lng'), q.getAttribute('lat'))
}

//清除过期poi
function clearPOI() {
	var len = map.getOverlays().length
	for(var i = 0; i < len; i++) {
		map.removeOverlay(map.getOverlays()[i]);
	}
}