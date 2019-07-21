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
	String csnum = req.getParameter("csnum");
	resp.setContentType("text;charset=utf-8");
	resp.setCharacterEncoding("UTF-8");
	System.out.println(csnum);
	PrintWriter out = resp.getWriter();
	if(CollegestudentDao.isCsNumExist(Integer.valueOf(csnum)))
    {
        out.print("Ñ§ºÅÒÑ´æÔÚ£¡");
    }
	else out.print("Ñ§ºÅ¿ÉÓÃ");
}

}
