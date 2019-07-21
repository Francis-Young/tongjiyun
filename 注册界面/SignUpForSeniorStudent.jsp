<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,javax.mail.*"%>
<%@ page import="javax.mail.internet.*,javax.activation.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>

   
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
  
    <title>Sign Up for High School Student</title>

    <!--link rel="stylesheet" href="css/bootstrap.css">-->
    <!-- 使用CDN引入能直接使用图标 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
     
    <!-- <link rel="stylesheet" href="css/jigsaw.css"> -->
     <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
     
    <style>
      body{
        /* background: url(images/绿水青山.jpg); */
        background-size: cover;
        background-color: rgb(255, 255, 255);
      }
    </style>

<style>
    /* .container { 
      width: 310px;
      margin: 100px auto;
    }*/
    
    #msg {
      width: 100%;
      line-height: 40px;
      font-size: 14px;
      text-align: center;
    }
    
    a:link,a:visited,a:hover,a:active {
      margin-left: 100px;
      color: #0366D6;
    }
    </style>
  </head>
  <body>
      <div class="container">
        <h1 class="text-center">注册界面（高中生）</h1>
        <br>
            <form action="${pageContext.request.contextPath}/signupServlet" method="POST" class="form-horizontal" onsubmit="return handlesubmit(this)">
                    <div class="form-group">
                      <label for="username" class="col-md-4 control-label">用户名</label>
                      <div class="col-md-5">
                          <input type="text" class="form-control" id="username" name="hsname" placeholder="用户名" onblur="checkValidate(this.value)"> 
                          <span class="msg" id="cardId_msg">*必填项</span> >
                      </div>  
                    </div>
                    <div class="form-group">
                      <label for="password1" class="col-md-4 control-label">密码</label>
                      <div class="col-md-5">
                          <input type="password" class="form-control" id="password1" name="hspassword" placeholder="密码">
                      </div>
                    </div>
                    <div class="form-group">
                            <label for="" class="col-md-4 control-label">性别</label>
                            <!-- 添加空格来对齐页面 -->
                            <label class="radio-inline ">&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="hssex" value="1" checked="checked">男</label>
                            <label class="radio-inline "><input type="radio" name="hssex" value="0">女</label>
                    </div>
                    <div class="form-group">
                      <label for="telephone" class="col-md-4 control-label">邮箱</label>
                      <div class="col-md-5">
                          <input type="email" class="form-control" name="hsphone" id="telephone">  
                      </div>
                    </div>
                    <div class="form-group">
                            <label for="testarea" class="col-md-4 control-label" >高考区域</label>
                            <div class="col-md-5">
                                <select class="form-control" id="testarea" name="hsregion">
                                    <option value="北京">北京</option>
                                    <option value="上海">上海</option>
                                    <option value="黑龙江">黑龙江</option>
                                    <option value="吉林">吉林</option>
                                    <option value="辽宁">辽宁</option>
                                    <option value="北京">河北</option>
                                    <option value="天津">天津</option>
                                    <option value="内蒙古">内蒙古</option>
                                    <option value="山西">山西</option>
                                    <option value="山东">山东</option>
                                    <option value="河南">河南</option>
                                    <option value="陕西">陕西</option>
                                    <option value="宁夏">宁夏</option>
                                    <option value="甘肃">甘肃</option>
                                    <option value="青海">青海</option>
                                    <option value="新疆">新疆</option>
                                    <option value="西藏">西藏</option>
                                    <option value="四川">四川</option>
                                    <option value="重庆">重庆</option>
                                    <option value="江西">江西</option>
                                    <option value="安徽">安徽</option>
                                    <option value="江苏">江苏</option>
                                    <option value="浙江">浙江</option>
                                    <option value="福建">福建</option>
                                    <option value="湖北">湖北</option>
                                    <option value="湖南">湖南</option>
                                    <option value="贵州">贵州</option>
                                    <option value="云南">云南</option>
                                    <option value="广西">广西</option>
                                    <option value="广东">广东</option>
                                    <option value="海南">海南</option>
                                    <option value="澳门">澳门</option>
                                    <option value="香港">香港</option>
                                    <option value="台湾">台湾</option>
                                </select>
                            </div>    
                    </div>
                    <div class="form-group">
                            <label for="testtime" class="col-md-4 control-label" >高考时间</label>
                            <div class="col-md-5">
                                <select class="form-control" id="testtime" name="hsgaokao_year">
                                    <option value="2000">2000</option>
                                    <option value="2001">2001</option>
                                    <option value="2002">2002</option>
                                    <option value="2003">2003</option>
                                    <option value="2004">2004</option>
                                    <option value="2005">2005</option>
                                    <option value="2006">2006</option>
                                    <option value="2007">2007</option>
                                    <option value="2008">2008</option>
                                    <option value="2009">2009</option>
                                    <option value="2010">2010</option>
                                    <option value="2011">2011</option>
                                    <option value="2012">2012</option>
                                    <option value="2013">2013</option>
                                    <option value="2014">2014</option>
                                    <option value="2015">2015</option>
                                    <option value="2016">2016</option>
                                    <option value="2017">2017</option>
                                    <option value="2018">2018</option>
                                    <option value="2019">2019</option>         
                                </select>
                            </div>
                     </div>
                     <div class="form-group">
                            <label for="" class="col-md-4 control-label">选科</label>
                            <label class="radio-inline">&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="hschoice" value="理科" checked="checked">理科</label>
                            <label class="radio-inline"><input type="radio" name="hschoice" value="文科">文科</label>
                            <label class="radio-inline"><input type="radio" name="hschoice" value="综评">综合评价</label>
                    </div>
                    
                    <div class="container">
                        <div id="captcha" style="position:relative"></div>
                        <div id="msg"></div>
                    </div>
                      <div class="row">
                             <button type="submit" class="btn btn-default btn-lg center-block" name="submit" value="submit" >提交</button> 
                             <!-- <button type="submit" class="btn btn-default btn-lg center-block" name="send" value="发送验证码" disabled="true" id="send1">发送验证码</button> -->
                      </div>
                    <!-- 隐藏的input用于给表单一个名字 -->
                    <input type="text" name="action" value="hsSIGNUP" hidden="true" aria-hidden="true">
            </form>
    </div>
    <!-- 判断输入的有效性 -->
    <script>
           function isValidateEmail(email){
             var patt = /edu.cn/;
             var tag=patt.test(email); 
             return tag;
           }
          function handlesubmit(form){
            if(form.hsname.value==""){
                alert("用户名不能为空！");
                return false;
            }
            if(form.hspassword.value==""){
                alert("密码不能为空！");
                return false;
            }
           /* if(form.hssex.value!="male" && form.hssex.value!="female"){
                alert("性别不能为空！");
                return false;
            }*/
            
            if(form.hsphone.value==""){
              alert("邮箱不能为空！");
              return false;
            }

            /*if(form.hschoice.value!="wenke"&&form.hschoice.value!="like"&&form.hschoice.value!="zongping"){
              alert("选科不能为空！");
              return false;
            }*/
            return true;
          }

    </script>
    <!-- 图片验证码 -->
    <script src="{pageContext.request.ContextPath}/js/jigsaw.js"></script>
    <script type="text/javascript">
    /*jigsaw.init(document.getElementById('captcha'), function () {
      document.getElementById('msg').innerHTML = '登录成功'
      ;
    })*/
    
    function checkValidate1(val){
  	    var msg1 = $("#cardId_msg");	//JQuery获取
  	    var info = "";	//提示信息
  		    $.ajax({
  		        type: "POST",
  		        url: "${pageContext.request.contextPath}/verifyhsname", //链接指向地址
  		        dataType:"json",
  		        data: {"hsname":val},  //形成一对key-value，提交对象可以通过request.getParameter("cardId");获得val值
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
  </body>
</body>
</html>
</html>