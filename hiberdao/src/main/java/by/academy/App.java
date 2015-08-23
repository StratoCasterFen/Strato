package by.academy;

import java.net.URL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import by.academy.domain.Criminal;
import by.academy.hbutil.HibernateUtil;

public class App {

	public static void main(String[] args) {
		Criminal criminal = new Criminal();
		criminal.setCriminalName("Turbo");
		criminal.setCriminalSurname("Bonicals");
		
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.saveOrUpdate(criminal);
	
		session.getTransaction().commit();
		session.close();
	}

}
