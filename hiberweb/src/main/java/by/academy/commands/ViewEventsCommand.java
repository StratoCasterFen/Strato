package by.academy.commands;

import by.academy.dao.CustomUserDao;
import by.academy.dao.DaoException;
import by.academy.dao.EventDao;
import by.academy.dao.UserDao;
import by.academy.pojos.User;
import by.academy.service.impl.EventService;
import by.academy.service.impl.UserService;
import by.academy.service.utils.ConnectionManager;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ViewEventsCommand implements ICommands{

	public static Logger logger = LogManager.getLogger(ViewEventsCommand.class.getName());
    private User user;
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		logger.info("execute start");
		String page = "/WEB-INF/view/eventlist.jsp";
		HttpSession session = request.getSession();
		logger.info("session"+session);
	    Integer userId=(Integer)session.getAttribute("userId");
	    CustomUserDao userDao=new UserDao();
	    try {
			UserService us= new UserService();
			us.setUserDao(userDao);
	    	user=userDao.getByPK(userId);
		} catch (DaoException e1) {
			e1.printStackTrace();
		}
	    logger.info("username"+userId);
	    request.setAttribute("username", user.getUserName());
		try {
			EventDao eventDao = new EventDao();
			EventService eventService = new EventService();
			eventService.setEventDao(eventDao);

			request.setAttribute("crimEvents", eventService.getEvents());
			logger.info("get event list:" + eventService.getEvents());
		} catch (Exception e) {
			logger.error("error:" + e);
			e.printStackTrace();
		}finally{
			//ConnectionManager.Close();
		}

		return page;
	}

}
