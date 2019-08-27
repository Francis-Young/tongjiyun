<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>百度地图API</title>
    <!-- baidu map -->
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
        body,
        html,
        #allmap {
            width: 100%;
            height: 100%;
            overflow: hidden;
            margin: 0;
            font-family: "微软雅黑";
        }
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=H7xFX2Kou46Bt7TpOH4NxwELfxNEd0iF">
    </script>
</head>

<body>
    <div id="allmap"></div>
     <script type="text/javascript">
    //百度地图API功能    
    var map = new BMap.Map("allmap");
    map.centerAndZoom(new BMap.Point(121.508532, 31.289027), 20); //根据坐标初始化地图   
    map.enableScrollWheelZoom(true);
    map.addControl(new BMap.NavigationControl()); //平移缩放控件    
    map.addControl(new BMap.ScaleControl()); //比例尺    
    map.addControl(new BMap.OverviewMapControl()); //缩略地图    
    map.addControl(new BMap.MapTypeControl()); //地图类型    
    map.setCurrentCity("上海"); // 仅当设置城市信息时，MapTypeControl的切换功能才能可用     
    //添加标注   
    var marker = new BMap.Marker(new BMap.Point(121.508532, 31.289027)); // 创建标注    
    map.addOverlay(marker); // 将标注添加到地图中

    map.addTileLayer(new BMap.PanoramaCoverageLayer());

    var stCtrl = new BMap.PanoramaControl(); //构造全景控件
    stCtrl.setOffset(new BMap.Size(20, 20));
    map.addControl(stCtrl); //添加全景控件
</script>
<script type="text/javascript">
	// 百度地图API功能
	var json_data = [[121.50941,31.288154],[121.504559,31.288679],[121.507344,31.292066],[121.510246,31.290939],[121.507174,31.287626]];
	var pointArray = new Array();
	for(var i=0;i<json_data.length;i++){
		var marker = new BMap.Marker(new BMap.Point(json_data[i][0], json_data[i][1])); // 创建点
		map.addOverlay(marker);    //增加点
		pointArray[i] = new BMap.Point(json_data[i][0], json_data[i][1]);
		marker.addEventListener("click",attribute);
	}
	//让所有点在视野范围内
	map.setViewport(pointArray);
	//获取覆盖物位置
	function attribute(e){
		var p = e.target;
		alert("marker的位置是" + p.getPosition().lng + "," + p.getPosition().lat);    
		window.location.href="http://localhost:8080/myTry/NewEatInTongji.jsp";
	}	
</script>
</body>
</html>
