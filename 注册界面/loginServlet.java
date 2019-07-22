package servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import daos.CollegestudentDao;
import daos.HighschoolstudentDao;


/**
 * Servlet implementation class verifycsname
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String utype = req.getParameter("utype");//0Îª¸ßÖÐÉú£¬1Îª´óÑ§Éú
		String uname = req.getParameter("uname");
		String upassword = req.getParameter("upassword");

		resp.setContentType("text;charset=utf-8");

		resp.setCharacterEncoding("UTF-8");

		PrintWriter out = resp.getWriter();

		if(utype.equals('0'))
		{
			if(HighschoolstudentDao.checkPasswordByHsname(uname, upassword))
			{
				out.print("true");
			}
			else
				out.print("false");
		}
		else
		{
			if(CollegestudentDao.isPasswordRight(upassword, CollegestudentDao.findCollegestudentByCsname(uname)))
			{
				out.print("true");
			}
			else
				out.print("false");
				
		}

	}

}
