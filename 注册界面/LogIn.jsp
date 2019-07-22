<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
   
    <title>Log in</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
     <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    
    
</head>
<body>

    <div class="container">
        <h1 class="text-center">登录界面</h1>
        <br>
            <form action="${pageContext.request.contextPath}/loginServlet" method="POST" class="form-horizontal"  >
                     <div class="form-group">
                            <label for="testtime" class="col-md-4 control-label" >类型</label>
                            <div class="col-md-5">
                                <select class="form-control" name="utype" >
                                    <option value="0">高中生</option>
                                    <option value="1">大学生</option>
                                </select>
                            </div>
                     </div>
                    <div class="form-group">
                      <label for="username" class="col-md-4 control-label" >用户名</label>
                      <div class="col-md-5">
                          <input type="text" class="form-control" name="uname" placeholder="用户名" > 
                      </div>  
                    </div>
                    <div class="form-group">
                      <label for="password1" class="col-md-4 control-label">密码</label>
                      <div class="col-md-5">
                          <input type="password" class="form-control" name="upassword" placeholder="密码"  >
                          <p style="color:red;text-align:left">${err }</p>
                      </div>
                    </div>
                         <button type="submit" class="btn btn-default btn-lg center-block" name="submit" value="提交" id="update">提交 </button> 
                         <!-- 后端传一个err变量，用EL表达式接收并以红色显示 -->
                         
                        
                    <input type="text" name="action" value="LOGIN" hidden="true" aria-hidden="true">
            </form>
      </div>
<script type="text/javascript">

</script>
</body>
</html>