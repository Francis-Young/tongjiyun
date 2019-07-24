<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html
    PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<%
   pageContext.setAttribute("Project_Path", request.getContextPath());

%>
    <title>吃在同济</title>
    
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
  
    <style>
        body {
            position: relative;
        }
        /* p{
       text-align: center;
       font-family:fantasy;
   }*/
        p {
            font-family: 'Times New Roman', Times, serif;
            font-size: 120%;
        }
    </style>

    <link type="text/css" href="css/style.css" rel="stylesheet" />

</head>

<body data-spy="scroll" data-target=".navbar" data-offset="50">
    <div class="container">
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="#section1">学苑饮食广场</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#section2">三好坞饮食广场</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#section3">半亩园餐厅</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#section4">北苑饮食广场</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#section5">西苑饮食广场</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#section6">南苑饮食广场</a>
                </li>
            </ul>
        </nav>

        <div id="section1" class="container-fluid " style="padding-top:70px;padding-bottom:70px">
            <h1>学苑饮食广场<small>${avScore1 }</small></h1>
            
            
            <div class="row">
                <div class="col-md-4">
                    <img class="img-fluid" src="css/6f3194c780e8644c5ef13abaebd083d.jpg">
                    <p class="mytext">冷面</p>
                </div>
                <div class="col-md-4">
                    <img class="img-fluid" src="吃在同济素材/学苑饮食广场/糖醋小排煲.jpg">
                    <p>糖醋小排煲</p>
                </div>
                <div class="col-md-4">
                    <img class="img-fluid" src="吃在同济素材/学苑饮食广场/红烧大排.jpg">
                    <p>汤</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <img src="吃在同济素材/学苑饮食广场/小锅米线.jpg">
                    <p>小锅米线</p>
                </div>
                <div class="col-md-6">
                    <img src="吃在同济素材/学苑饮食广场/照烧鸡腿.jpg">
                    <p>照烧鸡腿</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <img src="吃在同济素材/学苑饮食广场/青团.jpg" class="rounded-circle">
                    <p>青团</p>
                </div>
                <div class="col-md-6">
                    <img src="吃在同济素材/学苑饮食广场/冻酸奶.jpg" class="rounded-circle">
                    <p>冻酸奶</p>
                </div>
            </div>
            <div class="grade_warp">
                <div class="User_ratings User_grade" id="div_fraction0">
                    <div class="ratings_title01" id ="text1">
                    <%if (request.getAttribute("csScore1")!=null) {%><p>你的评分为${csScore1 }</p>
                    <p><span></span>再给这个食堂打个分吧？</p>
                    <%} else{%>
                        <p><span></span>-你给这个食堂打几分？</p><%} %>
                    </div>
                    <div class="ratings_bars">
                        <span id="title0">0</span>
                        <!--获取评分的值1-10-->
                        <span class="bars_10">0</span>
                        <div class="scale" id="bar0" style="background-color:skyblue">
                            <div></div>
                            <span id="btn0" style="background-color: skyblue"></span>
                        </div>
                        <span class="bars_10">10</span>
                    </div>
                </div>
            </div>
            <br><br>
            <button type="button" class="btn btn-default" id="xueyuan">提交</button>
        </div>
        <div id="section2" class="container-fluid " style="padding-top:70px;padding-bottom:70px">
            <h1>三好坞饮食广场<small>${avScore2 }</small></h1><p>三文鱼沙拉</p>
            <div class="row">
                <div class="col-md-3 ">
                    <img class="img-fuild" src="吃在同济素材/三好坞餐厅/三文鱼沙拉-2nd.jpg">
                    <p>三文鱼沙拉</p>
                </div>
                <div class="col-md-5">
                    <img src="吃在同济素材/三好坞餐厅/小排-2nd.jpg">
                    <p>小排</p>
                </div>
                <div class="col-md-4">
                    <img src="吃在同济素材/三好坞餐厅/小馄饨-2nd.jpg">
                    <p>小馄饨</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <img src="吃在同济素材/三好坞餐厅/快餐.jpg">
                    <p>快餐</p>
                </div>
                <div class="col-md-4">
                    <img src="吃在同济素材/三好坞餐厅/手抓饭.jpg">
                    <p>手抓饭</p>
                </div>
                <div class="col-md-4">
                    <img src="吃在同济素材/三好坞餐厅/桂花红烧肉.jpg">
                    <p>桂花红烧肉</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-5">
                    <img src="吃在同济素材/三好坞餐厅/沸腾鱼.jpg">
                    <p>沸腾鱼</p>
                </div>
                <div class="col-md-3">
                    <img src="吃在同济素材/三好坞餐厅/油炸小黄鱼-2nd.jpg">
                    <p>油炸小黄鱼</p>
                </div>
                <div class="col-md-4">
                    <img src="吃在同济素材/三好坞餐厅/麻辣烩-2nd.jpg">
                    <p>麻辣烩</p>
                </div>
            </div>
            <div class="grade_warp">
                <div class="User_ratings User_grade" id="div_fraction0">
                    <div class="ratings_title01" id = "text2">
                    <%if (request.getAttribute("csScore2")!=null) {%><p>你的评分为${csScore2 }</p>
                    <p><span></span>再给这个食堂打个分吧？</p>
                    <%} else{%>
                        <p><span></span>-你给这个食堂打几分？</p><%} %>
                    </div>
                    <div class="ratings_bars">
                        <span id="title1">0</span>
                        <!--获取评分的值1-10-->
                        <span class="bars_10">0</span>
                        <div class="scale" id="bar1" style="background-color:skyblue">
                            <div></div>
                            <span id="btn1" style="background-color: skyblue"></span>
                        </div>
                        <span class="bars_10">10</span>
                    </div>
                </div>
            </div>
            <br><br>
            <button type="button" class="btn btn-default" id="sanhaowu">提交</button>
            <div id="section3" class="container-fluid " style="padding-top:70px;padding-bottom:70px">
                <h1>半亩园餐厅<small>${avScore3 }</small></h1>
                <div class="row">
                    <div class="col-md-3">
                        <img src="吃在同济素材/半亩园/冒菜.jpg">
                        <p>冒菜</p>
                    </div>
                    <div class="col-md-5">
                        <img src="吃在同济素材/半亩园/照烧饭5.21.jpg">
                        <p>照烧饭</p>
                    </div>
                    <div class="col-md-4">
                        <img src="吃在同济素材/半亩园/半亩园一楼总览.jpg">
                        <p>一楼总览</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <img src="吃在同济素材/半亩园/定制盒饭.jpg">
                        <p>定制盒饭</p>
                    </div>
                    <div class="col-md-6">
                        <img src="吃在同济素材/半亩园/葱花鱼.jpg">
                        <p>葱花鱼</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <img src="吃在同济素材/半亩园/金针菇.jpg">
                        <p>金针菇</p>
                    </div>
                    <div class="col-md-6">
                        <img src="吃在同济素材/半亩园/鱿鱼.jpg">
                        <p>鱿鱼</p>
                    </div>
                </div>
                <div class="grade_warp">
                    <div class="User_ratings User_grade" id="div_fraction0">
                        <div class="ratings_title01" id = "text3">
                    <%if (request.getAttribute("csScore2")!=null) {%><p>你的评分为${csScore3 }</p>
                    <p><span></span>再给这个食堂打个分吧？</p>
                    <%} else{%>
                        <p><span></span>-你给这个食堂打几分？</p><%} %>
                        </div>
                        <div class="ratings_bars">
                            <span id="title2">0</span>
                            <!--获取评分的值1-10-->
                            <span class="bars_10">0</span>
                            <div class="scale" id="bar2" style="background-color:skyblue">
                                <div></div>
                                <span id="btn2" style="background-color: skyblue"></span>
                            </div>
                            <span class="bars_10">10</span>
                        </div>
                    </div>
                </div>
                <br><br>
                <button type="button" class="btn btn-default" id="banmuyuan">提交</button>
            </div>
        </div>
        <div id="section4" class="container-fluid " style="padding-top:70px;padding-bottom:70px">
            <h1>北苑饮食广场<small>${avScore4 }</small></h1>
            <div class="row">
                <div class="col-md-6">
                    <img src="吃在同济素材/北苑食堂/双拼饭.jpg">
                    <p>双拼饭</p>
                </div>
                <div class="col-md-6">
                    <img src="吃在同济素材/北苑食堂/泡菜牛肉.jpg">
                    <p>泡菜牛肉</p>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <img src="吃在同济素材/北苑食堂/总览.jpg">
                        <p>总览</p>
                    </div>
                    <div class="col-md-6">
                        <img src="吃在同济素材/北苑食堂/鱿鱼.jpg">
                        <p>鱿鱼</p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <img src="吃在同济素材/北苑食堂/牛排.jpg">
                    <p>牛排</p>
                </div>

                <div class="col-md-6">
                    <img src="吃在同济素材/北苑食堂/牛蛙套餐.jpg">
                    <p>牛蛙套餐</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <img src="吃在同济素材/北苑食堂/羊肉串.jpg">
                    <p>羊肉串</p>
                </div>
                <div class="col-md-6">
                    <img src="吃在同济素材/北苑食堂/麻辣香锅2.jpg">
                    <p>麻辣香锅</p>
                </div>
            </div>
            <div class="grade_warp">
                <div class="User_ratings User_grade" id="div_fraction0">
                    <div class="ratings_title01" id = "text4">
                    <%if (request.getAttribute("csScore4")!=null) {%><p>你的评分为${csScore2 }</p>
                    <p><span></span>再给这个食堂打个分吧？</p>
                    <%} else{%>
                        <p><span></span>-你给这个食堂打几分？</p><%} %>
                    </div>
                    <div class="ratings_bars">
                        <span id="title3">0</span>
                        <!--获取评分的值1-10-->
                        <span class="bars_10">0</span>
                        <div class="scale" id="bar3" style="background-color:skyblue">
                            <div></div>
                            <span id="btn3" style="background-color: skyblue"></span>
                        </div>
                        <span class="bars_10">10</span>
                    </div>
                </div>
            </div>
            <br><br>
            <button type="button" class="btn btn-default" id="beiyuan">提交</button>
        </div>
        <div id="section5" class="container-fluid " style="padding-top:70px;padding-bottom:70px">
            <h1>西苑饮食广场<small>${avScore5 }</small></h1>
            <div class="row">
                <div class="col-md-4">
                    <img src="吃在同济素材/大排档/全家福火锅.jpg">
                    <p>全家福火锅</p>
                </div>
                <div class="col-md-4">
                    <img src="吃在同济素材/大排档/小龙虾.jpg">
                    <p>小龙虾</p>
                </div>
                <div class="col-md-4">
                    <img src="吃在同济素材/大排档/干锅鱿鱼虾.jpg">
                    <p>干锅鱿鱼虾</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <img src="吃在同济素材/大排档/总览.jpg">
                    <p>总览</p>
                </div>
                <div class="col-md-4">
                    <img src="吃在同济素材/大排档/麻婆豆腐.jpg">
                    <p>麻婆豆腐</p>
                </div>

                <div class="col-md-4">
                    <img src="吃在同济素材/大排档/烧烤.jpg">
                    <p>烧烤</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <img src="吃在同济素材/大排档/粥&油条.jpg">
                    <p>粥&油条</p>
                </div>
                <div class="col-md-4">
                    <img src="吃在同济素材/大排档/羊肉火锅.jpg">
                    <p>定制盒饭</p>
                </div>
                <div class="col-md-4">
                    <img src="吃在同济素材/大排档/蛋糕.jpg">
                    <p>蛋糕</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4">
                    <img src="吃在同济素材/大排档/烤鱼.jpg">
                    <p>烤鱼</p>
                </div>
            </div>
        </div>
        <div class="grade_warp">
            <div class="User_ratings User_grade" id="div_fraction0">
                <div class="ratings_title01" id = "text5">
                    <%if (request.getAttribute("csScore5")!=null) {%><p>你的评分为${csScore2 }</p>
                    <p><span></span>再给这个食堂打个分吧？</p>
                    <%} else{%>
                        <p><span></span>-你给这个食堂打几分？</p><%} %>
                </div>
                <div class="ratings_bars">
                    <span id="title4">0</span>
                    <!--获取评分的值1-10-->
                    <span class="bars_10">0</span>
                    <div class="scale" id="bar4" style="background-color:skyblue">
                        <div></div>
                        <span id="btn4" style="background-color: skyblue"></span>
                    </div>
                    <span class="bars_10">10</span>
                </div>
            </div>
        </div>
        <br><br>
        <button type="button" class="btn btn-default" id="xiyuan">提交</button>
        <div id="section6" class="container-fluid" style="padding-top:70px;padding-bottom:70px">
            <h1>南苑饮食广场<small>${avScore6 }</small></h1>
            <p>期待！！！</p>
        </div>
    </div>

    <!-- 评分功能 -->
    <script>
    function handin(resid,score){
    	var x1 = document.getElementById("testid").innerText;  
  	    var msg = $("#cardId_msg");	//JQuery获取
  	    var info = "";	//提示信息
  		    $.ajax({
  		        type: "POST",
  		        url: "${pageContext.request.contextPath}/eatSetScoreServlet", //链接指向地址
  		        dataType:"json",
  		        data: {"resid":resid,"score":score},  //形成一对key-value，提交对象可以通过request.getParameter("cardId");获得val值
  		        success: function(data){    //提交成功后调用的方法
  		        	
  	              console.log(data);
  		        	if(data.toString()=="true"){    //后台返回表示重名
  	                    info = "*已存在";  //提示信息
  	                    msg.css("color", "red");    //修改样式
  	                    msg.html(info); //显示提示信息
  	                    $("#update").attr("disabled", true);    //按钮disabled
  	                    //console.log("已存在");
  	                }else if(data.toString()=="false") {
  	                    info = "*通过";
  	                    msg.css("color", "green");
  	                    msg.html(info);
  	                    $("#update").removeAttr("disabled");	//取消按钮disabled
  	                    //console.log("有效");
  	                }
  		        else {alert("ajax未执行！")}
  		        },
  		        
  		    });
  		}  //按钮disabled 
    </script>
       <script type="text/javascript">
    window.onload=function(){
        var r0 = document.getElementById("xueyuan");
        var r1 = document.getElementById("sanhaowu");
        var r2 = document.getElementById("banmuyuan");
        var r3 = document.getElementById("beiyuan");
        var r4 = document.getElementById("xiyuan");
        r0.onclick=function(){
            var score = document.getElementById("title0").innerText;
            var resid = "1";

            //XHR对象执行，发出Http请求，页面不用刷新
            var xhr = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject('Microsoft.XMLHTTP'); //创建XMLHTTP对象，考虑兼容性
            xhr.open("POST","eatSetScoreServlet?action=r0&score="+score+"&resid="+resid,true);
            xhr.onreadystatechange=function(){
                //alert("onreadystatechange,readyState="+xhr.readyState);
                if(xhr.readyState==4)//服务器返回了
                {
                    if(xhr.status==200)//xhr.status http状态码
                    {
                        alert(xhr.responseText);//xhr.responseText返回的报文体
                        document.getElementById("text1").innerText = xhr.responseText;
                        //根据服务器返回的内容更新需要更新的内容
                    }
                    else
                    {
                        alert("服务器返回错误"+xhr.readyState);
                    }
                }
            };
            //alert("send之前");
            xhr.send();//发出请求。并不会等服务器返回send方法才结束，因为我们需要提前监听xhr.onreadystatechange
            // 事件，以便得知“服务器返回了”
            //alert("send之后");
        };
        r1.onclick=function(){
            var score = document.getElementById("title1").innerText;
            var resid = "2";

            //XHR对象执行，发出Http请求，页面不用刷新
            var xhr = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject('Microsoft.XMLHTTP'); //创建XMLHTTP对象，考虑兼容性
            xhr.open("POST","eatSetScoreServlet?action=r1&score="+score+"&resid="+resid,true);
            xhr.onreadystatechange=function(){
                //alert("onreadystatechange,readyState="+xhr.readyState);
                if(xhr.readyState==4)//服务器返回了
                {
                    if(xhr.status==200)//xhr.status http状态码
                    {
                        alert(xhr.responseText);//xhr.responseText返回的报文体
                        document.getElementById("text2").innerText = xhr.responseText;
                        //根据服务器返回的内容更新需要更新的内容
                    }
                    else
                    {
                        alert("服务器返回错误"+xhr.readyState);
                    }
                }
            };
            //alert("send之前");
            xhr.send();//发出请求。并不会等服务器返回send方法才结束，因为我们需要提前监听xhr.onreadystatechange
            // 事件，以便得知“服务器返回了”
            //alert("send之后");
        };
        r2.onclick=function(){
            var score = document.getElementById("title2").innerText;
            var resid = "3";

            //XHR对象执行，发出Http请求，页面不用刷新
            var xhr = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject('Microsoft.XMLHTTP'); //创建XMLHTTP对象，考虑兼容性
            xhr.open("POST","eatSetScoreServlet?action=r2&score="+score+"&resid="+resid,true);
            xhr.onreadystatechange=function(){
                //alert("onreadystatechange,readyState="+xhr.readyState);
                if(xhr.readyState==4)//服务器返回了
                {
                    if(xhr.status==200)//xhr.status http状态码
                    {
                        alert(xhr.responseText);//xhr.responseText返回的报文体
                        document.getElementById("text3").innerText = xhr.responseText;
                        //根据服务器返回的内容更新需要更新的内容
                    }
                    else
                    {
                        alert("服务器返回错误"+xhr.readyState);
                    }
                }
            };
            //alert("send之前");
            xhr.send();//发出请求。并不会等服务器返回send方法才结束，因为我们需要提前监听xhr.onreadystatechange
            // 事件，以便得知“服务器返回了”
            //alert("send之后");
        };
        r3.onclick=function(){
            var score = document.getElementById("title3").innerText;
            var resid = "4";

            //XHR对象执行，发出Http请求，页面不用刷新
            var xhr = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject('Microsoft.XMLHTTP'); //创建XMLHTTP对象，考虑兼容性
            xhr.open("POST","eatSetScoreServlet?action=r3&score="+score+"&resid="+resid,true);
            xhr.onreadystatechange=function(){
                //alert("onreadystatechange,readyState="+xhr.readyState);
                if(xhr.readyState==4)//服务器返回了
                {
                    if(xhr.status==200)//xhr.status http状态码
                    {
                        alert(xhr.responseText);//xhr.responseText返回的报文体
                        document.getElementById("text4").innerText = xhr.responseText;
                        //根据服务器返回的内容更新需要更新的内容
                    }
                    else
                    {
                        alert("服务器返回错误"+xhr.readyState);
                    }
                }
            };
            //alert("send之前");
            xhr.send();//发出请求。并不会等服务器返回send方法才结束，因为我们需要提前监听xhr.onreadystatechange
            // 事件，以便得知“服务器返回了”
            //alert("send之后");
        };
        r4.onclick=function(){
            var score = document.getElementById("title4").innerText;
            var resid = "5";

            //XHR对象执行，发出Http请求，页面不用刷新
            var xhr = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject('Microsoft.XMLHTTP'); //创建XMLHTTP对象，考虑兼容性
            xhr.open("POST","eatSetScoreServlet?action=r4&score="+score+"&resid="+resid,true);
            xhr.onreadystatechange=function(){
                //alert("onreadystatechange,readyState="+xhr.readyState);
                if(xhr.readyState==4)//服务器返回了
                {
                    if(xhr.status==200)//xhr.status http状态码
                    {
                        alert(xhr.responseText);//xhr.responseText返回的报文体
                        document.getElementById("text5").innerText = xhr.responseText;
                        //根据服务器返回的内容更新需要更新的内容
                    }
                    else
                    {
                        alert("服务器返回错误"+xhr.readyState);
                    }
                }
            };
            //alert("send之前");
            xhr.send();//发出请求。并不会等服务器返回send方法才结束，因为我们需要提前监听xhr.onreadystatechange
            // 事件，以便得知“服务器返回了”
            //alert("send之后");
        };
    };
    
</script>
    <!-- 滑动条 -->
    <script type="text/javascript">
        scale = function (btn, bar, title) {
            this.btn = document.getElementById(btn);
            this.bar = document.getElementById(bar);
            this.title = document.getElementById(title);
            this.step = this.bar.getElementsByTagName("DIV")[0];
            this.init();
        };
        scale.prototype = {
            init: function () {
                var f = this,
                    g = document,
                    b = window,
                    m = Math;
                f.btn.onmousedown = function (e) {
                    var x = (e || b.event).clientX;
                    var l = this.offsetLeft;
                    var max = f.bar.offsetWidth - this.offsetWidth;
                    g.onmousemove = function (e) {
                        var thisX = (e || b.event).clientX;
                        var to = m.min(max, m.max(-2, l + (thisX - x)));
                        f.btn.style.left = to + 'px';
                        f.ondrag(m.round(m.max(0, to / max) * 10), to);
                        b.getSelection ? b.getSelection().removeAllRanges() : g.selection.empty();
                    };
                    g.onmouseup = new Function('this.onmousemove=null');
                };
            },
            ondrag: function (pos, x) {
                this.step.style.width = Math.max(0, x) + 'px';
                this.title.innerHTML = pos / 1 + '';
            }
        }
        new scale('btn0', 'bar0', 'title0');
        new scale('btn1', 'bar1', 'title1');
        new scale('btn2', 'bar2', 'title2');
        new scale('btn3', 'bar3', 'title3');
        new scale('btn4', 'bar4', 'title4');
        
        
    </script>
 
</body>

</html>