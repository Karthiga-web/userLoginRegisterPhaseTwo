package com.hcl.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcl.dao.EmployeeDao;
import com.hcl.model.Employee;

@WebServlet("/register")
public class EmployeeRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeDao employeeDao;

	public void init() {
		employeeDao = new EmployeeDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ("Register".equals(request.getParameter("submitButton"))) {
			register(request, response);
		} else if ("Member".equals(request.getParameter("memberButton"))) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		} else {

		}
	}

	private void register(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String message = null;
		Employee ifEmployeeExists = employeeDao.findIfEmployeeExists(request.getParameter("username"));
		if (ifEmployeeExists == null) {
			System.out.println("Saved");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String contactNumber = request.getParameter("contactNumber");
			Employee employee = new Employee();
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
			employee.setUsername(username);
			employee.setPassword(password);
			employee.setEmail(email);
			employee.setContactNumber(contactNumber);
			if (employeeDao.saveUser(employee)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
				message = "Enter correct values in the fields!";
				request.setAttribute("message", message);
				dispatcher.forward(request, response);
			}
		} else {
			System.out.println("Same User");
			RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
			message = "Please use different Username!";
			request.setAttribute("message", message);
			dispatcher.forward(request, response);
		}
	}
}
