package by.academy;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import by.academy.hbutil.HibernateUtil;
import by.academy.pojos.Criminal;

public class App {

	public static void main(String[] args) {
		Criminal criminal = new Criminal();
		criminal.setCriminalName("Turbo");
		criminal.setCriminalSurname("Bonicals");
		
		Session session = HibernateUtil.getSession();
//		session.beginTransaction();
//		session.saveOrUpdate(criminal);
//	
//		session.getTransaction().commit();
//		session.close();
		
		
		EntityManager em = HibernateUtil.getEjb3Configuration()
			    .buildEntityManagerFactory().createEntityManager();

		em.getTransaction().begin();

		//выполняем некоторую обработку бизнес объектов
		em.persist(criminal);
	
		//завершаем транзакцию 
		em.getTransaction().commit();
		em.close();
	}

}
