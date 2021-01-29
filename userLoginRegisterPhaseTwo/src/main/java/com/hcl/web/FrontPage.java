package com.hcl.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.dao.EmployeeDao;

/**
 * Servlet implementation class FrontPage
 */
@WebServlet("/index")
public class FrontPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao employeeDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		employeeDao = new EmployeeDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.sendRedirect("index.jsp");
	}

//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		if ("registerButton".equals(request.getParameter("registerButton"))) {
//			RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
//			dispatcher.forward(request, response);
//		} else if("loginButton".equals(request.getParameter("loginButton"))){
//			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
//			dispatcher.forward(request, response);
//		}else {
//			
//		}
//	}

}
