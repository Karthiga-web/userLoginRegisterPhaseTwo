package com.hcl.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.dao.EmployeeDao;

@WebServlet("/login")
public class EmployeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao loginDao;

	public EmployeeLoginServlet() {
		super();
		loginDao = new EmployeeDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message = null;
		try {
			authenticate(request, response);
		} catch (Exception e) {
			//If unexpected error occured, ask to login again
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			message = "Unexpected Error Occured! Try again!";
			//sending message to user
			request.setAttribute("message", message);
			dispatcher.forward(request, response);
		}
	}

	private void authenticate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String message = null;
		String check = loginDao.validate(username, password);
		if (check.equals("Pass")) {
			//If user exist, Successfull login 
			System.out.println("LoginSuccess");
			RequestDispatcher dispatcher = request.getRequestDispatcher("SuccessLogin.jsp");
			dispatcher.forward(request, response);
		} else if (check.equals("Exists")) {
			//If user exist but gave wrong password, ask again to give correct password
			System.out.println("Exists");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			message = "Wrong Password! Try Again!";
			//sending message to user
			request.setAttribute("message", message);
			dispatcher.forward(request, response);
		} else if (check.equals("NotExists")) {
			//If user doesn't exist, ask to register
			System.out.println("NotExists");
			RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
			message = "Are you a New Employee? Please Register!";
			//sending message to user
			request.setAttribute("message", message);
			dispatcher.forward(request, response);
		} else {
			//If unexpected error occured, ask to login again
			System.out.println("Unexpected");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			message = "Unexpected Error Occured! Try again!";
			//sending message to user
			request.setAttribute("message", message);
			dispatcher.forward(request, response);
		}
	}
}
