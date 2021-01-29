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
			user = findIfEmployeeExists(username);
			if (user != null) {
				if (user.getPassword().equals(password)) {
					return "Pass";
				} else {
					return "Exists";
				}
			} else {
				return "NotExists";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "TryAgain";
	}

	public Employee findIfEmployeeExists(String username) {
		Transaction transaction = null;
		Employee employee = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			employee = (Employee) session.createQuery("FROM Employee U WHERE U.username = :username")
					.setParameter("username", username).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employee;
	}
}
