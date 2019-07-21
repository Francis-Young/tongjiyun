package com.lewei.test;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import daos.CollegestudentDao;


/**
 * Servlet implementation class verifycsname
 */
@WebServlet("/verifycsname")
public class verifycsname extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verifycsname() {
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
		String csname = req.getParameter("csname");

		resp.setContentType("text;charset=utf-8");

		resp.setCharacterEncoding("UTF-8");

		PrintWriter out = resp.getWriter();

		if(CollegestudentDao.isCsNameExist(csname))

	    {

	        out.print("true");

	    }

		else out.print("false");
	}

}
