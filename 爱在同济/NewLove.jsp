<%@ page language="java" contentType="text/html; charset=utf-8"
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

<title>JustForLove</title>

<link rel="stylesheet" href="css/bootstrap.css">

<!-- 使用CDN引入能直接使用图标 -->
<!--<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
        integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">-->
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


</head>

<body>

	<div class="row">
		<div class="col-lg-1 col-md-1 col-sm-1">
			<div class="outer-box">
				<a id="item1">
					<h3 class="MyNavItem">流星云</h3>
				</a>
				<div class="MyNav" id="MySection1"></div>
			</div>
		</div>
		<div class="col-lg-9 col-md-9 col-sm-9">
			<div id="div1"
				style="display: none; width: 100px; height: 100px; border: 1px solid blue; margin: 25px">
				<img src="assets/images/hotel.svg"> 这里嵌入相关内容，大小还需要调整
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
					<h4>快来搜搜吧！转换为jsp时，下面加一个实时留言板</h4>
					<div class="input-group">
						<input type="text" class="form-control"
							onkeydown="onKeyDown(event)" /> <span class="input-group-addon"><button
								onclick="search()">
								<i class="glyphicon glyphicon-search"></i>
							</button></span>
					</div>
					<h2>实时留言板（服务器关闭时数据不会被存储）</h2>
                          <form action="MsgServlet" method="post">
                          <div class="form-group">
                          <label for="name">您的名字是：</label>
                <input type="text" id="name" name="name" class="form-control" placeholder="" required>
                          </div>
                          <div class="form-group">
								<label>文本框</label>
									
							<textarea class="form-control" rows="7" name="message"></textarea>
									
								</div>
								<div class="form-group">
									<div class="col-lg-offset-5 col-md-offset-5 col-sm-offset-5">
										<button type="submit" class="btn btn-default">提交</button>
									</div>
								</div>
                          
                          </form>
						<h4>所有留言内容：</h4>
						<ul class="min-list listing-review-list">
							<%
								//获取留言信息，并遍历出所有用户的留言
								Vector<String> book = (Vector<String>) application.getAttribute("msg");
								if (book != null) {
									for (String msg : book) {
										String[] str = msg.split("#");//分割用户与留言信息
										out.print("姓名：" + str[0] + "<br>");
										out.print("留言：" + str[1] + "<br>");
										//out.print("<li class="+listing-review+"><div class="+d-flex+"><div class="+listing-review__avatar+"><img src="+assets/images/uploads/listing-review-1.png+" alt="+Avatar+"></div><div class="+listing-review__content+"><header class="+listing-review__header+"><div class="+d-sm-flex justify-content-sm-between c-silver-charlice+"><div><span class="stars-outer" data-rating="4"><span class="stars-inner" style="width: 80%;"></span></span><span></span></div><span>Written</span></div></header><!-- .listing-review__header --><div class="listing-review__review"><p>1111</p></div><footer class="listing-review__footer"><button class="button button--like c-white"><i class="fa fa-thumbs-up"></i></button></footer></div><!-- .listing-review__content --></div></li><!-- .listing-review -->");
									}
								} else {
									out.print("还没有留言！");
								}
							%>
						
					</ul>
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
				alert("爱情有多彩的颜色，鼠标触碰色块，开启奇妙之旅！");
				$("#MySend").hide();
				$("#MyMessage").hide();
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

			function search(event) {
				var c = document.getElementById("content");
				//要做的事情
				//需要提交搜索框中的数据到后台
				//在下面通过innerHTML属性显示结果
				c.innerHTML = "<P>333333333<\p>";
			}

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
</body>
</html>