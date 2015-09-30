package by.academy;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import by.academy.cfg.Beans;
import by.academy.cfg.DaoCfg;
import by.academy.dao.interf.CriminalService;
import by.academy.pojos.Criminal;
//import org.hibernate.jpa.HibernatePersistenceProvider;

//import by.academy.dao.UserDao;
//import by.academy.dao.exception.DaoException;
//import by.academy.pojos.CriminalEvent;
//import by.academy.pojos.EventType;
//import by.academy.pojos.User;

public class App {
private static Logger logger = LogManager.getLogger(App.class.getName());
	public static void main(String[] args)  {
		
	    ApplicationContext context = new AnnotationConfigApplicationContext(DaoCfg.class, Beans.class);
	    		
		CriminalService cs=context.getBean(CriminalService.class);
		Criminal crim=new Criminal();
		crim.setCriminalName("Vini-PUH");
		crim.setCriminalSurname("Vini-PUH");
		cs.addCriminal(crim);
		
	}

}
