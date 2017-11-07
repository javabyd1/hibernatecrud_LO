package com.sdajava.hibernate.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {

	private final static SessionFactory sf = new Configuration()
	        .configure("com/sdajava/hibernate/hibernate.cfg.xml")
			.buildSessionFactory();

	/*
	Jezeli plik hibernate.cfg.xml jest w katalogu resources to SessionFactory powinno wygladac:
	private final static SessionFactory sf = new Configuration()
	        .configure()
			.buildSessionFactory();
	 */

    private static Session session = sf.openSession();

	public HibernateUtility() {
	}

	public static Session getHibernateSession() {
	      if(session == null) {
	    	  session = (Session) new HibernateUtility();
	       }
	       return session;
	}
	public void dispose(){
		if(session != null && session.isOpen()){
			session.close();
		}
		if(sf != null && !sf.isClosed()){
			sf.close();
		}
	}
}
