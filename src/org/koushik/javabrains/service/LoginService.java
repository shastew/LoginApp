package org.koushik.javabrains.service;

//import java.util.HashMap;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.koushik.javabrains.dto.User;

import com.sshaw.dao.hibernate.HibernateUtil;

public class LoginService {

//	HashMap<String, String> users = new HashMap<String, String>();
	
	public LoginService() {
	}
	
	@SuppressWarnings("unchecked")
	public boolean authenticate(String userName, String password) {
		
		List<User> users = null;
		
		if ((password == null || password.trim() == "") &&
		    (userName == null || userName.trim() == "")) {
			return false;
		}
		else {
		  Transaction trns = null;
		  SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		  Session session = sessionFactory.openSession();
		  try {
		   trns = session.beginTransaction();

		   users = session.createQuery(
		         " FROM User as u "
		       + "WHERE u.userName = :userName"
		       + "  AND u.password = :password")
		       .setString( "userName", userName )
		       .setString( "password", password )
		       .list();
		   for (Iterator<User> iter = users.iterator(); iter.hasNext();) {
		    User user = iter.next();
		    System.out.println(user.getFirstName() +" " + user.getLastName());
		   }
		   trns.commit();
		  } catch (RuntimeException e) {
		   if(trns != null){
		    trns.rollback();
		   }
		   e.printStackTrace();
		  } finally{
		   session.flush();
		   session.close();
		  } 
			if ((users != null) && (users.isEmpty() == false)) {
				return true;
			}
		}
		return false;
	}
	
	public User getUserDetails(String userName) {
		User user = null;		
		if ((userName == null || userName.trim() == "")) {
			return null;
		}
		else {
		    Transaction trns = null;
		    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		    Session session = sessionFactory.openSession();
		    try {
		        trns = session.beginTransaction();

		        List<User> users = session.createQuery(
		            " FROM User as u "
		          + "WHERE u.userName = :userName")
		            .setString( "userName", userName )
		            .list();
		        for (Iterator<User> iter = users.iterator(); iter.hasNext();) {
		            user = iter.next();
		            System.out.println(user.getFirstName() +" " + user.getLastName());
		        }
		        trns.commit();
		    } catch (RuntimeException e) {
		        if(trns != null){
		            trns.rollback();
		        }
		        e.printStackTrace();
		    } finally {
		        session.flush();
		        session.close();
		    } 
		}
		return user;
	}
	
}
