<%@ page language="java" contentType="text/html; charset=utf-8" import ="java.util.List,com.lewei.test.rankManage,daos.RankDao,beans.Rank"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JustForLove</title>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="">


  <link rel="stylesheet" href="assets/styles/style.css">
  <link type="text/css" href="css/style.css" rel="stylesheet" >
  <link rel="stylesheet" href="css/bootstrap.css"><!-- 最后引入bootstrap.css文件，使得冲突的样式以Bootstrap风格展示 -->
  <script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
  
<!--色块旋转效果-->
<style>
.MyNav:hover {
	background-color: #00f;
	transform: translateX(800px) translateY(500px) scale(0.5) rotate(360deg);
}

#MySection1 {
	position: absolute;
	left: 0px;
	top: 0px;
	z-index: 10;
	background-color: rgba(255,0,0,0.5);
	width: 100px;
	height: 100px;
	transition: all 5s;
}

#MySection2 {
	position: absolute;
	left: 0px;
	top: 0px;
	z-index: 10;
	width: 100px;
	height: 100px;
	background-color: rgba(251, 255, 0,0.5);
	transition: all 5s;
}

#MySection3 {
	position: absolute;
	left: 0px;
	top: 0px;
	z-index: 10;
	width: 100px;
	height: 100px;
	background-color: rgba(60, 255, 0,0.5);
	transition: all 5s;
}

#MySection4 {
	position: absolute;
	left: 0px;
	top: 0px;
	z-index: 10;
	width: 100px;
	height: 100px;
	background-color: rgba(0, 47, 255,0.5);
	transition: all 5s;
}

#MySection5 {
	position: absolute;
	left: 0px;
	top: 0px;
	z-index: 10;
	width: 100px;
	height: 100px;
	background-color: rgba(153, 0, 255,0.5);
	transition: all 5s;
}
</style>
<!--设置多层的效果-->
<style>
.outer-box {
	position: relative;
	color: #000;
	border: 0px solid #000;
	width: 100px;
	height: 100px
}

/*border可以用于定位元素，调试时很有用*/
</style>
<!--将覆盖的文字采用居中的效果-->
<style>
.MyNavItem {
	width: 100%;
	/*相对父级元素设置宽度*/
	height: 150px;
	/*绝对的方式设置高度*/
	text-align: center;
	line-height: 100px;
	/*设置子元素的垂直高度与父级元素的垂直高度相同*/
	vertical-align: middle;
}
</style>

<style type="text/css">
     #div1 {background:#09c;}
     #div11{height:500px;width:1050px; position:relative; margin:10px auto;}

#div11 a{position:absolute;top:10px;left:10px;color:#fff;font-weight:bold;padding:3px 6px;}

#div11 a:hover{border:1px solid #eee;background:#000;border-radius:5px;}
</style>


</head>

<body>
    <header id="masthead" class="site-header site-header--fluid bg-primary">
  <div class="d-lg-flex justify-content-lg-between align-items-lg-center site-header__container">
    <div class="d-lg-flex align-items-lg-center">
      <div class="site-header__logo">
        <a href="index.html">
          <h1 class="screen-reader-text">Listiry</h1>
          <img src="assets/images/logo-1.png" alt="Listiry">
        </a>
      </div><!-- .site-header__logo -->

      <form class="search-form" action="index.html">
        <div class="form-group__wrapper">
          <input type="text" name="place" placeholder="coffee shop, dinner..." class="form-input form-input--no-br">
        </div>
        <div class="form-group__wrapper">
          <input type="text" name="location" placeholder="location" class="form-input form-input--no-br">
          <a href="#" class="form-group__action c-dusty-gray">
            <i class="fa fa-map-marker"></i>
          </a>
        </div>
        <div class="form-group__wrapper">
          <button type="submit" class="button button--primary button--medium">
            <i class="fa fa-search"></i>
          </button>
        </div>
      </form>
    </div>

    <div class="d-lg-flex align-items-lg-center">
      <ul class="min-list main-navigation main-navigation--white">
        <li>
          <a href="#">Home</a>
          <ul class="min-list">
            <li>
              <a href="index.html">Home 1</a>
            </li>
            <li>
              <a href="index-2.html">Home 2</a>
            </li>
            <li>
              <a href="index-3.html">Home 3</a>
            </li>
            <li>
              <a href="index-4.html">Home 4</a>
            </li>
          </ul>
        </li>
        <li>
          <a href="#">吃在同济</a>
          <ul class="min-list">
            <li>
              <a href="listing-1.html">Listings Column Map 1</a>
            </li>
            <li>
              <a href="listing-2.html">Listings Column Map 2</a>
            </li>
            <li>
              <a href="listing-3.html">Listings Column Map 3</a>
            </li>
            <li>
              <a href="listing-5.html">Listings Fullwidth Map</a>
            </li>
            <li>
              <a href="listing-4.html">Listings Without Map</a>
            </li>
          </ul>
        </li>
        <li>
          <a href="#">学在同济</a>
          <ul class="min-list">
            <li>
              <a href="single-listing-1.html">Single Listing 1</a>
            </li>
            <li>
              <a href="single-listing-2.html">Single Listing 2</a>
            </li>
            <li>
              <a href="single-listing-3.html">Single Listing 3</a>
            </li>
            <li>
              <a href="single-listing-4.html">Single Listing 4</a>
            </li>
          </ul>
        </li>
        <li>
          <a href="#">住在同济</a>
          <ul class="min-list">
            <li>
              <a href="#">My Account</a>
              <ul class="min-list">
                <li>
                  <a href="profile.html">My Profile</a>
                </li>
                <li>
                  <a href="my-listings.html">My Listings</a>
                </li>
                <li>
                  <a href="bookmarked-listings.html">Bookmarked Listings</a>
                </li>
                <li>
                  <a href="change-password.html">Change Password</a>
                </li>
              </ul>
            </li>
            <li>
              <a href="contact.html">Contact</a>
            </li>
            <li>
              <a href="coming-soon.html">Coming Soon</a>
            </li>
            <li>
              <a href="404.html">404 Page</a>
            </li>
            <li>
              <a href="pricing-table.html">Pricing Table</a>
            </li>
            <li>
              <a href="login.html">Login/Signup</a>
            </li>
          </ul>
        </li>
        <li>
          <a href="blog.html">爱在同济</a>
        </li>
      </ul><!-- .main-navigation -->

      <div class="user-action">
        <a href="login.html" class="sign-in c-white">
          <i class="fa fa-user"></i>
                    登录
        </a>
        <button class="button button--small button--pill button--primary d-none d-lg-inline-block">&plus; Add Listing</button>
      </div><!-- .user-action -->
    </div>

    <div class="d-lg-none nav-mobile">
      <a href="#" class="nav-toggle js-nav-toggle nav-toggle--white">
        <span></span>
      </a><!-- .nav-toggle -->
    </div><!-- .nav-mobile -->
  </div><!-- .site-header__container -->
</header><!-- #masthead -->

	<div class="row">
		<div class="col-lg-1 col-md-1 col-sm-1">
			<div class="outer-box">
				<a id="item1">
					<h3 class="MyNavItem">流量云</h3>
				</a>
				<div class="MyNav" id="MySection1"></div>
			</div>
		</div>
		<div class="col-lg-9 col-md-9 col-sm-9">
		
			<div id="div1"
				style="display: none; width: 1250px; height: 700px; border: 1px solid blue; margin: 25px" >
				
				<jsp:include page="textyuntest.jsp" flush="true"></jsp:include>
				<!-- 
				<img src="https://hbimg.huabanimg.com/bffe1c8bebe9872f3e537ac9e699bd65b9249ea71ee4-SUPCnz_fw658"/>
			

          <div id="div11" class="col-lg-offset-3"> -->

</div>
</div>
				
			
			<div id="div2"
				style="display: none; width: 1250px; height: 700px; border: 1px solid blue; margin: 25px">
				<!-- 手风琴效果 -->
				<div class="panel-group" id="accordion" role="tablist">
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingOne">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapseOne">第一条</a>
							</h4>
						</div>
						<div id="collapseOne" class="panel-collapse collapse in"
							role="tabpanel">
							<div class="panel-body">我想我就是我，我相信明天，我相信伸手就能碰到天！
								我想我就是我，我相信明天，我相信伸手就能碰到天！ 我想我就是我，我相信明天，我相信伸手就能碰到天！
								我想我就是我，我相信明天，我相信伸手就能碰到天！ 我想我就是我，我相信明天，我相信伸手就能碰到天！</div>
						</div>
					</div>

					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingTwo">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapseTwo">第二条</a>
							</h4>
						</div>
						<div id="collapseTwo" class="panel-collapse collapse "
							role="tabpanel">
							<div class="panel-body">我想我就是我，我相信明天，我相信伸手就能碰到天！
								我想我就是我，我相信明天，我相信伸手就能碰到天！ 我想我就是我，我相信明天，我相信伸手就能碰到天！
								我想我就是我，我相信明天，我相信伸手就能碰到天！ 我想我就是我，我相信明天，我相信伸手就能碰到天！</div>
						</div>
					</div>

					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingThree">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapseThree">第三条</a>
							</h4>
						</div>
						<div id="collapseThree" class="panel-collapse collapse "
							role="tabpanel">
							<div class="panel-body">我想我就是我，我相信明天，我相信伸手就能碰到天！
								我想我就是我，我相信明天，我相信伸手就能碰到天！ 我想我就是我，我相信明天，我相信伸手就能碰到天！
								我想我就是我，我相信明天，我相信伸手就能碰到天！ 我想我就是我，我相信明天，我相信伸手就能碰到天！</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingThree">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapseFour">第四条</a>
							</h4>
						</div>
						<div id="collapseFour" class="panel-collapse collapse "
							role="tabpanel">
							<div class="panel-body">我相信我就是我，我相信明天，我相信伸手就能碰到天！
								我想我就是我，我相信明天，我相信伸手就能碰到天！ 我想我就是我，我相信明天，我相信伸手就能碰到天！
								我想我就是我，我相信明天，我相信伸手就能碰到天！ 我想我就是我，我相信明天，我相信伸手就能碰到天！</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingThree">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapseFive">第五条</a>
							</h4>
						</div>
						<div id="collapseFive" class="panel-collapse collapse "
							role="tabpanel">
							<div class="panel-body">我想我就是我，我相信明天，我相信伸手就能碰到天！
								我想我就是我，我相信明天，我相信伸手就能碰到天！ 我想我就是我，我相信明天，我相信伸手就能碰到天！
								我想我就是我，我相信明天，我相信伸手就能碰到天！ 我想我就是我，我相信明天，我相信伸手就能碰到天！</div>
						</div>
					</div>
				</div>
				<!-- 分页 -->
				<!--跳转到本页面后台刷新？？-->
				<div class="text-center">
					<ul class="pagination">
						<li><a href="#">&laquo;</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">6</a></li>
						<li><a href="#">7</a></li>
						<li><a href="#">8</a></li>
						<li><a href="#">9</a></li>
						<li><a href="#">10</a></li>
						<li><a href="#">&raquo;</a></li>
					</ul>
				</div>
			</div>
			<!--付费搜功能-->
			<div id="div3"
				style="display: none; width: 1250px; height: 700px; border: 1px solid blue; margin: 25px">
				<div class="col-sm-6 col-lg-6 col-sm-offset-3">
				
				<%@include file="static/search.jsp" %>
					<!--注释掉原来内容：<h4>快来搜搜吧！转换为jsp时，原本是一个实时留言板</h4>
					 
					-->
				</div>
				</div>

				<div id="div4"
					style="display: none; width: 1250px; height: 700px; border: 1px solid blue; margin: 25px">
					<div class="jumbotron">
						<div class="container">
							<h2>给稀罕的那个Ta发个信件吧</h2>
							<p>哈哈</p>
							<p>
								<a class="btn btn-info btn-lg" onclick="showMyMessage()">查看我收到的信息</a>
							</p>
							<p>
								<a class="btn btn-info btn-lg" onclick="sendMyMessage()">给Ta发</a>
							</p>
						</div>
					</div>
					<div class="container">
						<p id="MyMessage">1111111111111111111111</p>
						<div id="MySend">
							<form role="form" class="form-horizontal">
								<div class="form-group">
									<label class="control-label col-lg-3 col-md-3 col-sm-3">用户名</label>
									<div class="col-lg-5 col-md-5 col-sm-5">
										<input type="text" class="form-control" placeholder="user">
									</div>
								</div>
								<div class="form-group">
									<label for="name"
										class="control-label col-lg-3 col-md-3 col-sm-3">文本框</label>
									<div class="col-lg-5 col-md-5 col-sm-5">
										<textarea class="form-control" rows="7"></textarea>
									</div>
								</div>
								<div class="form-group">
									<div class="col-lg-offset-5 col-md-offset-5 col-sm-offset-5">
										<button type="submit" class="btn btn-default">发送</button>
									</div>
								</div>
							</form>
						</div>
					</div>

				</div>

				<div id="div5"
					style="display: none; width: 650px; height: 300px; border: 1px solid blue; margin: 40px 300px">
					<!--轮播/旋转木马效果-->
					<div id="carousel-example-generic" class="carousel slide">
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
						</ol>
						<div class="carousel-inner">
							<div class="item active">
								<img src="assets/images/beauty-2.svg">
								<div class="carousel-caption">
									<h3>我是五星上将</h3>
									<p>dgfhfk</p>
								</div>
							</div>
							<div class="item">
								<img src="assets/images/cinema.svg">
								<h3>曾梦想仗剑走天涯</h3>
								<p>tttttt</p>
							</div>
							<div class="item">
								<img src="assets/images/beauty-1.svg">
								<h3>繁华</h3>
								<p>hhhhh</p>
							</div>
						</div>
						<a class="left carousel-control" href="#carousel-example-generic"
							data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left"></span>
						</a> <a class="right carousel-control"
							href="#carousel-example-generic" data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right"></span>
						</a>
					</div>
				</div>
				<div id="div6"
					style="display: none; width: 1200px; height: 300px; border: 1px solid blue; margin: 0px 0px">
					<div id="MySend">
						<form role="form" class="form-horizontal">
							<div class="form-group">
								<label class="control-label col-lg-3 col-md-3 col-sm-3">用户名</label>
								<div class="col-lg-5 col-md-5 col-sm-5">
									<input type="text" class="form-control" placeholder="user">
								</div>
							</div>
							<div class="form-group">
								<label for="name"
									class="control-label col-lg-3 col-md-3 col-sm-3">文本框</label>
								<div class="col-lg-5 col-md-5 col-sm-5">
									<textarea class="form-control" rows="7"></textarea>
								</div>
							</div>
							<div class="form-group">
								<div class="col-lg-offset-5 col-md-offset-5 col-sm-offset-5">
									<button type="submit" class="btn btn-default">发送</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-2">
				<div class="outer-box">
					<a href="#" id="item2">
						<h3 class="MyNavItem">昨日墙</h3>
					</a>
					<div class="MyNav" id="MySection2"></div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-2">
				<div class="outer-box">
					<a href="#" id="item3">
						<h3 class="MyNavItem">付费搜</h3>
					</a>
					<div class="MyNav" id="MySection3"></div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-2">
				<div class="outer-box">
					<a href="#" id="item4">
						<h3 class="MyNavItem">站内信</h3>
					</a>
					<div class="MyNav" id="MySection4"></div>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-2">
				<div class="outer-box">
					<a href="#" id="item5">
						<h3 class="MyNavItem">传声筒</h3>
					</a>
					<div class="MyNav" id="MySection5"></div>
				</div>
			</div>
		</div>




		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.js"></script>

		<!--通过jQuery实现出现效果-->
		<script>
			$(function() {
				$("#item1").click(function() { //按钮的单击事件
					$("#div1").show(1000); //将层逐渐放大出来，显示过程的时间为1000毫秒
					$("#div2").hide(1000); //可以通过隐藏(hide)其他的只显示一个a标签点击后的结果
					$("#div3").hide(1000);
					$("#div4").hide(1000);
					$("#div5").hide(1000);
					$("#div6").hide(1000);
				});
			});
			$(function() {
				$("#item2").click(function() { //按钮的单击事件
					$("#div2").show(1000); //将层逐渐放大出来，显示过程的时间为1000毫秒
					$("#div1").hide(1000);
					$("#div3").hide(1000);
					$("#div4").hide(1000);
					$("#div5").hide(1000);
					$("#div6").hide(1000);
				});
			});
			$(function() {
				$("#item3").click(function() { //按钮的单击事件
					$("#div3").show(1000); //将层逐渐放大出来，显示过程的时间为1000毫秒
					$("#div1").hide(1000);
					$("#div2").hide(1000);
					$("#div4").hide(1000);
					$("#div5").hide(1000);
					$("#div6").hide(1000);
				});
			});
			$(function() {
				$("#item4").click(function() { //按钮的单击事件
					$("#div4").show(1000); //将层逐渐放大出来，显示过程的时间为1000毫秒
					$("#div1").hide(1000);
					$("#div2").hide(1000);
					$("#div3").hide(1000);
					$("#div5").hide(1000);
					$("#div6").hide(1000);
				});
			});
			$(function() {
				$("#item5").click(function() { //按钮的单击事件
					$("#div5").show(1000); //将层逐渐放大出来，显示过程的时间为1000毫秒
					$("#div6").show(1000);
					$("#div1").hide(1000);
					$("#div2").hide(1000);
					$("#div3").hide(1000);
					$("#div4").hide(1000);

				});
			});
		</script>

		<script>
			//网页加载完毕时触发的操作
			window.onload = function() {
				/*alert("爱情有多彩的颜色，鼠标触碰色块，开启奇妙之旅！");
				$("#MySend").hide();
				$("#MyMessage").hide();*/
			}
		</script>

		<script type="text/javascript">
			function onKeyDown(event) {
				var e = event || window.event
						|| arguments.callee.caller.arguments[0];
				if (e && e.keyCode == 27) { // 按 Esc 
					//要做的事情
				}
				if (e && e.keyCode == 113) { // 按 F2 
					//要做的事情
				}
				if (e && e.keyCode == 13) { // enter 键
					alert("此处回车触发搜索事件");
					c = document.getElementById("content");
					c.innerHTML = "<P>333333333<\p>";
				}

			}

			/*function search(event) {
				var c = document.getElementById("content");
				//要做的事情
				//需要提交搜索框中的数据到后台
				//在下面通过innerHTML属性显示结果
				c.innerHTML = "<P>333333333<\p>";
			}*/

			function showMyMessage() {
				$("#MySend").hide(1000);
				$("#MyMessage").show(1000);
				var c = document.getElementById("MyMessage");
				//此为样例，需要从后端将内容传上来！！！
				c.innerHTML = "<p>咋滴咧？足球比赛有守门员我还不进球了<p>"

			}

			function sendMyMessage() {
				$("#MyMessage").hide(1000);
				$("#MySend").show(1000);
			}
		</script>
		
		<script type="text/javascript">

var radius = 200;

var dtr = Math.PI/180;

var d=300;

var mcList = [];



var active = false;

var lasta = 1;

var lastb = 1;

var distr = true;

var tspeed=20;//滑动速度

var size=250;

var mouseX=0;

var mouseY=0;

var howElliptical=1;

var aA=null;

var oDiv=null;



window.onload=function ()

{
	
	alert("爱情有多彩的颜色，鼠标触碰色块，开启奇妙之旅！");
	$("#MySend").hide();
	$("#MyMessage").hide();

 var i=0;

 var oTag=null;
 
 console.log("1111111111");

 oDiv=document.getElementById('div11');

 aA=oDiv.getElementsByTagName('a');



 for(i=0;i<aA.length;i++)

 {

  oTag={};

  oTag.offsetWidth=aA[i].offsetWidth;

  oTag.offsetHeight=aA[i].offsetHeight;

  mcList.push(oTag);

 }

 sineCosine( 0,0,0 );

 positionAll();

 oDiv.onmouseover=function ()

 {

  active=true;

 };

 oDiv.onmouseout=function ()

 {

  active=false;

 };

 oDiv.onmousemove=function (ev)

 {

  var oEvent=window.event || ev;

  mouseX=oEvent.clientX-(oDiv.offsetLeft+oDiv.offsetWidth/2);

  mouseY=oEvent.clientY-(oDiv.offsetTop+oDiv.offsetHeight/2);

  mouseX/=5;

  mouseY/=5;

 };

 setInterval(update, 30);

};

function update()

{

 var a;

 var b;

 if(active)

 {

  a = (-Math.min( Math.max( -mouseY, -size ), size ) / radius ) * tspeed;

  b = (Math.min( Math.max( -mouseX, -size ), size ) / radius ) * tspeed;

 }

 else

 {

  a = lasta * 0.98;

  b = lastb * 0.98;

 }

 lasta=a;

 lastb=b;

 if(Math.abs(a)<=0.01 && Math.abs(b)<=0.01)

 {

  return;

 }

 var c=0;

 sineCosine(a,b,c);

 for(var j=0;j<mcList.length;j++)

 {

  var rx1=mcList[j].cx;

  var ry1=mcList[j].cy*ca+mcList[j].cz*(-sa);

  var rz1=mcList[j].cy*sa+mcList[j].cz*ca;

  var rx2=rx1*cb+rz1*sb;

  var ry2=ry1;

  var rz2=rx1*(-sb)+rz1*cb;

  var rx3=rx2*cc+ry2*(-sc);

  var ry3=rx2*sc+ry2*cc;

  var rz3=rz2;

  mcList[j].cx=rx3;

  mcList[j].cy=ry3;

  mcList[j].cz=rz3;

  per=d/(d+rz3);

  mcList[j].x=(howElliptical*rx3*per)-(howElliptical*2);

  mcList[j].y=ry3*per;

  mcList[j].scale=per;

  mcList[j].alpha=per;

  mcList[j].alpha=(mcList[j].alpha-0.6)*(10/6);

 }

 doPosition();

 depthSort();

}

function depthSort()

{

 var i=0;

 var aTmp=[];

 for(i=0;i<aA.length;i++)

 {

  aTmp.push(aA[i]);

 }

 aTmp.sort

 (

  function (vItem1, vItem2)

  {

   if(vItem1.cz>vItem2.cz)

   {

    return -1;

   }

   else if(vItem1.cz<vItem2.cz)

   {

    return 1;

   }

   else

   {

    return 0;

   }

  }

 );

 for(i=0;i<aTmp.length;i++)

 {

  aTmp[i].style.zIndex=i;

 }

}

function positionAll()

{

 var phi=0;

 var theta=0;

 var max=mcList.length;

 var i=0;

 var aTmp=[];

 var oFragment=document.createDocumentFragment();

 //随机排序

 for(i=0;i<aA.length;i++)

 {

  aTmp.push(aA[i]);

 }

 aTmp.sort

 (

  function ()

  {

   return Math.random()<0.5?1:-1;

  }

 );

 for(i=0;i<aTmp.length;i++)

 {

  oFragment.appendChild(aTmp[i]);

 }

 oDiv.appendChild(oFragment);

 for( var i=1; i<max+1; i++){

  if( distr )

  {

   phi = Math.acos(-1+(2*i-1)/max);

   theta = Math.sqrt(max*Math.PI)*phi;

  }

  else

  {

   phi = Math.random()*(Math.PI);

   theta = Math.random()*(2*Math.PI);

  }

  //坐标变换

  mcList[i-1].cx = radius * Math.cos(theta)*Math.sin(phi);

  mcList[i-1].cy = radius * Math.sin(theta)*Math.sin(phi);

  mcList[i-1].cz = radius * Math.cos(phi);

  aA[i-1].style.left=mcList[i-1].cx+oDiv.offsetWidth/2-mcList[i-1].offsetWidth/2+'px';

  aA[i-1].style.top=mcList[i-1].cy+oDiv.offsetHeight/2-mcList[i-1].offsetHeight/2+'px';

 }

}

function doPosition()

{

 var l=oDiv.offsetWidth/2;

 var t=oDiv.offsetHeight/2;

 for(var i=0;i<mcList.length;i++)

 {

  aA[i].style.left=mcList[i].cx+l-mcList[i].offsetWidth/2+'px';

  aA[i].style.top=mcList[i].cy+t-mcList[i].offsetHeight/2+'px';

  aA[i].style.fontSize=Math.ceil(12*mcList[i].scale/2)+8+'px';

  aA[i].style.filter="alpha(opacity="+100*mcList[i].alpha+")";

  aA[i].style.opacity=mcList[i].alpha;

 }

}

function sineCosine( a, b, c)

{

 sa = Math.sin(a * dtr);

 ca = Math.cos(a * dtr);

 sb = Math.sin(b * dtr);

 cb = Math.cos(b * dtr);

 sc = Math.sin(c * dtr);

 cc = Math.cos(c * dtr);

}

</script>
		
</body>
</html>