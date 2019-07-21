<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
  
    <title>Sign Up for University Student</title>

    <!--link rel="stylesheet" href="css/bootstrap.css">-->
    <!-- 使用CDN引入能直接使用图标 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
     
    <link rel="stylesheet" href="css/jigsaw.css">
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
        <h1 class="text-center">注册界面（大学生）</h1>
        <br>
            <form action="${pageContext.request.contextPath}/signupServlet" method="POST" class="form-horizontal" onsubmit="return handlesubmit(this)" >
                    <div class="form-group">
                      <label for="username" class="col-md-4 control-label">用户名</label>
                      <div class="col-md-5">
                          <input type="text" class="form-control" id="username" name="csname" placeholder="用户名">
                      </div>  
                    </div>
                    <div class="form-group">
                      <label for="password1" class="col-md-4 control-label">密码</label>
                      <div class="col-md-5">
                          <input type="password" class="form-control" id="password1" name="cspassword" placeholder="密码">
                      </div>
                    </div>
                    <div class="form-group">
                            <label for="" class="col-md-4 control-label">性别</label>
                            <!-- 添加空格来对齐页面 ，男=1，女=0-->
                            <label class="radio-inline ">&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="cssex" value="1" checked="checked">男</label>
                            <label class="radio-inline "><input type="radio" name="cssex" value="0">女</label>
                    </div>
                    <div class="form-group">
                      <label for="email1" class="col-md-4 control-label">邮箱</label>
                      <div class="col-md-5">
                          <input type="email" class="form-control" name="csemail" id="email1">  
                      </div>
                    </div>
                    <div class="form-group">
                        <label for="telephone" class="col-md-4 control-label">手机</label>
                        <div class="col-md-5">
                            <input type="tel" class="form-control" name="cstele" id="telephone">  
                        </div>        
                    </div>
                    <div class="form-group">
                            <label for="testtime" class="col-md-4 control-label" >入学年份</label>
                            <div class="col-md-5">
                                <select class="form-control" id="testtime" name="csyear">
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
                        <label for="schoolnum" class="col-md-4 control-label">学号</label>
                      <div class="col-md-5">
                          <input type="number" class="form-control" name="csnum" id="schoolnum">  
                      </div>    
                    </div>
                    <div class="form-group">
                        <!-- 将“同济大学”赋给变量并隐藏这一输入框 -->
               
                          <input type="text" name="csuniname" id="schoolname" hidden="true" value="同济大学" >  
                        
                    </div>
                    <div class="form-group">
                        <label for="majorname" class="col-md-4 control-label">专业名称</label>
                      <div class="col-md-5">
                          <input type="text" class="form-control" name="mname" id="majorname">  
                      </div>    
                    </div>
                      <div class="row">
                             <button type="submit" class="btn btn-default btn-lg center-block" name="submit" value="提交" >提交</button>  
                             <!-- <button type="submit" class="btn btn-default btn-lg center-block" name="send" value="发送验证码" disabled="true" id="send1">发送验证码</button> -->
                      </div>

                    <!-- 隐藏的input用于给表单一个名字 -->
                    <input type="text" name="action" value="csSIGNUP" hidden="true" aria-hidden="true">
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
            if(form.csname.value==""){
                alert("用户名不能为空！");
                return false;
            }
            if(form.cspassword.value==""){
                alert("密码不能为空！");
                return false;
            }
            /*if(form.cssex.value!="male"&&form.cssex.value!="female"){
                alert("性别不能为空！");
                return false;
            }*/
            
            if(isValidateEmail(form.csemail.value)==false){
              alert("请输入校园邮箱");
              return false;
            }
            
            if(form.csnum.value==""){
              alert("学号不能为空");
              return false;
            }

            /*if(form.csuniname.value==""){
              alert("学校名称不能为空");
              return false;
            }*/

            if(form.mname.value==""){
              alert("专业名称不能为空");
              return false;
            }
            
            return true;
          }

    </script>
    <!-- 图片验证码 -->
   
  </body>
</html>