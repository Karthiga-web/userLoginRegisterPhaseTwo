package com.hcl.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.hcl.dao.EmployeeDao;
import com.hcl.model.Employee;

@WebServlet("/register")
public class EmployeeRegistrationServlet extends HttpServlet {
	static Logger log = Logger.getLogger(EmployeeDao.class.getName());
	private static final long serialVersionUID = 1L;
	private EmployeeDao employeeDao;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		register(request, response);
	}

	private void register(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String message = null;
		Employee ifEmployeeExists = employeeDao.findIfEmployeeExists(request.getParameter("username"));
		if (ifEmployeeExists == null) {
			System.out.println("Saved");
			//get all values entered by the user
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String contactNumber = request.getParameter("contactNumber");
			Employee employee = new Employee();
			//store the values in employee
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
				//sending message to user
				request.setAttribute("message", message);
				log.info(message);
				dispatcher.forward(request, response);
			}
		} else {
			System.out.println("Same User");
			RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
			//sending message to user
			message = "Please use different Username!";
			request.setAttribute("message", message);
			log.info(message);
			dispatcher.forward(request, response);
		}
	}

	public EmployeeRegistrationServlet() {
		super();
		employeeDao = new EmployeeDao();
	}
}
