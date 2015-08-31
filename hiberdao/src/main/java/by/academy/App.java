package by.academy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import by.academy.hbutil.HibernateUtil;
import by.academy.pojos.Criminal;
import by.academy.pojos.CriminalEvent;
import by.academy.pojos.EventType;
import by.academy.pojos.Role;
import by.academy.pojos.User;

public class App {
private static Logger logger = LogManager.getLogger(App.class.getName());
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hiberpolice");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		User user = new User();
		user.setUserName("B.00hbjjjjSc000000000");
		user.setPassword("@3565+681");
//        Set<Role> roles = new HashSet<Role>();
//        Role role1=new Role("Admin11");
//        roles.add(role1);
//        Role role2=new Role("Guest11");
//        roles.add(role2);
//        logger.info("+pers role");       
//        user.setRoles(roles);
        Set<CriminalEvent> ces = new HashSet<CriminalEvent>();
        CriminalEvent ce1=new CriminalEvent();
        ce1.setEventName("eventNam00000000e1");
        ces.add(ce1);
        user.setCriminalEvents(ces);
        em.persist(user);
        em.getTransaction().commit();
//////////////////////////
  /*      em.getTransaction().begin();
        Role role3=new Role("testttt");
        Set<User> users=new HashSet<User>();
        User user1=new User();
    	user1.setUserName("Botor1");
    	User user2=new User();
    	user2.setUserName("Botor2");
    	users.add(user1);
    	users.add(user2);
    	role3.setUsers(users);
		em.persist(role3);		
		em.getTransaction().commit();*/
///////////////////////
//		em.getTransaction().begin();
//		EventType eventType=new EventType("hggggggggg");
//		
//		CriminalEvent ce = new CriminalEvent();
//		ce.setEventName("eventName1");
////		em.persist(ce);
//		Set<CriminalEvent> events =new HashSet<CriminalEvent>();
//		events.add(ce);
//		CriminalEvent ce1 = new CriminalEvent();
//		ce1.setEventName("eventName2");
//	//	em.persist(ce1);
//		events.add(ce1);
//		eventType.setCriminalEvents(events);
//		em.persist(eventType);
//		em.getTransaction().commit();
//		
//		logger.info("good!");
	       em.close();
	        emf.close();
	}

}
