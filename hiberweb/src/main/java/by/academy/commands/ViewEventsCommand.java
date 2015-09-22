package by.academy.commands;

import by.academy.dao.CustomUserDao;
import by.academy.dao.UserDao;
import by.academy.pojos.User;
import by.academy.service.impl.EventServiceImpl;
import by.academy.service.impl.UserServiceImpl;
import by.academy.service.interf.EventService;
import by.academy.service.interf.UserService;
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

	    UserService userservice;
		try {
			userservice = new UserServiceImpl();
			user=userservice.getUserById(userId);
			request.setAttribute("username", user.getUserName());

			EventService eventService = new EventServiceImpl();

			request.setAttribute("crimEvents", eventService.getEvents());
			logger.info("get event list:" + eventService.getEvents());
		} catch (Exception e) {
			logger.error("error:" + e);
			e.printStackTrace();
		}
		return page;
	}

}
