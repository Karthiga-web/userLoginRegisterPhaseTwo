package com.hcl.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hcl.model.Employee;
import com.hcl.util.HibernateUtil;

public class EmployeeDao {

	public boolean saveUser(Employee employee) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(employee);
			//hibernate insert query to save user details in DB
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String validate(String username, String password) {
		Transaction transaction = null;
		Employee user = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			//To find if employee exists in DB
			user = findIfEmployeeExists(username);
			//If user exist, go to login page
			if (user != null) {
				if (user.getPassword().equals(password)) {
					return "Pass";
				} else {
					//If user exist but gave wrong password, ask again to give correct password
					return "Exists";
				}
			} else {
				//If user doesn't exist, ask to register
				return "NotExists";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "TryAgain";
	}
//To find if employee exists in DB
	public Employee findIfEmployeeExists(String username) {
		Transaction transaction = null;
		Employee employee = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			//hibernate select query to find if user exists in DB
			employee = (Employee) session.createQuery("FROM Employee U WHERE U.username = :username")
					.setParameter("username", username).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}
}
