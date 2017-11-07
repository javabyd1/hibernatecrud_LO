package com.sdajava.hibernate.implement;

import java.util.List;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.sdajava.hibernate.interfaces.UserDAO;
import com.sdajava.hibernate.model.User;
import com.sdajava.hibernate.utility.HibernateUtility;

public class UserDAOImpl implements UserDAO{

	Session session = HibernateUtility.getHibernateSession();

	@Override
	public User insertUser(User u) {
		try{
			System.out.println(u.getName()+" "+u.getSurname());
			session.beginTransaction();
			session.save(u);
			session.getTransaction().commit();
		}
	    catch (HibernateException e) {
	    	if (session.getTransaction()!=null){
	    		session.getTransaction().rollback();
			}
	    	e.printStackTrace();
		  }
		return u;
	}
	@Override
	public List<User> getAllUsers() {
		List<User> users=null;
	      try{

	    	  session.beginTransaction();
	          users = session.createQuery("FROM User").list();
	          for (Iterator<User> iterator =
	        		  users.iterator(); iterator.hasNext();){
	        	  User user = (User) iterator.next();
	             System.out.print(" " + user.getName()+"\t");
	             System.out.print("  " + user.getSurname()+"\n");
	          }
	       }
	      catch (HibernateException e) {
	    	  if (session.getTransaction()!=null) session.getTransaction().rollback();
	    	  e.printStackTrace();
		  }
	   return users;
	}
	@Override
	public void updateUser(int id, String name,String surname){
		try{
	         session.beginTransaction();
	         User user = session.get(User.class, id);
	         System.out.println(" "+user.getName());
	         user.setName(name);
	         user.setSurname(surname);
			 session.update(user);
			 session.getTransaction().commit();
	    }
		catch (HibernateException e) {
	         if (session.getTransaction()!=null) session.getTransaction().rollback();
	         e.printStackTrace();
	    }
	}
	@Override
	public void removeUser(int id) {
		try{
	         User user = session.get(User.class, id);
	         System.out.println("  "+user.getName()+"  "+user.getSurname());
	         session.delete(user);
	         session.getTransaction().commit();
	    }
		catch (HibernateException e) {
	         if (session.getTransaction()!=null) session.getTransaction().rollback();
	         e.printStackTrace();
	      }
	}
	@Override
	public User findUser(int id) {
		User user=session.get(User.class, id);
		System.out.println(" "+user.getName()+"  "+user.getSurname());
		return user;
	}

}
