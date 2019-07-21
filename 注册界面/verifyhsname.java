package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.HighschoolstudentDao;

public class verifyhsname
{
public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String hsname = req.getParameter("hsname");

	resp.setContentType("text;charset=utf-8");
	resp.setCharacterEncoding("UTF-8");
	PrintWriter out = resp.getWriter();

	if(HighschoolstudentDao.isHsNameExist(hsname))
    {
        out.print("true");
    }
	else out.print("false");
}

}