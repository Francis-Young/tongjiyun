package com.lewei.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.io.PrintWriter;

import daos.CollegestudentDao;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class verifycsnum
 */
@WebServlet("/verifycsnum")
public class verifycsnum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verifycsnum() {
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
		//System.out.println("etetttw3");
			String csnum = req.getParameter("csnum");

			resp.setContentType("text;charset=utf-8");

			resp.setCharacterEncoding("UTF-8");

			//System.out.println(csnum);

			PrintWriter out = resp.getWriter();

			if(CollegestudentDao.isCsNumExist(Integer.valueOf(csnum)))

		    {
		        out.print("true");
		    }

			else out.print("false");

		}

		
	}


