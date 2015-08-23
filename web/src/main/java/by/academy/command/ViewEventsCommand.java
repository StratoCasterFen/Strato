package by.academy.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import by.academy.mydao.DaoException;
import by.academy.service.exception.ServiceException;
import by.academy.service.impl.EventServiceImpl;

public class ViewEventsCommand implements ICommand{

	public static Logger logger = LogManager.getLogger(ViewEventsCommand.class.getName());
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		logger.debug("execute start");
		String page = "/WEB-INF/view/eventlist.jsp";
        
        try {
        	EventServiceImpl eventService = new EventServiceImpl();
			request.setAttribute("crimEvents", eventService.getEvents());
			logger.debug("get event list");
		} catch (Exception e) {
			logger.error("error:"+e);
			e.printStackTrace();
		}
        return page;
	}

}
