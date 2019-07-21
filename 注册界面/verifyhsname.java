package com.lewei.test;



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
@WebServlet("/verifyhsname")
public class verifyhsname extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verifyhsname() {
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



























