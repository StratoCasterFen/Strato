package by.academy.command;

import by.academy.dao.EventDao;
import by.academy.service.impl.EventService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewEventsCommand implements ICommand{

	public static Logger logger = LogManager.getLogger(ViewEventsCommand.class.getName());
    private EntityManagerFactory emf;
    private EntityManager em;
    
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		logger.info("execute start");
		String page = "/WEB-INF/view/eventlist.jsp";
        
        try {
            emf = Persistence.createEntityManagerFactory("hiberpolice");
            em = emf.createEntityManager();
            
            EventDao eventDao = new EventDao();
            EventService eventService =new EventService(em);
            eventService.setEventDao(eventDao);
           
			request.setAttribute("crimEvents", eventService.getEvents());
			logger.info("get event list:"+eventService.getEvents());
		} catch (Exception e) {
			logger.error("error:"+e);
			e.printStackTrace();
		}
        
        em.close();
        emf.close();
        return page;
	}

}
