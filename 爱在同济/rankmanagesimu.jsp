<%@ page language="java" import="java.util.List,servlets.rankManage,java.text.SimpleDateFormat" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
#loader {
    position: absolute;
    left: 50%;
    top: 50%;
    z-index: 1;
    /*width: 20px;*/
    /*height: 20px;*/
    margin: -25px 0 0 -25px;
    border: 6px solid #f3f3f3;
    border-radius: 50%;
    border-top: 6px solid #00A76F;
    border-bottom: 6px solid #00A76F;
    width: 50px;
    height: 50px;
    -webkit-animation: spin 2s linear infinite;
    animation: spin 2s linear infinite;
}
 
@-webkit-keyframes spin {
    0% {
        -webkit-transform: rotate(0deg);
    }
    100% {
        -webkit-transform: rotate(360deg);
    }
}
 
@keyframes spin {
    0% {
        transform: rotate(0deg);
    }
    100% {
        transform: rotate(360deg);
    }
}
</style>
</head>
<body>
<h1>一周热词红人榜发布管理系统</h1>
<p>以下为系统自动识别结果，请予以确认或修正<p>
<form action="${pageContext.request.contextPath}/rankmanagerServlet" method="POST">
<% rankManage rm = new rankManage();//引用的类的构造函数需要为public
List<String> redpeople=rm.getRedpeople();

List<String> importantword =rm.getImportantword();
int i =0;
for( ; i<redpeople.size();i++)
{
	out.println(redpeople.get(i)+"&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp");%>
	 <input name=<%=i %> type="radio" value="r<%=redpeople.get(i) %>" checked="checked">红人
     <input name=<%=i %> type="radio" value="i<%=redpeople.get(i) %>">热词
     <input name=<%=i %> type="radio" value="d<%=redpeople.get(i) %>">废弃
	<br/>
	
<% 
}%><br/><br/><br/><br/><br/><% 
for(int j =0 ; j<importantword.size();j++)
{
	out.println(importantword.get(j));%>
	 <input name=<%=i+j %> type="radio" value="r<%=importantword.get(j) %>">红人
     <input name=<%=i+j %> type="radio" value="i<%=importantword.get(j) %>" checked="checked">热词
     <input name=<%=i+j %> type="radio" value="d<%=importantword.get(j) %>">废弃
	<br/>
	<%
}
%>
<input type="text" name="action" value="send" hidden="true" aria-hidden="true">
<button type="submit" class="btn btn-default btn-lg center-block" name="submit" value="submit" >确认发布</button> 
</form>
<script type="text/javascript">  </script>
</body>
</html>