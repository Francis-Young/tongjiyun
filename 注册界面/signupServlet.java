package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Collegestudent;
import beans.Highschoolstudent;
import daos.CollegestudentDao;
import daos.HighschoolstudentDao;

/**
 * Servlet implementation class signupServlet
 */

@WebServlet("/signupServlet")

public class signupServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

       

    /**
     * @see HttpServlet#HttpServlet()
     */

    public signupServlet() {

        super();

        // TODO Auto-generated constructor stub

    }



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// TODO Auto-generated method stub

		resp.getWriter().append("Served at: ").append(req.getContextPath());

		//System.out.println('t');

		//获取请求的行为

		String action = req.getParameter("action");

		System.out.println(req.getParameter("action"));

		//根据不同的action请求，进入不同的方法

		switch (action)

		{

			case "hsSIGNUP":

				hssignup(req,resp);

				break;

			case "csSIGNUP":

				cssignup(req,resp);

				break;

			default:

				break;

		}

	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub

		doGet(request, response);

	}

	

	private void cssignup(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 

	{

		// TODO Auto-generated method stub

		System.out.println("进入注册业务！");

		req.setCharacterEncoding("GB2312");

		String csname = req.getParameter("csname");

		csname = new String(csname.getBytes("ISO-8859-1"),"UTF-8"); //中文解码转换

		String cspassword = req.getParameter("cspassword");

		String cssex = req.getParameter("cssex");	

		String csyear = req.getParameter("csyear");
		
		String csemail = req.getParameter("csemail");
		
		String cstele = req.getParameter("cstele");
		
		String csnum = req.getParameter("csnum");

		String csuniname = req.getParameter("csuniname");
		
		csuniname = new String(csuniname.getBytes("ISO-8859-1"),"UTF-8"); 
		
		String mname = req.getParameter("mname");
		
		mname = new String(mname.getBytes("ISO-8859-1"),"UTF-8"); 
		
        	Collegestudent cs = new Collegestudent();
        	cs.setCsemail(csemail);;
        	cs.setCsyear(Integer.valueOf(csyear));
        	cs.setCsname(csname);
        	cs.setCspassword(cspassword);
        	cs.setCstele(cstele);
        	cs.setCssex(Integer.valueOf(cssex));
        	cs.setCsnum(Integer.valueOf(csnum));
        	cs.setCsuniname(csuniname);
        	cs.setMname(mname);
        	CollegestudentDao.addCollegestudent(cs);

        //resp.sendRedirect("http://localhost:8080/TomcatTest/login.jsp");//转到登录页面
        

        

	}

	private void hssignup(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 

	{

		// TODO Auto-generated method stub

		System.out.println("进入注册业务！");

		req.setCharacterEncoding("GB2312");

		String hsname = req.getParameter("hsname");

		hsname = new String(hsname.getBytes("ISO-8859-1"),"UTF-8"); //中文解码转换

		String hspassword = req.getParameter("hspassword");

		String hssex = req.getParameter("hssex");	

		String hsgaokao_year = req.getParameter("hsgaokao_year");
		
		String hsphone = req.getParameter("hsphone");
		
		String hsregion = req.getParameter("hsregion");
		
		hsregion = new String(hsregion.getBytes("ISO-8859-1"),"UTF-8"); 

		String hschoice = req.getParameter("hschoice");
		
		hschoice = new String(hschoice.getBytes("ISO-8859-1"),"UTF-8"); 

		System.out.println(hsname+hspassword+hssex+hsgaokao_year+hsphone+hsregion+hschoice);


        	Highschoolstudent hs = new Highschoolstudent();
        	hs.setHschoice(hschoice);
        	hs.setHsgaokao_year(Integer.valueOf(hsgaokao_year));
        	hs.setHsname(hsname);
        	hs.setHspassword(hspassword);
        	hs.setHsphone(hsphone);
        	hs.setHsregion(hsregion);
        	hs.setHssex(Integer.valueOf(hssex));
        	HighschoolstudentDao.addHighschoolstudent(hs);        

	}

}
	

	

	
