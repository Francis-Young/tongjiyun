package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CollegestudentDao;

public class verifycsname
{
public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String csname = req.getParameter("csname");
	resp.setContentType("text;charset=utf-8");
	resp.setCharacterEncoding("UTF-8");
	PrintWriter out = resp.getWriter();
	System.out.println(csname);
	if(CollegestudentDao.isCsNameExist(csname))
    {
        out.print("true");
    }
	else out.print("false");
}

}
