package by.academy;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import by.academy.hbutil.HibernateUtil;
import by.academy.pojos.Criminal;
import by.academy.pojos.Role;
import by.academy.pojos.User;

public class App {
private static Logger logger = LogManager.getLogger(App.class.getName());
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("hiberpolice");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		User user = new User();
		user.setUserName("B.00hbjjjjSc");
		user.setPassword("@3565+681");
        List<Role> roles = new ArrayList<Role>();
        Role role1=new Role("Admin");
        roles.add(role1);
        em.persist(role1);
        Role role2=new Role("Guest");
        roles.add(role2);
        logger.info("+pers role");
        em.persist(role2);
        logger.info("-pers role");
        user.setUser_role(roles);

		
		//em.persist(user);
		em.persist(user);
		
		em.getTransaction().commit();

	}

}
