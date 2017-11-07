package com.sdajava.hibernate;

import com.sdajava.hibernate.implement.UserDAOImpl;
import com.sdajava.hibernate.model.User;
import com.sdajava.hibernate.utility.HibernateUtility;

public class Main {

	public static void main(String[] args) {

		UserDAOImpl userDAOImpl=new UserDAOImpl();
		User user =new User();
		user.setName("jan");
		user.setSurname("kowalski");

        User user1 =new User();
        user1.setName("andrzej");
        user1.setSurname("kowalski");


		userDAOImpl.insertUser(user);
        userDAOImpl.insertUser(user1);
 		userDAOImpl.getAllUsers();

		HibernateUtility hu = new HibernateUtility ();
		hu.dispose ();
	}
}
