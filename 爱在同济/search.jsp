<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<style>* {
	box-sizing:border-box;
}
body {
	margin:0;
	padding:0;
	background-image:url(ydrzimages/p3.jpg);
	font-weight:500;
	font-family:"Microsoft YaHei","宋体","Segoe UI","Lucida Grande",Helvetica,Arial,sans-serif,FreeSans,Arimo;
}
#container {
	width:500px;
	height:80px;
	margin:0 auto;
}
div.search {
	padding:10px 0;
}
form {
	position:relative;
	width:300px;
	margin:0 auto;
}
input,button {
	border:none;
	outline:none;
}
input {
	width:100%;
	height:42px;
	padding-left:13px;
}
button {
	height:42px;
	width:42px;
	cursor:pointer;
	position:absolute;
}

#tbl
{
    font-family: "Trebuchet MS",Arial,Helvetica,sans-serif;
    width: 30%;
    border-collapse: collapse;
}
 
#tbl caption
{
    font-size: 2em;
    color: #009B63;
    font-weight: bold;
}
 
#tbl th
{
    font-size: 1.1em;
    border: 1px solid rgb(0,136,88);
    text-align: center;
    padding-top: 5px;
    padding-bottom: 5px;
    color: #ffffff;
    background-color: #009B63;
    width: 10%;
}
 
#tbl td
{
    font-size:1em;
    border: 1px solid #98bf21;
    padding: 3px 3px 3px 3px;
    width: 10%;
}


/*搜索框6*/
     
.bar6 input {
	width:250px;
	border:2px solid #c5464a;
	border-radius:5px;
	background:transparent;
	top:0;
	right:0;
	transition:.3s linear;
	float:right;
}
.bar6 input:focus {
	width:300px;
}
.bar6 button {
	background:#c5464a;
	border-radius:0 5px 5px 0;
	width:60px;
	top:0;
	right:0;
}
.bar6 button:before {
	content:"搜索";
	font-size:13px;
	color:#F9F0DA;
}
/*搜索框7*/
      
.bar7 form {
	height:42px;
}
.bar7 input {
	width:250px;
	border-radius:42px;
	border:2px solid #324B4E;
	background:#F9F0DA;
	transition:.3s linear;
	float:right;
}
.bar7 input:focus {
	width:300px;
}
.bar7 button {
	background:none;
	top:-2px;
	right:20px;
}
.bar7 button:before {
	content:"Search";
	font-family:FontAwesome;
	color:#324b4e;
}
/*搜索框8*/
       
.bar8 form {
	height:42px;
}
.bar8 input {
	width:0;
	padding:0 42px 0 15px;
	border-bottom:2px solid transparent;
	background:transparent;
	transition:.3s linear;
	position:absolute;
	top:0;
	right:0;
	z-index:2;
}
.bar8 input:focus {
	width:300px;
	z-index:1;
	border-bottom:2px solid #F9F0DA;
}
.bar8 button {
	background:#683B4D;
	top:0;
	right:0;
}
.bar8 button:before {
	content:"Go";
	font-family:FontAwesome;
	font-size:16px;
	color:#F9F0DA;
}

#fountainG{
    position:relative;
    margin:10% auto;
    width:240px;
    height:29px}
 
.fountainG{
    position:absolute;
    top:0;
    background-color:#33cc99;
    width:29px;
    height:29px;
    -webkit-animation:bounce_fountainG 1.3s infinite normal;
    -moz-animation:bounce_fountainG 1.3s infinite normal;
    -o-animation:bounce_fountainG 1.3s infinite normal;
    -ms-animation:bounce_fountainG 1.3s infinite normal;
    animation:bounce_fountainG 1.3s infinite normal;
    -moz-transform:scale(.3);
    -webkit-transform:scale(.3);
    -ms-transform:scale(.3);
    -o-transform:scale(.3);
    transform:scale(.3);
    border-radius:19px;
}
 
#fountainG_1{
    left:0;
    -moz-animation-delay:0.52s;
    -webkit-animation-delay:0.52s;
    -ms-animation-delay:0.52s;
    -o-animation-delay:0.52s;
    animation-delay:0.52s;
}
 
#fountainG_2{
    left:30px;
    -moz-animation-delay:0.65s;
    -webkit-animation-delay:0.65s;
    -ms-animation-delay:0.65s;
    -o-animation-delay:0.65s;
    animation-delay:0.65s;
}
 
#fountainG_3{
    left:60px;
    -moz-animation-delay:0.78s;
    -webkit-animation-delay:0.78s;
    -ms-animation-delay:0.78s;
    -o-animation-delay:0.78s;
    animation-delay:0.78s;
}
 
#fountainG_4{
    left:90px;
    -moz-animation-delay:0.91s;
    -webkit-animation-delay:0.91s;
    -ms-animation-delay:0.91s;
    -o-animation-delay:0.91s;
    animation-delay:0.91s;
}
 
#fountainG_5{
    left:120px;
    -moz-animation-delay:1.04s;
    -webkit-animation-delay:1.04s;
    -ms-animation-delay:1.04s;
    -o-animation-delay:1.04s;
    animation-delay:1.04s;
}
 
#fountainG_6{
    left:150px;
    -moz-animation-delay:1.17s;
    -webkit-animation-delay:1.17s;
    -ms-animation-delay:1.17s;
    -o-animation-delay:1.17s;
    animation-delay:1.17s;
}
 
#fountainG_7{
    left:180px;
    -moz-animation-delay:1.3s;
    -webkit-animation-delay:1.3s;
    -ms-animation-delay:1.3s;
    -o-animation-delay:1.3s;
    animation-delay:1.3s;
}
 
#fountainG_8{
    left:210px;
    -moz-animation-delay:1.43s;
    -webkit-animation-delay:1.43s;
    -ms-animation-delay:1.43s;
    -o-animation-delay:1.43s;
    animation-delay:1.43s;
}
 
@-moz-keyframes bounce_fountainG{
    0%{
        -moz-transform:scale(1);
        background-color:#33cc99;
    }
 
    100%{
        -moz-transform:scale(.3);
        background-color:#0099cc;
    }
 
}
 
@-webkit-keyframes bounce_fountainG{
    0%{
        -webkit-transform:scale(1);
        background-color:#33cc99;
    }
 
    100%{
        -webkit-transform:scale(.3);
        background-color:#0099cc;
    }
 
}
 
@-ms-keyframes bounce_fountainG{
    0%{
        -ms-transform:scale(1);
        background-color:#33cc99;
    }
 
    100%{
        -ms-transform:scale(.3);
        background-color:#0099cc;
    }
 
}
 
@-o-keyframes bounce_fountainG{
    0%{
        -o-transform:scale(1);
        background-color:#33cc99;
    }
 
    100%{
        -o-transform:scale(.3);
        background-color:#0099cc;
    }
 
}
 
@keyframes bounce_fountainG{
    0%{
        transform:scale(1);
        background-color:#33cc99;
    }
 
    100%{
        transform:scale(.3);
        background-color:#0099cc;
    }
 
}
</style>
 
<script type="text/javascript">
//加载动画效果

$(document).ready(function(){
$('#fountainG').hide();
});
function search()
{    
	$('#fountainG').show(500);
	setTimeout(function(){
     
       
   
	function showLoad(){
		 
	    $('#fountainG').show(500);
	}
	//隐藏动画效果
	function hiddenLoad(){
		$('#fountainG').hide();
	}
	
	hiddenLoad();
	$('#fountainG').hide();
	var key = $("#key").val()
	var url="${pageContext.request.contextPath}/searchServlet?key="+key
	function gettext(text)
	{
		var subt = text.match(/mark1(\S*?)mark2/);
		return subt[1];
	}
	function getdate(text)
	{
		var subt = text.match(/mark0(\S*?)mark1/);
		return subt[1];
	}

    

     $.ajax({
              type:"post",
              url:"${pageContext.request.contextPath}/searchServlet",
              async:true, //默认-异步（true） 同步-false
              dataType:"text",
              
              data:{"key":key},
              beforeSend: function (){
                  //ajax刷新前加载load动画
                  showLoad();
              },
              success:function (dataArray) {
            	  
            	  var subtext = dataArray.match(/mark1(\S*?)mark2/g);
            	  var subdate = dataArray.match(/mark0(\S*?)mark1/g);
            	 // alert(subtext[1]);
            	 // alert(decodeURI(subtext[1]))
            	 // alert(decodeURI(subdate))
            	  //decodeURI方法返回一个字符数组，所以如果要知道字符串的数量就要分组decode，否则组的每位只有一个字符
            	
                  var tableBody = "<tbody id='tableBody'>";
 					
                  for (var i = 0; i < subdate.length; i++) {
 
                      tableBody += "<tr>";
 
                      tableBody += "<td>"+(i+1)+"</td>";
                      tableBody += "<td>"+getdate(subdate[i])+"</td>";
                      tableBody += "<td>"+gettext(decodeURI(subtext[i]))+"</td>";
 
                      tableBody += "</tr>";
                  }
 
                  tableBody += "</tBody>";
 
                  $("tbody#tableBody").remove();//删除已有表格
                  $("#tableHead").after(tableBody);
 
              },
              error:function (e,textStatus,request) {
                  //隐藏load动画
                  hiddenLoad();
                  alert("错误！"+e.status);
                  var json=JSON.parse(request.responseText);  
                  alert(json.city); 
                  alert(request.responseText)
                  alert(" parser error"+textStatus); // parser error;
              },
              complete:function () {
            	  $('#fountainG').hide(0);
                  //完成以后隐藏load动画
                 
                  //表格隔行显色，鼠标悬浮高亮显示
                  var oTab = document.getElementById('tbl');
                  var oldColor = '';//用于保存原来一行的颜色
 
                  for(var i = 0; oTab.tBodies[0].rows.length; i++){
 
                      //当鼠标移上去，改变字体色-背景色
                      oTab.tBodies[0].rows[i].onmouseover = function () {
                          oldColor = this.style.background;
                          this.style.background = "#009B63";
                          this.style.color = "#ffffff";
                      };
 
                      //当鼠标移开，恢复原来的颜色
                      oTab.tBodies[0].rows[i].onmouseout = function () {
                          this.style.background = oldColor;
                          this.style.color = "#000000";
                      };
 
                      //隔行显色
                      if(i%2){
                          oTab.tBodies[0].rows[i].style.background = "#EAF2D3";
                      }
                      else{
                          oTab.tBodies[0].rows[i].style.background = "";
                      }
                  }
              }
          });
    

	},2000);//settimeout
}
</script>

</head>
<body>
<div id="container">
    <div class="search bar6">
        <form>
            <input type="text" placeholder="请输入您要搜索的姓名" name="cname" id="key" >
            <button type="button" onclick=search()></button>
        </form>
    </div>
</div>   

      <table id="tbl" align="center">
 
        <caption>搜索内测</caption>
 
        <thead id="tableHead">
          <tr>
            <th>No.</th>
            <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Date&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
            <th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Content&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
          </tr>
        </thead>
 
        <tbody id="tableBody"></tbody>
 

      </table>

 <%--load动画效果--%>
     <div id="fountainG">
       <div id="fountainG_1" class="fountainG">
       </div>
       <div id="fountainG_2" class="fountainG">
       </div>
       <div id="fountainG_3" class="fountainG">
       </div>
       <div id="fountainG_4" class="fountainG">
       </div>
       <div id="fountainG_5" class="fountainG">
       </div>
       <div id="fountainG_6" class="fountainG">
       </div>
       <div id="fountainG_7" class="fountainG">
       </div>
       <div id="fountainG_8" class="fountainG">
       </div>
     </div>
  



 
</body>
</html>