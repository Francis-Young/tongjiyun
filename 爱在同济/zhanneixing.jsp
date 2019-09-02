<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="daos.LetterDao,daos.CollegestudentDao,daos.HighschoolstudentDao,beans.Collegestudent,beans.Highschoolstudent,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
LetterDao ld = new LetterDao();
int usertype=0;
int userid=0;
if(session.getAttribute("usertype").equals("collegestudent"))
{
	usertype=1;
	Collegestudent cs= (Collegestudent)session.getAttribute("user");
	userid=cs.getCsid();
}
else
	{
	usertype=0;
	Highschoolstudent hs= (Highschoolstudent) session.getAttribute("user");
	userid=hs.getHsid();
	}

List<Integer> cRoster= ld.findcollegeRosterByTalkersid(userid, usertype);
List<Integer> hRoster= ld.findhighschoolRosterByTalkersid(userid, usertype);
CollegestudentDao cd=new CollegestudentDao();
HighschoolstudentDao hd = new HighschoolstudentDao();

for(int i=0;i<cRoster.size();i++)
{
	Collegestudent yunzoneOwner = CollegestudentDao.findCollegestudentById(cRoster.get(i));
	String yunzoneOwnerName = yunzoneOwner.getCsname();
	int yunzoneOwnerId = yunzoneOwner.getCsid();
	
}
%>
</body>
</html>