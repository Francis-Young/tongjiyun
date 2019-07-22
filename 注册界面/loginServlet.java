package com.lewei.test;

import java.io.IOException;



import java.io.PrintWriter;



import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;



import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;



import beans.Collegestudent;

import beans.Highschoolstudent;

import daos.CollegestudentDao;

import daos.HighschoolstudentDao;







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

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// TODO Auto-generated method stub
		
		resp.setContentType("text;charset=utf-8");

		resp.setCharacterEncoding("UTF-8");

		//resp.getWriter().append("Served at: ").append(req.getContextPath());

		String utype = req.getParameter("utype");//������Ϊ��0������ѧ��Ϊ��1��
		//System.out.println(utype);
		String uname = req.getParameter("uname");

		String upassword = req.getParameter("upassword");

		//resp.setContentType("text;charset=utf-8");

		//resp.setCharacterEncoding("UTF-8");

		HttpSession session = req.getSession();

		



		if(utype.equals("0"))

		{

			if(HighschoolstudentDao.checkPasswordByHsname(uname, upassword))

			{

				Highschoolstudent hs = HighschoolstudentDao.findHighschoolstudentByHsname(uname);

				session.setAttribute("usertype", "highschoolstudent");

				session.setAttribute("user", hs);
				System.out.println("��½�ɹ�");
			}

			else {

		    req.setAttribute("err", "�û��������������");

	        req.getRequestDispatcher("LogIn.jsp").forward(req,resp);//����ת��
			}
		}

		else

		{

			if(CollegestudentDao.isPasswordRight(upassword, CollegestudentDao.findCollegestudentByCsname(uname)))

			{

				Collegestudent cs = CollegestudentDao.findCollegestudentByCsname(uname);

				session.setAttribute("usertype", "collegestudent");

				session.setAttribute("user", cs);
				System.out.println("��½�ɹ�");


			}

			else {

		    req.setAttribute("err", "�û��������������");

	        req.getRequestDispatcher("LogIn.jsp").forward(req,resp);//����ת��
            
			}	

		}

		

		

		

		

		

	}



	/**

	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)

	 */

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		

		doGet(req,resp);



}

}


