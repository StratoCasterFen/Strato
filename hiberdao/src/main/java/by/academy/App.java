package by.academy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
import by.academy.dao.DaoException;
import by.academy.dao.UserDao;

public class App {
//private static Logger logger = LogManager.getLogger(App.class.getName());
	public static void main(String[] args) throws DaoException {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hiberpolice");
		EntityManager em = emf.createEntityManager();

//		em.getTransaction().begin();
//		User user = new User();
//		user.setUserName("B.00hbjjjjSc000000000");
//		user.setPassword("@3565+681");
////        Set<Role> roles = new HashSet<Role>();
////        Role role1=new Role("Admin11");
////        roles.add(role1);
////        Role role2=new Role("Guest11");
////        roles.add(role2);
////        logger.info("+pers role");       
////        user.setRoles(roles);
//        Set<CriminalEvent> ces = new HashSet<CriminalEvent>();
//        CriminalEvent ce1=new CriminalEvent();
//        ce1.setEventName("eventNam00000000e1");
//        ces.add(ce1);
//      //  user.setCriminalEvents(ces);
//      //  em.persist(ce1);
//        em.persist(user);
//     //   em.flush();
//        em.getTransaction().commit();
        
    //    em.getTransaction().begin();
        //UserDao dao=new UserDao();
    //    List<User> users = em.findAll(User);
      //  logger.info(users);
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
///////////////////////
		
		em.getTransaction().begin();
	
		UserDao ud=new UserDao();
	//	logger.info(ud.getAll());
//		ud.setEntityManager(em);
//		User user=ud.getByPK(3);
//        CriminalEvent eve=new CriminalEvent();
//        eve.setEventName("hgjjgjjjj");
//        eve.setUserId(user);
//     
//		em.persist(eve);		
		em.getTransaction().commit();
		
		
	      em.close();
	     emf.close();
	}

}
