package by.academy.commands;

import by.academy.dao.EventDao;
import by.academy.service.impl.EventService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewEventsCommand implements ICommands{

	public static Logger logger = LogManager.getLogger(ViewEventsCommand.class.getName());
    
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		logger.info("execute start");
		String page = "/WEB-INF/view/eventlist.jsp";

		try {
			EventDao eventDao = new EventDao();
			EventService eventService = new EventService();
			eventService.setEventDao(eventDao);

			request.setAttribute("crimEvents", eventService.getEvents());
			logger.info("get event list:" + eventService.getEvents());
		} catch (Exception e) {
			logger.error("error:" + e);
			e.printStackTrace();
		}

		return page;
	}

}
