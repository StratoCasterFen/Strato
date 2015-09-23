package by.academy.commands;

import by.academy.dto.UserDto;
import by.academy.service.exeption.ServiceException;
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
	
    private UserDto userDto;
    private UserService userService;
    private Integer userId;
    
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		logger.info("execute start");
		String page = "/WEB-INF/view/eventlist.jsp";
		HttpSession session = request.getSession();
		logger.info("session"+session);
		userId = (Integer) session.getAttribute("userId");

		try {
			userService = new UserServiceImpl();
			userDto = userService.getUserById(userId);
			request.setAttribute("username", userDto.getUserName());

			EventService eventService = new EventServiceImpl();

			request.setAttribute("crimEvents", eventService.getEvents());
			logger.info("get event list:" + eventService.getEvents());
		} catch (ServiceException e) {
			logger.error("error:" + e);
			e.printStackTrace();
		}

		return page;
	}

}
