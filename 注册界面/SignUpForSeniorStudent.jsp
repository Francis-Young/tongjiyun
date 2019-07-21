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
  
    <title>Learn Bootstrap</title>

    <!--link rel="stylesheet" href="css/bootstrap.css">-->
    <!-- 使用CDN引入能直接使用图标 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
     
    <!-- <link rel="stylesheet" href="css/jigsaw.css"> -->
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
                          <input type="text" class="form-control" id="username" name="hsname" placeholder="用户名">
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
                            <label class="radio-inline ">&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="hssex" value="male" checked="checked">男</label>
                            <label class="radio-inline "><input type="radio" name="hssex" value="female">女</label>
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
                                    <option value="北京">北京</option>
                                    <option value="北京">北京</option>
                                    <option value="北京">北京</option>
                                    <option value="北京">北京</option>
                                    <option value="北京">北京</option>
                                    <option value="北京">北京</option>
                                    <option value="北京">北京</option>
                                    <option value="北京">北京</option>
                                </select>
                            </div>    
                    </div>
                    <div class="form-group">
                            <label for="testtime" class="col-md-4 control-label" >高考时间</label>
                            <div class="col-md-5">
                                <select class="form-control" id="testtime" name="hsgaokao_year">
                                    <option value="2000">2000</option>
                                    <option value="2000">2000</option>
                                    <option value="2000">2000</option>
                                    <option value="2000">2000</option>
                                    <option value="2000">2000</option>
                                    <option value="2000">2000</option>
                                    <option value="2000">2000</option>
                                    <option value="2000">2000</option>
                                    <option value="2000">2000</option>   
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
                    <input type="text" name="action" value="SIGNUP" hidden="true" aria-hidden="true">
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
            
            /*if(isValidateEmail(form.hsphone.value)==false){
              alert("请输入校园邮箱");
              return false;
            }*/

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
    jigsaw.init(document.getElementById('captcha'), function () {
      document.getElementById('msg').innerHTML = '登录成功'
      ;
    })
    </script>
  </body>

</body>
</html>
</html>